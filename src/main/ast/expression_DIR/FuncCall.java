package main.ast.expression_DIR;

import main.visitor.IVisitor;

import java.util.List;

public class FuncCall extends Expr{
    private Expr expr;
    private ArgExpr argExpr;

    public FuncCall(Expr expr){
        this.expr = expr;
        argExpr = null;
    }
    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Expr getExpr(){ return expr; }

    public ArgExpr getArgExpr(){ return argExpr; }
    @Override
    public void setArgExpr(ArgExpr argExpr){ this.argExpr = argExpr; }

    public int getNumArgs(){
        if (argExpr == null) return 0;
        int argNum = 1;
        List <Expr> args = argExpr.getExprs();

        for (Expr arg : args){
            if (arg instanceof CommaExpr) {
                argNum++;
                argNum += dfsFunction(((CommaExpr) arg).getExprs());
            }
        }

        return argNum;
    }

    private int dfsFunction(List<Expr> exprs){
        int dfs = 0;
        for (Expr expr : exprs){
            if (expr instanceof CommaExpr) {
                dfs++;
                dfs += dfsFunction(((CommaExpr) expr).getExprs());
            }
        }
        return dfs;
    }
}
