package code;

import code.visitor.*;
import code.ast.AstTree;
import code.core.*;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {
    public static void main(String[] args) throws Exception {
        MiniPythonLexer lexer = new MiniPythonLexer(CharStreams.fromFileName("src/test/main.mipy"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MiniPythonParser parser = new MiniPythonParser(tokens);

        ParseTree tree = parser.start();
        AstTreeVisitor visitor = new AstTreeVisitor();
        AstTree ast = (AstTree) visitor.visit(tree);
        ast.accept(new BuilderVisitor());
    }
}