package AST;

import AST.Visitor.Visitor;

public abstract class Exp extends ASTNode {

    public Exp(int left) {
        super(left);
    }

    @Override
    public abstract void accept(Visitor v);
}

