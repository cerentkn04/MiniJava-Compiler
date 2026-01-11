package AST;

import java.util.List;

public class ClassBody {
    public final List<VarDecl> vars;
    public final List<MethodDecl> methods;

    public ClassBody(List<VarDecl> vars, List<MethodDecl> methods) {
        this.vars = vars;
        this.methods = methods;
    }
}

