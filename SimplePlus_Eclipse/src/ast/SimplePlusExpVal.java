package ast;

import behavioural_analysis.BTAtom;
import behavioural_analysis.BTBase;
import util_analysis.Environment;
import util_analysis.SemanticError;

import java.util.ArrayList;


public class SimplePlusExpVal extends SimplePlusExp {

	private Integer value;

	public SimplePlusExpVal(int value) {
		this.value = value;
	}

	// No semantic errors here

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment e) {
		return new ArrayList<SemanticError>();
	}

	@Override
	public Integer getValue(Environment e) {
		return value;
	}

	@Override
	public String getType(Environment e){
		return "int";
	}

	/*@Override
	public boolean getBoolVal(Environment e){
		return false;
	}*/
	@Override
	public ArrayList<SemanticError> inferBehavior(Environment e){
		ArrayList<SemanticError> res = new ArrayList<SemanticError>();
		return res;
	}

	@Override
	public String codeGeneration(){
		return "push " + value + "\n";
	}
	@Override
	public Integer checkVarDec(){return null;}
	@Override
	public String getId(Environment e){ return null;}
}
