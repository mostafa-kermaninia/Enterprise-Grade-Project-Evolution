package main.ast.declaration_DIR;

import main.ast.nodes_DIR.Node;
import main.ast.literal_DIR.Initializer;
import main.visitor.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class InitDeclarator extends Node {
    private Declarator declarator;
    private Initializer initializer;

    public InitDeclarator(Declarator declarator) {
        this.declarator = declarator;
        this.initializer = null;
        this.setLine(declarator.getLine());
    }

    public InitDeclarator(Declarator declarator, Initializer initializer) {
        this.declarator = declarator;
        this.initializer = initializer;
        this.setLine(declarator.getLine());
    }

    public Declarator getDeclarator() {
        return declarator;
    }

    public void setDeclarator(Declarator declarator) {
        this.declarator = declarator;
    }

    public Initializer getInitializer() {
        return initializer;
    }

    public void setInitializer(Initializer initializer) {
        this.initializer = initializer;
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
        if (initializer != null)
            children.add(initializer);
        return children;
    }

}
