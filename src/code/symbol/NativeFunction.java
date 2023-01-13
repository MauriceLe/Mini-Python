package code.symbol;

import java.util.List;
import java.util.Iterator;
import java.util.Scanner;

public abstract class NativeFunction extends Function{

    public static final NativeFunction print = new NativeFunction() {
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
    public static final NativeFunction input = new NativeFunction() {
        private Scanner sc = new Scanner(System.in);

        @Override
        public Object call(List<Object> args){
            return this.sc.nextLine();
        }
    };
}
