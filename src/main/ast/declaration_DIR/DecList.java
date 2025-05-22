package main.ast.declaration_DIR;


import main.ast.baseNodes_DIR.Node;
import main.visitor.IVisitor;

import java.util.ArrayList;

public class DecList extends Node {

    private ArrayList<Declaration> declarations;

    public DecList() { declarations = new ArrayList<>(); }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public void addDeclaration(Declaration declaration) { this.declarations.add(declaration); }
    public ArrayList<Declaration> getDeclarations() { return declarations; }
}
