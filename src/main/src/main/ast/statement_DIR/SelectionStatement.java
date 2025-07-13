package main.ast.statement_DIR;

import main.ast.expression_DIR.Expression;
import main.symbolTable.SymbolTable;
import main.visitor.IVisitor;

public class SelectionStatement extends Statement {
    private final Statement mainStatement;
    private Statement elseStatement;
    private final Expression expression;
    private int elseLine;
    private SymbolTable symbolTable;

    public SelectionStatement(Expression expression, Statement mainStatement) {
        this.expression = expression;
        this.mainStatement = mainStatement;
        this.elseStatement = null;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Expression getExpression() {
        return expression;
    }

    public Statement getMainStatement() {
        return mainStatement;
    }

    public Statement getElseStatement() {
        return elseStatement;
    }

    public void setElseStatement(Statement statement) {
        this.elseStatement = statement;
    }

    public int getElseLine() {
        return elseLine;
    }

    public void setElseLine(int line) {
        this.elseLine = line;
    }

    public SymbolTable getSymbolTable() {
        return symbolTable;
    }

    public void setSymbolTable(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }

    public boolean allReturn() {
        boolean ans = true;
        if (elseStatement == null) {
            return false;
        } else if (elseStatement instanceof SelectionStatement) {
            SelectionStatement selStatement = (SelectionStatement) elseStatement;
            ans = ans && selStatement.allReturn();
        } else if (elseStatement instanceof CompoundStatement) {
            CompoundStatement compStatement = (CompoundStatement) elseStatement;
            ans = ans && compStatement.hasJumpStatement();
        }
        if (mainStatement instanceof CompoundStatement)
            ans = ans & ((CompoundStatement) mainStatement).hasJumpStatement();
        else if (mainStatement instanceof SelectionStatement)
            ans = ans && ((SelectionStatement) mainStatement).allReturn();

        return ans;
    }
}
