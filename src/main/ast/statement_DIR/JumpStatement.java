package main.ast.statement_DIR;

import main.ast.nodes_DIR.Node;
import main.ast.expression_DIR.Expr;
import main.visitor.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class JumpStatement extends Stmt {
    public static final int CONTINUE = 1;
    public static final int BREAK = 2;
    public static final int RETURN = 3;

    private int type;
    private Expr returnValue;
    private int line;

    public JumpStatement(int type, int line) {
        this.type = type;
        this.line = line;
        this.returnValue = null;
    }

    public JumpStatement(int type, Expr returnValue, int line) {
        this.type = type;
        this.returnValue = returnValue;
        this.line = line;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Expr getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(Expr returnValue) {
        this.returnValue = returnValue;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    @Override
    public List<Node> get_child() {
        List<Node> children = new ArrayList<>();
        if (returnValue != null) {
            children.add(returnValue);
        }
        return children;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
