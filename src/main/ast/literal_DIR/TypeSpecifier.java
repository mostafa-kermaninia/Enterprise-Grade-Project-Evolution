package main.ast.literal_DIR;

import main.ast.baseNodes_DIR.Node;
import main.visitor.IVisitor;

public class TypeSpecifier extends Node {
    private String type;
    private boolean var_dec = false;
    private boolean notUsed = false;
    private boolean typeDef = false;
    private String typeDefName;

    public TypeSpecifier(String type) {
        this.type = type;
    }

    public TypeSpecifier(String type, boolean var_dec) {
        this.type = type;
        this.var_dec = var_dec;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public String getType() {
        return type;
    }

    public boolean isVar_dec() {
        return var_dec;
    }

    public void setNotUsed() {
        notUsed = true;
    }

    public boolean Used() {
        return !notUsed;
    }

    public boolean isTypeDef() {
        return typeDef;
    }

    public void setTypeDef(String typeDefName) {
        typeDef = true;
        this.typeDefName = typeDefName;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNotVarDec() {
        var_dec = false;
    }

    public String getTypeDefName() {
        return typeDefName;
    }
}
