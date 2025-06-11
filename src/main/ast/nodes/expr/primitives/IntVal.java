package main.ast.nodes.expr.primitives;

import main.ast.nodes.expr.Expr;
import main.types.IntType;
import main.types.StringType;
import main.types.Type;
import main.visitor.IVisitor;

public class IntVal extends Value {
    private int intVal;
    public IntVal(int intVal){this.intVal = intVal;}

    public int getIntVal() {
        return intVal;
    }

    public void setIntVal(int intVal) {
        this.intVal = intVal;
    }
    @Override
    public String toString(){return "IntValue:" + String.valueOf(this.intVal);}
    @Override
    public <T> T accept(IVisitor<T> visitor){return visitor.visit(this);}

    public Type get_type() {
        return new IntType();
    }
}