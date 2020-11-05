import java.util.*;

public interface StmParseTree {
    public Map<String,Integer>
        interpret(Map<String,Integer> env)
        throws InterpreterException;
}
