package main.symbolTable.item;

import main.ast.TypeSpecifier;

public class VarDecSymbolTableItem extends SymbolTableItem{
    public static final String START_KEY = "VarDec_";
    public boolean isPtr = false;
    public boolean isFree = true;
    public boolean isInit = false;
    public boolean fromUser = false;
    public String type = "";

    public TypeSpecifier getVarDec() {
        return varDec;
    }

    public void setVarDec(TypeSpecifier varDec) {
        this.varDec = varDec;
    }

    private TypeSpecifier varDec;

    public VarDecSymbolTableItem(TypeSpecifier varDec) {
        this.varDec = varDec;
    }

    @Override
    public String getKey() {
        return START_KEY + this.varDec.getType();
    }
}
