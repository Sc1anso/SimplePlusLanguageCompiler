package ast;

import behavioural_analysis.BTAtom;
import behavioural_analysis.BTBase;
import util_analysis.Environment;
import util_analysis.SemanticError;
import util_analysis.Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class SimplePlusStmtCall extends SimplePlusStmt {
    private String id;
    private ArrayList<SimplePlusExp> args = new ArrayList<SimplePlusExp>();
    private Integer funof;
    private Integer dec_nl;
    private Integer call_nl;
    private LinkedList<String> parname = new LinkedList<String>();

    public SimplePlusStmtCall(String id, ArrayList<SimplePlusExp> args){
        this.id = id;
        this.args = args;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment e) {
        ArrayList<SemanticError> res = new ArrayList<SemanticError>();

        if (!e.containsVariable(this.id)){
            //check if function is declared
            res.add(new SemanticError(Strings.ErrorFunNotDec + this.id));
            return res;
        } else{
            //calculating function offsets for code generation
            funof = -(e.getVariableOffset(this.id) + 1);
            call_nl = e.getSize();
            dec_nl = e.getVariableNestLevel(this.id);
            //check if id is a function
            if (!e.isFunction(this.id)){
                res.add(new SemanticError(Strings.ErrorNotAFun + this.id));
            }
        }

        //CHECKING FOR CORRECT NUMBER OF PARAMETERS IN INPUT
        if (args.size() != e.getNumFunPar(this.id) && e.containsVariable(this.id) && e.isFunction(this.id)){
            res.add(new SemanticError(Strings.ErrorWrongParNum + this.id + " expected: " + e.getNumFunPar(this.id) + " passed: " + args.size()));

        }
        //CHECKING FOR CORRECT TYPE OF EXPRESSIONS PASSED AS PARAMETERS OF FUNCTION
        Integer idx = 0;
        parname = e.getNameFunArg();
        for (SimplePlusExp expres: this.args){ //ciclo gli argomenti passati e nel mentre con un contatore ciclo anche i parametri dichiarati
            //CHECKSEMANTICS FOR EXPRESSION
            if (expres.getId(e) != null){
                if (!parname.contains(expres.getId(e))){
                    e.addPop();
                }
            }
            res.addAll(expres.checkSemantics(e));

            if (idx < e.getFunDomain(this.id).size() && res.size() == 0){
                //System.out.println(idx);
                if (!expres.getType(e).equals(e.getFunDomain(this.id).get(idx))){
                    res.add(new SemanticError(Strings.ErrorTypeOfParams + e.getFunDomain(this.id).get(idx) + " and expression passed type: " + expres.getType(e)));
                }
            }
            idx ++;


        }
        return res;
    }

    @Override
    public ArrayList<SemanticError> inferBehavior(Environment e) {
        ArrayList<SemanticError> res = new ArrayList<SemanticError>();
        LinkedList<Integer> dom_list = new LinkedList<Integer>();
        HashMap<String, HashMap<String, Integer>> fun_dom = e.getFunEffDomain();
        Integer counter = 0;
        String old_id = "";

        e.incCallCount();
        //calculating domain of effects for function
        for (String key: fun_dom.get(this.id).keySet()){
            dom_list.push(fun_dom.get(this.id).get(key) + counter);
            if (old_id.equals(key)){
                counter++;
            }
            old_id = key;
        }
        //checking for aliasing
        for (SimplePlusExp exp: this.args){
            if (!exp.getClass().toString().contains("Val")){
                Integer old_ef = e.getVarEffect(exp.getId(e));
                Integer new_ef = dom_list.removeLast();

                res.addAll(exp.inferBehavior(e));
                if (exp.getId(e) != null){
                    if (old_ef < 2 && new_ef <= 2 && new_ef > old_ef){
                        e.addVariable(exp.getId(e), new VarInfo(new_ef));
                    } else if (old_ef >= 2){
                        e.addVariable(exp.getId(e), new VarInfo(3));
                        res.add(new SemanticError(Strings.ErrorProbableAliasing + exp.getId(e)));
                    }
                }
            }
        }
        return res;
    }

    @Override
    public String codeGeneration(){
        String arCode = "";
        String getAR = "";
        for (int i = args.size()-1; i >= 0; i--){
            if(args.get(i).toString().contains("SimplePlusExpVar")){
                arCode += args.get(i).codeGeneration2();
            } else {
                arCode += args.get(i).codeGeneration();
            }
        }
        if (!call_nl.equals(dec_nl)){
            getAR += "lw\n";
        }

        return "lfp\n"+ 				// CL
                arCode+
                "lfp\n"+getAR+ 		// setto AL risalendo la catena statica
                                // ora recupero l'indirizzo a cui saltare e lo metto sullo stack
                "push "+funof.toString()+"\n"+    // metto offset sullo stack
                "lfp\n"+getAR+ 		// risalgo la catena statica
                "add\n"+
                "lw\n"+ 				// carico sullo stack il valore all'indirizzo ottenuto
                "js\n";
    }
    @Override
    public Integer checkVarDec(){return null;}
}
