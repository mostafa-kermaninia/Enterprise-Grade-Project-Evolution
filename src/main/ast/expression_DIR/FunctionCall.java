package main.ast.expression_DIR;

import main.visitor.IVisitor;

import java.util.List;

public class FunctionCall extends Expression {
    private Expression expression;
    private ArgumentExpression argumentExpression;

    public FunctionCall(Expression expression){
        this.expression = expression;
        argumentExpression = null;
    }
    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public void removeArg() {

        argumentExpression.removeLastExpr();
    }

    public Expression getExpression(){ return expression; }

    public ArgumentExpression getArgumentExpression(){ return argumentExpression; }
    @Override
    public void setArgumentExpression(ArgumentExpression argumentExpression){ this.argumentExpression = argumentExpression; }

    public int getNumArgs(){
        if (argumentExpression == null) return 0;
        int argNum = 1;
        List <Expression> args = argumentExpression.getExpressions();

        for (Expression arg : args){
            if (arg instanceof CommaExpression) {
                argNum++;
                argNum += dfsFunction(((CommaExpression) arg).getExpressions());
            }
        }

        return argNum;
    }

    private int dfsFunction(List<Expression> expressions){
        int dfs = 0;
        for (Expression expression : expressions){
            if (expression instanceof CommaExpression) {
                dfs++;
                dfs += dfsFunction(((CommaExpression) expression).getExpressions());
            }
        }
        return dfs;
    }
}
