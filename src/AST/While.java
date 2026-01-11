package AST;

import AST.Visitor.Visitor;

public class While extends Statement {
    public final Exp condition;
    public final Statement body;

    public While(Exp condition, Statement body, int line) {
        super(line);
        this.condition = condition;
        this.body = body;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

