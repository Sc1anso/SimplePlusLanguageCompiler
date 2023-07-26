package ast;

import behavioural_analysis.BTBase;
import util_analysis.Environment;
import util_analysis.SemanticError;
import util_analysis.Strings;

import java.util.ArrayList;

public class SimplePlusFunArgs extends SimplePlusStmt{

    private final String id;
    private final String type;
    private final Boolean ref;
    private Integer offset;

    public SimplePlusFunArgs (String i, String t, Boolean r) {
        this.id = i;
        this.type = t;
        this.ref = r;

    }

    public String getId(){
        return id;
    }

    public String getType(){
        return this.type;
    }

    public Boolean getRef() {
        return ref;
    }

    public Integer getOffset(){return this.offset;}

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment e){
        ArrayList<SemanticError> res = new ArrayList<SemanticError>();
        //check semantics for function arguments, if is already declared give an error
        if (e.containsVariableCurrScope(this.id)){
            res.add(new SemanticError(Strings.ErrorVariableDeclared + this.id));
        }
        return res;
    }

    @Override
    public ArrayList<SemanticError> inferBehavior(Environment e){
        return null;
    }

    @Override
    public String codeGeneration(){
        return "";
    }

    @Override
    public Integer checkVarDec(){return null;}
}
