package main.ast.declaration_DIR;

import main.ast.baseNodes_DIR.Node;
import main.visitor.IVisitor;

public class ForDec extends Node {
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

    public InitDeclaratorList getInitDecList() {
        return initDeclaratorList;
    }

    public void setInitDecList(InitDeclaratorList initDeclaratorList) {
        this.initDeclaratorList = initDeclaratorList;
    }

    public DeclarationSpecifiers getDeclarationSpecifiers() {
        return declarationSpecifiers;
    }
}
