/**
 * 栗林健太郎
 * 2030006
 * 2020年11月19日
 */

import java.util.*;

public class NumParseTree extends ExpParseTree {
    private int val;

    public NumParseTree(int x) {
        val = x;
    }

    public List<Command> compile() {
        List<Command> cl = new ArrayList<Command>();
        cl.add(new Command(CommandName.PUSH, val));
        return cl;
    }

    public String toString() {
        return "" + val;
    }
}
