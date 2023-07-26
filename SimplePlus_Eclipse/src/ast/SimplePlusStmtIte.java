package ast;
import behavioural_analysis.BTBase;
import behavioural_analysis.BTBlock;
import lib.SIMPLEPLUSlib;
import util_analysis.Environment;
import util_analysis.SemanticError;
import util_analysis.Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class SimplePlusStmtIte extends SimplePlusStmt{
    private SimplePlusExp exp;
    private SimplePlusStmt thenBranch;
    private SimplePlusStmt elseBranch;
    private HashMap<String, VarInfo> e2;

    public SimplePlusStmtIte (SimplePlusExp exp, SimplePlusStmt thenBranch, SimplePlusStmt elseBranch){
        this.exp = exp;
        this.thenBranch = thenBranch;
        this.elseBranch = elseBranch;
        //this.i_t_e = ite;
        //this.d_del_var = v_d_del;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment e) {
        HashMap<String, VarInfo> to_reput = new HashMap<String, VarInfo>();
        ArrayList<SemanticError> res = new ArrayList<SemanticError>();

        res.addAll(this.exp.checkSemantics(e));

        //check if the guard is bool type
        if (!exp.getType(e).equals("bool")){
            res.add(new SemanticError(Strings.ErrorIteStmt + exp.getType(e)));
        }
        e2 = e.getSemBranch();
        for (String key: e2.keySet()){
            to_reput.put(key, e2.get(key));
        }
        e.openScope();
        //check semantics for then branch
        res.addAll(this.thenBranch.checkSemantics(e));
        e.closeScope();
        e.closeScope();
        e.openScope();
        for (String key: to_reput.keySet()){
            e.addVariable(key, to_reput.get(key));
        }
        e.openScope();
        //check semantics for else branch
        if(elseBranch != null) {
            res.addAll(this.elseBranch.checkSemantics(e));
        }
        e.closeScope();
        return res;
    }

    @Override
    public ArrayList<SemanticError> inferBehavior(Environment e) {
        ArrayList<SemanticError> res = new ArrayList<SemanticError>();
        HashMap<String, Integer> else_branch = new HashMap<String, Integer>();
        HashMap<String, Integer> then_branch = new HashMap<String, Integer>();
        HashMap<String, Integer> guard_branch = new HashMap<String, Integer>();
        HashMap<String, Integer> max_branch = new HashMap<String, Integer>();

        e.openScope();

        res.addAll(exp.inferBehavior(e));
        res.addAll(thenBranch.inferBehavior(e));
        //calculating effects for then and else branch and give the max
        if (elseBranch != null) {
            res.addAll(elseBranch.inferBehavior(e));

            else_branch = e.getBranch();
            e.closeScope();
            then_branch = e.getBranch();
            e.closeScope();
            guard_branch = e.getBranch();
            e.closeScope();
            for (String key: else_branch.keySet()){
                if (then_branch.get(key) == null){
                    max_branch.put(key, else_branch.get(key));
                } else {
                    max_branch.put(key, Math.max(else_branch.get(key), then_branch.get(key)));
                }
            }
            for (String key: then_branch.keySet()){
                if (else_branch.get(key) == null){
                    max_branch.put(key, then_branch.get(key));
                } else {
                    max_branch.put(key, Math.max(else_branch.get(key), then_branch.get(key)));
                }
            }
            for (String key: guard_branch.keySet()){
                if (max_branch.get(key) == null){
                    max_branch.put(key, guard_branch.get(key));
                } else {
                    max_branch.put(key, Math.max(max_branch.get(key), guard_branch.get(key)));
                }
            }
            for (String key: max_branch.keySet()){
                e.addVariable(key, new VarInfo(max_branch.get(key)));
            }
        } else { //calculating effects if there is only then branch
            then_branch = e.getBranch();
            e.closeScope();
            guard_branch = e.getBranch();
            e.closeScope();
            for (String key: then_branch.keySet()){
                max_branch.put(key, then_branch.get(key));
            }
            for (String key: guard_branch.keySet()){
                if (max_branch.get(key) == null){
                    max_branch.put(key, guard_branch.get(key));
                } else {
                    max_branch.put(key, Math.max(max_branch.get(key), guard_branch.get(key)));
                }
            }
            for (String key: max_branch.keySet()){
                e.addVariable(key, new VarInfo(max_branch.get(key)));
            }
        }
        return res;
    }

    @Override
    public String codeGeneration() {
        String l1 = SIMPLEPLUSlib.freshLabel();
        String l2 = SIMPLEPLUSlib.freshLabel();
        return this.exp.codeGeneration()+
                "push 1\n"+
                "beq "+ l1 +"\n"+
                this.elseBranch.codeGeneration()+
                "b " + l2 + "\n" +
                l1 + ":\n"+
                this.thenBranch.codeGeneration()+
                l2 + ":\n";
    }
    @Override
    public Integer checkVarDec(){return null;}
}
