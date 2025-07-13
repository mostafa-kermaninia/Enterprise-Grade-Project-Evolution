package main.ast.declaration_DIR;

import main.ast.baseNodes_DIR.Node;
import main.ast.literal_DIR.TypeSpecifier;
import main.visitor.IVisitor;

public class DeclarationSpecifier extends Node {
    private TypeSpecifier typeSpecifier;
    private String typeName;

    public DeclarationSpecifier() {
        typeSpecifier = null;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public TypeSpecifier getTypeSpecifier() {
        return typeSpecifier;
    }

    public void setTypeSpecifier(TypeSpecifier typeSpecifier) {
        this.typeSpecifier = typeSpecifier;
    }

    public String getType() {
        return typeName;
    }

    public void setType(String typeName) {
        this.typeName = typeName;
    }
}
