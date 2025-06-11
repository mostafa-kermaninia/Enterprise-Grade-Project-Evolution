package main.symbolTable.item;

import main.ast.nodes.declaration.FuncDec;

public class FuncDecSymbolTableItem extends SymbolTableItem {
    public static final String START_KEY = "FuncDec_";

    private String func_name;
    private FuncDec func_dec;
    public FuncDecSymbolTableItem(String functionName) {
        this.func_name = functionName;
    }

    @Override
    public String getKey() {
        return START_KEY + this.func_name;
    }

    public String getFunc_name() {
        return func_name;
    }

    public void setFunc_name(String func_name) {
        this.func_name = func_name;
    }

    public void set_func_dec(FuncDec new_func_dec){
        this.func_dec = new_func_dec;
    }

    public FuncDec get_func_dec(){
        return this.func_dec;
    }
}
