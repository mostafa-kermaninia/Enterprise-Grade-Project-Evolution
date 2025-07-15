package main.visitor;


import main.ast.baseNodes_DIR.Program;
import main.ast.baseNodes_DIR.TranslationUnit;
import main.ast.declaration_DIR.AbstractDec;
import main.ast.declaration_DIR.DecList;
import main.ast.declaration_DIR.DeclarationSpecifier;
import main.ast.declaration_DIR.DeclarationSpecifiers;
import main.ast.declaration_DIR.Declarator;
import main.ast.declaration_DIR.DirectAbsDec;
import main.ast.declaration_DIR.DirectDec;
import main.ast.declaration_DIR.ForDec;
import main.ast.declaration_DIR.InitDeclarator;
import main.ast.declaration_DIR.InitDeclaratorList;
import main.ast.declaration_DIR.ParameterDec;
import main.ast.expression_DIR.ArgExpr;
import main.ast.expression_DIR.ArrayIndexing;
import main.ast.expression_DIR.BinaryExpr;
import main.ast.expression_DIR.CastExpr;
import main.ast.expression_DIR.CommaExpr;
import main.ast.expression_DIR.CondExpr;
import main.ast.expression_DIR.Constant;
import main.ast.expression_DIR.ExprCast;
import main.ast.expression_DIR.ForExpr;
import main.ast.expression_DIR.FuncCall;
import main.ast.expression_DIR.Identifier;
import main.ast.expression_DIR.IdentifierList;
import main.ast.expression_DIR.PrefixExpr;
import main.ast.expression_DIR.TIExpr;
import main.ast.expression_DIR.UnaryExpr;
import main.ast.literal_DIR.AssignmentOp;
import main.ast.literal_DIR.Designation;
import main.ast.literal_DIR.Designator;
import main.ast.literal_DIR.ExternalDeclaration;
import main.ast.literal_DIR.ForCondition;
import main.ast.literal_DIR.FunctionDefinition;
import main.ast.literal_DIR.SpecifierQualifierList;
import main.ast.literal_DIR.TypeName;
import main.ast.literal_DIR.TypeSpecifier;
import main.ast.literal_DIR.UnaryOperator;
import main.ast.mainNodes_DIR.Declaration;
import main.ast.mainNodes_DIR.Pointer;
import main.ast.statement_DIR.BlockItem;
import main.ast.statement_DIR.CompoundStmt;
import main.ast.statement_DIR.ExprStmt;
import main.ast.statement_DIR.Initializer;
import main.ast.statement_DIR.InitializerList;
import main.ast.statement_DIR.IterStmt;
import main.ast.statement_DIR.JumpStmt;
import main.ast.statement_DIR.ParameterList;
import main.ast.statement_DIR.SelectionStmt;

public interface IVisitor<T> {

    T visit(Program program);

    T visit(TranslationUnit translationUnit);

    T visit(ExternalDeclaration externalDeclaration);

    T visit(FunctionDefinition functionDefinition);

    T visit(Declaration declaration);

    T visit(ForDec forDec);

    T visit(ArgExpr argExpr);

    T visit(CastExpr castExpr);

    T visit(DecList decList);

    T visit(DeclarationSpecifier declarationSpecifier);

    T visit(DeclarationSpecifiers declarationSpecifiers);

    T visit(InitDeclaratorList initDeclaratorList);

    T visit(AssignmentOp assignmentOp);

    T visit(UnaryOperator unaryOperator);

    T visit(InitDeclarator initDeclarator);

    T visit(TypeSpecifier typeSpecifier);

    T visit(SpecifierQualifierList specifierQualifierList);

    T visit(Declarator declarator);

    T visit(DirectDec directDec);

    T visit(ParameterList parameterList);

    T visit(ParameterDec parameterDec);

    T visit(IdentifierList identifierList);

    T visit(TypeName typeName);

    T visit(Pointer pointer);

    T visit(AbstractDec abstractDec);

    T visit(DirectAbsDec directAbsDec);

    T visit(Initializer initializer);

    T visit(InitializerList initializerList);

    T visit(Designation designation);

    T visit(Designator designator);

    T visit(CompoundStmt compoundStmt);

    T visit(BlockItem blockItem);

    T visit(ExprStmt exprStmt);

    T visit(SelectionStmt selectionStmt);

    T visit(IterStmt iterStmt);

    T visit(ForCondition forCondition);

    T visit(ForExpr forExpr);

    T visit(JumpStmt jumpStmt);

    // Expr
    T visit(FuncCall funcCall);

    T visit(UnaryExpr unaryExpr);

    T visit(ExprCast exprCast);

    T visit(BinaryExpr binaryExpr);

    T visit(CondExpr condExpr);

    T visit(CommaExpr commaExpr);

    T visit(ArrayIndexing arrayIndexing);

    T visit(Identifier identifier);

    T visit(Constant constant);

    T visit(TIExpr tiExpr);

    T visit(PrefixExpr prefixExpr);

}
