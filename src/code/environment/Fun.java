package code.environment;
import code.ast.Node;

public class Fun {
    
    private Environment closure;
    private Node node;

    public Fun(Environment env, Node node) {
        this.closure = env;
        this.node = node;
    }

    public Environment getClosure() {
        return this.closure;
    }

    public Node getNode() {
        return this.node;
    }

}
