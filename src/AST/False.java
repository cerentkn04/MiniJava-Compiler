package AST;

import AST.Visitor.Visitor;

public class False extends Exp {
    public False(int line) { super(line); }
    public void accept(Visitor v) { v.visit(this); }
}
