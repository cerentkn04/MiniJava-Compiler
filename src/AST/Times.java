package AST;

import AST.Visitor.Visitor;

public class Times extends Exp {
    public Exp left, right;

    public Times(Exp l, Exp r, int pos) {
        super(pos);
        left = l;
        right = r;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}

