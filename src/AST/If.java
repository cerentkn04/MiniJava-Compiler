package AST;

import AST.Visitor.Visitor;

public class If extends Statement {
    public final Exp condition;
    public final Statement thenStmt;
    public final Statement elseStmt;

    public If(Exp condition, Statement thenStmt, Statement elseStmt, int line) {
        super(line);
        this.condition = condition;
        this.thenStmt = thenStmt;
        this.elseStmt = elseStmt;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

