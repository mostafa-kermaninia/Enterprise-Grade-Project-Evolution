package main.ast.expression_DIR;

import main.ast.baseNodes_DIR.Node;
import main.ast.literal_DIR.TypeName;
import main.visitor.IVisitor;

public class CastExpression extends Node {
    private CastExpression castExpression;
    private Expression expression;
    private TypeName typeName;
    private String number;

    public CastExpression() {
        castExpression = null;
        expression = null;
        typeName = null;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
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

    public CastExpression getCastExpression() {
        return castExpression;
    }

    public void setCastExpression(CastExpression castExpression) {
        this.castExpression = castExpression;
    }
}
