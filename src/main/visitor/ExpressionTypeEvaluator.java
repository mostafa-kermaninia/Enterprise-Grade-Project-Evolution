package main.visitor;


import main.ast.nodes.expr.*;
import main.ast.nodes.expr.operator.BinaryOperator;
import main.ast.nodes.expr.primitives.*;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.item.FuncDecSymbolTableItem;
import main.symbolTable.item.VarDecSymbolTableItem;
import main.typeErrors.IncompatibleOperand;
import main.typeErrors.TypeError;
import main.types.*;
//
import main.symbolTable.SymbolTable;

import java.util.ArrayList;


// int + int = int
// double + int = double
// double + double = double
// char + char = char
// char + int = char
// string + char = string
// string + string = string

//int - int = int
//double - double = double
//int - double = double
//char - char = char
//char - int = char

// int / int = double
// double / double = double
//int / double = double

//int * int = int
//double * int = double
//double * double = double

//bool && bool = bool

//bool || bool = bool

//( double, char, int) >= ( double, char, int) = bool

//( double, char, int) == ( double, char, int) = bool
//string == string = bool


//char ++ (--) = char
//int ++ (--) = int
//double ++ (--) = double

public class ExpressionTypeEvaluator extends Visitor<Type>{
    private SymbolTable currentSymbolTable;
    private ArrayList<TypeError> type_errors;

    ExpressionTypeEvaluator(ArrayList<TypeError> type_errors){
        this.type_errors = type_errors;
    }


    public void setCurrentSymbolTable(SymbolTable currentSymbolTable) {
        this.currentSymbolTable = currentSymbolTable;
    }


    @Override
    public Type visit(UnaryExpr unaryExpr) {



        Type operand_type = unaryExpr.getOperand().accept(this);
        Type final_type = new NonType();
        if((operand_type instanceof CharType) || (operand_type instanceof IntType) || (operand_type instanceof DoubleType) ){
            final_type = operand_type;
        }


        if(final_type instanceof NonType){
            this.type_errors.add(new IncompatibleOperand(unaryExpr.getLine()));
        }

        return final_type;
    }

    @Override
    public Type visit(BinaryExpr binaryExpr) {

        Type l_op_type = binaryExpr.getFirstOperand().accept(this);
        Type r_op_type = binaryExpr.getSecondOperand().accept(this);
        Type final_type = new NonType();




        switch (binaryExpr.getOperator()) {

            case BinaryOperator.MINUS:
                if ((l_op_type instanceof IntType || l_op_type instanceof DoubleType) && (r_op_type instanceof IntType || r_op_type instanceof DoubleType)) {
                    if (l_op_type instanceof IntType && r_op_type instanceof IntType) {
                        final_type = new IntType();
                    } else {
                        final_type = new DoubleType();
                    }
                }

                if ((l_op_type instanceof IntType || l_op_type instanceof CharType) && (r_op_type instanceof IntType || r_op_type instanceof CharType)) {
                    if (l_op_type instanceof IntType && r_op_type instanceof IntType) {
                        final_type = new IntType();
                    } else {
                        final_type = new CharType();
                    }
                }
                break;
            case BinaryOperator.PLUS:
                if ((l_op_type instanceof IntType || l_op_type instanceof DoubleType) && (r_op_type instanceof IntType || r_op_type instanceof DoubleType)) {
                    if (l_op_type instanceof IntType && r_op_type instanceof IntType) {
                        final_type = new IntType();
                    } else {
                        final_type = new DoubleType();
                    }
                }
                if ((l_op_type instanceof IntType || l_op_type instanceof CharType) && (r_op_type instanceof IntType || r_op_type instanceof CharType)) {
                    if (l_op_type instanceof IntType && r_op_type instanceof IntType) {
                        final_type = new IntType();
                    } else {
                        final_type = new CharType();
                    }
                }
                if ((l_op_type instanceof StringType || l_op_type instanceof CharType) && (r_op_type instanceof StringType || r_op_type instanceof CharType)) {
                    if(!(l_op_type instanceof CharType && r_op_type instanceof CharType)){
                        final_type = new StringType();
                    }
                }
                break;

            case BinaryOperator.MULT:
                if ((l_op_type instanceof IntType || l_op_type instanceof DoubleType) && (r_op_type instanceof IntType || r_op_type instanceof DoubleType)) {
                    if (l_op_type instanceof IntType && r_op_type instanceof IntType) {
                        final_type = new IntType();
                    } else {
                        final_type = new DoubleType();
                    }
                }
                break;

            case BinaryOperator.DIVIDE:
                if ((l_op_type instanceof IntType || l_op_type instanceof DoubleType) && (r_op_type instanceof IntType || r_op_type instanceof DoubleType)) {
                    final_type = new DoubleType();
                }
                break;


            case BinaryOperator.OR, BinaryOperator.AND:
                if (l_op_type instanceof BooleanType && r_op_type instanceof BooleanType) {
                    final_type = new BooleanType();
                }
                break;

            case BinaryOperator.EQUALS, BinaryOperator.GTE:
                if (    (l_op_type instanceof IntType || l_op_type instanceof DoubleType || l_op_type instanceof BooleanType)
                        && (r_op_type instanceof IntType || r_op_type instanceof DoubleType || r_op_type instanceof BooleanType)) {
                    final_type = new BooleanType();
                }

                if(l_op_type instanceof StringType && r_op_type instanceof StringType){
                    final_type = new BooleanType();
                }
            break;

        }


    if(final_type instanceof NonType){
        this.type_errors.add(new IncompatibleOperand(binaryExpr.getSecondOperand().getLine()));
    }


        return final_type;
    }


    @Override
    public Type visit(Identifier identifier) {
        Type final_type = new NonType();
        try{
            VarDecSymbolTableItem potential_vardec = (VarDecSymbolTableItem) currentSymbolTable.getItem(VarDecSymbolTableItem.START_KEY + identifier.getName());
            final_type = potential_vardec.get_var_dec().getTypeName();
        }
        catch (ItemNotFoundException ignored) {

        }
        return final_type;
    }

    @Override
    public Type visit(FuncCallExpr func_call) {
        Type final_type = new NonType();
        try{
            FuncDecSymbolTableItem potential_func_dec = (FuncDecSymbolTableItem) currentSymbolTable.getItem(FuncDecSymbolTableItem.START_KEY + func_call.getName());
            final_type = potential_func_dec.get_func_dec().get_type_name();
        }
        catch (ItemNotFoundException ignored) {

        }
        return final_type;
    }




    public Type visit(IntVal int_Val) {
        return int_Val.get_type();
    }
    public Type visit(StringVal string_val){return string_val.get_type();}
    public Type visit(BoolVal bool_val){return bool_val.get_type();}
    public Type visit(DoubleVal double_val){return double_val.get_type();}
    public Type visit(CharVal char_val){return char_val.get_type();}




    public Type visit(Expr expr){
        return new NonType();
    }




}
