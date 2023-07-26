package ast;

import behavioural_analysis.BTBase;
import behavioural_analysis.BTBlock;
import lib.SIMPLEPLUSlib;
import util_analysis.Environment;
import util_analysis.SemanticError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class SimplePlusElementFun extends SimplePlusStmt {
    private final String type;
    private final String id;
    private Integer dec_ite;
    private Integer pop_to_add;
    private ArrayList<SimplePlusFunArgs> args = new ArrayList<SimplePlusFunArgs>();
    //private ArrayList<SimplePlusElementBase> parlist = new ArrayList<SimplePlusElementBase>();
    private ArrayList<SimplePlusStmt> declist = new ArrayList<SimplePlusStmt>();


    public SimplePlusElementFun (String i, String t) {
        this.id = i;
        this.type = t;
    }

    public void addDecBody (ArrayList<SimplePlusStmt> d) {
        this.declist = d;

    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment e){
        //create result list
        ArrayList<SemanticError> res = new ArrayList<SemanticError>();
        ArrayList<SemanticError> resBody = new ArrayList<SemanticError>();
        ArrayList<String> dom = new ArrayList<String>();

        //calculating domain of type of function
        for(SimplePlusFunArgs ar: args){
            dom.add(ar.getType());
        }

        //insert fun id in current scope
        e.addVariable(this.id, new VarInfo(e.getSize(), e.getOffset(), this.type, -10, false, true, false, args.size(), dom));


        //open new scope for arguments and for declarations in function body
        e.openScope();

        for(SimplePlusFunArgs ar: args){
            //check semantics of fun args
            res.addAll(ar.checkSemantics(e));
            if (res.size() == 0){
                e.addVariable(ar.getId(), new VarInfo(e.getSize(), e.getOffset(), ar.getType(), -11, ar.getRef(), false, true));
                e.addNameFunArg(ar.getId());

            }
        }
        //check semantics for instructions in function body
        for(SimplePlusStmt st: declist){
            resBody.addAll(st.checkSemantics(e));
            if (resBody.size() > 0){
                res.addAll(resBody);
            }
        }

        e.closeScope();
        dec_ite = e.getDec_ite();
        pop_to_add = e.getPoptoadd();
        return res;
    }

    @Override
    public ArrayList<SemanticError> inferBehavior(Environment e){
        ArrayList<SemanticError> res = new ArrayList<SemanticError>();
        HashMap<String, Integer> eff_dom_fun = new HashMap<String, Integer>();
        HashMap<String, Integer> new_eff_dom_fun = new HashMap<String, Integer>();
        HashMap<String, Integer> check_dom = new HashMap<String, Integer>();

        //set fun args effect = 0
        for(SimplePlusFunArgs ar: args){
            //System.out.println("argomenti: " + ar.getId());
            eff_dom_fun.put(ar.getId(), 0);
        }

        e.addVariable(this.id, new VarInfo(eff_dom_fun));

        e.openScope();

        for(SimplePlusFunArgs ar: args){
            e.addVariable(ar.getId(), new VarInfo(0));
        }

        //CALCULATING EFFECTS FOR FUN BODY
        for (SimplePlusStmt st: declist){
            res.addAll(st.inferBehavior(e));
        }

        for (String key: eff_dom_fun.keySet()){
            check_dom.put(key, eff_dom_fun.get(key));
        }

        new_eff_dom_fun = eff_dom_fun;
        eff_dom_fun = e.getBranch();
        for (String key: new_eff_dom_fun.keySet()){
            if (eff_dom_fun.get(key) != null){
                new_eff_dom_fun.put(key, eff_dom_fun.get(key));
            }
        }

        //FIXPOINT COMPUTATION
        if (e.getCallCount() > 0){
            while (!check_dom.equals(new_eff_dom_fun)){
                //System.out.println(check_dom.equals(new_eff_dom_fun));

                for (SimplePlusStmt st: declist){
                    res.addAll(st.inferBehavior(e));
                }
                //System.out.println("eff dom fun: " + eff_dom_fun);
                for (String key: eff_dom_fun.keySet()){
                    check_dom.put(key, eff_dom_fun.get(key));
                }
                //System.out.println("check fun domain: " + check_dom);
                new_eff_dom_fun = eff_dom_fun;
                eff_dom_fun = e.getBranch();
                for (String key: new_eff_dom_fun.keySet()){
                    if (eff_dom_fun.get(key) != null){
                        new_eff_dom_fun.put(key, eff_dom_fun.get(key));
                    }
                }
            }
        }
        e.closeScope();
        e.addVariable(this.id, new VarInfo(new_eff_dom_fun));
        return res;
    }

    public void addPar (SimplePlusFunArgs p) {
        args.add(p);
    }

    @Override
    public String codeGeneration(){
        Integer decs = 0;
        String declCode="";
        if (declist!=null){
            for (SimplePlusStmt dec: declist) {
                //System.out.println(declist);
                decs+= dec.checkVarDec();
                declCode+=dec.codeGeneration();
            }
        }
        //System.out.println("dec fun code: " + declCode);

        String popDecl="";
        if (declist!=null) for (Integer i = 0; i < (decs + dec_ite); i++){
            //popDecl+="pop\n";
        }
        //System.out.println("dec pop code: " + popDecl);


        String argCode="";
        /*for (SimplePlusFunArgs dec: args) {
            //System.out.println(dec.getId() + " off: " + dec.getOffset());
            argCode += "push " + dec.getOffset() + "\n" +
                    "lfp\n" +
                    "add\n" +
                    "lw\n";
        }*/
        String popParl="";
        for (SimplePlusFunArgs dec: args)
            popParl+="pop\n";
        for (Integer i = 0; i < pop_to_add; i++){
            popParl+="pop\n";
        }

        String funl= SIMPLEPLUSlib.freshFunLabel();
        SIMPLEPLUSlib.putCode(funl+":\n"+
                "cfp\n"+ 		// setta $fp a $sp
                "lra\n"+ 		// inserimento return address
                //argCode+        // inserimento parametri di funzione
                declCode+ 		// inserimento dichiarazioni locali
                "srv\n"+ 		// pop del return value
                popDecl+        //pop dichiarazioni locali
                "sra\n"+ 		// pop del return address
                "pop\n"+ 		// pop di AL
                popParl+        // pop parametri di funzione
                //"pop\n"+
                "sfp\n"+  		// setto $fp a valore del CL
                "lrv\n"+ 		// risultato della funzione sullo stack
                "lra\n"+"js\n"  // salta a $ra
        );

        return "push "+ funl +"\n";

    }
    @Override
    public Integer checkVarDec(){ return null;}
}
