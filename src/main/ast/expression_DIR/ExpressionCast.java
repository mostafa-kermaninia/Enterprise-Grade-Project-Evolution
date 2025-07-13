package main.ast.expression_DIR;

import main.ast.literal_DIR.TypeName;
import main.visitor.IVisitor;

public class ExpressionCast extends Expression {
    private TypeName typeName;
    private CastExpression castExpression;

    public ExpressionCast(TypeName typeName, CastExpression castExpression) {
        this.typeName = typeName;
        this.castExpression = castExpression;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public CastExpression getCastExpression() {
        return castExpression;
    }

    public TypeName getTypeName() {
        return typeName;
    }

}
