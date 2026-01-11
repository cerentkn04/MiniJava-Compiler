package AST;

import java.util.List;
import AST.Visitor.Visitor;

public class Call extends Exp {
    public final Exp receiver;
    public final String method;
    public final List<Exp> args;

    public Call(Exp receiver, String method, List<Exp> args, int line) {
        super(line);
        this.receiver = receiver;
        this.method = method;
        this.args = args;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}

