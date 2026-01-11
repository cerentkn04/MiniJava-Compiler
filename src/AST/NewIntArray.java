package AST;
import AST.Visitor.Visitor;
public class NewIntArray extends Exp {
    public Exp size;
    public NewIntArray(Exp s, int left) { 
        super(left);
        this.size = s; }
            
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

