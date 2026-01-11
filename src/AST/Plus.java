package AST;

import AST.Visitor.Visitor;

public class Plus extends BinOp {
    public Plus(Exp l, Exp r, int line) {
        super(l, r, line);
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}

