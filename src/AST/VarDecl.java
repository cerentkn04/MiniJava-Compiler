package AST;

import AST.Visitor.Visitor;

public class VarDecl extends ASTNode {
    public final Type type;
    public final String name;

    public VarDecl(Type type, String name, int line) {
        super(line);
        this.type = type;
        this.name = name;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

