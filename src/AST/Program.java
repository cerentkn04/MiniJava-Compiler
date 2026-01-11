package AST;

import java.util.List;
import AST.Visitor.Visitor;

public class Program extends ASTNode {
    public final MainClass mainClass;
    public final List<ClassDecl> classDecls;

    public Program(MainClass mainClass, List<ClassDecl> classDecls, int line) {
        super(line);
        this.mainClass = mainClass;
        this.classDecls = classDecls;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

