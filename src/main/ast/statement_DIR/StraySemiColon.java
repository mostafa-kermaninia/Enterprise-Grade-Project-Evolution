package main.ast.statement_DIR;

import main.ast.nodes_DIR.ExternalDeclaration;
import main.visitor.IVisitor;

public class StraySemiColon extends ExternalDeclaration {
    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
