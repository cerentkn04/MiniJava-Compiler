package AST;

import AST.Visitor.Visitor;

public class Assign extends Statement {
    public final String name;
    public final Exp value;

    public Assign(String name, Exp value, int line) {
        super(line);
        this.name = name;
        this.value = value;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

