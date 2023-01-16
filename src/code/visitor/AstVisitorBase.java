package code.visitor;

import code.ast.Arithmetic;
import code.ast.Assignment;
import code.ast.AstTree;
import code.ast.Block;
import code.ast.Callable;
import code.ast.Class;
import code.ast.Compare;
import code.ast.Expression;
import code.ast.Function;
import code.ast.Identifier;
import code.ast.If;
import code.ast.ImportModule;
import code.ast.Negation;
import code.ast.Return;
import code.ast.Statement;
import code.ast.While;
import code.ast.types.Bool;
import code.ast.types.Int;
import code.ast.types.Text;

public class AstVisitorBase<T> implements AstVisitor<T>{

    @Override
    public T visit(Assignment node) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T visit(Arithmetic node) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T visit(AstTree node) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T visit(Compare node) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T visit(Statement node) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T visit(Expression node) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T visit(Negation node) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T visit(Callable node) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T visit(If node) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T visit(Identifier node) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T visit(Return node) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T visit(Class node) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T visit(Function node) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T visit(Int node) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T visit(Text node) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T visit(Bool node) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T visit(Block node) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T visit(While node) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T visit(ImportModule node) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
