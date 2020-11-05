import java.util.*;

public class TestAssign {
    public static void main(String[] args)
        throws InterpreterException
    {
        Map<String,Integer> env = new HashMap<String,Integer>();
        ExpParseTree two = new NumParseTree(2);
        VarParseTree x = new VarParseTree("x");
        ExpParseTree e = new MulParseTree(x,x);
        StmParseTree a0 = new AssignParseTree(x,two);
        StmParseTree a = new AssignParseTree(x,e);
        StmParseTree s = new SCompParseTree(a,a);
        s = new SCompParseTree(a,s);
        s = new SCompParseTree(a0,s);
        System.out.println(s.interpret(env));
    }
}