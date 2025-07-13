package main.ast.declaration_DIR;

import java.util.ArrayList;
import java.util.List;
import main.ast.baseNodes_DIR.Node;
import main.visitor.IVisitor;

public class DeclarationSpecifiers extends Node {
    private ArrayList<DeclarationSpecifier> declarationSpecifiers;

    public DeclarationSpecifiers() {
        declarationSpecifiers = new ArrayList<>();
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public List<DeclarationSpecifier> getDeclarationSpecifiers() {
        return declarationSpecifiers;
    }

    public void addDeclarationSpecifier(DeclarationSpecifier declarationSpecifier) {
        this.declarationSpecifiers.add(declarationSpecifier);
    }

}
