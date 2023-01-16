package code;

import code.core.*;
import code.visitor.*;
import code.ast.AstTree;
import org.antlr.v4.gui.TreeViewer;
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

        //TreeViewer viewer = new TreeViewer(null, ast);
        //viewer.open();

        ast.accept(new BuilderVisitor());
    }
}