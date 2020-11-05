import java.util.*;

public class AssignParseTree
    implements StmParseTree
{
    private VarParseTree var;
    private ExpParseTree exp;

    public AssignParseTree(VarParseTree v, ExpParseTree e) {
        var = v;
        exp = e;
    }

    public Map<String,Integer>
        interpret(Map<String,Integer> env)
        throws InterpreterException
    {
        int n = exp.interpret(env);
        env.put(var.getName(), n);
        return env;
    }

    public String toString() {
        return "assign(" + var + "," + exp + ")";
    }
}