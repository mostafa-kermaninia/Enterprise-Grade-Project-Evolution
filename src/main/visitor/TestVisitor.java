package main.visitor;

import main.ast.nodes_DIR.Node;
import main.ast.statement_DIR.CompoundStatement;
import main.ast.statement_DIR.IterationStatement;
import main.ast.statement_DIR.SelectionStatement;
import main.ast.expression_DIR.*;
import main.ast.nodes_DIR.FunctionDefinition;
import java.util.HashSet;
import java.util.Set;

public class TestVisitor {

    private final Set<Expr> alreadyEvaluated = new HashSet<>();

    public void counter(Node node) {
        if (node == null) return;

        if (node instanceof FunctionDefinition) {
            evaluateFunction((FunctionDefinition) node);
        } else if (node instanceof IterationStatement) {
            evaluateIterationStatement((IterationStatement) node);
        } else if (node instanceof SelectionStatement) {
            evaluateSelectionStatement((SelectionStatement) node);
        } else if (node instanceof Expr && !alreadyEvaluated.contains(node)) {
            evaluateExpressionNode((Expr) node);
        } else {
            // Traverse child nodes
            node.get_child().forEach(this::counter);
        }
    }

    private void evaluateFunction(FunctionDefinition func) {
        int count = countStatements(func.getBody());
        System.out.println("Line " + func.getLine() + ": Stmt function " + func.getFunctionName() + " = " + count);
        counter(func.getBody());
    }

    private void evaluateIterationStatement(IterationStatement iterationStmt) {
        if (iterationStmt.getCondition() != null) {
            Expr cond = iterationStmt.getCondition();
            System.out.println("Line " + cond.getLine() + ": Expr " + evaluateExpression(cond));
            alreadyEvaluated.add(cond);
        }

        int count = countStatements(iterationStmt.getBody());
        String iterationType = getIterationStatementType(iterationStmt);
        System.out.println("Line " + iterationStmt.getLine() + ": Stmt " + iterationType + " = " + count);

        counter(iterationStmt.getBody());
    }

    private void evaluateSelectionStatement(SelectionStatement sel) {
        if (sel.getCondition() != null) {
            System.out.println("Line " + sel.getCondition().getLine() + ": Expr " + evaluateExpression(sel.getCondition()));
        }

        evaluateBody(sel.getThenBody(), "Then");
        evaluateBody(sel.getElseBody(), "Else");
    }

    private void evaluateBody(Node body, String bodyType) {
        if (body != null) {
            int count = countStatements(body);
            System.out.println("Line " + body.getLine() + ": Stmt selection (" + bodyType + ") = " + count);
//            System.out.println("Line " + body.getLine() + ": Stmt selection" + " = " + count);
            counter(body);
        }
    }

    private void evaluateExpressionNode(Expr expr) {
        System.out.println("Line " + expr.getLine() + ": Expr " + evaluateExpression(expr));
        alreadyEvaluated.add(expr);
    }

    private String getIterationStatementType(IterationStatement stmt) {
        switch (stmt.getType()) {
            case FOR: return "for";
            case WHILE: return "while";
            case DO_WHILE: return "do-while";
            default: return "unknown";
        }
    }

    private int countStatements(Node body) {
        if (body instanceof CompoundStatement) {
            return ((CompoundStatement) body).getStatements().size();
        }
        return body != null ? 1 : 0;
    }

    private String evaluateExpression(Expr expr) {
        if (expr instanceof ConstantExpr) {
            return ((ConstantExpr) expr).getOperator();
        } else if (expr instanceof BinaryExpr) {
            return ((BinaryExpr) expr).getOperator();
        } else if (expr instanceof UnaryExpr) {
            return ((UnaryExpr) expr).getOperand();
        } else if (expr instanceof IdentifierExpr) {
            return ((IdentifierExpr) expr).getName();
        } else if (expr instanceof PostfixExpr) {
            return ((PostfixExpr) expr).getOperator();
        } else if (expr instanceof PrefixExpr) {
            return ((PrefixExpr) expr).getOperator();
        } else if (expr instanceof AssignmentExpr) {
            return ((AssignmentExpr) expr).getOperator();
        } else if (expr instanceof CommaExpr) {
            return ((CommaExpr) expr).getOperator();
        } else if (expr instanceof FunctionCallExpr) {
            return ((FunctionCallExpr) expr).getInstance().toString();
        }
        return "Unknown expression type";
    }
}

