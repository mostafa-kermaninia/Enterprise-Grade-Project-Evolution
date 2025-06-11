package main.visitor;

import main.ast.nodes.Program;
import main.ast.nodes.Stmt.*;
import main.ast.nodes.declaration.FuncDec;
import main.ast.nodes.declaration.Main;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.item.VarDecSymbolTableItem;
import main.typeErrors.IncompatibleAssign;
import main.typeErrors.TypeError;
import main.typeErrors.WrongCondition;
import main.types.*;

import java.util.ArrayList;

public class TypeChcker   extends Visitor<Void> {
    private ArrayList<TypeError> type_errors = new ArrayList<>();
    private ExpressionTypeEvaluator expr_type_evaluator = new ExpressionTypeEvaluator(type_errors);
    private SymbolTable current_symbol_table;


    private Type tmp_return_type = new NonType();



    @Override
    public Void visit(Program program) {

        for (FuncDec funcDec : program.getFuncDecs()) {
            if (funcDec != null) {
                funcDec.accept(this);
            }
        }

        if (program.getMain() != null) {
            program.getMain().accept(this);
        }


        for (TypeError compileError : this.type_errors) {
            System.out.println(compileError.getErrorMessage());
        }
        return null;
    }


    @Override
    public Void visit(FuncDec func_dec) {
        tmp_return_type = new NonType();
        current_symbol_table = func_dec.get_symbol_table();
        expr_type_evaluator.setCurrentSymbolTable(current_symbol_table);
        for (Stmt stmt : func_dec.getStmts()) {
            if (stmt != null) {
                stmt.accept(this);
            }
        }

        func_dec.set_type_name(this.tmp_return_type);

        return null;
    }

    @Override
    public Void visit(Main main) {
        current_symbol_table = main.get_symbol_table();
        expr_type_evaluator.setCurrentSymbolTable(current_symbol_table);

        for (Stmt stmt : main.getStmts()) {
            if (stmt != null) {
                stmt.accept(this);
            }
        }

        return null;
    }

    @Override
    public Void visit(Assign assign) {
        Type left_hand_type = new NonType();
        try {
            VarDec left_hand_var = ((VarDecSymbolTableItem)this.current_symbol_table.getItem(VarDecSymbolTableItem.START_KEY + assign.getLeftHand())).get_var_dec();
            left_hand_type = left_hand_var.getTypeName();
        } catch (ItemNotFoundException ignored) {
        }

        Type right_hand_type = assign.getRightHand().accept(this.expr_type_evaluator);

        if(left_hand_type instanceof IntType){
            if(!(right_hand_type instanceof IntType) && !(right_hand_type instanceof CharType)){
                this.type_errors.add(new IncompatibleAssign(assign.getLine()));
            }
        } else if (left_hand_type instanceof DoubleType) {
            if((right_hand_type instanceof StringType) || (right_hand_type instanceof BooleanType)){
                this.type_errors.add(new IncompatibleAssign(assign.getLine()));
            }
        } else if (left_hand_type instanceof BooleanType) {
            if(!(right_hand_type instanceof BooleanType)){
                this.type_errors.add(new IncompatibleAssign(assign.getLine()));
            }
        }else if (left_hand_type instanceof StringType) {
            if(!(right_hand_type instanceof StringType) && !(right_hand_type instanceof CharType)){
                this.type_errors.add(new IncompatibleAssign(assign.getLine()));
            }
        }else if (left_hand_type instanceof CharType) {
            if(!(right_hand_type instanceof CharType) && !(right_hand_type instanceof IntType)){
                this.type_errors.add(new IncompatibleAssign(assign.getLine()));
            }
        }

        return null;
    }

    @Override
    public Void visit(IfStmt if_stmt) {
        Type condition_type =  if_stmt.getCondition().accept(this.expr_type_evaluator);
        if(! (condition_type instanceof BooleanType)){
            this.type_errors.add(new WrongCondition(if_stmt.getLine()));
        }

        if_stmt.getIfBody().accept(this);
        if(if_stmt.getElseBody()!= null){
            if_stmt.getElseBody().accept(this);
        }
        return null;
    }


    @Override
    public Void visit(Return return_stmt) {
        Type return_type =  return_stmt.getReturn_value().accept(this.expr_type_evaluator);
        if(this.tmp_return_type instanceof NonType){
            this.tmp_return_type = return_type;
        }
        return null;
    }





}
