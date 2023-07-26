package ast;

import behavioural_analysis.BTAtom;
import behavioural_analysis.BTBase;
import util_analysis.Environment;
import util_analysis.SemanticError;
import util_analysis.Strings;

import java.util.ArrayList;

public class SimplePlusVarDec extends SimplePlusStmt {
    private String type;
    private String ID;
    private SimplePlusExp exp;

    public SimplePlusVarDec (String type, String ID, SimplePlusExp exp){
        this.type = type;
        this.ID = ID;
        this.exp = exp;
    }

    public String getId(){
        return this.ID;
    }

    public SimplePlusExp getExp(){
        return this.exp;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment e){

        ArrayList<SemanticError> res = new ArrayList<SemanticError>();
        ArrayList<SemanticError> resExp = new ArrayList<SemanticError>();

        //check if variable is declared in current scope
        if (e.containsVariableCurrScope(this.ID) ){
            res.add(new SemanticError(Strings.ErrorVariableDeclared + this.ID));
        } else {
            if (type.equals("int")){
                //add int variable in current scope
                e.addVariable(this.ID, new VarInfo(e.getSize(), e.getOffset(), type, -12, false, false, false));
            } else {
                //add bool variable in current scope
                e.addVariable(this.ID, new VarInfo(e.getSize(), e.getOffset(), type, 1, false, false, false));
            }
            if (e.getVariableNestLevel(this.ID) > 2){
                e.addDec_ite(1);
            }

            if (exp != null){
                resExp.addAll(this.exp.checkSemantics(e));
                if (resExp.size() == 0){
                    //check if type of expression is equal to variable type
                    if (!this.exp.getType(e).equals(e.getVariableType(this.ID))) {
                        resExp.add(new SemanticError(Strings.ErrorTypeAssgn + e.getVariableType(this.ID) + ", type of expression: " + this.exp.getType(e)));
                    } else {
                        e.addVariable(this.ID, new VarInfo(e.getSize(), e.getVariableOffset(this.ID), type, exp.getValue(e), false, false, false));

                    }
                }
            }
        }
        res.addAll(resExp);

        return res;
    }

    @Override
    public ArrayList<SemanticError> inferBehavior(Environment e){
        ArrayList<SemanticError> res = new ArrayList<SemanticError>();

        if (exp != null){
            e.addVariable(this.ID, new VarInfo(1));
        } else {
            e.addVariable(this.ID, new VarInfo(0));
        }
        return res;
    }

    @Override
    public String codeGeneration(){
        if (this.exp != null){
            return this.exp.codeGeneration();
        }
        else return "";
    }

    @Override
    public Integer checkVarDec(){return null;}
}
