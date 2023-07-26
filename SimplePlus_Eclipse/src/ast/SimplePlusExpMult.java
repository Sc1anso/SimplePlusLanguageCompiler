package ast;

import behavioural_analysis.BTBase;
import behavioural_analysis.BTBlock;
import util_analysis.Environment;
import util_analysis.SemanticError;
import util_analysis.Strings;

import java.util.ArrayList;
import java.util.LinkedList;

public class SimplePlusExpMult extends SimplePlusExp {

	SimplePlusExp leftSide, rightSide;

	public SimplePlusExpMult(SimplePlusExp leftSide, SimplePlusExp rightSide) {
		this.leftSide = leftSide;
		this.rightSide = rightSide;
	}

	@Override
	public Integer getValue(Environment e) {
		if (leftSide.getValue(e) != null && rightSide.getValue(e) != null){
			return leftSide.getValue(e) * rightSide.getValue(e);
		}
		return null;
	}

	@Override
	public String getType(Environment e){
		return "int";
	}

	@Override
	public String getId(Environment e){ return null;}

	/*@Override
	public boolean getBoolVal(Environment e){
		return false;
	}*/

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment e) {
		ArrayList<SemanticError> result = new ArrayList<SemanticError>();

		//check semantics for left side and right side of expression
		result.addAll(leftSide.checkSemantics(e));
		result.addAll(rightSide.checkSemantics(e));
		//check if both expressions has the same type
		if (leftSide.getType(e) != null && rightSide.getType(e) != null){
			if (!leftSide.getType(e).equals("int") || !rightSide.getType(e).equals("int")){
				result.add(new SemanticError(Strings.ErrorType + leftSide.getType(e) + ", right side type: " + rightSide.getType(e)));
			}
		}

		return result;
	}

	@Override
	public String codeGeneration(){
		return this.leftSide.codeGeneration()+
				this.rightSide.codeGeneration()+
				"mult\n";
	}
	@Override
	public Integer checkVarDec(){return null;}

	@Override
	public ArrayList<SemanticError> inferBehavior(Environment e){
		ArrayList<SemanticError> res = new ArrayList<SemanticError>();

		res.addAll(leftSide.inferBehavior(e));
		res.addAll(rightSide.inferBehavior(e));

		return res;
	}
}
