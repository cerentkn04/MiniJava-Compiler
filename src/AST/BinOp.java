package AST;

public abstract class BinOp extends Exp {
    public final Exp left;
    public final Exp right;

    public BinOp(Exp left, Exp right, int line) {
        super(line);
        this.left = left;
        this.right = right;
    }
}

