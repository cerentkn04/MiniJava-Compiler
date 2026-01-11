package AST;
import AST.Visitor.Visitor;
public class Lt extends BinOp {
    public Lt(Exp left, Exp right, int pos) { super(left, right, pos); }
    @Override
    public void accept(Visitor v) { 
        v.visit(this); 
    }
}

