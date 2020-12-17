/**
 * 栗林健太郎
 * 2030006
 * 2020年12月17日
 */

import java.util.*;

public class WhileParseTree
    extends StmParseTree
{
    private ExpParseTree ept;
    private StmParseTree stm;

    public WhileParseTree(ExpParseTree e, StmParseTree s) {
        ept = e;
        stm = s;
    }

    public Map<String,Integer>
        interpret(Map<String,Integer> env)
        throws InterpreterException
    {
        while (ept.interpret(env) != 0) {
            env = stm.interpret(env);
        }

        return env;
    }

    public List<Command> compile() {
        List<Command> cl1 = ept.compile();
        int cl1Size = cl1.size();
        List<Command> cl2 = stm.compile();
        int cl2Size = cl2.size();

        cl1.add(new Command(CommandName.CJMP, 2));
        cl1.add(new Command(CommandName.JMP, cl2Size + 2));
        cl1.addAll(cl2);
        cl1.add(new Command(CommandName.JMP, -(cl1Size + cl2Size + 2)));

        return cl1;
    }

    public String toString() {
        return "while (" + ept + ") { " + stm + " }";
    }
}
