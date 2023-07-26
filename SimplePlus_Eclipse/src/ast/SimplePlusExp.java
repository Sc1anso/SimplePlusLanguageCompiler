package ast;

import behavioural_analysis.BTBase;
import util_analysis.Environment;
import util_analysis.SemanticError;

import java.util.ArrayList;

/**
 * Represents a Simple Expression
 * Some child classes of this one will be SimpleExpSum, SimpleExpDiff, 
 * SimpleExpDiv, SimpleExpMult and SimpleExpNeg
 * @author Abel
 *
 */
public abstract class SimplePlusExp extends SimplePlusElementBase {

	/**
	 * Calculates the value of an expression
	 * @param e the environment that stores variable values
	 * @return an integer which is the value of the expression
	 */
	public abstract Integer getValue(Environment e);

	public abstract String getType(Environment e);

	public abstract String getId(Environment e);

	//public abstract boolean getBoolVal(Environment e);

	/**public abstract boolean getBoolValue(Environment e);*/

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment e){
		return null;
	}


	@Override
	public ArrayList<SemanticError> inferBehavior(Environment e) {
		
		return null;
	}

	@Override
	public String codeGeneration(){
		return "";
	}

	public String codeGeneration2(){
		return "";
	}

}
