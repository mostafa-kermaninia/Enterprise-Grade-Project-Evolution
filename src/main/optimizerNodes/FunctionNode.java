package main.optimizerNodes;

import main.ast.nodes.declaration.FuncDec;

import java.util.ArrayList;

public class FunctionNode {
    private FuncDec the_function;
    private boolean used_status = false;
    private ArrayList<FunctionNode> reachable_functions = new ArrayList<FunctionNode>();


    public void start_marking(){
        this.used_status = true;
        for (FunctionNode func : reachable_functions){
            if(func !=null){
                func.start_marking();
            }
        }
    }

    public FunctionNode(FuncDec the_function){
        this.the_function =  the_function;
    }

    public FuncDec get_the_function(){
        return this.the_function;
    }

    public void add_reachable_function(FunctionNode new_reachable_node){
        this.reachable_functions.add(new_reachable_node);
    }

    public ArrayList<FunctionNode> get_reachable_functions(){
        return this.reachable_functions;
    }

    public boolean get_used_status(){
        return this.used_status;
    }

    public void set_used_status(boolean new_status){
        this.used_status = new_status;
    }

    public boolean has_name(String key_name){
        return this.the_function.getFuncName().equals(key_name);
    }

}
