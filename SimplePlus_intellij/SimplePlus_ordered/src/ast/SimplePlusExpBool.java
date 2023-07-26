package ast;

import util_analysis.Environment;
import util_analysis.SemanticError;

import java.util.ArrayList;


public class SimplePlusExpBool extends SimplePlusExp {

	private Integer value;

	public SimplePlusExpBool(boolean value) {
		if (value){
			this.value = 1;
		} else {
			this.value = 0;
		}
	}

	// No semantic errors here

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment e) {
		return new ArrayList<SemanticError>();
	}

	@Override
	public Integer getValue(Environment e) {
		if (this.value == 1)
			return 1;
		else
			return 0;
	}

	@Override
	public String getType(Environment e){
		return "bool";
	}

	/*@Override
	public boolean getBoolVal(Environment e){
		return value;
	}*/
	@Override
	public String codeGeneration(){
		return "push " + this.value;
	}

	@Override
	public Integer checkVarDec(){return null;}

	@Override
	public String getId(Environment e){ return null;}



}
