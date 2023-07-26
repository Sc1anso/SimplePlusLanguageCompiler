package ast;

import behavioural_analysis.BTBase;
import behavioural_analysis.BTPrint;
import util_analysis.Environment;
import util_analysis.SemanticError;

import java.util.ArrayList;

public class SimplePlusStmtPrint extends SimplePlusStmt {

	private SimplePlusExp exp;
	private Environment env;

	public SimplePlusStmtPrint(SimplePlusExp exp) {
		this.exp = exp;
	}

	public Integer toPrint(Environment e){
		return exp.getValue(e);
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment e) {

		return  this.exp.checkSemantics(e);
	}

	@Override
	public ArrayList<SemanticError> inferBehavior(Environment e) {

		return exp.inferBehavior(e);
	}

	@Override
	public String codeGeneration() {

		return exp.codeGeneration()+
		 "print\n";
	}
	@Override
	public Integer checkVarDec(){return null;}

}
