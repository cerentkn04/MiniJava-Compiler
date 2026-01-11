package AST;
import AST.Visitor.Visitor;
public class Minus extends BinOp {
      public Minus(Exp left, Exp right, int pos) {
        super(left, right, pos);  // ← BinOp constructor expects left, right, position
    }
        
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

