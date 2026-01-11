package AST;

import AST.Visitor.Visitor;

public class Print extends Statement {
    public final Exp exp;

    public Print(Exp exp, int line) {
        super(line);
        this.exp = exp;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

