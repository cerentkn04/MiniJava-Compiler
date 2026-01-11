package AST;
import AST.Visitor.Visitor;
public class And extends BinOp {
    public And(Exp left, Exp right, int pos) { super(left, right, pos); }
        @Override
    public void accept(Visitor v) { 
        v.visit(this); 
    }
}

