import ast.Assignment;
import ast.*;

public interface AstVisitor<T> {
    T visit(Assignment node);
    T visit(Arithmetic node);
    T visit(Method node);
    T visit(Compare node);
    T visit(Statement node);
    T visit(Expression node);
    T visit(Negation node);
    T visit(Function node);
    T visit(If node);
    T visit(Identifier node);
    T visit(Return node);
}
