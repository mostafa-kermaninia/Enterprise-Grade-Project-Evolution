package main.ast.expression_DIR;

import main.ast.literal_DIR.TypeName;
import main.ast.mainNodes_DIR.Expr;
import main.ast.statement_DIR.InitializerList;
import main.visitor.IVisitor;

public class TIExpr extends Expr {
    private InitializerList initializerList;
    private TypeName typeName;

    public TIExpr(TypeName typeName, InitializerList initializerList) {
        this.typeName = typeName;
        this.initializerList = initializerList;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public InitializerList getInitializerList() {
        return initializerList;
    }

    public TypeName getTypeName() {
        return typeName;
    }
}
