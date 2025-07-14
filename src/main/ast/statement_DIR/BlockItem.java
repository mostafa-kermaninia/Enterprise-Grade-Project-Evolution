package main.ast.statement_DIR;

import main.ast.baseNodes_DIR.Node;
import main.ast.mainNodes_DIR.Declaration;
import main.ast.mainNodes_DIR.Stmt;
import main.visitor.IVisitor;

public class BlockItem extends Node {
    private Stmt stmt;
    private Declaration declaration;

    public BlockItem() {
        stmt = null;
        declaration = null;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Stmt getStmt() {
        return stmt;
    }

    public void setStmt(Stmt stmt) {
        this.stmt = stmt;
    }

    public Declaration getDeclaration() {
        return declaration;
    }

    public void setDeclaration(Declaration declaration) {
        this.declaration = declaration;
    }
}
