package main.ast.declaration_DIR;

import main.ast.nodes_DIR.Node;
import main.ast.expression_DIR.Expr;
import main.visitor.IVisitor;

public class DirectAbstractDeclarator extends Node {
    private Expr expression;
    private AbstractDeclarator abstractDeclarator;
    private ParameterList parameterList;
    private DirectAbstractDeclarator previousDeclarator;

    public DirectAbstractDeclarator(Expr expression) {
        this.expression = expression;
    }

    public DirectAbstractDeclarator() {}

    public DirectAbstractDeclarator(AbstractDeclarator abstractDeclarator) {
        this.abstractDeclarator = abstractDeclarator;
    }

    public DirectAbstractDeclarator(ParameterList parameterList) {
        this.parameterList = parameterList;
    }

    public DirectAbstractDeclarator(DirectAbstractDeclarator previousDeclarator, Expr expression) {
        this.previousDeclarator = previousDeclarator;
        this.expression = expression;
    }

    public DirectAbstractDeclarator(DirectAbstractDeclarator previousDeclarator, ParameterList parameterList) {
        this.previousDeclarator = previousDeclarator;
        this.parameterList = parameterList;
    }

    public Expr getExpression() {
        return expression;
    }

    public void setExpression(Expr expression) {
        this.expression = expression;
    }

    public AbstractDeclarator getAbstractDeclarator() {
        return abstractDeclarator;
    }

    public void setAbstractDeclarator(AbstractDeclarator abstractDeclarator) {
        this.abstractDeclarator = abstractDeclarator;
    }

    public ParameterList getParameterList() {
        return parameterList;
    }

    public void setParameterList(ParameterList parameterList) {
        this.parameterList = parameterList;
    }

    public DirectAbstractDeclarator getPreviousDeclarator() {
        return previousDeclarator;
    }

    public void setPreviousDeclarator(DirectAbstractDeclarator previousDeclarator) {
        this.previousDeclarator = previousDeclarator;
    }

    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }



}
