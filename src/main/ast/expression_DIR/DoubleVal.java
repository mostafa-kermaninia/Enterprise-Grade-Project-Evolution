package main.ast.expression_DIR;

import main.visitor.IVisitor;

public class DoubleVal extends Expr {
    private double double_val;
    public DoubleVal(String double_val){this.double_val =  Double.parseDouble(double_val);}

    public double get_double_val() {
        return double_val;
    }

    public void set_double_val(double double_val) {
        this.double_val = double_val;
    }
    @Override
    public String toString(){return "DoubleValue:" + String.valueOf(this.double_val);}
    @Override
    public <T> T accept(IVisitor<T> visitor){return visitor.visit(this);}
}

