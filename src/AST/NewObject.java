package AST;

import AST.Visitor.Visitor;

public class NewObject extends Exp {
    public final String className;

    public NewObject(String className, int line) {
        super(line);
        this.className = className;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}

