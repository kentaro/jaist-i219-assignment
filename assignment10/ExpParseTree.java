/**
 * 栗林健太郎
 * 2030006
 * 2020年11月19日
 */

import java.util.*;

public abstract class ExpParseTree {
    private String sourceCode;

    public abstract List<Command> compile();
    public abstract String toString();

    public List<Command> genCode() {
        List<Command> cl;
        cl = this.compile();
        cl.add(new Command(CommandName.QUIT));
        return cl;
    }
}
