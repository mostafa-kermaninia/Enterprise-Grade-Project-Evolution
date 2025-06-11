package main.ast.nodes.expr.primitives;

import main.ast.nodes.Node;
import main.ast.nodes.expr.Expr;
import main.types.NonType;
import main.types.Type;

public abstract class Value extends Expr {
    public Type get_type() {
        return new NonType();
    }
}
