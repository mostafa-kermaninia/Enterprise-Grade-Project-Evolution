package main.ast.literal_DIR;

import main.ast.nodes_DIR.Node;
import main.ast.declaration_DIR.AbstractDeclarator;
import main.visitor.IVisitor;

public class TypeName extends Node {
    private SpecifierQualifierList specifierQualifierList;
    private AbstractDeclarator abstractDeclarator;

    public TypeName(SpecifierQualifierList specifierQualifierList, AbstractDeclarator abstractDeclarator) {
        this.specifierQualifierList = specifierQualifierList;
        this.abstractDeclarator = abstractDeclarator;
    }

    public SpecifierQualifierList getSpecifierQualifierList() {
        return specifierQualifierList;
    }

    public void setSpecifierQualifierList(SpecifierQualifierList specifierQualifierList) {
        this.specifierQualifierList = specifierQualifierList;
    }

    public AbstractDeclarator getAbstractDeclarator() {
        return abstractDeclarator;
    }

    public void setAbstractDeclarator(AbstractDeclarator abstractDeclarator) {
        this.abstractDeclarator = abstractDeclarator;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }



}
