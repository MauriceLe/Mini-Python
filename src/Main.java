import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Main {
    public static void main(String[] args) throws Exception {
        MiniPythonLexer lexer = new MiniPythonLexer(CharStreams.fromStream(System.in));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MiniPythonParser parser = new MiniPythonParser(tokens);
        ParseTree tree = parser.start();

        MiniPythonBaseListener extractor = new MiniPythonBaseListener();
        ParseTreeWalker.DEFAULT.walk(extractor, tree);
    }
}