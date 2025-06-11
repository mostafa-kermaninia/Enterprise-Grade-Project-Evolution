package main.symbolTable.item;

import main.ast.nodes.Stmt.VarDec;

public class VarDecSymbolTableItem extends SymbolTableItem{
    public static final String START_KEY = "VarDec_";
    private String var_name;
    private VarDec the_var_dec;

    public VarDecSymbolTableItem(String variableName) {
        this.var_name = variableName;
    }

    @Override
    public String getKey() {
        return START_KEY + this.var_name;
    }

    public String getVar_name() {
        return var_name;
    }

    public void setVar_name(String var_name) {
        this.var_name = var_name;
    }

    public void set_vardec(VarDec new_the_var_dec){
        this.the_var_dec = new_the_var_dec;
    }

    public VarDec get_var_dec(){
        return this.the_var_dec;
    }
}
