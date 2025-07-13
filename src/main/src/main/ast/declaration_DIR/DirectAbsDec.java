package main.ast.declaration_DIR;

import main.ast.baseNodes_DIR.Node;
import main.ast.expression_DIR.Expression;
import main.ast.statement_DIR.ParameterList;
import main.visitor.IVisitor;

public class DirectAbsDec extends Node {
    private Expression expression;
    private AbstractDec abstractDec;
    private ParameterList parameterList;
    private DirectAbsDec directAbsDec;

    public DirectAbsDec() {
        expression = null;
        abstractDec = null;
        parameterList = null;
        directAbsDec = null;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public AbstractDec getAbstractDec() {
        return abstractDec;
    }

    public void setAbstractDec(AbstractDec abstractDec) {
        this.abstractDec = abstractDec;
    }

    public ParameterList getParameterList() {
        return parameterList;
    }

    public void setParameterList(ParameterList parameterList) {
        this.parameterList = parameterList;
    }

    public DirectAbsDec getDirectAbsDec() {
        return directAbsDec;
    }

    public void setDirectAbsDec(DirectAbsDec directAbsDec) {
        this.directAbsDec = directAbsDec;
    }
}
