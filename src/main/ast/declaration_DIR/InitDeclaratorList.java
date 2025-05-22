package main.ast.declaration_DIR;

import main.ast.baseNodes_DIR.Node;
import main.visitor.IVisitor;

import java.util.ArrayList;

public class InitDeclaratorList extends Node {
    private ArrayList<InitDeclarator> initDeclarators;

    public InitDeclaratorList(InitDeclarator initDeclarator) {
        initDeclarators = new ArrayList<>();
        initDeclarators.add(initDeclarator);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public ArrayList<InitDeclarator> getInitDeclarators() { return initDeclarators; }
    public void addInitDeclarator(InitDeclarator initDeclarator) { this.initDeclarators.add(initDeclarator); }

}
