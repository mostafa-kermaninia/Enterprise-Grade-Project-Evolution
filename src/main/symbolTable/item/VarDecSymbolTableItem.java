package main.symbolTable.item;

import main.ast.literal_DIR.TypeSpecifier;

public class VarDecSymbolTableItem extends SymbolTableItem {
    public static final String START_KEY = "VarDec_";

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
