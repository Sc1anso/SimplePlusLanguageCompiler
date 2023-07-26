package ast;

import lib.SIMPLEPLUSlib;
import util_analysis.Environment;
import util_analysis.SemanticError;
import util_analysis.Strings;

import java.util.ArrayList;

public class SimplePlusOr extends SimplePlusExp{
    SimplePlusExp leftSide, rightSide;

    public SimplePlusOr(SimplePlusExp leftSide, SimplePlusExp rightSide) {
        this.leftSide = leftSide;
        this.rightSide = rightSide;
    }

    @Override
    public Integer getValue(Environment e) {
        if (leftSide.getValue(e) == 0 && rightSide.getValue(e) == 0){
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public String getType(Environment e){
        return "bool";
    }

    /*@Override
    public boolean getBoolVal(Environment e) {
        if (leftSide.getValue(e) == 0 && rightSide.getValue(e) == 0){
            return true;
        } else {
            return false;
        }
    }*/

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment e) {
        ArrayList<SemanticError> result = new ArrayList<SemanticError>();

        //check semantics for left side and right side of expression
        result.addAll(leftSide.checkSemantics(e));
        result.addAll(rightSide.checkSemantics(e));
        //check if both expressions has the same type
        if (!leftSide.getType(e).equals("bool") || !rightSide.getType(e).equals("bool")){
            result.add(new SemanticError(Strings.ErrorType + leftSide.getType(e) + ", right side type: " + rightSide.getType(e)));
        }

        return result;
    }

    @Override
    public String codeGeneration(){
        String l1 = SIMPLEPLUSlib.freshLabel();
        String l2 = SIMPLEPLUSlib.freshLabel();
        return this.leftSide.codeGeneration()+
                this.rightSide.codeGeneration()+
                "bor " + l1 + "\n"+
                "push 0\n"+
                "b " + l2 + "\n"+
                l1 + ":\n"+
                "push 1\n"+
                l2 + ":\n";
    }
    @Override
    public Integer checkVarDec(){return null;}
    @Override
    public String getId(Environment e){ return null;}

    @Override
    public ArrayList<SemanticError> inferBehavior(Environment e){
        ArrayList<SemanticError> res = new ArrayList<SemanticError>();

        res.addAll(leftSide.inferBehavior(e));
        res.addAll(rightSide.inferBehavior(e));

        return res;
    }
}
