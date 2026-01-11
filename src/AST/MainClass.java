package AST;

import AST.Visitor.Visitor;

public class MainClass extends ASTNode {
    public final String className;
    public final String argName;
    public final Statement body;

    public MainClass(String className, String argName, Statement body, int line) {
        super(line);
        this.className = className;
        this.argName = argName;
        this.body = body;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

