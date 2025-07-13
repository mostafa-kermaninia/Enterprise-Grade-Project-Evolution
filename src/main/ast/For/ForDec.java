package main.ast.For;

import main.ast.DeclarationSpecifiers;
import main.ast.InitDeclaratorList;
import main.visitor.IVisitor;
import main.ast.Node;


public class ForDec extends Node{
    private DeclarationSpecifiers declarationSpecifiers;
    private InitDeclaratorList initDeclaratorList;

    public ForDec(DeclarationSpecifiers declarationSpecifiers) {
        this.declarationSpecifiers = declarationSpecifiers;
        initDeclaratorList = null;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public InitDeclaratorList getInitDecList() { return initDeclaratorList; }
    public void setInitDecList(InitDeclaratorList initDeclaratorList) { this.initDeclaratorList = initDeclaratorList; }

    public DeclarationSpecifiers getDeclarationSpecifiers() { return declarationSpecifiers; }
}
