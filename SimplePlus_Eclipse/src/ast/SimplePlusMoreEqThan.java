package ast;

import lib.SIMPLEPLUSlib;
import util_analysis.Environment;
import util_analysis.SemanticError;
import util_analysis.Strings;

import java.util.ArrayList;

public class SimplePlusMoreEqThan extends SimplePlusExp{
    SimplePlusExp leftSide, rightSide;

    public SimplePlusMoreEqThan(SimplePlusExp leftSide, SimplePlusExp rightSide) {
        this.leftSide = leftSide;
        this.rightSide = rightSide;
    }

    public Integer getValue(Environment e) {
        if (leftSide.getValue(e) >= rightSide.getValue(e)){
            return 1;
        } else{
            return 0;
        }
    }

    @Override
    public String getType(Environment e){
        return "bool";
    }

    /*@Override
    public boolean getBoolVal(Environment e) {
        if (leftSide.getValue(e) >= rightSide.getValue(e)){
            return true;
        } else{
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
        if (!leftSide.getType(e).equals("int") || !rightSide.getType(e).equals("int")){
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
                "bmeq " + l1 + "\n"+
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
