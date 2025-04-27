package main.ast.declaration_DIR;

import main.ast.nodes_DIR.Node;
import main.ast.expression_DIR.Expr;
import main.ast.expression_DIR.IdentifierList;
import main.visitor.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class DirectDeclarator extends Declarator {
    private String identifier;
    private Declarator declarator;
    private DirectDeclarator directDeclarator;
    private Expr size;
    private ParameterList parameterList;
    private IdentifierList identifierList;

    public DirectDeclarator(String identifier) {
        this.identifier = identifier;
    }

    public DirectDeclarator(Declarator declarator) {
        this.declarator = declarator;
    }

    public DirectDeclarator(DirectDeclarator directDeclarator) {
        this.directDeclarator = directDeclarator;
    }

    public DirectDeclarator(DirectDeclarator directDeclarator, Expr size) {
        this.directDeclarator = directDeclarator;
        this.size = size;
    }

    public DirectDeclarator(DirectDeclarator directDeclarator, ParameterList parameterList) {
        this.directDeclarator = directDeclarator;
        this.parameterList = parameterList;
    }

    public DirectDeclarator(DirectDeclarator directDeclarator, IdentifierList identifierList) {
        this.directDeclarator = directDeclarator;
        this.identifierList = identifierList;
    }

    public Declarator getDeclarator() {
        return declarator;
    }

    public Expr getSize() {
        return size;
    }

    public void setSize (Expr size_) {size = size_; }

    public ParameterList getParameterList() {
        return parameterList;
    }

    public IdentifierList getIdentifierList() {
        return identifierList;
    }

    public void setIdentifierList(IdentifierList identifierList_) {identifierList = identifierList_; }

    public String getIdentifier() {
        if (identifier != null) {
            return identifier;
        }

        if (directDeclarator != null) {
            return directDeclarator.getIdentifier();
        }

        return null;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public List<Node> get_child() {
        List<Node> children = new ArrayList<>();
        if (declarator != null)
            children.add(declarator);
        if (size != null)
            children.add(size);
        if (parameterList != null)
            children.add(parameterList);
        if (identifierList != null)
            children.add(identifierList);
        return children;
    }

}
