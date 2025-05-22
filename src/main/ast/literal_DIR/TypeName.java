package main.ast.literal_DIR;

import main.ast.baseNodes_DIR.Node;
import main.ast.declaration_DIR.AbstractDec;
import main.visitor.IVisitor;

public class TypeName extends Node {
    private SpecifierQualifierList specifierQualifierList;
    private AbstractDec abstractDec;

    public TypeName(SpecifierQualifierList specifierQualifierList) {
        this.specifierQualifierList = specifierQualifierList;
        abstractDec = null;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }


    public SpecifierQualifierList getSpecifierQualifierList() {
        return specifierQualifierList;
    }

    public AbstractDec getAbstractDec() { return abstractDec; }
    public void setAbstractDec(AbstractDec abstractDec) { this.abstractDec = abstractDec; }
}
