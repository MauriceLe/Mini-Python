import java.util.List;
import java.util.Iterator;
import java.util.Scanner;
import ast.Node;
import symbol.Callable;

public abstract class NativeFun extends Fun implements Callable{

    public NativeFun(Environment env, Node node) {
        super(env, node);
    }

    public static final NativeFun print = new NativeFun(null, null) {
        @Override
        public Object call(List<Object> args){
            String out = "";
            for(Iterator<Object> i = args.iterator(); i.hasNext();){
                out = out + i.next().toString() + "\n";
            }
            System.out.println(out);
            return null;
        }
    };
    public static final NativeFun input = new NativeFun(null, null) {
        private Scanner sc = new Scanner(System.in);

        @Override
        public Object call(List<Object> args){
            return this.sc.nextLine();
        }
    };

}
