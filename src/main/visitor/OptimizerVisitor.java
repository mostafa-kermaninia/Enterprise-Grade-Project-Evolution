
package main.visitor;

import main.ast.nodes.Program;
import main.ast.nodes.Stmt.*;
        import main.ast.nodes.declaration.FuncDec;
import main.ast.nodes.declaration.Main;
import main.ast.nodes.expr.*;
import main.ast.nodes.expr.primitives.*;

import main.optimizerNodes.*;

import java.util.ArrayList;


/*GOALs:
 *   1. Print Functions that are not reachable from main
 *   2. Print Variables that are not used (left hand side of assign is not considered as usage)
 *   3. Print dead code (code that comes after return statement

 *
 * */


/* Steps to print the unreachable functions:
*       1.create a tree of function calls. each function is linked to all the functions it calls
*       2.traverse this tree from the main and mark all the used functions
*       3.keep track of all the functions declared in the program
*       4.print out all the function declarations which are not marked
*
* */

/* Steps to print the unused variables:
 *       1.keep track of a list of variables that are declared in the current scope
 *       2.mark each variable when it is used
 *       3.at the end of each scope, print out the list of the variables which are not used
 *
 * */


/* Steps to print the dead code:
*       1.we need to keep track of return status in our current (if and else is a tricky one)
*       2.we need to print out statements after the return
*
* */

public class OptimizerVisitor extends Visitor<Void>{

    private FunctionNode current_func_node = null;
    private ArrayList<FunctionNode> func_dec_list = new ArrayList<FunctionNode>();


    private ArrayList<VariableNode> variable_list = new ArrayList<VariableNode>();

    private boolean current_return_status = false;

    private FunctionNode find_func_with_name(String name){
        for (FunctionNode func : this.func_dec_list){
            if(func.has_name(name)){
                return func;
            }
        }
        return null;
    }

    private void print_unused_functions(){
        this.find_func_with_name("main").start_marking();

        for (FunctionNode func : this.func_dec_list){
            if(!func.get_used_status()){
                FuncDec the_function = func.get_the_function();
                System.out.println("function \"" + the_function.getFuncName() + "\" at line " + the_function.getLine()+ " is not reachable form main");
            }
        }
    }


    private void print_all_unused_vars(){
        for (VariableNode var : this.variable_list){
            if(!var.get_used_status()){
                System.out.println("variable \"" + var.get_name() + "\" at line " + var.get_line()+ " is not used");
            }
        }
    }

    private VariableNode find_var_with_name(String name){
        for (VariableNode var : this.variable_list){
            if(var.has_name(name)){
                return var;
            }
        }
        return null;
    }

    private void check_for_dead_code(int line){
        if(this.current_return_status){
            System.out.println("Dead code at line"+ line);
        }
    }

    @Override
    public Void visit(Program program) {

        for (FuncDec func_dec : program.getFuncDecs()){
            func_dec.accept(this);
        }
        program.getMain().accept(this);
        print_unused_functions();
        return null;
    }
    public Void visit(Main main) {
        this.current_return_status = false;
        this.variable_list = new ArrayList<VariableNode>();
        FunctionNode main_node = new FunctionNode(new FuncDec("main"));
        this.func_dec_list.add(main_node);
        this.current_func_node = main_node;

        for (Stmt stmt : main.getStmts()){
            stmt.accept(this);
        }
        print_all_unused_vars();
        return null;
    }

    public Void visit(FuncDec funcDec) {
        this.current_return_status = false;
        this.variable_list = new ArrayList<VariableNode>();
        FunctionNode new_func_node = new FunctionNode(funcDec);
        this.func_dec_list.add(new_func_node);
        this.current_func_node = new_func_node;

        for (Stmt stmt : funcDec.getStmts()){
            stmt.accept(this);
        }
        print_all_unused_vars();
        return null;
    }

    public Void visit(Assign assign) {
        check_for_dead_code(assign.getLine());
        assign.getRightHand().accept(this);
        return null;
    }
    public Void visit(VarDec varDec) {
        check_for_dead_code(varDec.getLine());
        this.variable_list.add(new VariableNode(varDec.getVarName(), varDec.getLine()));
        return null;
    }
    public Void visit(IfStmt ifStmt) {
        check_for_dead_code(ifStmt.getLine());
        boolean prev_ret_status = this.current_return_status;
        ifStmt.getCondition().accept(this);
        ifStmt.getIfBody().accept(this);
        boolean first_body_ret = this.current_return_status;
        this.current_return_status =  prev_ret_status;
        ifStmt.getElseBody().accept(this);
        boolean second_body_ret = this.current_return_status;

        this.current_return_status = prev_ret_status || (first_body_ret && second_body_ret);
        return null;
    }


    public Void visit(FuncCallStmt funcCall) {
        check_for_dead_code(funcCall.getLine());
        this.current_func_node.add_reachable_function(this.find_func_with_name(funcCall.getFunction().getName()));
        return null;
    }

    public Void visit(FuncCallExpr func_call_expr){
        this.current_func_node.add_reachable_function(this.find_func_with_name(func_call_expr.getName()));
        return null;
    }

    public Void visit(UnaryExpr unaryExpr) {
        unaryExpr.getOperand().accept(this);
        return null;
    }
    public Void visit(BinaryExpr binaryExpr) {
        binaryExpr.getFirstOperand().accept(this);
        binaryExpr.getSecondOperand().accept(this);
        return null;
    }
    public Void visit(Identifier identifier) {
        VariableNode var_node = find_var_with_name(identifier.getName());
        if(var_node!= null){
            var_node.set_used_status(true);
        }
        return null;
    }

    public Void visit(IntVal int_Val) {
        return null;
    }
    public Void visit(StringVal string_val){return null;}
    public Void visit(BoolVal bool_val){return null;}
    public Void visit(DoubleVal double_vals){return null;}
    public Void visit(CharVal char_val){return null;}

    public Void visit(Return the_return){
        check_for_dead_code(the_return.getLine());
        this.current_return_status = true;
        the_return.getReturn_value().accept(this);
        return null;
    }
}


