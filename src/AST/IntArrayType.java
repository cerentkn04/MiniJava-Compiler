package AST;

import AST.Visitor.Visitor;

public class IntArrayType extends Type {

    public IntArrayType(int line) {
        super(line);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

