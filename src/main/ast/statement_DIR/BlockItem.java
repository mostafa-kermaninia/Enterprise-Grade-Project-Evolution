package main.ast.statement_DIR;

import main.ast.baseNodes_DIR.Node;
import main.ast.declaration_DIR.Declaration;
import main.visitor.IVisitor;

public class BlockItem extends Node {
    private Statement statement;
    private Declaration declaration;

    public BlockItem() {
        statement = null;
        declaration = null;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public Declaration getDeclaration() {
        return declaration;
    }

    public void setDeclaration(Declaration declaration) {
        this.declaration = declaration;
    }
}
