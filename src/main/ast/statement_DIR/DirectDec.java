package main.ast.statement_DIR;

import main.ast.expression_DIR.IdentifierList;
import main.ast.baseNodes_DIR.Node;
import main.ast.expression_DIR.Expr;
import main.visitor.IVisitor;

public class DirectDec extends Node {
    private String identifier;
    private Declarator declarator;
    private DirectDec directDec;
    private Expr expr;
    private ParameterList parameterList;
    private IdentifierList identifierList;

    public DirectDec() {
        declarator = null;
        directDec = null;
        expr = null;
        parameterList = null;
        identifierList = null;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Declarator getDeclarator() {return declarator;}
    public void setDeclarator(Declarator declarator) { this.declarator = declarator; }

    public DirectDec getDirectDec() { return directDec; }
    public void setDirectDec(DirectDec directDec) { this.directDec = directDec; }

    public String getIdentifier() { return identifier; }
    public void setIdentifier(String identifier) { this.identifier = identifier; }

    public Expr getExpr() { return expr; }
    public void setExpr(Expr expr) { this.expr = expr; }

    public ParameterList getParameterList() { return parameterList; }
    public void setParameterList(ParameterList parameterList) { this.parameterList = parameterList; }

    public IdentifierList getIdentifierList() { return identifierList; }
    public void setIdentifierList(IdentifierList identifierList) { this.identifierList = identifierList; }
}
