package ast;

import behavioural_analysis.BTBase;
import behavioural_analysis.BTPrint;
import util_analysis.Environment;
import util_analysis.SemanticError;
import util_analysis.Strings;

import java.util.ArrayList;


public class SimplePlusStmtRet extends SimplePlusStmt {
    private SimplePlusExp exp;
    private Integer count = 0;

    public SimplePlusStmtRet (SimplePlusExp exp){
        this.exp = exp;
        this.count ++;
    }

    public Integer getValue(Environment e){
        return this.exp.getValue(e);
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment e) {
        ArrayList<SemanticError> res = new ArrayList<SemanticError>();

        if (e.getFunType().equals("void")){
            res.add(new SemanticError(Strings.ErrorVoidFunc));
        } else if (!e.getFunType().equals(exp.getType(e))){
            res.add(new SemanticError(Strings.ErrorRetType + e.getFunType() + " tipo ritornato: " + this.exp.getType(e)));
        } else {
            res.addAll(this.exp.checkSemantics(e));
        }

        return res;
    }

    @Override
    public ArrayList<SemanticError> inferBehavior(Environment e) {
        return exp.inferBehavior(e);
    }

    @Override
    public String codeGeneration() {
        return exp.codeGeneration()+"ret\n";
    }
    @Override
    public Integer checkVarDec(){return null;}
}
