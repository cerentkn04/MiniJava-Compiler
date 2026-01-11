package AST;

import java.util.List;
import AST.Visitor.Visitor;
public class ClassDeclSimple extends ClassDecl {
      public ClassDeclSimple(String name, List<VarDecl> vs, List<MethodDecl> ms, int left) {
        super(name, null, vs, ms, left);  // null for parent class
    }
    
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

