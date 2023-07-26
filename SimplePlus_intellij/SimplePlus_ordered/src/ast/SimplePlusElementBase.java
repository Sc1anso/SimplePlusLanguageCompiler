package ast;

import behavioural_analysis.BTBase;
import util_analysis.Environment;
import util_analysis.SemanticError;

import java.util.ArrayList;

public abstract class SimplePlusElementBase {

	/**performs a semantic check for controlling that all declared variables exist
	 * @param e is the current environment where the information about existent variables is stored
	 * @return a list of the semantic problems found
	 */
	public abstract ArrayList<SemanticError> checkSemantics(Environment e);


	
	/**
	 * performs behavioral type inference for Simple programs
	 * @param e is the current environment where the information about existent variables is stored
	 * @return the behavior of the expression
	 */
	public abstract ArrayList<SemanticError> inferBehavior(Environment e);

	public abstract String codeGeneration();

	public abstract Integer checkVarDec();
}
