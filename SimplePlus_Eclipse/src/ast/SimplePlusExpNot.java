package ast;

import behavioural_analysis.BTBase;
import behavioural_analysis.BTBlock;
import util_analysis.Environment;
import util_analysis.SemanticError;
import util_analysis.Strings;

import java.util.ArrayList;
import java.util.LinkedList;

public class SimplePlusExpNot extends SimplePlusExp {

	SimplePlusExp exp;
	Integer expval;

	public SimplePlusExpNot(SimplePlusExp exp) {
		this.exp = exp;
	}

	@Override
	public Integer getValue(Environment e) {
		if (exp.getValue(e) != null){
			if (exp.getValue(e) == 1){
				return 0;
			} else {
				return 1;
			}
		}
		return null;
	}

	@Override
	public String getType(Environment e){
		return "bool";
	}

	/*@Override
	public boolean getBoolVal(Environment e){
		return !exp.getBoolVal(e);
	}*/

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment e) {
		if (exp.getValue(e) == 1){
			expval = 0;
		} else {
			expval = 1;
		}
		ArrayList<SemanticError> result = new ArrayList<SemanticError>();

		if (exp.checkSemantics(e).size() != 0){
			result.addAll(exp.checkSemantics(e));
		}
		//check if type of expression is bool
		if (!exp.getType(e).equals("bool")){
			result.add(new SemanticError(Strings.ErrorType + exp.getType(e)));
		}
			
		return result;
	}

	@Override
	public String codeGeneration(){
		return exp.codeGeneration() + "not\n";
	}
	@Override
	public Integer checkVarDec(){return null;}
	@Override
	public String getId(Environment e){ return null;}
	@Override
	public ArrayList<SemanticError> inferBehavior(Environment e){
		ArrayList<SemanticError> res = new ArrayList<SemanticError>();

		res.addAll(exp.inferBehavior(e));

		return res;
	}

}
