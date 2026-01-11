package AST;

import AST.Visitor.Visitor;

public class IdentifierType extends Type {
    public final String name;

    public IdentifierType(String name, int line) {
        super(line);
        this.name = name;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

