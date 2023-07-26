package main;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import ast.SVMVisitorImpl;
import ast.SimplePlusStmtBlock;
import ast.SimplePlusVisitorImpl;


import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import util_analysis.*;
import gen.*;

public class Analyse {

	public static void main(String[] args) {
		
		String fileName = "test.spl";
		
		try{   
			FileInputStream is = new FileInputStream(fileName);
			ANTLRInputStream input = new ANTLRInputStream(is);
        
			//create lexer
			SimplePlusLexer lexer = new SimplePlusLexer(input);
			
			//create parser
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			SimplePlusParser parser = new SimplePlusParser(tokens);
			
			//tell the parser to build the AST
			parser.setBuildParseTree(true);
			
			//build custom visitor
			SimplePlusVisitorImpl visitor = new SimplePlusVisitorImpl();
			
			//visit the root, this will recursively visit the whole tree
			SimplePlusStmtBlock mainBlock = (SimplePlusStmtBlock) visitor.visitBlock(parser.block());
			

			//check semantics
			//give a fresh environment, no need to make it persist
			ArrayList<SemanticError> errors = mainBlock.checkSemantics(new Environment());
			
			//this means the semantic checker found some errors
			if (errors.size() > 0) {
				System.out.println("\nCheck semantics FAILED");
				for(SemanticError err: errors)
					System.out.println(err);
			}else{
				System.out.println("\nCheck semantics succeded");
				System.out.println("Calculating behavioral type");

				
				//give a fresh environment, no need to make it persist
				ArrayList<SemanticError> res = mainBlock.inferBehavior(new Environment());
				//System.out.println(res.toString());
				if (res.size() > 0){
					System.out.println("behavioral analysis FAILED");
					for (SemanticError err: res){
						System.out.println(err);
					}
				} else {
					// CODE GENERATION
					String code = mainBlock.codeGeneration();
					code = "push 0\n" + code;
					if(code.contains("function0:")){
						code = code.replace("\n\nfunction0:", "\nhalt\n\nfunction0:");
					} else {
						code = code.concat("halt\n");
					}
					code = code.replace("del\nb label", "del\nlfp\nb label");
					code = code.replace("del\nlabel", "del\nlfp\nlabel");
					code = code.replace("del\npush", "del\nlfp\npush");
					code = code.replace("push 1\nlfp\nadd\nsw\nb label", "b label");
					BufferedWriter out = new BufferedWriter(new FileWriter(fileName+".asm"));
					out.write(code);
					out.close();
					System.out.println("Code generated! Assembling and running generated code.");

					FileInputStream isASM = new FileInputStream(fileName+".asm");
					ANTLRInputStream inputASM = new ANTLRInputStream(isASM);
					SVMLexer lexerASM = new SVMLexer(inputASM);
					CommonTokenStream tokensASM = new CommonTokenStream(lexerASM);
					SVMParser parserASM = new SVMParser(tokensASM);

					//parserASM.assembly();

					SVMVisitorImpl visitorSVM = new SVMVisitorImpl();
					visitorSVM.visit(parserASM.assembly());

					System.out.println("You had: "+lexerASM.lexicalErrors+" lexical errors and "+parserASM.getNumberOfSyntaxErrors()+" syntax errors.");
					if (lexerASM.lexicalErrors>0 || parserASM.getNumberOfSyntaxErrors()>0) System.exit(1);

					System.out.println("Starting Virtual Machine...");
					ExecuteVM vm = new ExecuteVM(visitorSVM.code);
					vm.cpu();
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
