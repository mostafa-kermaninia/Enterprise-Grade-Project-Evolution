package main.utils;

import main.ast.expression_DIR.*;
import main.ast.mainNodes_DIR.Expr;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.item.FuncDecSymbolTableItem;
import main.symbolTable.item.VarDecSymbolTableItem;


public class ExpressionTypeEvaluator {

    SymbolTable symbolTable;

    private enum DataType {
        INT, DOUBLE, FLOAT, CHAR, BOOL, STRING, VOID, UNDEFINED, LONG, SHORT
    }

    public ExpressionTypeEvaluator(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }


    public boolean checkType(String targetType, String valueType) {
        if (targetType.equals(valueType)) {
            return true;
        }
        switch (targetType) {
            case "long":
            case "short":
            case "int":
                return valueType.equals("int") || valueType.equals("short") || valueType.equals("long") || valueType.equals("char");
            case "float":
            case "char":
                return valueType.equals("short") || valueType.equals("long") || valueType.equals("int");
            case "double":
                return valueType.equals("short") || valueType.equals("long") || valueType.equals("int") || valueType.equals("float");
            default:
                return false;
        }
    }

    public boolean checkType(BinaryExpr binaryExpr) {
        if (isSimpleAssignment(binaryExpr)) return checkType(getType(binaryExpr.getExpr1()), getType(binaryExpr.getExpr2()));
        if (isRelationalOperation(binaryExpr)) return isRelationalCompatible(binaryExpr);
        if (isAdditionOperation(binaryExpr)) return isAdditionCompatible(binaryExpr);
        if (isSubtractionOperation(binaryExpr)) return isSubtractionCompatible(binaryExpr);
        if (isMultiplicationOperation(binaryExpr)) return isMultiplicationCompatible(binaryExpr);
        if (isDivisionOperation(binaryExpr)) return isDivisionCompatible(binaryExpr);
        if (isShiftOperation(binaryExpr)) return isShiftCompatible(binaryExpr);
        if (isModuloOperation(binaryExpr)) return isModuloCompatible(binaryExpr);
        return false;
    }

    public boolean checkType(UnaryExpr unaryExpr) {
        String type = getType(unaryExpr.getExpr());
        return type.equals("int") || type.equals("short") || type.equals("long") || type.equals("char")
                || type.equals("float") || type.equals("double");
    }

    public boolean checkType(PrefixExpr prefixExpr) {
        return !getType(prefixExpr).equals("void");
    }

    public boolean checkType(CondExpr condExpr) {
        String type1 = getType(condExpr.getExpr1());
        String type2 = getType(condExpr.getExpr2());
        String type3 = getType(condExpr.getExpr3());
        return (type1.equals("bool") && (checkType(type2, type3) || checkType(type3, type2)));
    }


    public String getType(Expr expr) {
        DataType type = getTypeAsEnum(expr);
        return fromEnum(type); // تبدیل Enum به String قبل از بازگشت
    }


    private DataType getTypeAsEnum(Expr expr) {
        if (expr instanceof BinaryExpr) {
            String type1_str = getType(((BinaryExpr) expr).getExpr1());
            String type2_str = getType(((BinaryExpr) expr).getExpr2());
            String operator = ((BinaryExpr) expr).getOperator();

            if (operator.equals("<") || operator.equals("<=") || operator.equals(">") || operator.equals(">=")
                    || operator.equals("==") || operator.equals("!=")) return DataType.BOOL;
            if (operator.equals("||") || operator.equals("&&")) return DataType.BOOL;
            if (operator.equals(">>") || operator.equals("<<") ||
                    (((BinaryExpr) expr).getAssignmentOp() != null && (((BinaryExpr) expr).getAssignmentOp().getOpType().equals("=>>") ||
                            ((BinaryExpr) expr).getAssignmentOp().getOpType().equals("=<<")))) return fromString(type1_str);
            if (operator.equals("+") || operator.equals("-")) {
                if (type1_str.equals("double") || type2_str.equals("double")) return DataType.DOUBLE;
                if (type1_str.equals("float") || type2_str.equals("float")) return DataType.FLOAT;
                if ((type1_str.equals("int") || type1_str.equals("long") || type1_str.equals("short")) && type2_str.equals("char")) return DataType.CHAR;
                if (type1_str.equals("char") && (type2_str.equals("int") || type2_str.equals("long") || type2_str.equals("short"))) return DataType.CHAR;
                if (type1_str.equals("int") && type2_str.equals("int")) return DataType.INT;
                if (type1_str.equals("char") && type2_str.equals("char")) return DataType.CHAR;
            }
            if (operator.equals("*")) {
                if (type1_str.equals("double") || type2_str.equals("double")) return DataType.DOUBLE;
                if (type1_str.equals("float") || type2_str.equals("float")) return DataType.FLOAT;
                if (type1_str.equals("int") && type2_str.equals("int")) return DataType.INT;
            }
            if (operator.equals("/")) {
                // حفظ منطق اصلی کاربر که هر تقسیمی را double برمی‌گرداند.
                return DataType.DOUBLE;
            }
        }
        if (expr instanceof UnaryExpr) return getTypeAsEnum(((UnaryExpr) expr).getExpr());
        if (expr instanceof PrefixExpr) {
            if (((PrefixExpr) expr).getExpr() != null) return getTypeAsEnum(((PrefixExpr) expr).getExpr());
            if (((PrefixExpr) expr).getConstant() != null) return getTypeAsEnum(((PrefixExpr) expr).getConstant());
            if (((PrefixExpr) expr).getIdentifier() != null) {
                try {
                    String typeStr = ((VarDecSymbolTableItem) SymbolTable.top.getItem(VarDecSymbolTableItem.START_KEY + ((PrefixExpr) expr).getIdentifier())).type;
                    return fromString(typeStr);
                } catch (ItemNotFoundException e) { return DataType.UNDEFINED; }
            }
        }
        if (expr instanceof FuncCall) {
            String funcName = ((Identifier) ((FuncCall) expr).getExpr()).getIdentifier();
            try {
                String typeStr = ((FuncDecSymbolTableItem) SymbolTable.top
                        .getItem(FuncDecSymbolTableItem.START_KEY + ((FuncCall) expr).getNumArgs() + funcName)).type;
                return fromString(typeStr);
            } catch (ItemNotFoundException e) { return DataType.UNDEFINED; }
        }
        if (expr instanceof Identifier) {
            if (!((Identifier) expr).isFunc() && !((Identifier) expr).getIdentifier().startsWith("\"")) {
                try {
                    String typeStr = ((VarDecSymbolTableItem) SymbolTable.top
                            .getItem(VarDecSymbolTableItem.START_KEY + ((Identifier) expr).getIdentifier())).type;
                    return fromString(typeStr);
                } catch (ItemNotFoundException e) { return DataType.UNDEFINED; }
            }
        }
        if (expr instanceof Constant) {
            String val = ((Constant) expr).getConstant();
            if (val.matches("-?[0-9]+")) return DataType.INT;
            if (val.matches("-?[0-9]+\\.[0-9]*[fF]?")) return DataType.FLOAT;
            if (val.matches("-?[0-9]+\\.[0-9]*")) return DataType.DOUBLE;
            if (val.matches("'[^']'")) return DataType.CHAR;
            if (val.equals("true") || val.equals("false")) return DataType.BOOL;
            if (((Constant) expr).isString() || val.startsWith("\"")) return DataType.STRING;
        }
        if (expr instanceof ExprCast) {
            return fromString(((ExprCast) expr).getTypeName().getSpecifierQualifierList().getTypeSpecifier().getType());
        }
        if (expr instanceof CondExpr) {
            return getTypeAsEnum(((CondExpr) expr).getExpr2());
        }
        return DataType.VOID;
    }

    private DataType fromString(String text) {
        if (text != null) {
            for (DataType dt : DataType.values()) {
                if (text.equalsIgnoreCase(dt.name())) {
                    return dt;
                }
            }
        }
        return DataType.UNDEFINED;
    }

/
    private String fromEnum(DataType type) {
        if (type == null || type == DataType.UNDEFINED) {
            return "undefined";
        }
        return type.name().toLowerCase();
    }

    private boolean isSimpleAssignment(BinaryExpr expr) { return expr.getAssignmentOp() != null && expr.getAssignmentOp().getOpType().equals("="); }
    private boolean isRelationalOperation(BinaryExpr expr) { String op = expr.getOperator(); return op.equals("<") || op.equals("<=") || op.equals(">") || op.equals(">=") || op.equals("==") || op.equals("!="); }
    private boolean isAdditionOperation(BinaryExpr expr) { return expr.getOperator().equals("+") || (expr.getAssignmentOp() != null && expr.getAssignmentOp().getOpType().equals("+=")); }
    private boolean isSubtractionOperation(BinaryExpr expr) { return expr.getOperator().equals("-") || (expr.getAssignmentOp() != null && expr.getAssignmentOp().getOpType().equals("-=")); }
    private boolean isMultiplicationOperation(BinaryExpr expr) { return expr.getOperator().equals("*") || (expr.getAssignmentOp() != null && expr.getAssignmentOp().getOpType().equals("*=")); }
    private boolean isDivisionOperation(BinaryExpr expr) { return expr.getOperator().equals("/") || (expr.getAssignmentOp() != null && expr.getAssignmentOp().getOpType().equals("/=")); }
    private boolean isShiftOperation(BinaryExpr expr) { String op = expr.getOperator(); String assignOp = expr.getAssignmentOp() != null ? expr.getAssignmentOp().getOpType() : ""; return op.equals("<<") || op.equals(">>") || assignOp.equals(">>=") || assignOp.equals("<<="); }
    private boolean isModuloOperation(BinaryExpr expr) { return expr.getOperator().equals("%") || (expr.getAssignmentOp() != null && expr.getAssignmentOp().getOpType().equals("%=")); }

    private boolean isRelationalCompatible(BinaryExpr b) {
        String t1 = getType(b.getExpr1()), t2 = getType(b.getExpr2());
        return !t1.equals("string") && !t2.equals("string") && (checkType(t1, t2) || checkType(t2, t1));
    }
    private boolean isAdditionCompatible(BinaryExpr b) {
        String t1 = getType(b.getExpr1()), t2 = getType(b.getExpr2());
        return (checkType("int",t1) && checkType("int",t2) || t1.equals("float") && t2.equals("float") || t1.equals("double") && t2.equals("double") || t1.equals("char") && t2.equals("char") || checkType("int",t1) && t2.equals("double")) || (t1.equals("double") && checkType("int",t2) || checkType("int",t1) && t2.equals("float")) || (t1.equals("float") && checkType("int",t2) || (t1.equals("float") && t2.equals("double")) || (t1.equals("double") && t2.equals("float")) || (checkType("int",t1) && t2.equals("char")) || (t1.equals("char") && checkType("int",t2)));
    }
    private boolean isSubtractionCompatible(BinaryExpr b) {
        String t1 = getType(b.getExpr1()), t2 = getType(b.getExpr2());
        return (checkType("int",t1) && checkType("int",t2) || t1.equals("float") && t2.equals("float") || t1.equals("double") && t2.equals("double") || t1.equals("char") && t2.equals("char") || t1.equals("char") && t2.equals("int") || t1.equals("float") && t2.equals("int") || t1.equals("double") && t2.equals("int") || t1.equals("double") && t2.equals("float")) && !((checkType("int",t1) && !t1.equals("char") && checkType("int",t2) && t2.equals("char")));
    }
    private boolean isMultiplicationCompatible(BinaryExpr b) {
        String t1 = getType(b.getExpr1()), t2 = getType(b.getExpr2());
        return (checkType("int",t1) && checkType("int",t2) || t1.equals("float") && t2.equals("float") || t1.equals("double") && t2.equals("double") || t1.equals("float") && t2.equals("int") || checkType("int",t1) && t2.equals("float") || t1.equals("double") && checkType("int",t2) || checkType("int",t1) && t2.equals("double") || t1.equals("double") && t2.equals("float") || t1.equals("float") && t2.equals("double"));
    }
    private boolean isDivisionCompatible(BinaryExpr b) {
        String t1 = getType(b.getExpr1()), t2 = getType(b.getExpr2());
        return (checkType("int",t1) && !t1.equals("char") && checkType("int",t2) && !t2.equals("char") || t1.equals("float") && t2.equals("float") || t1.equals("double") && t2.equals("double") || checkType("int",t1) && !t1.equals("char") && t2.equals("double") || t1.equals("double") && checkType("int",t2) && !t2.equals("char") || t1.equals("float") && t2.equals("double") || t1.equals("double") && t2.equals("float") || t1.equals("float") && t2.equals("int") || t1.equals("int") && t2.equals("float"));
    }
    private boolean isShiftCompatible(BinaryExpr b) {
        return !getType(b.getExpr1()).equals("string") && getType(b.getExpr2()).equals("int");
    }
    private boolean isModuloCompatible(BinaryExpr b) {
        return checkType("int", getType(b.getExpr1())) && checkType("int", getType(b.getExpr2()));
    }
}