/**
 * 栗林健太郎
 * 2030006
 * 2020年11月19日
 */

import java.util.*;

public class AddParseTree extends ExpParseTree {
    private ExpParseTree ept1, ept2;

    public AddParseTree(ExpParseTree e1, ExpParseTree e2) {
        ept1 = e1;
        ept2 = e2;
    }

    public List<Command> compile() {
        List<Command> cl = new ArrayList<Command>();
        cl = ept1.compile();
        cl.addAll(ept2.compile());
        cl.add(new Command(CommandName.ADD));
        return cl;
    }

    public String toString() {
        return "ADD(" + ept1 + ", " + ept2 + ")";
    }
}
