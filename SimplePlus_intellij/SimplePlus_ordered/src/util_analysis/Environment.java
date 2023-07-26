package util_analysis;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import ast.VarInfo;

public class Environment {

	//contains the stack of scopes. the last one is always the current active scope
	//this linked list is used as a stack with LIFO behavior
	LinkedList<HashMap<String, VarInfo>> scopes = new LinkedList<HashMap<String,VarInfo>>();
	Integer decl_in_ite = 0;
	LinkedList<String> fun_args = new LinkedList<String>();
	Integer add_pop = 0;
	Integer call_count = 0;
	//Integer count_size = 0;
	
	public void addVariable(String id, VarInfo val) {
		scopes.peek().put(id, val);
	}

	public void addDec_ite(Integer decs){ decl_in_ite += decs; }

	public Integer getDec_ite(){ return decl_in_ite; }

	public void addNameFunArg(String id){
		fun_args.push(id);
	}

	public void incCallCount() {
		call_count++;
	}

	public Integer getCallCount(){
		return call_count;
	}

	public LinkedList<String> getNameFunArg(){
		return fun_args;
	}

	public void addPop(){
		add_pop++;
	}
	public Integer getPoptoadd(){
		return add_pop;
	}
	/** 
	 * Inserts a new scope into the environment.
	 * When a scope is inserted old scope is clone so previous defined
	 * variables still exist
	 */
	public void openScope(){
		scopes.push(new HashMap<String, VarInfo>());
	}
	
	
	/**
	 * Drops the current scope and returns to the outer scope
	 * removing all changes and additions done within this scope 
	 */
	public void closeScope(){
		scopes.pop();
	}
	
	/**
	 * Given an id determines if the variable belongs to the environment
	 * this is to check the scopes from inner to outer looking for the variable
	 * @param id
	 */
	public boolean containsVariable(String id){
		
		for(HashMap<String, VarInfo> scope:scopes){
			if(scope.containsKey(id))
				return true;
		}
		
		return false;
	}

	public boolean containsVariableCurrScope(String id){
		return scopes.peek().containsKey(id);
	}

	public Integer containsRefVariable(String id){
		Integer count = 0;
		for(HashMap<String, VarInfo> scope:scopes){
			count ++;
			if(scope.containsKey(id))
				return count;
		}
		return 0;
	}

	public Integer getSize(){
		Integer count_size = 0;
		for(HashMap<String, VarInfo> scope:scopes){
			count_size ++;
		}
		return count_size;
	}

	public Integer getOffset(){
		Integer count = 0;
		Integer varnum = 1;

		for(HashMap<String, VarInfo> scope: scopes){
			count ++;
			//varnum = scope.size();
			//System.out.println("\n" + scope.keySet() + "\n");
			for (String key: scope.keySet()){
				varnum++;
				//System.out.println(key + " varnum = offset --> " + varnum);
			}
			//System.out.println(scope.size());
			/*for(Integer i = 0; i < varnum; i++){
				count++;
			}*/

			//System.out.println("varnum: " + varnum);
		}
		//System.out.println("count: " + count);
		//System.out.println("scopes size: " + varnum);
		return varnum;
	}

	public Integer getParNl1(Integer nest_lvl){
		Integer size = 0;
		Integer count = scopes.size();
		for (HashMap<String, VarInfo> scope: scopes){
			if (count < nest_lvl && count > 0){
				size += scope.keySet().size();
			}
			count--;
			//System.out.println("size nl " + count + ": " + size);
			//System.out.println(scope);
			//break;
		}
		return size;
	}
	
	/**
	 * Remove the variable with the given id from the first scope that contains it
	 * notice that if the variable exists in an outer scope it will have
	 * that value
	 * @param id
	 */
	public void deleteVariable(String id){
		for(HashMap<String, VarInfo> scope:scopes){
			if(scope.containsKey(id)){
				scope.remove(id);
				return;
			}
		}
	}
	
	/**
	 * Check for variable
	 * @param id of the variable
	 * @return variable value, null if the variable doesnt exist
	 */
	public Integer getVariableValue(String id){
		for(HashMap<String, VarInfo> scope:scopes){
			if(scope.containsKey(id)){
				return scope.get(id).getVal();
			}
		}
		
		return null;
	}

	public Integer getVariableNestLevel(String id){
		for(HashMap<String, VarInfo> scope:scopes){
			if(scope.containsKey(id)){
				return scope.get(id).getNestlev();
			}
		}

		return null;
	}

	public Integer getVariableOffset(String id){
		for(HashMap<String, VarInfo> scope:scopes){
			if(scope.containsKey(id)){
				return scope.get(id).getOffset();
			}
		}

		return null;
	}

	public String getVariableType(String id){
		for(HashMap<String, VarInfo> scope:scopes){
			if(scope.containsKey(id)){
				return scope.get(id).getType();
			}
		}
		return null;
	}

	public Integer getVarEffect(String id){
		for(HashMap<String, VarInfo> scope:scopes){
			if(scope.containsKey(id)){
				return scope.get(id).getEffect();
			}
		}
		return null;
	}

	public void printEnv(){
		Integer lvl = scopes.size();
		for(HashMap<String, VarInfo> scope:scopes){
			System.out.println("livello: " + lvl--);
			for (String key: scope.keySet()){
				if (scope.get(key).getEffect() == null){
					System.out.println("id: " + key + " effect domain: " + scope.get(key).getEff_domain());
				}
				else
					System.out.println("id: " + key + " effect: " + scope.get(key).getEffect());
			}
		}
	}

	public void printSemEnv(){
		Integer lvl = scopes.size();
		for(HashMap<String, VarInfo> scope:scopes){
			System.out.println("livello: " + lvl--);
			for (String key: scope.keySet()){
				System.out.println("id: " + key + " offset: " + scope.get(key).getOffset() + " nesting level: " + scope.get(key).getNestlev());
			}
		}
	}

	public Integer getFunDomSize(){
		for (HashMap<String, VarInfo> scope: scopes){
			for (String key: scope.keySet()){
				if (scope.get(key).getDomain() != null){
					return scope.get(key).getDomain().size();
				}
			}
		}
		return null;
	}

	public HashMap<String, Integer> getBranch(){
		HashMap<String, VarInfo> branch = scopes.peek();
		HashMap<String, Integer> res = new HashMap<String, Integer>();
		for (String key: branch.keySet()){
			res.put(key, branch.get(key).getEffect());
		}
		return res;
	}

	public HashMap<String, VarInfo> getSemBranch(){
		return scopes.peek();
	}

	public HashMap<String, HashMap<String, Integer>> getFunEffDomain(){
		HashMap<String, HashMap<String, Integer>> res = new HashMap<String, HashMap<String, Integer>>();
		for (HashMap<String, VarInfo> branch: scopes){
			for (String key: branch.keySet()){
				if (branch.get(key).getEff_domain() != null)
					res.put(key, branch.get(key).getEff_domain());
			}
		}
		return res;
	}

	public Integer getNumFunPar(String id){
		for(HashMap<String, VarInfo> scope:scopes){
			if(scope.containsKey(id)){
				return scope.get(id).getNparams();
			}
		}

		return null;
	}

	public Boolean isVarPass(String id){
		for(HashMap<String, VarInfo> scope:scopes){
			if(scope.containsKey(id)){
				return scope.get(id).getReference();
			}
		}

		return null;
	}

	public Boolean isFunction(String id){
		for(HashMap<String, VarInfo> scope:scopes){
			if(scope.containsKey(id)){
				return scope.get(id).getFunction();
			}
		}

		return null;
	}

	public Boolean isFunarg(String id){
		for(HashMap<String, VarInfo> scope:scopes){
			if(scope.containsKey(id)){
				return scope.get(id).getFunarg();
			}
		}

		return null;
	}

	public HashMap<Integer, String> listFunPar(String id){
		HashMap<Integer, String> res = new HashMap<Integer, String>();
		Boolean funparzone = false;
		for(HashMap<String, VarInfo> scope:scopes){
			System.out.println("scope");
			System.out.println(scopes);
			if(scope.containsKey(id)){
				funparzone = true;
			} else{
				funparzone = false;
			}
			if (funparzone){
				Integer count = 0;
				for (String i: scope.keySet()){
					//System.out.println(i);
					res.put(count, i);
					count ++;
				}
			}
		}
		return res;
	}

	public ArrayList<String> getFunDomain(String id){
		for(HashMap<String, VarInfo> scope:scopes){
			if(scope.containsKey(id)){
				return scope.get(id).getDomain();
			}
		}
		return null;
	}

	public String getFunType(){
		for (HashMap<String, VarInfo> scope: scopes){
			for (String fcheck: scope.keySet()){
				if (scope.get(fcheck).getFunction()){
					return scope.get(fcheck).getType();
				}
			}
		}
		return null;
	}

	/**
	 * Check local scope for variable
	 * @param id of the variable
	 * @return variable value in current scope, null otherwise
	 */
	public Integer getVariableValueLocal(String id){
		
		return scopes.peek().get(id).getVal();
		
	}

}
