package AST;

import AST.Visitor.Visitor;

public class ArrayAssign extends Statement {
    public final String name;
    public final Exp index;
    public final Exp value;

    public ArrayAssign(String name, Exp index, Exp value, int line) {
        super(line);
        this.name = name;
        this.index = index;
        this.value = value;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

