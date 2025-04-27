package main.ast.expression_DIR;

import main.ast.nodes_DIR.Node;
import main.ast.literal_DIR.TypeName;

import java.util.ArrayList;
import java.util.List;

public class CastExpression extends Expr {
    private TypeName typeName;
    private Expr expression;
    private String digitSequence;

    public CastExpression(TypeName typeName, Expr expression) {
        this.typeName = typeName;
        this.expression = expression;
        this.digitSequence = null;
    }

    public CastExpression(Expr expression) {
        this.expression = expression;
        this.typeName = null;
        this.digitSequence = null;
    }

    public CastExpression(String digitSequence) {
        this.digitSequence = digitSequence;
        this.typeName = null;
        this.expression = null;
    }

    public TypeName getTypeName() {
        return typeName;
    }

    public void setTypeName(TypeName typeName) {
        this.typeName = typeName;
    }

    public Expr getExpression() {
        return expression;
    }

    public void setExpression(Expr expression) {
        this.expression = expression;
    }

    public String getDigitSequence() {
        return digitSequence;
    }

    public void setDigitSequence(String digitSequence) {
        this.digitSequence = digitSequence;
    }

    @Override
    public List<Node> get_child() {
        List<Node> children = new ArrayList<>();
        if (typeName != null) {
            children.add(typeName);
        }
        if (expression != null) {
            children.add(expression);
        }
        return children;
    }
}
