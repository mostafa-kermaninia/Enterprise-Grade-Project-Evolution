package main.ast.declaration_DIR;

import main.ast.nodes_DIR.Declaration;
import main.ast.nodes_DIR.Node;
import main.ast.literal_DIR.TypeSpecifier;

import java.util.ArrayList;
import java.util.List;

public class DeclarationSpecifier extends Declaration {
    private String keyword;
    private TypeSpecifier typeSpecifier;

    public DeclarationSpecifier(String keyword) {
        this.keyword = keyword;
    }

    public DeclarationSpecifier(TypeSpecifier typeSpecifier) {
        this.typeSpecifier = typeSpecifier;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public TypeSpecifier getTypeSpecifier() {
        return typeSpecifier;
    }

    public void setTypeSpecifier(TypeSpecifier typeSpecifier) {
        this.typeSpecifier = typeSpecifier;
    }

    public boolean isKeyword() {
        return keyword != null;
    }

    public boolean isTypeSpecifier() {
        return typeSpecifier != null;
    }

    @Override
    public List<Node> get_child() {
        ArrayList<Node> children = new ArrayList<>();
        if (typeSpecifier != null)
            children.add(typeSpecifier);
        return children;
    }
}
