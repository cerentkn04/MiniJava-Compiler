package AST;

import AST.Visitor.Visitor;

public class Not extends Exp {
    public final Exp exp;

    public Not(Exp exp, int line) {
        super(line);
        this.exp = exp;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}

