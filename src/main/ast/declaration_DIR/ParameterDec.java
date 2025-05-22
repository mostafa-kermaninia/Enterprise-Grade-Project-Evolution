package main.ast.declaration_DIR;

import main.ast.baseNodes_DIR.Node;
import main.visitor.IVisitor;

public class ParameterDec extends Node {
    private DeclarationSpecifiers declarationSpecifiers;
    private Declarator declarator;
    private AbstractDec abstractDec;

    public ParameterDec(DeclarationSpecifiers declarationSpecifiers) {
        this.declarationSpecifiers = declarationSpecifiers;
        declarator = null;
        abstractDec = null;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public DeclarationSpecifiers getDeclarationSpecifier() {
        return declarationSpecifiers;
    }

    public void setDeclarator(Declarator declarator) {
        this.declarator = declarator;
    }

    public Declarator getDeclarator() {
        return declarator;
    }

    public void setAbstractDec(AbstractDec abstractDec) {
        this.abstractDec = abstractDec;
    }

    public AbstractDec getAbstractDec() {
        return abstractDec;
    }

}
