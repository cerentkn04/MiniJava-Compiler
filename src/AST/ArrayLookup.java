package AST;

import AST.Visitor.Visitor;

public class ArrayLookup extends Exp {
    public final Exp array;
    public final Exp index;

    public ArrayLookup(Exp array, Exp index, int line) {
        super(line);
        this.array = array;
        this.index = index;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}

