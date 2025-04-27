package main.ast.literal_DIR;

import main.ast.nodes_DIR.Node;
import main.ast.expression_DIR.Expr;
import main.visitor.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class
Designator extends Node {
    private Expr indexExpr;
    private String fieldName;

    public Designator(Expr indexExpr) {
        this.indexExpr = indexExpr;
        this.fieldName = null;
    }

    public Designator(String fieldName) {
        this.indexExpr = null;
        this.fieldName = fieldName;
    }

    public boolean isArrayAccess() {
        return indexExpr != null;
    }

    public boolean isFieldAccess() {
        return fieldName != null;
    }

    public Expr getIndexExpr() {
        return indexExpr;
    }

    public String getFieldName() {
        return fieldName;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public List<Node> get_child() {
        List<Node> children = new ArrayList<>();
        if (indexExpr != null) {
            children.add(indexExpr);
        }

        return children;
    }
}
