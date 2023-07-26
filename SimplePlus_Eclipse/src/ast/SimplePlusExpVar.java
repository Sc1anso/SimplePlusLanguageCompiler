package ast;

import behavioural_analysis.BTAtom;
import behavioural_analysis.BTBase;
import util_analysis.Environment;
import util_analysis.SemanticError;
import util_analysis.Strings;

import java.util.ArrayList;

public class SimplePlusExpVar extends SimplePlusExp {

	private final String id;
	private Integer of;
	private Integer varpass_of;
	private Integer nest_lvl;
	private Integer sz_nl1;
	private Integer dom_size;
	private Environment env;

	public SimplePlusExpVar(String id) {
		this.id = id;
	}
	

	
	@Override
	public ArrayList<SemanticError> checkSemantics(Environment e) {
		ArrayList<SemanticError> result = new ArrayList<SemanticError>();

		// Checks if the variable in use exists. if it doesn't then add an error.
		if (!e.containsVariable(this.id)){
			result.add(new SemanticError(Strings.ErrorVariableDoesntExist + this.id));

		} else {
			//if the variable exists, then calculate offsets for code generation
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
				//System.out.println(this.id + " off: " + (sz_nl1));
				if ((varpass_of-sz_nl1)-dom_size <= 0){
					varpass_of = varpass_of - sz_nl1;
				} else {
					varpass_of = -(((varpass_of - sz_nl1) - dom_size) + 1);
				}
			} else if (nest_lvl > 2){
				varpass_of = -((varpass_of - sz_nl1)+1);
			}

		}

		return result;
	}

	@Override
	public Integer getValue(Environment e) {
		return e.getVariableValue(this.id);
	}

	public String getType(Environment e) {
		return e.getVariableType(this.id);
	}

	@Override
	public String getId(Environment e) {
		return this.id;
	}

	/*@Override
	public boolean getBoolVal(Environment e) {
		if (e.getVariableValue(id) == 1){
			return true;
		} else {
			return false;
		}
	}*/

	@Override
	public ArrayList<SemanticError> inferBehavior(Environment e){
		ArrayList<SemanticError> res = new ArrayList<SemanticError>();
		//calculating effects for variables
		if (e.containsVariableCurrScope(this.id)){
			Integer effect = e.getVarEffect(this.id);
			//if variable is already declared and effect is delete (2) or error (3), put the variable in environment with effect 3
			if (effect > 1){
				e.addVariable(this.id, new VarInfo(3));
				res.add(new SemanticError(Strings.ErrorDeleteVar + this.id));
			}
			else{
				//if variable is already declared and effect is bottom (0) or read-write(1), put the variable in environment with effect 1
				e.addVariable(this.id, new VarInfo(1));
			}
		} else {
			//if is a new variable, put them in environment with effect 1
			e.addVariable(this.id, new VarInfo(1));
		}
		return res;
	}
	@Override
	public String codeGeneration(){
		//System.out.println("IN CODE GEN:\n" + this.id + " offset: " + varpass_of + " nestlvl: " + nest_lvl);
		String load_w = "";
		if (varpass_of < 0){
			load_w = "lw\n";
		}
		return "push " + varpass_of + "\n"+
				"lfp\n"+load_w+
				"add\n"+
				"lw\n";

	}

	public String codeGeneration2(){
		String load_w = "";

		return "push " + varpass_of + "\n"+
				"lfp\n"+load_w+
				"add\n"+
				"lw\n";
	}
	@Override
	public Integer checkVarDec(){return null;}


}
