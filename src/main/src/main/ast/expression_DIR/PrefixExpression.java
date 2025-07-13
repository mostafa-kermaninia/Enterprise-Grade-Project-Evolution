package main.ast.expression_DIR;

import java.util.ArrayList;
import main.ast.literal_DIR.TypeName;
import main.ast.literal_DIR.UnaryOperator;
import main.visitor.IVisitor;

public class PrefixExpression extends Expression {
    private ArrayList<String> Ops = new ArrayList<>();
    private String identifier;
    private String constant;
    private Expression expression;
    private TIExpression tiExpression;
    private CastExpression castExpression;
    private UnaryOperator unaryOp;
    private TypeName typeName;

    public PrefixExpression() {
        expression = null;
        tiExpression = null;
        castExpression = null;
        unaryOp = null;
        typeName = null;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public void addOp(String op) {
        Ops.add(op);
    }

    public ArrayList<String> getOps() {
        return Ops;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getConstant() {
        return constant;
    }

    public void setConstant(String constant) {
        this.constant = constant;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public TIExpression getTIExpression() {
        return tiExpression;
    }

    public void setTIExpression(TIExpression tiExpression) {
        this.tiExpression = tiExpression;
    }

    public CastExpression getCastExpression() {
        return castExpression;
    }

    public void setCastExpression(CastExpression castExpression) {
        this.castExpression = castExpression;
    }

    public UnaryOperator getUnaryOp() {
        return unaryOp;
    }

    public void setUnaryOp(UnaryOperator unaryOp) {
        this.unaryOp = unaryOp;
    }

    public TypeName getTypeName() {
        return typeName;
    }

    public void setTypeName(TypeName typeName) {
        this.typeName = typeName;
    }

}
