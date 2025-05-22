package main.ast.expression_DIR;

import main.ast.literal_DIR.TypeName;
import main.ast.literal_DIR.UnaryOperator;
import main.visitor.IVisitor;

import java.util.ArrayList;

public class PrefixExpr extends Expr{
    private ArrayList<String> Ops = new ArrayList<>();
    private String identifier;
    private String constant;
    private Expr expr;
    private TIExpr tiExpr;
    private CastExpr castExpr;
    private UnaryOperator unaryOp;
    private TypeName typeName;

    public PrefixExpr(){
        expr = null;
        tiExpr = null;
        castExpr = null;
        unaryOp = null;
        typeName = null;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }


    public void addOp(String op){ Ops.add(op); }
    public ArrayList<String> getOps(){ return Ops; }

    public String getIdentifier(){ return identifier; }
    public void setIdentifier(String identifier){ this.identifier = identifier; }

    public String getConstant(){ return constant; }
    public void setConstant(String constant){ this.constant = constant; }

    public Expr getExpr(){ return expr; }
    public void setExpr(Expr expr){ this.expr = expr; }

    public TIExpr getTIExpr(){ return tiExpr; }
    public void setTIExpr(TIExpr tiExpr){ this.tiExpr = tiExpr; }

    public CastExpr getCastExpr(){ return castExpr; }
    public void setCastExpr(CastExpr castExpr){ this.castExpr = castExpr; }

    public UnaryOperator getUnaryOp(){ return unaryOp; }
    public void setUnaryOp(UnaryOperator unaryOp){ this.unaryOp = unaryOp; }

    public TypeName getTypeName(){ return typeName; }
    public void setTypeName(TypeName typeName){ this.typeName = typeName; }

}
