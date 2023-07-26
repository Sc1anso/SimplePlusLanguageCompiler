package ast;

import gen.SimplePlusBaseVisitor;
import gen.SimplePlusParser.*;

import java.util.ArrayList;

public class SimplePlusVisitorImpl extends SimplePlusBaseVisitor<SimplePlusElementBase> {

	@Override
	public SimplePlusElementBase visitBlock(BlockContext ctx) {

		ArrayList<SimplePlusStmt> children = new ArrayList<SimplePlusStmt>();

		for(StatementContext stmtCtx : ctx.statement())
			children.add((SimplePlusStmt) visitStatement(stmtCtx));

		return new SimplePlusStmtBlock(children);
	}
	
	@Override
	public SimplePlusElementBase visitStatement(StatementContext ctx) {
		return visit(ctx.getChild(0));
	}

	@Override
	public SimplePlusElementBase visitDeclaration(DeclarationContext ctx) { return visit(ctx.getChild(0)); }

	@Override
	public SimplePlusElementBase visitDecFun(DecFunContext ctx) {
		//initialize @res with the visits to the type and its ID
		SimplePlusElementFun res = new SimplePlusElementFun(ctx.ID().getText(), ctx.type().getText());

		//add argument declarations
		//we are getting a shortcut here by constructing directly the ParNode
		//this could be done differently by visiting instead the VardecContext

		for(ArgContext vc : ctx.arg()){
			if (vc.ref() != null && vc.ref().getText().equals("var")){
				res.addPar(new SimplePlusFunArgs(vc.ID().getText(), vc.type().getText(), true));
			} else{
				res.addPar(new SimplePlusFunArgs(vc.ID().getText(), vc.type().getText(), false));
			}
		}

		//add body
		//create a list for the nested statements
		ArrayList<SimplePlusStmt> funBody = new ArrayList<SimplePlusStmt>();

		//check whether there are actually nested decs
		if(ctx.block() != null){
			//System.out.println();
			funBody.add((SimplePlusStmt) visit(ctx.block()));
		}

		//get the exp body
		//StatementContext exp = visit(ctx.block().statement());

		//add the body and the inner declarations to the function
		res.addDecBody(funBody);

		return res;
	}

	@Override
	public SimplePlusElementBase visitDecVar(DecVarContext ctx){
		String type = ctx.type().getText();
		String ID = ctx.ID().getText();
		SimplePlusExp exp = null;
		if (ctx.exp() != null){
			exp = (SimplePlusExp) visit(ctx.exp());
		}

		return new SimplePlusVarDec(type, ID, exp);
	}
	
	@Override
	public SimplePlusElementBase visitAssignment(AssignmentContext ctx) {
		SimplePlusExp exp = (SimplePlusExp) visit(ctx.exp());

		SimplePlusExpVar id = new SimplePlusExpVar(ctx.ID().getText());

		return new SimplePlusStmtAssignment(id,exp);
	}
	
	@Override
	public SimplePlusElementBase visitDeletion(DeletionContext ctx) {

		return new SimplePlusStmtDelete(ctx.ID().getText());

	}
	
	@Override
	public SimplePlusElementBase visitPrint(PrintContext ctx) {

		SimplePlusExp exp = (SimplePlusExp) visit(ctx.exp());
		return new SimplePlusStmtPrint(exp);
	}
	
	@Override
	public SimplePlusElementBase visitBaseExp(BaseExpContext ctx) {
		return visit(ctx.exp());
	}
	
	@Override
	public SimplePlusElementBase visitNegExp(NegExpContext ctx) {
		return new SimplePlusExpNeg((SimplePlusExp) visit(ctx.exp()));
	}
	
	@Override
	public SimplePlusElementBase visitBinExp(BinExpContext ctx) {

		SimplePlusExp left = (SimplePlusExp) visit(ctx.left);

		SimplePlusExp right = (SimplePlusExp) visit(ctx.right);

		switch (ctx.op.getText()) {
			case "+": return new SimplePlusExpSum(left, right);
			case "-": return new SimplePlusExpDiff(left, right);
			case "*": return new SimplePlusExpMult(left, right);
			case "/": return new SimplePlusExpDiv(left, right);
			case "<": return new SimplePlusLessThan(left, right);
			case "<=": return new SimplePlusLessEqThan(left, right);
			case ">": return new SimplePlusMoreThan(left, right);
			case ">=": return new SimplePlusMoreEqThan(left, right);
			case "==": return new SimplePlusCompEq(left, right);
			case "!=": return new SimplePlusCompNotEq(left, right);
			case "&&": return new SimplePlusAnd(left, right);
			case "||": return new SimplePlusOr(left, right);
			default: return null; //this should not happen
		}

	}

	@Override
	public SimplePlusElementBase visitBoolExp(BoolExpContext ctx) {
		return new SimplePlusExpBool(Boolean.parseBoolean(ctx.BOOL().getText()));
	}

	@Override
	public SimplePlusElementBase visitValExp(ValExpContext ctx) {
		return new SimplePlusExpVal(Integer.parseInt(ctx.NUMBER().getText()));
	}
	
	@Override
	public SimplePlusElementBase visitVarExp(VarExpContext ctx) {
		return new SimplePlusExpVar(ctx.ID().getText());
	}

	@Override
	public SimplePlusElementBase visitRet(RetContext ctx) {
		return new SimplePlusStmtRet((SimplePlusExp) visit(ctx.exp()));
	}

	@Override
	public SimplePlusElementBase visitIte(IteContext ctx) {

		SimplePlusExp exp = (SimplePlusExp) visit(ctx.exp());

		SimplePlusStmt thenStmt = (SimplePlusStmt) visit(ctx.statement(0));
		SimplePlusStmt elseStmt = (SimplePlusStmt) visit(ctx.statement(1));

		return new SimplePlusStmtIte(exp, thenStmt, elseStmt);
	}

	@Override
	public SimplePlusElementBase visitCall(CallContext ctx){
		String id = ctx.ID().getText();
		ArrayList<SimplePlusExp> args = new ArrayList<SimplePlusExp>();
		for(ExpContext ex: ctx.exp()){
			args.add((SimplePlusExp) visit(ex));
		}
		return new SimplePlusStmtCall(id, args);
	}
}
