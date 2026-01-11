package AST;

import AST.Visitor.Visitor;

public abstract class Type extends ASTNode {

    public Type(int line) {
        super(line);
    }

    @Override
    public abstract void accept(Visitor v);
}

