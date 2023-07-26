package ast;

import behavioural_analysis.BTBase;
import behavioural_analysis.BTBlock;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import util_analysis.Environment;
import util_analysis.SemanticError;

import java.util.LinkedList;
import java.util.ArrayList;
import lib.*;

public class SimplePlusStmtBlock extends SimplePlusStmt {

	ArrayList<SimplePlusStmt> children;
	//Integer counter;
	//Integer max_counter;
	//Boolean ite;

	public SimplePlusStmtBlock(ArrayList<SimplePlusStmt> children) {
		this.children = children;

	}

	/**
	 * It checks the semantic for every child in order item by item
	 * It creates a new scope for the elements that will be found inside
	 * Each element may add new elements to the environment inside the current scope
	 * After finishing drop the newly created scope
	 */
	public ArrayList<SemanticError> checkSemantics(Environment e) {
		//create scope for inner elements
		if (e.getSize() != 2){
			e.openScope();
		}

		
		//initialize result variable
		ArrayList<SemanticError> result = new ArrayList<SemanticError>();
		
		//check children semantics
		if(children!=null)
			for(SimplePlusStmt el:children) {
				result.addAll(el.checkSemantics(e));
			}
		//close scope for this block
		if (e.getSize() != 2){
			e.closeScope();
		}
		
		return result;
	}


	@Override
	public ArrayList<SemanticError> inferBehavior(Environment e) {
		ArrayList<SemanticError> res = new ArrayList<SemanticError>();
		//create scope for inner elements
		if (e.getSize() != 2){
			e.openScope();
		}

		for(SimplePlusStmt el:children) {
			res.addAll(el.inferBehavior(e));
		}

		return res;
	}

	@Override
	public String codeGeneration(){

		String progCode = "";
		for(SimplePlusStmt el:children){
			//System.out.println(el);
			progCode += el.codeGeneration();
		}

		return 	progCode+
				SIMPLEPLUSlib.getCode();
	}
	public Integer checkVarDec(){
		Integer decs = 0;

		for(SimplePlusStmt el:children){
			if (el.toString().contains("VarDec")){
				decs++;
			}
		}
		return decs;
	}

}
