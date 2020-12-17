/**
 * 栗林健太郎
 * 2030006
 * 2020年12月17日
 */

import java.util.*;

public class IfParseTree
    extends StmParseTree
{
    private ExpParseTree ept;
    private StmParseTree stm1, stm2;

    public IfParseTree(ExpParseTree e, StmParseTree s1, StmParseTree s2) {
        ept  = e;
        stm1 = s1;
        stm2 = s2;
    }

    public Map<String,Integer>
        interpret(Map<String,Integer> env)
        throws InterpreterException
    {
        Map<String,Integer> ret;

        if (ept.interpret(env) != 0) {
            ret = stm1.interpret(env);
        } else {
            ret = stm2.interpret(env);
        }

        return ret;
    }

    public List<Command> compile() {
        List<Command> cl1 = ept.compile();
        List<Command> cl2 = stm1.compile();
        List<Command> cl3 = stm2.compile();

        cl1.add(new Command(CommandName.CJMP, 2));
        cl1.add(new Command(CommandName.JMP, cl2.size() + 2));
        cl1.addAll(cl2);
        cl1.add(new Command(CommandName.JMP, cl3.size() + 1));
        cl1.addAll(cl3);

        return cl1;
    }

    public String toString() {
        return "if (" + ept + ") { " + stm1 + "," + stm2 + " }";
    }
}
