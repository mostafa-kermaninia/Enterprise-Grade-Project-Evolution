package main.ast.expression_DIR;

import main.ast.literal_DIR.TypeName;
import main.ast.mainNodes_DIR.Expr;
import main.visitor.IVisitor;

public class ExprCast extends Expr {
    private TypeName typeName;
    private CastExpr castExpr;

    public ExprCast(TypeName typeName, CastExpr castExpr) {
        this.typeName = typeName;
        this.castExpr = castExpr;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public CastExpr getCastExpr() {
        return castExpr;
    }

    public TypeName getTypeName() {
        return typeName;
    }

}
