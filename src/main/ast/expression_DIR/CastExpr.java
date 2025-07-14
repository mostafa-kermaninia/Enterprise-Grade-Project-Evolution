package main.ast.expression_DIR;

import main.ast.baseNodes_DIR.Node;
import main.ast.literal_DIR.TypeName;
import main.ast.mainNodes_DIR.Expr;
import main.visitor.IVisitor;

public class CastExpr extends Node {
    private CastExpr castExpr;
    private Expr expr;
    private TypeName typeName;
    private String number;

    public CastExpr() {
        castExpr = null;
        expr = null;
        typeName = null;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Expr getExpr() {
        return expr;
    }

    public void setExpr(Expr expr) {
        this.expr = expr;
    }

    public TypeName getTypeName() {
        return typeName;
    }

    public void setTypeName(TypeName typeName) {
        this.typeName = typeName;
    }

    public String getNum() {
        return number;
    }

    public void setNum(String number) {
        this.number = number;
    }

    public CastExpr getCastExpr() {
        return castExpr;
    }

    public void setCastExpr(CastExpr castExpr) {
        this.castExpr = castExpr;
    }
}
