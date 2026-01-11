package AST.Visitor;

import AST.*;
import java.util.List;

public class ASTPrintVisitor implements Visitor {

    private int indentLevel = 0;

    private void indent() {
        for (int i = 0; i < indentLevel; i++) System.out.print("  ");
    }

    private void printLine(ASTNode n) {
        System.out.println(" (line " +( n.line + 1) + ")");
    }

    public void visit(Program n) {
        indent(); System.out.print("Program"); printLine(n);
        indentLevel++;
        n.mainClass.accept(this);
        for (ClassDecl c : n.classDecls) {
            c.accept(this);
        }
        indentLevel--;
    }

    public void visit(MainClass n) {
        indent(); System.out.print("MainClass " + n.className); printLine(n);
        indentLevel++;
        n.body.accept(this);
        indentLevel--;
    }

    public void visit(ClassDecl n) {
        indent(); System.out.print("ClassDecl " + n.name);
        if (n.parent != null) System.out.print(" extends " + n.parent);
        printLine(n);
        
        indentLevel++;
        for (VarDecl v : n.vars) v.accept(this);
        for (MethodDecl m : n.methods) m.accept(this);
        indentLevel--;
    }

    public void visit(VarDecl n) {
        indent(); System.out.print("VarDecl " + n.name + " : ");
        n.type.accept(this);
        printLine(n);
    }

    public void visit(MethodDecl n) {
        indent(); System.out.print("MethodDecl " + n.name); printLine(n);
        indentLevel++;
        indent(); System.out.print("Returns: "); n.returnType.accept(this); System.out.println();
        for (VarDecl p : n.params) p.accept(this);
        for (VarDecl l : n.locals) l.accept(this);
        for (Statement s : n.statements) s.accept(this);
        indent(); System.out.print("ReturnExp: "); n.returnExp.accept(this); System.out.println();
        indentLevel--;
    }

    // Statements
    public void visit(Block n) {
        indent(); System.out.print("Block"); printLine(n);
        indentLevel++;
        for (Statement s : n.stmts) s.accept(this);
        indentLevel--;
    }

    public void visit(Print n) {
        indent(); System.out.print("Print"); printLine(n);
        indentLevel++;
        indent(); n.exp.accept(this); System.out.println();
        indentLevel--;
    }

    public void visit(Assign n) {
        indent(); System.out.print("Assign " + n.name); printLine(n);
        indentLevel++;
        indent(); n.value.accept(this); System.out.println();
        indentLevel--;
    }

    // Expressions (Simplified for readability)
    public void visit(Plus n) {
      System.out.print("Plus");
      printLine(n); // This handles the "(line X)" and the newline
      indentLevel++;
    
      indent(); 
      n.left.accept(this);
      System.out.println(); // Force a newline between the two numbers
    
      indent(); 
      n.right.accept(this);
    
      indentLevel--;
    }
    public void visit(IntegerLiteral n) {
      System.out.print("IntLiteral " + n.value);
    }
    public void visit(IdentifierExp n) { System.out.print("IdExp(" + n.name + ")"); }

    // Types
    public void visit(IntType n) { System.out.print("IntType"); }
    public void visit(BooleanType n) { System.out.print("BooleanType"); }
    public void visit(IntArrayType n) { System.out.print("IntArrayType"); }
    public void visit(IdentifierType n) { System.out.print("IdentifierType(" + n.name + ")"); }

    // Implement remaining stubs to satisfy Visitor interface
    public void visit(If n) {
      indent(); System.out.print("If"); printLine(n);
      indentLevel++;
      indent(); System.out.print("Cond: "); n.condition.accept(this); System.out.println();
      n.thenStmt.accept(this);
      indent(); System.out.println("Else:");
      n.elseStmt.accept(this);
      indentLevel--;
    }
    // --- Binary Expressions ---
    public void visit(Minus n) {
        System.out.print("Minus"); printLine(n);
        indentLevel++;
        indent(); n.left.accept(this); System.out.println();
        indent(); n.right.accept(this);
        indentLevel--;
    }

    public void visit(Times n) {
        System.out.print("Times"); printLine(n);
        indentLevel++;
        indent(); n.left.accept(this); System.out.println();
        indent(); n.right.accept(this);
        indentLevel--;
    }

    public void visit(Lt n) {
        System.out.print("Lt"); printLine(n);
        indentLevel++;
        indent(); n.left.accept(this); System.out.println();
        indent(); n.right.accept(this);
        indentLevel--;
    }

    public void visit(And n) {
        System.out.print("And"); printLine(n);
        indentLevel++;
        indent(); n.left.accept(this); System.out.println();
        indent(); n.right.accept(this);
        indentLevel--;
    }

    // --- Unary and Literals ---
    public void visit(Not n) {
        System.out.print("Not"); printLine(n);
        indentLevel++;
        indent(); n.exp.accept(this);
        indentLevel--;
    }

    public void visit(True n) { System.out.print("TrueLiteral"); }
    public void visit(False n) { System.out.print("FalseLiteral"); }
    public void visit(This n) { System.out.print("This"); }

    // --- Method Calls and Arrays ---
    public void visit(Call n) {
        System.out.print("Call (method: " + n.method + ")"); printLine(n);
        indentLevel++;
        indent(); System.out.print("Receiver: "); n.receiver.accept(this); System.out.println();
        indent(); System.out.println("Args:");
        indentLevel++;
        for (Exp e : n.args) {
            indent(); e.accept(this); System.out.println();
        }
        indentLevel--;
        indentLevel--;
    }

    public void visit(ArrayLookup n) {
        System.out.print("ArrayLookup"); printLine(n);
        indentLevel++;
        indent(); n.array.accept(this); System.out.println();
        indent(); n.index.accept(this);
        indentLevel--;
    }

    public void visit(ArrayLength n) {
        System.out.print("ArrayLength"); printLine(n);
        indentLevel++;
        indent(); n.array.accept(this);
        indentLevel--;
    }

    public void visit(ArrayAssign n) {
        indent(); System.out.print("ArrayAssign " + n.name); printLine(n);
        indentLevel++;
        indent(); System.out.print("Index: "); n.index.accept(this); System.out.println();
        indent(); System.out.print("Value: "); n.value.accept(this);
        indentLevel--;
    }

    // --- Allocation ---
    public void visit(NewIntArray n) {
        System.out.print("NewIntArray"); printLine(n);
        indentLevel++;
        indent(); n.size.accept(this);
        indentLevel--;
    }

    public void visit(NewObject n) {
        System.out.print("NewObject " + n.className); printLine(n);
    }

    // --- Control Flow ---
    public void visit(While n) {
        indent(); System.out.print("While"); printLine(n);
        indentLevel++;
        indent(); System.out.print("Cond: "); n.condition.accept(this); System.out.println();
        n.body.accept(this);
        indentLevel--;
    }
    public void visit(BooleanLiteral n) {}
    public void visit(NewArray n) {}
}
