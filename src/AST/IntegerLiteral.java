package AST;

import AST.Visitor.Visitor;

public class IntegerLiteral extends Exp {
    public final int value;

    public IntegerLiteral(int value, int line) {
        super(line);
        this.value = value;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}

