package AST;

import java.util.List;
import AST.Visitor.Visitor;

public class ClassDecl extends ASTNode {
    public final String name;
    public final String parent;   // null if no extends
    public final List<VarDecl> vars;
    public final List<MethodDecl> methods;

    public ClassDecl(String name,
                     String parent,
                     List<VarDecl> vars,
                     List<MethodDecl> methods,
                     int line) {
        super(line);
        this.name = name;
        this.parent = parent;
        this.vars = vars;
        this.methods = methods;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

