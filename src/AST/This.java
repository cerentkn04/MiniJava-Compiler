package AST;

import AST.Visitor.Visitor;

public class This extends Exp {
    public This(int line) {
        super(line);
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}

