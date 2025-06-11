package main.ast.nodes.Stmt;

import main.types.*;
import main.visitor.IVisitor;

public class VarDec extends Stmt{
    private String varName;
    private Type typeName;



    public VarDec(String varName) {
        this.varName = varName;
    }
    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName = varName;
    }
    public Type getTypeName() {return typeName;}

    public void setTypeName(String new_typeName) {
        switch (new_typeName) {
            case "string":
                this.typeName = new StringType();
                break;

            case "int":
                this.typeName = new IntType();
                break;

            case "double":
                this.typeName = new DoubleType();
                break;

            case "bool":
                this.typeName = new BooleanType();
                break;

            case "char":
                this.typeName = new CharType();
                break;

            default:
                this.typeName = new NonType();
        }

    }
}
