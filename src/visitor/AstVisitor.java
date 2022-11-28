package visitor;

import ast.*;
import ast.types.*;

public interface AstVisitor<T> {
    T visit(Assignment node);
    T visit(Arithmetic node);
    T visit(AstTree node);
    T visit(Method node);
    T visit(Compare node);
    T visit(Statement node);
    T visit(Expression node);
    T visit(Negation node);
    T visit(Function node);
    T visit(If node);
    T visit(Identifier node);
    T visit(Return node);
    T visit(DefClass node);
    T visit(DefFunction node);
    T visit(DefMethod node);
    T visit(Int node);
    T visit(Text node);
    T visit(Bool node);
    T visit(Block node);
}
