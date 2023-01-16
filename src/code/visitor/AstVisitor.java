package code.visitor;

import code.ast.*;
import code.ast.Class;
import code.ast.types.*;

public interface AstVisitor<T> {
    T visit(Assignment node);
    T visit(Arithmetic node);
    T visit(AstTree node);
    T visit(Compare node);
    T visit(Statement node);
    T visit(Expression node);
    T visit(Negation node);
    T visit(Callable node);
    T visit(If node);
    T visit(Identifier node);
    T visit(Return node);
    T visit(Class node);
    T visit(Function node);
    T visit(Int node);
    T visit(Text node);
    T visit(Bool node);
    T visit(Block node);
    T visit(While node);
    T visit(ImportModule node);
    T visit(Try node);
}
