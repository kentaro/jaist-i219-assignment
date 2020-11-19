/**
 * 栗林健太郎
 * 2030006
 * 2020年11月19日
 */

import java.util.*;

public class VirtualMachine {
    private List<Command> comList;
    private int pc;
    private Stack<Integer> stk;

    public VirtualMachine(List<Command> cl) {
        comList = cl;
    }

    public void reset(int pc, Stack<Integer> stk) {
        this .pc = pc;
        this.stk = stk;
    }

    public List<Command> getComList() {
        return comList;
    }

    public int run() throws VMException {
        int x, x1, x2;

        while (true) {
            if (pc < 0 || pc >= comList.size()) {
                throw new VMException(pc, comList.size());
            }
            Command com = comList.get(pc);
            switch (com.getName()) {
                case PUSH:
                    stk.push(com.getNum());
                    pc++;
                    break;
                case MUL:
                    if (stk.size() < 2) {
                        throw new VMException(stk, stk.size());
                    }
                    x2 = stk.top();
                    stk.pop();
                    x1 = stk.top();
                    stk.pop();
                    x = x1 * x2;
                    stk.push(x);
                    pc++;
                    break;
                case QUO:
                    if (stk.size() < 2) {
                        throw new VMException(stk, stk.size());
                    }
                    x2 = stk.top();
                    stk.pop();
                    x1 = stk.top();
                    stk.pop();
                    if (x2 == 0) {
                        throw new VMException("Division by zero");
                    }
                    x = x1 / x2;
                    stk.push(x);
                    pc++;
                    break;
                case ADD:
                    if (stk.size() < 2) {
                        throw new VMException(stk, stk.size());
                    }
                    x2 = stk.top();
                    stk.pop();
                    x1 = stk.top();
                    stk.pop();
                    x = x1 + x2;
                    stk.push(x);
                    pc++;
                    break;
                case SUB:
                    if (stk.size() < 2) {
                        throw new VMException(stk, stk.size());
                    }
                    x2 = stk.top();
                    stk.pop();
                    x1 = stk.top();
                    stk.pop();
                    x = x1 - x2;
                    stk.push(x);
                    pc++;
                    break;
                case QUIT:
                    if (stk.size() != 1) {
                        throw new VMException(stk, stk.size());
                    }
                    x = stk.top();
                    stk.pop();
                    return x;
                default:
                    throw new IllegalStateException("pc1: " + pc + ", cl1: " + comList);
            }
        }
    }
}
