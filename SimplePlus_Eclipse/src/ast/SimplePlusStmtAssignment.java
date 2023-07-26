package ast;

import behavioural_analysis.BTAtom;
import behavioural_analysis.BTBase;
import util_analysis.Environment;
import util_analysis.SemanticError;
import util_analysis.Strings;

import java.util.ArrayList;

public class SimplePlusStmtAssignment extends SimplePlusStmt {
    SimplePlusExpVar id;
    SimplePlusExp exp;
    private Integer varpass_of;
    private Integer nest_lvl;
    private Integer sz_nl1;
    private Integer dom_size;

    public SimplePlusStmtAssignment(SimplePlusExpVar id, SimplePlusExp exp) {
        this.id = id;
        this.exp = exp;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment e) {

        ArrayList<SemanticError> res = new ArrayList<SemanticError>();
        //check if the variable is declared
        if (!e.containsVariable(this.id.getId(e))){
            res.addAll(this.id.checkSemantics(e));
        }
        //check semantics of expression
        res.addAll(this.exp.checkSemantics(e));

        if (e.containsVariable(this.id.getId(e))){

            //if id is function id or is a function argument not passed with "var", give an error
            if (e.isFunction(id.getId(e)) || (e.isFunarg(id.getId(e)) && !e.isVarPass(id.getId(e))) ){
                res.add(new SemanticError(Strings.ErrorParVarPass + id.getId(e)));
            } else {
                //TYPE CHECK
                if (this.id.getType(e).equals(this.exp.getType(e))){
                    //put the variable in the current scope with the current value
                    e.addVariable(id.getId(e), new VarInfo(e.getVariableNestLevel(id.getId(e)), e.getVariableOffset(id.getId(e)), e.getVariableType(id.getId(e)), exp.getValue(e), e.isVarPass(id.getId(e)), e.isFunction(id.getId(e)), e.isFunarg(id.getId(e))));

                    //calculating offsets for code generation
                    sz_nl1 = e.getParNl1(e.getVariableNestLevel(this.id.getId(e)));
                    varpass_of = e.getVariableOffset(this.id.getId(e));
                    nest_lvl = e.getVariableNestLevel(this.id.getId(e));

                    if (e.getFunDomSize() != null) {
                        dom_size = e.getFunDomSize();
                    } else {
                        dom_size = 0;
                    }
                    if (nest_lvl == 1){
                        varpass_of = -(varpass_of + 1);
                    } else if (nest_lvl == 2){
                        if ((varpass_of-sz_nl1)-dom_size < 0){
                            varpass_of = varpass_of - sz_nl1;
                        } else {
                            varpass_of = -(((varpass_of - sz_nl1) - dom_size) + 1);
                        }
                    } else if (nest_lvl > 2){
                        varpass_of = -((varpass_of - sz_nl1)+1);
                    }
                } else {
                    res.add(new SemanticError(Strings.ErrorType + this.id.getId(e) + " = " + this.exp.getType(e)));
                }
            }
        }
        //System.out.println(exp.getValue(e));
        return res;
    }


    @Override
    public ArrayList<SemanticError> inferBehavior(Environment e) {
        ArrayList<SemanticError> res = new ArrayList<SemanticError>();

        res.addAll(id.inferBehavior(e));
        res.addAll(exp.inferBehavior(e));

        return res;
    }

    @Override
    public String codeGeneration(){
        //System.out.println(exp.getValue());
        return this.exp.codeGeneration()+
                "push " + varpass_of + "\n"+
                "lfp\n"+
                "add\n"+
                "sw\n";
    }

    @Override
    public Integer checkVarDec(){return null;}

}
