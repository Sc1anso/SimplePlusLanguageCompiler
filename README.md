
# SimplePlus Language Compiler
This is the project for the "Compilatori e Interpreti" class.

The following project consists of software that, on the basis of a grammar for a programming language 'SimplePlus.g4', performs the semantic and effects analysis and the generation and execution of code for the described language.
In the project directory (or package) 'ast', the abstract syntax tree is implemented by means of various Java classes, which allow the code written following the grammar described in the 'SimplePlus.g4' file to be visited. Within these classes (one for each node type) is the code that deals with semantic analysis, effects and the generation of bytecode.

The methods that implement the analysis and code generation are:
- checkSemantics(Environment e): deals with the semantic analysis of the node being visited, it takes as input parameter the environment that will contain the declarations of the variables and functions and their respective information.
- inferBehavior(Environment e): deals with the analysis of the effects of the node being visited, again the method takes as input the environment that will contain the declared variables and their respective effect.
- codeGeneration(): method that returns a string containing the generated code of the programme found in the test.spl file, the output will then be saved in the test.spl.asm file.

## Project structure
- The directory "gen" contains the lexer and parser of both the grammar "SimplePlus.g4", relating to the programming language that will be analysed, and the grammar "SVM.g4", relating to the bytecode that will be generated and executed from the programme that we will write in the "test.spl" file. In this directory is the "ExecuteVM" class, in which the stack machine on which the code will be executed is implemented.
- In the directory "lib" is the class "SIMPLEPLUSlib", which has the function of generating the labels for the bytecode and managing the correct writing of the bytecode of the function declarations.
- In the directory "main" there is the class "Analyse", which allows the execution of all analyses, the generation and execution of bytecode.
In the directory "util_analysis" there are:
- the "Environment" class that implements the environment;
- the "SemanticError" class which manages the text strings concerning the errors detected by the analyses;
- the "Strings" class where the strings for each type of error are located.

## Abstract Syntax tree
The abstract syntax tree was implemented by implementing a series of classes in the project's 'ast' directory. Each implemented class has the purpose of analysing a particular type of node. It is possible to divide the implemented classes into two macrocategories: Expressions (Exp) and Statements (Stmt), the classes referring to Statements will be described first and then those relating to Expressions.
Statements:
- SimplePlusStmtAssignment: deals with visiting assignments, e.g.: x = x + 1;
- SimplePlusStmtBlock: deals with visiting blocks of expressions, a block can be the whole programme, the instructions inside a function declaration or the instructions inside an If-Then-Else;
- SimplePlusStmtCall: deals with visiting a function call;
- SimplePlusStmtDelete: class/node of the AST which deals with the visit of delete instructions;
- SimplePlusStmtIte: deals with the visit of an If-Then or If-Then-Else type statement;
- SimplePlusStmtPrint: class/node of the AST which deals with the visit of a statement of type 'print';
- SimplePlusStmtRet: deals with the visit of 'return' type statements;
- SimplePlusVarDec: takes care of visiting variable declarations;
- SimplePlusElementFun: deals with the visit of a function declaration;
- SimplePlusFunArgs: takes care of checking the function's arguments when visiting the function declaration.
Expressions:
- SimplePlusAnd: visit of an expression containing a logical AND;
- SimplePlusCompEq: visit of an expression where the equality between two values is checked;
- SimplePlusCompNotEq: visit of an expression where the inequality between two values is checked;
- SimplePlusExpBool: visit of a Boolean expression;
- SimplePlusExpDiff: visit of an arithmetic subtraction expression;
- SimplePlusExpDiv: visit an arithmetic expression of division;
- SimplePlusExpMult: visit an arithmetic expression of multiplication;
- SimplePlusExpNeg: visit a negation expression of a value;
- SimplePlusExpNot: visit of a negation expression of a Boolean expression;
- SimplePlusExpSum: visit of an arithmetic sum expression;
- SimplePlusExpVal: visit of a value;
- SimplePlusExpVar: visit of an identifier (variable);
The visit of the AST is implemented in the 'SimplePlusVisitorImpl' class, which calls the nodes described above according to the instructions read in the program in the test.spl file.

## Semantic analysis
The semantic analysis of the code is entrusted to the "checkSemantics(Environment e)" method implemented in each node of the AST.
We note that an object of type "Environment" is passed as a parameter to the function, which corresponds to our environment for semantic analysis.
The environment is implemented via the class "Environment", which is initialised when the AST starts.
The environment has been implemented as a "LinkedList<HashMap<String, Varinfo>>", each HashMap present in the list corresponds to the scopes associated to our programme and each HashMap contains within it a list of <String, Varinfo> associations which correspond in order to the variable and the information regarding the variable (nesting level, offset, type, etc.).
The 'Environment' class contains methods for entering and retrieving this information.
The semantic analyser takes care of checking:
- undeclared variables/functions;
- variables declared several times in the same environment;
- current parameters do not conform to formal parameters;
- correctness of types and number of parameters passed as input;
- variables deleted and then used.

## Behavioral analysis
The analysis of the effects takes place immediately after the semantic analysis and only occurs if no errors have been found in the latter, and is entrusted to the "inferBehavior(Environment e)" function which, as with "checkSemantics(...)", is called from each node of the AST.
The implementation is very similar to that seen for the semantic analysis with the difference that the "Varinfo" object in this case only contains information regarding the effect associated with the variable (a number from 0 to 3, 0 for bottom effect, 1 for read-write, 2 for delete, 3 for error (top)) and depending on the instruction we are visiting the effects are calculated according to the method seen in the lesson.
This type of analysis allows us to identify aliasing problems and if aliasing is found the programme execution is interrupted by returning the error, in addition to aliasing, it is possible to identify repeated variable deletions due to recursion, this second error is identifiable thanks to the implementation of fixed point computation for effects:
- aliasing;
- multiple deleted variables.

## Bytecode generation and execution
If the two previous analyses find no errors, the programme proceeds with the generation of the code, which is entrusted to the 'codeGeneration()' method, defined in each node of the AST.
The generated code, called 'bytecode', follows the syntax defined in the 'SVM.g4' file, which defines the syntax for the operations that the stack machine will perform; this syntax has been enriched by inserting the keywords for the instructions
- Delete;
- Return;
- And;
- Or;
- Not;
- Negation of integers;
- Major (>);
- Minor (<);
- More then (>=);
- Less then (<=);
- Not equal (!=);

The "codeGeneration()" function writes the generated bytecode in the "test.spl.asm" file, which is then read by the "SVMVisitorImpl" programme, which performs the lexical analysis. If the latter does not encounter any problems, the code is then executed on the stack machine defined in "ExecuteVM", which will execute the code and print the result of the last executed instruction on the screen. The two files just mentioned have been enriched with code to read and execute the instructions added in the "SVM.g4" grammar listed above.
