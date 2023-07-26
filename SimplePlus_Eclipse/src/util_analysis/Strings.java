package util_analysis;

public class Strings {

	public static final String ErrorVariableDoesntExist = "Not variable found. Variable either doesnt exist or has been deleted. Variable name: ";
	public static final String ErrorVariableDeclared = "Variable already declared in current scope. Variable name: ";
	public static final String ErrorFunNotDec = "Function not found. Function name: ";
	public static final String ErrorParVarPass = "Using a variable not passed with 'var'. Variable name: ";
	public static final String ErrorType = "Wrong type of expression. Left side type: ";
	public static final String ErrorTypeAssgn = "Wrong type of assignment. Variable type: ";
	public static final String ErrorNotAFun = "The symbol is not a function: ";
	public static final String ErrorWrongParNum = "Wrong number of parameters in input for function: ";
	public static final String ErrorTypeOfParams = "The type of expression is different from the type of the parameter. Parameter type: ";
	public static final String ErrorFunDelete = "Trying to delete a function. Function: ";
	public static final String ErrorIteStmt = "Wrong type of IF-THEN-ELSE condition. Type: ";
	public static final String ErrorVoidFunc = "Function type is void";
	public static final String ErrorRetType = "Return type is not equal to function type: ";
	public static final String ErrorProbableAliasing = "Aliasing found for var passed in function, variable name: ";
	public static final String ErrorDeleteVar = "Variable deleted several times. Variable name: ";
	public static final String ErrorDeletePar = "Deleting parameter not passed with 'var'. Par name: ";
}
