package ast;

import behavioural_analysis.BTBase;
import behavioural_analysis.BTBlock;
import lib.SIMPLEPLUSlib;
import util_analysis.Environment;
import util_analysis.SemanticError;
import util_analysis.Strings;

import java.util.ArrayList;
import java.util.LinkedList;

public class SimplePlusCompNotEq extends SimplePlusExp{
    SimplePlusExp leftSide, rightSide;

    public SimplePlusCompNotEq(SimplePlusExp leftSide, SimplePlusExp rightSide) {
        this.leftSide = leftSide;
        this.rightSide = rightSide;
    }

    public Integer getValue(Environment e) {
        if (leftSide.getValue(e) != null && rightSide.getValue(e) != null){
            if (leftSide.getValue(e) != rightSide.getValue(e)){
                return 1;
            } else{
                return 0;
            }
        }
        return null;
    }

    @Override
    public String getType(Environment e){
        return "bool";
    }

    /*@Override
    public boolean getBoolVal(Environment e){
        if (leftSide.getValue(e) != rightSide.getValue(e)){
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
        if (!leftSide.getType(e).equals(rightSide.getType(e))){
            result.add(new SemanticError(Strings.ErrorType + leftSide.getType(e) + ", right side type: " + rightSide.getType(e)));
        }

        return result;
    }
    @Override
    public ArrayList<SemanticError> inferBehavior(Environment e){
        ArrayList<SemanticError> res = new ArrayList<SemanticError>();
        BTBlock current = null;

        LinkedList<BTBase> behaviors = new LinkedList<BTBase>();
        //System.out.println(leftSide);
        //System.out.println(rightSide);
        res.addAll(leftSide.inferBehavior(e));
        res.addAll(rightSide.inferBehavior(e));
        //behaviors.push(leftSide.inferBehavior(e));
        //behaviors.push(rightSide.inferBehavior(e));

        //System.out.println("comp EQ: " + behaviors);
        /*for(BTBase b:behaviors){
            current = BTBase.add(b,current);
            //System.out.println("comp EQ: " + current);
        }*/
        return res;
    }
    @Override
    public Integer checkVarDec(){return null;}
    @Override
    public String getId(Environment e){ return null;}

    @Override
    public String codeGeneration(){
        String l1 = SIMPLEPLUSlib.freshLabel();
        String l2 = SIMPLEPLUSlib.freshLabel();
        return leftSide.codeGeneration()+
                rightSide.codeGeneration()+
                "bneq "+ l1 +"\n"+
                "push 0\n"+
                "b " + l2 + "\n" +
                l1 + ":\n"+
                "push 1\n" +
                l2 + ":\n";
    }
}
