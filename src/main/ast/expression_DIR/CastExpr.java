package main.ast.expression_DIR;

import main.ast.literal_DIR.TypeName;

public class CastExpr extends Expr {
    private TypeName castType;
    private Expr expression;

    public CastExpr(TypeName castType, Expr expression) {
        this.castType = castType;
        this.expression = expression;
    }

    public TypeName getCastType() {
        return castType;
    }

    public void setCastType(TypeName castType) {
        this.castType = castType;
    }

    public Expr getExpression() {
        return expression;
    }

    public void setExpression(Expr expression) {
        this.expression = expression;
    }


}
