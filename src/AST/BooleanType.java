package AST;

import AST.Visitor.Visitor;

public class BooleanType extends Type {

    public BooleanType(int line) {
        super(line);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

