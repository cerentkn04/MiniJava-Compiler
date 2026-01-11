package AST;

import AST.Visitor.Visitor;

public class ArrayLength extends Exp {
    public Exp array;
    public ArrayLength(Exp array, int left) {
        super(left);   // call Exp constructor
        this.array = array;
    }
    public void accept(Visitor v) { v.visit(this); }
}

