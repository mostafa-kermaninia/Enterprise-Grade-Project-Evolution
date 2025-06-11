package main.optimizerNodes;


public class VariableNode {

    private String var_name;
    private boolean used_status = false;
    private int line;



    public VariableNode(String var_name, int line){
        this.var_name = var_name;
        this.line = line;
    }

    public int get_line(){
        return this.line;
    }

    public boolean  has_name(String key_name){
        return this.var_name.equals(key_name);
    }


    public String get_name(){
        return this.var_name;
    }

    public void set_used_status(boolean new_status){
        this.used_status = new_status;
    }

    public boolean get_used_status(){
        return this.used_status;
    }


}
