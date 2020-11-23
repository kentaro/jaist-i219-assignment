/**
 * 栗林健太郎
 * 2030006
 * 2020年11月23日
 */

import java.util.*;

public class UmiParseTree
    implements ExpParseTree
{
    private ExpParseTree ept;

    public UmiParseTree(ExpParseTree e) {
        ept = e;
    }

    public int interpret(Map<String,Integer> env)
        throws InterpreterException
    {
        int n = ept.interpret(env);
        return -n;
    }

    public List<Command> compile() {
        List<Command> cl;
        cl = ept.compile();
        cl.add(new Command(CommandName.MONE));
        return cl;
    }

    public String toString() {
        return "umi(" + ept + ")";
    }
}
