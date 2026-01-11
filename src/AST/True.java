package AST;

import AST.Visitor.Visitor;


public class True extends Exp {
    public True(int line) { super(line); }
    public void accept(Visitor v) { v.visit(this); }
}

