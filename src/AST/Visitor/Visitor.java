package AST.Visitor;

import AST.*;

public interface Visitor {

    // Program structure
    void visit(Program n);
    void visit(MainClass n);
    void visit(ClassDecl n);
    void visit(MethodDecl n);
    void visit(VarDecl n);

    // Types
    void visit(IntType n);
    void visit(BooleanType n);
    void visit(IntArrayType n);
    void visit(IdentifierType n);

    void visit(BooleanLiteral n);

    // Statements
    void visit(Block n);
    void visit(If n);
    void visit(While n);
    void visit(Print n);
    void visit(Assign n);
    void visit(ArrayAssign n);

    // Expressions
    void visit(Plus n);
    void visit(Minus n);
    void visit(Times n);
    void visit(Lt n);
    void visit(And n);
    void visit(Not n);
    void visit(IntegerLiteral n);
    void visit(True n);
    void visit(False n);
    void visit(IdentifierExp n);
    void visit(This n);
    void visit(NewArray n);
    void visit(NewIntArray n);
    void visit(NewObject n);
    void visit(ArrayLength n);
    void visit(Call n);
    void visit(ArrayLookup n);
}

