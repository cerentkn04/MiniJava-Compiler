package AST;

import AST.Visitor.Visitor;

public class NewArray extends Exp {
    public final Exp size;

    public NewArray(Exp size, int line) {
        super(line);
        this.size = size;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}

