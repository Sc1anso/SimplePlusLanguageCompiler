package ast;

import java.util.ArrayList;
import java.util.HashMap;

public class VarInfo {
    private Integer nestlev;
    private Integer offset;
    private String type;
    private Boolean reference;
    private Boolean function;
    private Boolean funarg;
    private Integer val;
    private Integer nparams;
    private ArrayList<String> domain;
    private HashMap<String, Integer> eff_domain;
    private Integer effect;
    //private final String paramOfFun;

    public VarInfo (Integer nl, Integer of, String t, Integer v, Boolean refpass, Boolean function, Boolean funarg){
        this.nestlev = nl;
        this.offset = of;
        this.type = t;
        this.val = v;
        this.reference = refpass;
        this.function = function;
        this.funarg = funarg;
        //this.paramOfFun = pof;
    }

    public VarInfo (Integer nl, Integer of, String t, Integer v, Boolean refpass, Boolean function, Boolean funarg, Integer npar, ArrayList<String> dom){
        this.nestlev = nl;
        this.offset = of;
        this.type = t;
        this.val = v;
        this.reference = refpass;
        this.function = function;
        this.funarg = funarg;
        this.nparams = npar;
        this.domain = dom;
    }

    public VarInfo(Integer ef){
        this.effect = ef;
    }
    public VarInfo(HashMap<String, Integer> ef_dom){
        this.eff_domain = ef_dom;
    }

    public Integer getNestlev(){
        return this.nestlev;
    }
    public Integer getOffset(){
        return this.offset;
    }

    public Integer getVal() {
        return this.val;
    }

    public String getType() {
        return this.type;
    }
    public Boolean getReference(){
        return this.reference;
    }

    public Boolean getFunction() {
        return function;
    }

    public Boolean getFunarg() {
        return funarg;
    }

    public Integer getNparams() {
        return nparams;
    }

    public Integer getEffect(){return effect;}

    public ArrayList<String> getDomain() {
        return domain;
    }

    public HashMap<String, Integer> getEff_domain() {
        return eff_domain;
    }
}
