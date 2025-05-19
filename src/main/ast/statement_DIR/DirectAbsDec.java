package main.ast.statement_DIR;

import main.ast.baseNodes_DIR.Node;
import main.ast.expression_DIR.Expr;
import main.visitor.IVisitor;

public class DirectAbsDec extends Node {
    private Expr expr;
    private AbstractDec abstractDec;
    private ParameterList parameterList;
    private DirectAbsDec directAbsDec;

    public DirectAbsDec(){
        expr = null;
        abstractDec = null;
        parameterList = null;
        directAbsDec = null;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }


    public Expr getExpr() {
        return expr;
    }
    public void setExpr(Expr expr) {
        this.expr = expr;
    }

    public AbstractDec getAbstractDec() { return abstractDec;}
    public void setAbstractDec(AbstractDec abstractDec) { this.abstractDec = abstractDec; }

    public ParameterList getParameterList() { return parameterList; }
    public void setParameterList(ParameterList parameterList) { this.parameterList = parameterList; }

    public DirectAbsDec getDirectAbsDec() { return directAbsDec; }
    public void setDirectAbsDec(DirectAbsDec directAbsDec) { this.directAbsDec = directAbsDec; }
}
