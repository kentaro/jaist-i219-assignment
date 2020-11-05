import java.util.*;

public class SCompParseTree
    implements StmParseTree
{
    private StmParseTree stm1, stm2;

    public SCompParseTree(StmParseTree s1, StmParseTree s2) {
        stm1 = s1;
        stm2 = s2;
    }

    public Map<String,Integer>
        interpret(Map<String,Integer> env)
        throws InterpreterException
    {
        Map<String,Integer> env1 = stm1.interpret(env);
        Map<String,Integer> env2 = stm2.interpret(env1);
        return env2;
    }

    public String toString() {
        return "scomp(" + stm1 + "," + stm2 + ")";
    }
}