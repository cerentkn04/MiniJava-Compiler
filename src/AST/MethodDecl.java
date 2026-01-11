package AST;

import java.util.List;
import AST.Visitor.Visitor;

public class MethodDecl extends ASTNode {
    public final Type returnType;
    public final String name;
    public final List<VarDecl> params;
    public final List<VarDecl> locals;
    public final List<Statement> statements;
    public final Exp returnExp;

    public MethodDecl(
            Type returnType,
            String name,
            List<VarDecl> params,
            List<VarDecl> locals,
            List<Statement> statements,
            Exp returnExp,
            int line) {

        super(line);
        this.returnType = returnType;
        this.name = name;
        this.params = params;
        this.locals = locals;
        this.statements = statements;
        this.returnExp = returnExp;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

