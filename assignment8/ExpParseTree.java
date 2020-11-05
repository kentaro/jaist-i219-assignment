import java.util.*;

public interface ExpParseTree {
    int calculate()
        throws CalculatorException;
    int interpret(Map<String,Integer> env)
        throws InterpreterException;
}