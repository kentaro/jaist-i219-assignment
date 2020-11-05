import java.util.*;

public class VarParseTree
    implements ExpParseTree
{
    private String name;

    public VarParseTree(String s) {
        name = s;
    }

    public String getName() {
        return name;
    }

    // dummy to implement ExpParseTree
    public int calculate() { return 0; }

    public int interpret(Map<String,Integer> env)
        throws InterpreterException
    {
        try {
            return env.get(name);
        } catch (NullPointerException e) {
            throw new InterpreterException(name);
        }
    }

    public String toString() {
        return name;
    }
}