package AST;

import AST.Visitor.Visitor;

public class IdentifierExp extends Exp {
    public final String name;

    public IdentifierExp(String name, int line) {
        super(line);
        this.name = name;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}

