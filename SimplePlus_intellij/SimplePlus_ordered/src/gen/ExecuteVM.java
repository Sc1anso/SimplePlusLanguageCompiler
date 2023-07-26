package gen;

public class ExecuteVM {
    
    public static final int CODESIZE = 10000;
    public static final int MEMSIZE = 10000;
 
    private int[] code;
    private int[] memory = new int[MEMSIZE];
    
    private int ip = 0;
    private int sp = MEMSIZE;
    private int hp = 0;       
    private int fp = MEMSIZE; 
    private int ra;           
    private int rv;
    
    public ExecuteVM(int[] code) {
      this.code = code;
    }
    
    public void cpu() {
      while ( true ) {
          //System.out.println("hp: " + hp);
          //System.out.println("sp: " + sp);
          //System.out.println(code[ip]);
    	if(hp+1>=sp) {
    		System.out.println("\nError: Out of memory");
            return;
    	}
    	else {
            //System.out.println("bytecodee: " + code[ip]);
    		int bytecode = code[ip++]; // fetch
            int v1,v2;
            int address;
            //System.out.println("ip: " + ip);
            //System.out.println("sp: " + sp);
            //System.out.println("hp: " + hp);
            //System.out.println("fp: " + fp);
            //System.out.println("ra: " + ra);
            //System.out.println("rv: " + rv);
            switch ( bytecode ) {
              case SVMParser.PUSH:
                push( code[ip++] );
                break;
              case SVMParser.POP:
                pop();
                break;
              case SVMParser.ADD :
                v1=pop();
                v2=pop();
                push(v2 + v1);
                break;
              case SVMParser.MULT :
                v1=pop();
                v2=pop();
                push(v2 * v1);
                break;
              case SVMParser.DIV :
                v1=pop();
                v2=pop();
                push(v2 / v1);
                break;
              case SVMParser.SUB :
                v1=pop();
                v2=pop();
                push(v2 - v1);
                break;
              case SVMParser.NEG :
                v1 = pop();
                push((v1 - (2 * v1)));
                break;
              case SVMParser.NOT :
                v1 = pop();
                if (v1 == 1) push(0);
                else push(1);
                break;
              case SVMParser.STOREW : //
                address = pop();
                memory[address] = pop();    
                break;
              case SVMParser.LOADW : //
            	// check if object address where we take the method label
            	// is null value (-10000)
                if (memory[sp] == -10000) {
                	System.out.println("\nError: Null pointer exception");
                	return;
                }  
                push(memory[pop()]);
                break;
              case SVMParser.BRANCH : 
                address = code[ip];
                ip = address;
                break;
              case SVMParser.BRANCHEQ : //
                address = code[ip++];
                v1=pop();
                v2=pop();
                //System.out.println("EQ v1: " + v1);
                //System.out.println("EQ v2: " + v2);
                if (v2 == v1) ip = address;
                break;
              case SVMParser.BRANCHNEQ : //
                address = code[ip++];
                v1=pop();
                v2=pop();
                //System.out.println("EQ v1: " + v1);
                //System.out.println("EQ v2: " + v2);
                if (v2 != v1) ip = address;
                break;
              case SVMParser.BRANCHLESS :
                address = code[ip++];
                v1=pop();
                v2=pop();
                if (v2 < v1) ip = address;
                break;
              case SVMParser.BRANCHLESSEQ :
                address = code[ip++];
                v1=pop();
                v2=pop();
                if (v2 <= v1) ip = address;
                break;
              case SVMParser.BRANCHMORE :
                address = code[ip++];
                v1=pop();
                v2=pop();
                //System.out.println("MORE v1: " + v1);
                //System.out.println("MORE v2: " + v2);
                if (v2 > v1) ip = address;
                break;
              case SVMParser.BRANCHMOREQ :
                address = code[ip++];
                v1=pop();
                v2=pop();
                if (v2 >= v1) ip = address;
                break;
              case SVMParser.BRANCHAND :
                address = code[ip++];
                v1=pop();
                v2=pop();
                if (v2==1 && v1==1) ip = address;
                break;
              case SVMParser.BRANCHOR :
                address = code[ip++];
                v1=pop();
                v2=pop();
                if (v2==1 || v1==1) ip = address;
                break;
              case SVMParser.JS : //	
            	address = pop();
                ra = ip;
                ip = address;
                break;
             case SVMParser.STORERA : //
                ra=pop();
                break;
             case SVMParser.LOADRA : //
                push(ra);
                break;
             case SVMParser.STORERV : //
                rv=pop();
                break;
             case SVMParser.LOADRV : //
                push(rv);
                break;
             case SVMParser.LOADFP : //
                push(fp);
                break;
             case SVMParser.STOREFP : //
                fp=pop();
                break;
             case SVMParser.COPYFP : //
                fp=sp;
                break;
             case SVMParser.STOREHP : //
                hp=pop();
                break;
             case SVMParser.LOADHP : //
                push(hp);
                break;
             case SVMParser.RETURN :
                System.out.println((sp<MEMSIZE)?memory[sp]:"Empty stack!");
                break;
             case SVMParser.DELETE :
                 //System.out.println(memory[sp]);
                pop();
                 //System.out.println(memory[sp]);
                break;
             case SVMParser.PRINT :
                System.out.println((sp<MEMSIZE)?memory[sp]:"Empty stack!");
                break;
             case SVMParser.HALT :
            	//to print the result 
             	System.out.println("\nResult: " + memory[sp] + "\n");
             	return;
            }
    	} 
      }
    } 
    
    private int pop() {
      return memory[sp++];
    }
    
    private void push(int v) {
      memory[--sp] = v;
    }
    
}