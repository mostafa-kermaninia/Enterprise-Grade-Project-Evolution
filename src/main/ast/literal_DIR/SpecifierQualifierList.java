package main.ast.literal_DIR;

import main.ast.baseNodes_DIR.Node;
import main.visitor.IVisitor;

public class SpecifierQualifierList extends Node {
    private TypeSpecifier typeSpecifier;
    private SpecifierQualifierList specifierQualifierList;

    public SpecifierQualifierList() {
        typeSpecifier = null;
        specifierQualifierList = null;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }


    public SpecifierQualifierList getSpecifierQualifierList() {
        return specifierQualifierList;
    }
    public void setSpecifierQualifierList(SpecifierQualifierList specifierQualifierList) { this.specifierQualifierList = specifierQualifierList; }

    public TypeSpecifier getTypeSpecifier() { return typeSpecifier; }
    public void setTypeSpecifier(TypeSpecifier typeSpecifier) { this.typeSpecifier = typeSpecifier; }
}
