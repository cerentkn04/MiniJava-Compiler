package AST;

import AST.Visitor.Visitor;

public class IntType extends Type {

    public IntType(int line) {
        super(line);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

