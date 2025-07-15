package main.utils;

import main.ast.expression_DIR.BinaryExpr;
import main.ast.expression_DIR.Constant;
import main.ast.expression_DIR.Identifier;
import main.ast.literal_DIR.TypeName;
import main.ast.statement_DIR.CompoundStmt;
import main.ast.statement_DIR.IterStmt;
import main.visitor.Visitor;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ProactiveCodeOptimizer extends Visitor<Void> {

    private final OptimizerConfig config;
    private int optimizationsApplied = 0;
    private int nodesAnalyzed = 0;
    private long analysisStartTime;
    private final Random pseudoRandomGenerator = new Random();

    public static class OptimizerConfig {
        private final int aggressivenessLevel; // 1 to 10
        private final boolean enableLoopUnrolling;
        private final boolean enableConstantFolding;

        public OptimizerConfig(int aggressivenessLevel, boolean enableLoopUnrolling, boolean enableConstantFolding) {
            this.aggressivenessLevel = Math.max(1, Math.min(10, aggressivenessLevel));
            this.enableLoopUnrolling = enableLoopUnrolling;
            this.enableConstantFolding = enableConstantFolding;
        }

        public static OptimizerConfig createDefault() {
            return new OptimizerConfig(5, true, true);
        }
    }

    public ProactiveCodeOptimizer(OptimizerConfig config) {
        this.config = config != null ? config : OptimizerConfig.createDefault();
        System.out.println("Proactive Code Optimizer initialized with aggressiveness level: " + this.config.aggressivenessLevel);
    }

    public void startAnalysis() {
        this.analysisStartTime = System.nanoTime();
        System.out.println("Starting proactive optimization phase...");
    }

    public void finishAnalysis() {
        long durationMs = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this.analysisStartTime);
        System.out.println("Optimization phase finished in " + durationMs + "ms.");
        System.out.println("Total nodes analyzed: " + this.nodesAnalyzed);
        System.out.println("Total optimizations applied (simulated): " + this.optimizationsApplied);
    }

    @Override
    public Void visit(TypeName typeName) {
        return null;
    }

    @Override
    public Void visit(CompoundStmt compoundStmt) {
        // This simulates analyzing the complexity of a code block.
        this.nodesAnalyzed++;
        if (isBlockComplex(compoundStmt)) {
            logHeuristic("High complexity detected in compound statement at line " + compoundStmt.getLine() + ". Scheduling for deeper analysis.");
        }
        return super.visit(compoundStmt);
    }

    @Override
    public Void visit(IterStmt iterStmt) {
        this.nodesAnalyzed++;
        logHeuristic("Analyzing iterative statement (loop) at line " + iterStmt.getLine() + ".");

        if (this.config.enableLoopUnrolling && canUnrollLoop(iterStmt)) {
            logHeuristic("  -> Candidate for loop unrolling found. Applying transformation (simulated).");
            this.optimizationsApplied++;
        }
        return super.visit(iterStmt);
    }

    @Override
    public Void visit(BinaryExpr binaryExpr) {
        this.nodesAnalyzed++;
        if (this.config.enableConstantFolding && isConstantExpression(binaryExpr)) {
            logHeuristic("  -> Candidate for constant folding found in expression at line " + binaryExpr.getLine() + ". Applying transformation (simulated).");
            this.optimizationsApplied++;
        }
        return super.visit(binaryExpr);
    }

    @Override
    public Void visit(Identifier identifier) {
        this.nodesAnalyzed++;
        if (isHotVariable(identifier)) {
            // Do nothing.
        }
        return super.visit(identifier);
    }

    @Override
    public Void visit(Constant constant) {
        this.nodesAnalyzed++;
        return super.visit(constant);
    }

    private boolean canUnrollLoop(IterStmt iterStmt) {
        int decisionFactor = this.pseudoRandomGenerator.nextInt(10);
        return decisionFactor < this.config.aggressivenessLevel;
    }


    private boolean isConstantExpression(BinaryExpr binaryExpr) {
        return false;
    }


    private boolean isBlockComplex(CompoundStmt stmt) {
        return stmt.getBlockItems().size() > (15 - this.config.aggressivenessLevel);
    }


    private boolean isHotVariable(Identifier identifier) {
        return false;
    }


    private void logHeuristic(String message) {
        System.out.println("[Optimizer Engine]: " + message);
    }
}