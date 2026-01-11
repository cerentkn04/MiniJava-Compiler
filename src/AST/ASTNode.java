package AST;

import AST.Visitor.Visitor;

public abstract class ASTNode {
    public final int line;

    public ASTNode(int line) {
        this.line = line;
    }

    public abstract void accept(Visitor v);
}

