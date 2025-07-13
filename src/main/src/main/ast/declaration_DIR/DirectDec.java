package main.ast.declaration_DIR;

import main.ast.baseNodes_DIR.Node;
import main.ast.expression_DIR.Expression;
import main.ast.expression_DIR.IdentifierList;
import main.ast.literal_DIR.TypeSpecifier;
import main.ast.statement_DIR.ParameterList;
import main.visitor.IVisitor;

public class DirectDec extends Node {
    private String identifier = "";
    private Declarator declarator;
    private DirectDec directDec;
    private Expression expression;
    private ParameterList parameterList;
    private IdentifierList identifierList;
    private TypeSpecifier typeSpecifier;

    public DirectDec() {
        declarator = null;
        directDec = null;
        expression = null;
        parameterList = null;
        identifierList = null;
        typeSpecifier = null;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Declarator getDeclarator() {
        return declarator;
    }

    public void setDeclarator(Declarator declarator) {
        this.declarator = declarator;
    }

    public DirectDec getDirectDec() {
        return directDec;
    }

    public void setDirectDec(DirectDec directDec) {
        this.directDec = directDec;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public ParameterList getParameterList() {
        return parameterList;
    }

    public void setParameterList(ParameterList parameterList) {
        this.parameterList = parameterList;
    }

    public IdentifierList getIdentifierList() {
        return identifierList;
    }

    public void setIdentifierList(IdentifierList identifierList) {
        this.identifierList = identifierList;
    }

    public TypeSpecifier getTypeSpecifier() {
        return typeSpecifier;
    }

    public void setTypeSpecifier(TypeSpecifier typeSpecifier) {
        this.typeSpecifier = typeSpecifier;
    }
}
