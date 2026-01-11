package AST;

import java.util.List;
import AST.Visitor.Visitor;

public class Block extends Statement {
    public final List<VarDecl> vars;
    public final List<Statement> stmts;
    int left;

    public Block(List<VarDecl> vars, List<Statement> stmts, int left) {
       super(left);
        this.vars = vars;
        this.stmts = stmts;
        this.left = left;
    }
     @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

