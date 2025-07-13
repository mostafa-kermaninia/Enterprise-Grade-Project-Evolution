package main.ast.ExternalDeclaration;

import main.ast.DeclarationSpecifiers;
import main.ast.InitDeclaratorList;
import main.ast.Node;
import main.visitor.IVisitor;

public class Declaration extends Node {
    private DeclarationSpecifiers declarationSpecifiers;
    private InitDeclaratorList initDeclaratorList;

    public Declaration(DeclarationSpecifiers declarationSpecifiers) {
        this.declarationSpecifiers = declarationSpecifiers;
        initDeclaratorList = null;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public InitDeclaratorList getInitDeclaratorList() { return initDeclaratorList; }
    public void setInitDecList(InitDeclaratorList initDeclaratorList) { this.initDeclaratorList = initDeclaratorList; }

    public DeclarationSpecifiers getDeclarationSpecifiers() { return declarationSpecifiers; }
}
