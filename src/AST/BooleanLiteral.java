package AST;
import AST.Visitor.Visitor;
public class BooleanLiteral extends Exp {
    public boolean value;

    public BooleanLiteral(boolean val, int pos) {
        super(pos);
        value = val;
    }

    public void accept(Visitor v) { // ERROR
        v.visit(this);
    }
}

