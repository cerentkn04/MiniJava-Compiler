package AST.Visitor;

import AST.*;
import java.util.List;

public class PrettyPrintVisitor implements Visitor {

    private int indentLevel = 0;

    private void indent() {
        for (int i = 0; i < indentLevel; i++) System.out.print("  ");
    }

    public void visit(Program n) {
        n.mainClass.accept(this);
        for (ClassDecl c : n.classDecls) {
            System.out.println();
            c.accept(this);
        }
    }

    public void visit(MainClass n) {
        System.out.print("class " + n.className + " {");
        System.out.println("\n  public static void main (String [] " + n.argName + ") {");
        indentLevel = 2;
        indent();
        n.body.accept(this); // Changed to body
        System.out.println("  }\n}");
    }

    public void visit(ClassDecl n) {
        System.out.print("class " + n.name);
        if (n.parent != null) System.out.print(" extends " + n.parent);
        System.out.println(" {");
        indentLevel++;
        for (VarDecl v : n.vars) { indent(); v.accept(this); }
        for (MethodDecl m : n.methods) m.accept(this);
        indentLevel--;
        System.out.println("}");
    }

    public void visit(VarDecl n) {
        n.type.accept(this);
        System.out.println(" " + n.name + ";");
    }

    public void visit(MethodDecl n) {
        indent();
        System.out.print("public ");
        n.returnType.accept(this); // Changed to returnType
        System.out.print(" " + n.name + "(");
        for (int i = 0; i < n.params.size(); i++) {
            n.params.get(i).type.accept(this);
            System.out.print(" " + n.params.get(i).name);
            if (i < n.params.size() - 1) System.out.print(", ");
        }
        System.out.println(") {");
        indentLevel++;
        for (VarDecl v : n.locals) { indent(); v.accept(this); }
        for (Statement s : n.statements) { indent(); s.accept(this); }
        indent(); System.out.print("return ");
        n.returnExp.accept(this); // Changed to returnExp
        System.out.println(";");
        indentLevel--;
        indent(); System.out.println("}");
    }

    // Binary Ops (Usually use 'left' and 'right' from BinOp base class)
    public void visit(Plus n) { System.out.print("("); n.left.accept(this); System.out.print(" + "); n.right.accept(this); System.out.print(")"); }
    public void visit(Minus n) { System.out.print("(");
                                n.left.accept(this);
                                System.out.print(" - ");
                                n.right.accept(this);
                                System.out.print(")");}
    public void visit(Times n) { System.out.print("(");
                                 n.left.accept(this);
                                 System.out.print(" * ");
                                 n.right.accept(this);
                                 System.out.print(")");}
    public void visit(Lt n) { System.out.print("("); n.left.accept(this); System.out.print(" < "); n.right.accept(this); System.out.print(")"); }
    public void visit(And n) { System.out.print("("); n.left.accept(this); System.out.print(" && "); n.right.accept(this); System.out.print(")"); }

    public void visit(If n) {
        System.out.print("if (");
        n.condition.accept(this); // Changed to condition
        System.out.println(")");
        indentLevel++; indent(); n.thenStmt.accept(this); indentLevel--; // Changed to thenStmt
        indent(); System.out.println("else");
        indentLevel++; indent(); n.elseStmt.accept(this); indentLevel--; // Changed to elseStmt
    }

    public void visit(While n) {
        System.out.print("while (");
        n.condition.accept(this); // Likely condition based on If.java
        System.out.print(") ");
        n.body.accept(this); // Check While.java for 'body' vs 's'
    }

    public void visit(Assign n) {
        System.out.print(n.name + " = ");
        n.value.accept(this); // Changed to value
        System.out.println(";");
    }

    public void visit(Call n) {
        n.receiver.accept(this); // Changed to receiver
        System.out.print("." + n.method + "("); // Changed to method
        for (int i = 0; i < n.args.size(); i++) {
            n.args.get(i).accept(this);
            if (i < n.args.size() - 1) System.out.print(", ");
        }
        System.out.print(")");
    }

    // Boilerplate for remaining methods
    public void visit(IntType n) { System.out.print("int"); }
    public void visit(BooleanType n) { System.out.print("boolean"); }
    public void visit(IntArrayType n) { System.out.print("int[]"); }
    public void visit(IdentifierType n) { System.out.print(n.name); }
    public void visit(Print n) { System.out.print("System.out.println("); n.exp.accept(this); System.out.println(");"); }
    public void visit(ArrayAssign n) { System.out.print(n.name + "["); n.index.accept(this); System.out.print("] = "); n.value.accept(this); System.out.println(";"); }
    public void visit(IntegerLiteral n) { System.out.print(n.value); }
    public void visit(True n) { System.out.print("true"); }
    public void visit(False n) { System.out.print("false"); }
    public void visit(BooleanLiteral n) { System.out.print(n.value); }
    public void visit(IdentifierExp n) { System.out.print(n.name); }
    public void visit(This n) { System.out.print("this"); }
    public void visit(ArrayLength n) { n.array.accept(this); System.out.print(".length"); }
    public void visit(ArrayLookup n) { n.array.accept(this); System.out.print("["); n.index.accept(this); System.out.print("]"); }
    public void visit(NewArray n) {} 
      // 1. Block
public void visit(Block n) {
    System.out.println("{");
    indentLevel++;
    for (Statement s : n.stmts) { // Changed to stmts
        indent();
        s.accept(this);
    }
    indentLevel--;
    indent(); System.out.print("}");
}

// 2. Not
public void visit(Not n) { 
    System.out.print("!"); 
    n.exp.accept(this); // Changed to exp
}

// 3. NewIntArray
public void visit(NewIntArray n) { 
    System.out.print("new int["); 
    n.size.accept(this); // Changed to size
    System.out.print("]"); 
}

// 4. NewObject
public void visit(NewObject n) { 
    System.out.print("new " + n.className + "()"); // Changed to className
}
}
