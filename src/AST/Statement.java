package AST;

import AST.Visitor.Visitor;

public abstract class Statement extends ASTNode {

    public Statement(int line) {
        super(line);
    }

    @Override
    public abstract void accept(Visitor v);
}

