package main.ast.declaration_DIR;

import main.ast.baseNodes_DIR.Node;
import main.ast.statement_DIR.Initializer;
import main.visitor.IVisitor;

public class InitDeclarator extends Node {
    private Declarator declarator;
    private Initializer initializer;

    public InitDeclarator(Declarator declarator) {
        initializer = null;
        this.declarator = declarator;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Declarator getDeclarator() {
        return declarator;
    }

    public Initializer getInitializer() {
        return initializer;
    }

    public void setInitializer(Initializer initializer) {
        this.initializer = initializer;
    }

}
