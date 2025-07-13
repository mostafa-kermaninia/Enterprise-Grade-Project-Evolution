package main.visitor;

import main.ast.expr.*;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.item.FuncDecSymbolTableItem;
import main.symbolTable.item.VarDecSymbolTableItem;

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

public class ExpressionTypeEvaluator{
    SymbolTable symbolTable;
    ExpressionTypeEvaluator(SymbolTable symbolTable){
        this.symbolTable = symbolTable;
    }

    public boolean checkType(String type1, String type2){
        if (type1.equals(type2))
            return true;
        switch (type1){
            case "int":
                if (type2.equals("short") || type2.equals("long") || type2.equals("char"))
                    return true;
                break;
            case "float":
                if (type2.equals("short") || type2.equals("long") || type2.equals("int"))
                    return true;
                break;
            case "double":
                if (type2.equals("short") || type2.equals("long") || type2.equals("int") || type2.equals("float"))
                    return true;
                break;
            case "char":
                if (type2.equals("short") || type2.equals("long") || type2.equals("int"))
                    return true;
                break;
        }
        return false;
    }

    public boolean checkType(BinaryExpr binaryExpr){
        Expr expr1 = binaryExpr.getExpr1();
        Expr expr2 = binaryExpr.getExpr2();
        String type1 = getType(expr1);
        String type2 = getType(expr2);
        if (binaryExpr.getAssignmentOp() != null && binaryExpr.getAssignmentOp().getOpType().equals("="))
            return checkType(getType(binaryExpr.getExpr1()), getType(binaryExpr.getExpr2()));
        else if((binaryExpr.getOperator().equals("<") || binaryExpr.getOperator().equals("<=")
                || binaryExpr.getOperator().equals(">") || binaryExpr.getOperator().equals(">=")
                || binaryExpr.getOperator().equals("==") || binaryExpr.getOperator().equals("!="))
                && !getType(binaryExpr.getExpr1()).equals("string") && !getType(binaryExpr.getExpr2()).equals("string")){
            return checkType(getType(binaryExpr.getExpr1()), getType(binaryExpr.getExpr2())) ||
                    checkType(getType(binaryExpr.getExpr2()), getType(binaryExpr.getExpr1()));
        }
        else if (binaryExpr.getOperator().equals("+") || (binaryExpr.getAssignmentOp() != null &&
                binaryExpr.getAssignmentOp().getOpType().equals("+="))){
            return  (checkType("int", type1) && checkType("int", type2) || type1.equals("float") && type2.equals("float") ||
                    type1.equals("double") && type2.equals("double") || type1.equals("char") && type2.equals("char") ||
                    checkType("int", type1) && type2.equals("double")) ||
                    (type1.equals("double") && checkType("int", type2) ||
                            checkType("int", type1) && type2.equals("float")) ||
                    (type1.equals("float") && checkType("int", type2) ||
                            (type1.equals("float") && type2.equals("double")) ||
                    (type1.equals("double") && type2.equals("float")) || (checkType("int", type1) && type2.equals("char")) ||
                    (type1.equals("char") && checkType("int", type2)));
        }
        else if (binaryExpr.getOperator().equals("-") || (binaryExpr.getAssignmentOp() != null &&
                binaryExpr.getAssignmentOp().getOpType().equals("-="))){
            return  (checkType("int", type1) && checkType("int", type2) || type1.equals("float") && type2.equals("float") ||
                      type1.equals("double") && type2.equals("double") || type1.equals("char") && type2.equals("char") ||
                        type1.equals("char") && type2.equals("int")) && !((checkType("int", type1) && !type1.equals("char") && checkType("int", type2) && type2.equals("char")));
        }
        else if (binaryExpr.getOperator().equals("*") || (binaryExpr.getAssignmentOp() != null &&
                binaryExpr.getAssignmentOp().getOpType().equals("*="))){
            return (checkType("int", type1) && checkType("int", type2) || type1.equals("float") && type2.equals("float")
                    || type1.equals("double") && type2.equals("double") ||
                    type1.equals("float") && type2.equals("int") ||
                    checkType("int", type1) && type2.equals("float") ||
                    type1.equals("double") && checkType("int", type2)
                    || checkType("int", type1) && type2.equals("double") ||
                    type1.equals("double") && type2.equals("float") ||
                    type1.equals("float") && type2.equals("double"));
        }
        else if (binaryExpr.getOperator().equals("/") || (binaryExpr.getAssignmentOp() != null &&
                binaryExpr.getAssignmentOp().getOpType().equals("/="))) {
            return  (checkType("int", type1) && !type1.equals("char")  && checkType("int", type2) && !type2.equals("char") ||
                    type1.equals("float") && type2.equals("float") ||
                    type1.equals("double") && type2.equals("double") ||
                    checkType("int", type1) && !type1.equals("char") && type2.equals("double") ||
                    type1.equals("double") && checkType("int", type2) && !type2.equals("char"));
        }
        else if (binaryExpr.getOperator().equals("<<") || binaryExpr.getOperator().equals(">>") &&
                (binaryExpr.getAssignmentOp()!=null && (binaryExpr.getAssignmentOp().getOpType().equals(">>=") ||
                binaryExpr.getAssignmentOp().getOpType().equals("<<=")))){
            if (!type1.equals("string") && type2.equals("int"))
                return true;
        } else if ((binaryExpr.getAssignmentOp() != null && binaryExpr.getAssignmentOp().getOpType().equals("%=")) ||
                    binaryExpr.getOperator().equals("%")) {
            if (checkType("int", type1) && checkType("int", type2))
                return true;
        }
        return false;
    }

    public boolean checkType(UnaryExpr unaryExpr){
        String type = getType(unaryExpr.getExpr());
        if (type.equals("int") || type.equals("short") || type.equals("long") || type.equals("char") || type.equals("float") || type.equals("double"))
            return true;
        return false;
    }

    public boolean checkType(PrefixExpr prefixExpr){
        if (getType(prefixExpr).equals("void"))
            return false;
        return true;
    }

    public boolean checkType(CondExpr condExpr){
        return  (getType(condExpr.getExpr1()).equals("bool") &&
                (checkType(getType(condExpr.getExpr2()),getType(condExpr.getExpr3())) ||
                        checkType(getType(condExpr.getExpr3()),getType(condExpr.getExpr2()))));
    }

    public String getType(Expr expr){
        if (expr instanceof BinaryExpr){
            BinaryExpr binaryExpr = (BinaryExpr) expr;
            return getType(binaryExpr);
        }
        else if (expr instanceof ExprCast){
            ExprCast exprCast = (ExprCast) expr;
            return exprCast.getTypeName().getSpecifierQualifierList().getTypeSpecifier().getType();
        }
        else if(expr instanceof FuncCall){
            FuncCall funcCall = (FuncCall) expr;
            String funcName = ((Identifier) funcCall.getExpr()).getIdentifier();
            try {
                 return ((FuncDecSymbolTableItem) SymbolTable.top.getItem(FuncDecSymbolTableItem.START_KEY  + funcCall.getNumArgs() + funcName )).type;
            } catch (ItemNotFoundException e) {
                System.out.println("Line: akbar" + "-> " + funcName + " not declared");
            }
        }
        else if(expr instanceof Identifier){
            Identifier identifier = (Identifier) expr;
            if (!identifier.isFunc() && !identifier.getIdentifier().startsWith("\"")){
                try {
                    return ((VarDecSymbolTableItem) SymbolTable.top.getItem(VarDecSymbolTableItem.START_KEY + identifier.getIdentifier())).type;
                } catch (ItemNotFoundException e) {
                    System.out.println("Line: hi" + identifier.getLine() + "-> " + identifier.getIdentifier() + " not declared");
                }
            }
        }
        else if(expr instanceof PrefixExpr){
            return getType(((PrefixExpr) expr));
        }
        else if(expr instanceof UnaryExpr){
            return getType(((UnaryExpr) expr));
        }
        else if (expr instanceof Constant){
            return getType(((Constant) expr));
        }
        return "void";
    }

    public String getType(PrefixExpr prefixExpr){
        String type = "void";
        if (prefixExpr.getExpr() != null)
            type = getType(prefixExpr.getExpr());
        else if (prefixExpr.getConstant() != null)
            type = getType(prefixExpr.getConstant());
        else if (prefixExpr.getIdentifier() != null) {
            String identifier = prefixExpr.getIdentifier();
            try {
                type = ((VarDecSymbolTableItem) SymbolTable.top.getItem(VarDecSymbolTableItem.START_KEY + identifier)).type;
            } catch (ItemNotFoundException e) {
                System.out.println("Line: mame" + "-> " + " not declared");
            }
        }
        if (prefixExpr.getOps().size() != 0) {
            for(int i = prefixExpr.getOps().size() - 1; i >= 0; i--){
                String op = prefixExpr.getOps().get(i);
                if(op.equals("sizeof")) type = "int";
                else if(op.equals("++") || op.equals("--"))
                    if (type.equals("int") || type.equals("short") || type.equals("long") || type.equals("char") || type.equals("float") || type.equals("double"))
                        type = type;
                    else
                        return "void";
            }
        }
        return type;
    }

    public String getType(UnaryExpr unaryExpr){
        return getType(unaryExpr.getExpr());
    }

    public String getType(BinaryExpr binaryExpr){
        Expr expr1 = binaryExpr.getExpr1();
        Expr expr2 = binaryExpr.getExpr2();
        String type1 = getType(expr1);
        String type2 = getType(expr2);
        if (binaryExpr.getOperator().equals("<") || binaryExpr.getOperator().equals("<=") || binaryExpr.getOperator().equals(">") || binaryExpr.getOperator().equals(">=")
        || binaryExpr.getOperator().equals("==") || binaryExpr.getOperator().equals("!=")){
            return "bool";
        }
        else if (binaryExpr.getOperator().equals("+")){
            if (type1.equals("int") && type2.equals("int")) return "int";
            else if (type1.equals("float") && type2.equals("float")) return "float";
            else if (type1.equals("double") && type2.equals("double")) return "double";
            else if (type1.equals("char") && type2.equals("char")) return "char";
            else if ((type1.equals("int") && type2.equals("double")) ||
                    (type1.equals("double") && type2.equals("int"))) return "double";
            else if ((type1.equals("int") && type2.equals("float")) ||
                    (type1.equals("float") && type2.equals("int"))) return "float";
            else if ((type1.equals("float") && type2.equals("double")) ||
                (type1.equals("double") && type2.equals("float"))) return "double";
            else if ((type1.equals("int") && type2.equals("char")) ||
                    (type1.equals("char") && type2.equals("int"))) return "char";
        }
        else if (binaryExpr.getOperator().equals("-")){
            if (type1.equals("int") && type2.equals("int")) return "int";
            else if (type1.equals("float") && type2.equals("float")) return "float";
            else if (type1.equals("double") && type2.equals("double")) return "double";
            else if (type1.equals("char") && type2.equals("char")) return "char";
            else if (type1.equals("char") && type2.equals("int")) return "char";
        }
        else if(binaryExpr.getOperator().equals("/")){
            if (type1.equals("int") && type2.equals("int")) return "double";
            else if (type1.equals("float") && type2.equals("float")) return "double";
            else if (type1.equals("double") && type2.equals("double")) return "double";
            else if (type1.equals("int") && type2.equals("double")) return "double";
            else if (type1.equals("double") && type2.equals("int")) return "double";
        }
        else if (binaryExpr.getOperator().equals("*")){
            if (type1.equals("int") && type2.equals("int")) return "int";
            else if (type1.equals("float") && type2.equals("float")) return "float";
            else if (type1.equals("double") && type2.equals("double")) return "double";
            else if (type1.equals("float") && type2.equals("int")) return "float";
            else if (type1.equals("int") && type2.equals("float")) return "float";
            else if (type1.equals("double") && type2.equals("int")) return "double";
            else if (type1.equals("int") && type2.equals("double")) return "double";
            else if (type1.equals("double") && type2.equals("float")) return "double";
            else if (type1.equals("float") && type2.equals("double")) return "double";
        }
        else if (binaryExpr.getOperator().equals("||") || binaryExpr.getOperator().equals("&&")){
            return "bool";
        } else if (binaryExpr.getOperator().equals(">>") || binaryExpr.getOperator().equals("<<")
                || (binaryExpr.getAssignmentOp()!=null && (binaryExpr.getAssignmentOp().getOpType().equals("=>>") ||
                binaryExpr.getAssignmentOp().getOpType().equals("=<<")))) {
            return type1;
        }
        return "void";
    }

    public String getType(CondExpr condExpr){
        return getType(condExpr.getExpr2());
    }

    public String getType(Constant constant){
        String val = constant.getConstant();
        if (val.matches("[0-9]+")) return "int";
        if (val.matches("[0-9]+\\.[0-9]*[fF]?")) return "float";
        if (val.matches("[0-9]+\\.[0-9]*")) return "double";
        if (val.matches("'[^']'")) return "char";
        if (val.equals("true") || val.equals("false")) return "bool";
        if (constant.isString() || val.matches("^\".*\"")) return "string";
        return "void";
    }
}
