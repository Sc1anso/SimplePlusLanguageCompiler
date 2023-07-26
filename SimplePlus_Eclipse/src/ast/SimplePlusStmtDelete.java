package ast;

import behavioural_analysis.BTAtom;
import behavioural_analysis.BTBase;
import util_analysis.Environment;
import util_analysis.SemanticError;
import util_analysis.Strings;

import java.util.LinkedList;
import java.util.ArrayList;

public class SimplePlusStmtDelete extends SimplePlusStmt {

	private String id;
	private SimplePlusExp exp;
	private Environment env;
	private Integer of;
	private Integer varpass_of;
	private Integer nest_lvl;
	private Integer sz_nl1;
	private Integer dom_size;


	/**
	 * Creates a delete statement
	 * @param id the variable we want to delete
	 */
	public SimplePlusStmtDelete(String id) {
		this.id = id;

	}

	/*
	 * Checks if the variable in use exists. if it doesn't then add an error, 
	 * if it does then remove it from the current scope
	 */
	@Override
	public ArrayList<SemanticError> checkSemantics(Environment e) {
		ArrayList<SemanticError> result = new ArrayList<SemanticError>();

		//check for the variable
		if(!e.containsVariable(id)){
			result.add(new SemanticError(Strings.ErrorVariableDoesntExist + id));
		}
		//if the variable does exist then delete it from the environment
		else {
			//if id to delete is not function id
			if (!e.isFunction(id)){
				//check if variable is function argument and is passed with "var"
				if (e.isFunarg(id) && !e.isVarPass(id)){
					result.add(new SemanticError(Strings.ErrorDeletePar + id));
				} else {
					sz_nl1 = e.getParNl1(e.getVariableNestLevel(this.id));
					of = -e.getVariableOffset(this.id);
					varpass_of = e.getVariableOffset(this.id);
					nest_lvl = e.getVariableNestLevel(this.id);
					if (e.getFunDomSize() != null) {
						dom_size = e.getFunDomSize();
					} else {
						dom_size = 0;
					}
					if (nest_lvl == 1){
						varpass_of = -(varpass_of + 1);
					} else if (nest_lvl == 2){
						if ((varpass_of-sz_nl1)-dom_size <= 0){
							varpass_of = varpass_of - sz_nl1;
						} else {
							varpass_of = -(((varpass_of - sz_nl1) - dom_size) + 1);
						}
					} else if (nest_lvl > 2){
						varpass_of = -((varpass_of - sz_nl1)+1);
					}
					e.deleteVariable(id);
				}

			} else {
				result.add(new SemanticError(Strings.ErrorFunDelete + id));
			}
		}
		
		return result;
	}

	@Override
	public ArrayList<SemanticError> inferBehavior(Environment e) {
		ArrayList<SemanticError> res = new ArrayList<SemanticError>();

		if (e.containsVariableCurrScope(this.id)){
			Integer effect = e.getVarEffect(this.id);
			if (effect > 1){
				//if old effect is 2 or 3 then give an error
				e.addVariable(this.id, new VarInfo(3));
				res.add(new SemanticError(Strings.ErrorDeleteVar + this.id));
			}
			else{
				//set var effect equals 2 (delete)
				e.addVariable(this.id, new VarInfo(2));
			}
		} else {
			//set var effect equals 2 (delete)
			e.addVariable(this.id, new VarInfo(2));
		}
		
		return res;
	}
	@Override
	public String codeGeneration() {
		return "push " + varpass_of + "\n"+
				"lfp\n"+
				"add\n"+
				"lw\n"+
				"del\n";
	}
	@Override
	public Integer checkVarDec(){return null;}

}
