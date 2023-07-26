package ast;

import behavioural_analysis.BTBase;
import behavioural_analysis.BTBlock;
import util_analysis.Environment;
import util_analysis.SemanticError;
import util_analysis.Strings;

import java.util.ArrayList;
import java.util.LinkedList;

public class SimplePlusExpNeg extends SimplePlusExp {

	SimplePlusExp exp;
	Integer expval;

	public SimplePlusExpNeg(SimplePlusExp exp) {
		this.exp = exp;
	}

	@Override
	public Integer getValue(Environment e) {
		if (exp.getValue(e) != null){
			expval = exp.getValue(e);
			return -exp.getValue(e);
		}
		return null;
	}

	/*@Override
	public boolean getBoolVal(Environment e){
		return false;
	}*/

	@Override
	public String getType(Environment e){
		return "int";
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment e) {
		expval = exp.getValue(e);
		ArrayList<SemanticError> result = new ArrayList<SemanticError>();

		if (exp.checkSemantics(e).size() != 0){
			result.addAll(exp.checkSemantics(e));
		}
		//check if type of expression is integer
		if (!exp.getType(e).equals("int")){
			result.add(new SemanticError(Strings.ErrorType + exp.getType(e)));
		}
			
		return result;
	}

	@Override
	public String codeGeneration(){
		return exp.codeGeneration() + "neg\n";
	}
	@Override
	public Integer checkVarDec(){return null;}
	@Override
	public String getId(Environment e){ return exp.getId(e);}

	@Override
	public ArrayList<SemanticError> inferBehavior(Environment e){
		ArrayList<SemanticError> res = new ArrayList<SemanticError>();

		res.addAll(exp.inferBehavior(e));

		return res;
	}
}
