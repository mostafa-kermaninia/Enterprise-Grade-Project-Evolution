// package main.visitor;
//
// import main.ast.baseNodes_DIR.*;
// import main.ast.declaration_DIR.*;
// import main.ast.expression_DIR.*;
// import main.ast.literal_DIR.*;
// import main.ast.statement_DIR.*;
// import main.symbolTable.*;
// import main.symbolTable.exceptions.*;
// import main.symbolTable.item.*;
//
// public class nnnn extends Visitor<Void> {
// public SymbolTable symbolTableMain;
// public boolean noError = true;
// @Override
// public Void visit(Program program) {
// SymbolTable.top = new SymbolTable();
// SymbolTable.root = SymbolTable.top;
//
// program.setSymbolTable(SymbolTable.top);
// program.getTranslationUnit().accept(this);
// symbolTableMain = SymbolTable.top;
// return null;
// }
//
// public Void visit(TranslationUnit translationUnit) {
// for (ExternalDeclaration externalDeclaration :
// translationUnit.getExternalDeclaration()){
// externalDeclaration.accept(this);
// }
// return null;
// }
//
// public Void visit(ExternalDeclaration externalDeclaration) {
// if (externalDeclaration.getDeclaration() != null)
// externalDeclaration.getDeclaration().accept(this);
// else
// externalDeclaration.getFunctionDefinition().accept(this);
// return null;
// }
//
// public Void visit(FunctionDefinition functionDefinition) {
// ParameterList plist =
// functionDefinition.getDeclarator().getDirectDec().getParameterList();
// if (plist == null)
// functionDefinition.setNumArgs(0);
// else
// functionDefinition.setNumArgs(plist.getParameterDecs().size());
//
//
// FuncDecSymbolTableItem func_dec_item = new
// FuncDecSymbolTableItem(functionDefinition);
// try {
// SymbolTable.top.put(func_dec_item);
// } catch (ItemAlreadyExistsException e) {
// System.out.println("Redefinition of function \"" +
// functionDefinition.getDeclarator().getDirectDec().getDirectDec().getIdentifier()
// +"\" in line " +
// functionDefinition.getDeclarator().getDirectDec().getDirectDec().getLine());
// noError = false;
// }
//
//
// SymbolTable func_dec_symbol_table = new SymbolTable(SymbolTable.top);
// functionDefinition.setSymbolTable(func_dec_symbol_table);
// SymbolTable.push(func_dec_symbol_table);
//
// if (functionDefinition.getDecSpecifiers() != null)
// functionDefinition.getDecSpecifiers().accept(this);
// functionDefinition.getDeclarator().accept(this);
// if (functionDefinition.getDecList() != null)
// functionDefinition.getDecList().accept(this);
// functionDefinition.getCompoundStatement().accept(this);
//
//// System.out.println();
// SymbolTable.pop();
// return null;
// }
//
// public Void visit(CastExpression castExpression) {
// if (castExpression.getCastExpression() != null)
// castExpression.getCastExpression().accept(this);
// if (castExpression.getExpression() != null)
// castExpression.getExpression().accept(this);
// if (castExpression.getTypeName() != null)
// castExpression.getTypeName().accept(this);
// return null;
// }
//
//
// public Void visit(Declaration declaration) {
// declaration.getDeclarationSpecifiers().accept(this);
// if (declaration.getInitDeclaratorList() != null)
// declaration.getInitDeclaratorList().accept(this);
// return null;
// }
//
// public Void visit(DecList decList) {
// for (Declaration declaration : decList.getDeclarations())
// declaration.accept(this);
// return null;
// }
//
// public Void visit(DeclarationSpecifiers declarationSpecifiers) {
// for (DeclarationSpecifier declarationSpecifier :
// declarationSpecifiers.getDeclarationSpecifiers())
// declarationSpecifier.accept(this);
// if (declarationSpecifiers.getDeclarationSpecifiers().get(0).getType() != null
// &&
// declarationSpecifiers.getDeclarationSpecifiers().get(0).getType().equals("typedef"))
// declarationSpecifiers.getDeclarationSpecifiers().get(declarationSpecifiers.getDeclarationSpecifiers().size()
// - 1
// ).getTypeSpecifier().setTypeDef(declarationSpecifiers.getDeclarationSpecifiers().get(1).getType());
// return null;
// }
//
// public Void visit(ForDec forDec) {
// forDec.getDeclarationSpecifiers().accept(this);
// if (forDec.getInitDecList() != null)
// forDec.getInitDecList().accept(this);
//
// return null;
// }
//
//
// public Void visit(DeclarationSpecifier declarationSpecifier) {
// if (declarationSpecifier.getTypeSpecifier() != null)
// declarationSpecifier.getTypeSpecifier().accept(this);
// return null;
// }
//
// public Void visit(InitDeclaratorList initDeclaratorList) {
// for (InitDeclarator initDeclarator : initDeclaratorList.getInitDeclarators())
// initDeclarator.accept(this);
//
// return null;
// }
//
// public Void visit(InitDeclarator initDeclarator) {
// DirectDec directDec = initDeclarator.getDeclarator().getDirectDec();
// while (directDec.getIdentifier().isEmpty())
// directDec = directDec.getDirectDec();
// if (!directDec.getIdentifier().isEmpty()){
// TypeSpecifier typeSpecifier = new TypeSpecifier(directDec.getIdentifier());
// typeSpecifier.setLine(directDec.getLine());
// directDec.setTypeSpecifier(typeSpecifier);
// VarDecSymbolTableItem var_dec_item = new
// VarDecSymbolTableItem(typeSpecifier);
// try {
// SymbolTable.top.put(var_dec_item);
// } catch (ItemAlreadyExistsException e) {
// System.out.println("Redeclaration of variable \"" + typeSpecifier.getType() +
// "\" in line " + typeSpecifier.getLine());
// noError = false;
// }
// }
//
// initDeclarator.getDeclarator().accept(this);
// if (initDeclarator.getInitializer() != null)
// initDeclarator.getInitializer().accept(this);
// return null;
// }
//
// public Void visit(ArgumentExpression argExpression) {
// for (Expression expression : argExpression.getExpressions())
// if (expression != null)
// expression.accept(this);
// return null;
// }
//
// public Void visit(UnaryOperator unaryOperator) {
// return null;
// }
//
//
// public Void visit(TypeSpecifier typeSpecifier) {
// try {
// TypeSpecifier typeSpecifier2 = ((VarDecSymbolTableItem)
// SymbolTable.top.getItem(VarDecSymbolTableItem.START_KEY +
// typeSpecifier.getType())).getVarDec();
// if (typeSpecifier2.isTypeDef()) {
// typeSpecifier.setType(typeSpecifier2.getTypeDefName());
// typeSpecifier.setNotVarDec();
// }
// } catch(ItemNotFoundException e){
//
// }
//
// if (typeSpecifier.isVar_dec()) {
// VarDecSymbolTableItem var_dec_item = new
// VarDecSymbolTableItem(typeSpecifier);
// try {
// SymbolTable.top.put(var_dec_item);
// } catch (ItemAlreadyExistsException e) {
// System.out.println("Redeclaration of variable \"" + typeSpecifier.getType() +
// "\" in line " + typeSpecifier.getLine());
// noError = false;
// }
// }
//
//
// return null;
// }
//
// public Void visit(AssignmentOp assignmentOp) {
// return null;
// }
//
// public Void visit(Pointer pointer) {
// return null;
// }
//
// public Void visit(ParameterList parameterList) {
// for (ParameterDec parameterDec : parameterList.getParameterDecs())
// parameterDec.accept(this);
// return null;
// }
//
//
// public Void visit(Declarator declarator) {
// declarator.getDirectDec().accept(this);
// if (declarator.getPointer() != null)
// declarator.getPointer().accept(this);
// return null;
// }
//
// public Void visit(DirectDec directDec) {
// if (directDec.getDeclarator() != null)
// directDec.getDeclarator().accept(this);
// if (directDec.getDirectDec() != null)
// directDec.getDirectDec().accept(this);
// if (directDec.getIdentifierList() != null)
// directDec.getIdentifierList().accept(this);
// if (directDec.getExpression() != null)
// directDec.getExpression().accept(this);
// if (directDec.getParameterList() != null)
// directDec.getParameterList().accept(this);
// return null;
// }
//
// public Void visit(SpecifierQualifierList specifierQualifierList) {
// if (specifierQualifierList.getTypeSpecifier() != null)
// specifierQualifierList.getTypeSpecifier().accept(this);
// if (specifierQualifierList.getSpecifierQualifierList() != null)
// specifierQualifierList.getSpecifierQualifierList().accept(this);
// return null;
// }
//
// public Void visit(ParameterDec parameterDec) {
// parameterDec.getDeclarationSpecifier().accept(this);
// if (parameterDec.getAbstractDec() != null)
// parameterDec.getAbstractDec().accept(this);
// if (parameterDec.getDeclarator() != null)
// parameterDec.getDeclarator().accept(this);
// return null;
// }
//
// public Void visit(IdentifierList identifierList) {
// return null;
// }
//
// public Void visit(TypeName typeName) {
// typeName.getSpecifierQualifierList().accept(this);
// if (typeName.getAbstractDec() != null)
// typeName.getAbstractDec().accept(this);
// return null;
// }
//
//
// public Void visit(DirectAbsDec directAbsDec) {
// if (directAbsDec.getExpression() != null)
// directAbsDec.getExpression().accept(this);
// if (directAbsDec.getAbstractDec() != null)
// directAbsDec.getAbstractDec().accept(this);
// if (directAbsDec.getParameterList() != null)
// directAbsDec.getParameterList().accept(this);
// if (directAbsDec.getDirectAbsDec() != null)
// directAbsDec.getDirectAbsDec().accept(this);
// return null;
// }
//
// public Void visit(AbstractDec abstractDec) {
// abstractDec.getPointer().accept(this);
// if (abstractDec.getDirectAbsDec() != null)
// abstractDec.getDirectAbsDec().accept(this);
// return null;
// }
//
// public Void visit(Initializer initializer) {
// if (initializer.getExpression() != null)
// initializer.getExpression().accept(this);
// else
// initializer.getInitList().accept(this);
// return null;
// }
//
// public Void visit(InitializerList initializerList) {
// for (Initializer initializer : initializerList.getInitializers())
// initializer.accept(this);
// for (Designation designation : initializerList.getDesignations())
// designation.accept(this);
// return null;
// }
//
// public Void visit(Designation designation) {
// for (Designator designator : designation.getDesignators())
// designator.accept(this);
// return null;
// }
//
// public Void visit(Designator designator) {
// if (designator.getExpression() != null)
// designator.getExpression().accept(this);
// return null;
// }
//
// public Void visit(CompoundStatement compoundStatement) {
// for (BlockItem blockItem : compoundStatement.getBlockItems()){
// blockItem.accept(this);
// }
// return null;
// }
//
// public Void visit(BlockItem blockItem) {
// if (blockItem.getStatement() != null)
// blockItem.getStatement().accept(this);
// else
// blockItem.getDeclaration().accept(this);
// return null;
// }
//
// public Void visit(ExpressionStatement expressionStatement) {
// if (expressionStatement.getExpression() != null)
// expressionStatement.getExpression().accept(this);
// return null;
// }
//
// public Void visit(SelectionStatement selectionStatement) {
// SymbolTable symbolTable = new SymbolTable(SymbolTable.top);
// selectionStatement.setSymbolTable(symbolTable);
// SymbolTable.push(symbolTable);
//
// selectionStatement.getExpression().accept(this);
// selectionStatement.getMainStatement().accept(this);
// if (selectionStatement.getElseStatement() != null)
// selectionStatement.getElseStatement().accept(this);
//
// SymbolTable.pop();
// return null;
// }
//
//
// public Void visit(IterStatement iterStatement) {
// SymbolTable symbolTable = new SymbolTable(SymbolTable.top);
// iterStatement.setSymbolTable(symbolTable);
// SymbolTable.push(symbolTable);
//
// if (iterStatement.getForCondition() != null)
// iterStatement.getForCondition().accept(this);
// if (iterStatement.getExpression() != null)
// iterStatement.getExpression().accept(this);
// if (iterStatement.getStatement() != null)
// iterStatement.getStatement().accept(this);
//
//
// SymbolTable.pop();
// return null;
// }
//
// public Void visit(ForCondition forCondition) {
// if (forCondition.getForDec() != null)
// forCondition.getForDec().accept(this);
// if (forCondition.getExpression() != null)
// forCondition.getExpression().accept(this);
// if (forCondition.getForExpression1() != null)
// forCondition.getForExpression1().accept(this);
// if (forCondition.getForExpression2() != null)
// forCondition.getForExpression2().accept(this);
// return null;
// }
//
// public Void visit(ForExpression forExpression) {
// for (Expression expression : forExpression.getExpressions()) {
// if (expression != null)
// expression.accept(this);
// }
// return null;
// }
//
// public Void visit(JumpStatement jumpStatement) {
// if (jumpStatement.getCondition() != null)
// jumpStatement.getCondition().accept(this);
// return null;
// }
//
// public Void visit(FunctionCall funcCall) {
//
// String funcName = ((Identifier) funcCall.getExpression()).getIdentifier();
// int line = ((Identifier) funcCall.getExpression()).getLine();
// ((Identifier) funcCall.getExpression()).setFunc();
//
// if (funcName.equals("scanf") || funcName.equals("printf")){}
//
// else {
// try {
// SymbolTable.top.getItem(FuncDecSymbolTableItem.START_KEY +
// funcCall.getNumArgs() + funcName );
// } catch (ItemNotFoundException e) {
// System.out.println(FuncDecSymbolTableItem.START_KEY + funcCall.getNumArgs() +
// funcName );
// System.out.println("Line:" + line + "-> " + funcName + " not declared");
// noError = false;
// }
// }
//
// funcCall.getExpression().accept(this);
// if (funcCall.getArgumentExpression() != null) {
// funcCall.getArgumentExpression().accept(this);
// }
//
// return null;
// }
//
// public Void visit(UnaryExpression unaryExpression) {
// unaryExpression.getExpression().accept(this);
// return null;
// }
//
// public Void visit(ExpressionCast expressionCast) {
// expressionCast.getCastExpression().accept(this);
// expressionCast.getTypeName().accept(this);
// return null;
// }
//
// public Void visit(BinaryExpression binaryExpression) {
// binaryExpression.getExpression1().accept(this);
// binaryExpression.getExpression2().accept(this);
// if (binaryExpression.getAssignmentOp() != null)
// binaryExpression.getAssignmentOp().accept(this);
// return null;
// }
//
// public Void visit(CondExpression condExpression) {
// condExpression.getExpression1().accept(this);
// condExpression.getExpression2().accept(this);
// condExpression.getExpression3().accept(this);
// return null;
// }
//
// public Void visit(CommaExpression commaExpression) {
// for (Expression expression : commaExpression.getExpressions())
// if (expression != null)
// expression.accept(this);
// return null;
// }
//
// public Void visit(ArrayIndexing arrayIndexing) {
// arrayIndexing.getExpression1().accept(this);
// arrayIndexing.getExpression2().accept(this);
// return null;
// }
//
// public Void visit(Identifier identifier) {
// if (!identifier.isFunc() && !identifier.getIdentifier().startsWith("\"")){
// try {
// SymbolTable.top.getItem(VarDecSymbolTableItem.START_KEY +
// identifier.getIdentifier());
// } catch (ItemNotFoundException e) {
// System.out.println("Line:" + identifier.getLine() + "-> " +
// identifier.getIdentifier() + " not declared");
// noError = false;
// }
// }
//
// return null;
// }
//
// public Void visit(Constant constant) {
// return null;
// }
//
// public Void visit(TypeInitExpression tiExpression) {
// tiExpression.getInitializerList().accept(this);
// tiExpression.getTypeName().accept(this);
// return null;
// }
//
//
// public Void visit(PrefixExpression prefixExpression) {
// if (prefixExpression.getExpression() != null)
// prefixExpression.getExpression().accept(this);
// if (prefixExpression.getCastExpression() != null)
// prefixExpression.getCastExpression().accept(this);
// if (prefixExpression.getTypeName() != null)
// prefixExpression.getTypeName().accept(this);
// if (prefixExpression.getTypeInitExpression() != null)
// prefixExpression.getTypeInitExpression().accept(this);
// if (prefixExpression.getUnaryOp() != null)
// prefixExpression.getUnaryOp().accept(this);
// return null;
// }
//
//
// }
//
