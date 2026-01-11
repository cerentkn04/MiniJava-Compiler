package AST;

import java.util.List;
import AST.Visitor.Visitor;

public class ClassDeclExtends extends ClassDecl {
    public String name, parent;
    public List<VarDecl> vars;
    public List<MethodDecl> methods;

    public ClassDeclExtends(String n, String p, List<VarDecl> v, List<MethodDecl> m, int pos) {
        super(n, p, v, m, pos);
        name = n;
        parent = p;
        vars = v;
        methods = m;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}

