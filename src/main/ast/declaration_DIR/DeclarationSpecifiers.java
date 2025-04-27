package main.ast.declaration_DIR;

import main.ast.nodes_DIR.Node;
import main.visitor.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class DeclarationSpecifiers extends Node {
    private ArrayList<DeclarationSpecifier> declarationSpecifiers;

    public DeclarationSpecifiers() {
        this.declarationSpecifiers = new ArrayList<>();
    }

    public void addDeclarationSpecifier(DeclarationSpecifier declarationSpecifier) {
        this.declarationSpecifiers.add(declarationSpecifier);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public List<Node> get_child() {
        return new ArrayList<>(declarationSpecifiers);
    }

    public ArrayList<DeclarationSpecifier> getDeclarationSpecifiers() {
        return declarationSpecifiers;
    }

    public void setDeclarationSpecifiers(ArrayList<DeclarationSpecifier> declarationSpecifiers) {
        this.declarationSpecifiers = declarationSpecifiers;
    }
}
