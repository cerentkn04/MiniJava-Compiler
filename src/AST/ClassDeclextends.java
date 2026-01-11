package AST;

import java.util.List;

public class ClassDeclExtends extends ClassDecl {
    public ClassDeclExtends(String name, String parent, List<VarDecl> vs, List<MethodDecl> ms, int left) {}
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

