/**
 * 栗林健太郎
 * 2030006
 * 2020年12月18日
 */

import java.util.*;

public class VirtualMachine {
    private List<Command> comList;
    private int pc;
    private Stack<Integer> stk;
    private Map<String, Integer> env;

    public VirtualMachine(List<Command> cl) {
        comList = cl;
    }

    public VirtualMachine(List<Command> cl, int pc, Stack<Integer> stk, Map<String, Integer> env) {
        comList = cl;
        this .pc = pc;
        this.stk = stk;
        this.env = env;
    }

    public void reset(int pc, Stack<Integer> stk, Map<String, Integer> env) {
        this .pc = pc;
        this.stk = stk;
        this.env = env;
    }

    public List<Command> getComList() {
        return comList;
    }

    public Map<String, Integer> run() throws VMException {
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
                case LOAD:
                    if (!env.containsKey(com.getVar())) {
                        throw new VMException(com.getVar());
                    }
                    stk.push(env.get(com.getVar()));
                    pc++;
                    break;
                case STORE:
                    x = stk.top();
                    stk.pop();
                    env.put(com.getVar(), x);
                    pc++;
                    break;
                case MONE:
                    x = stk.top();
                    stk.pop();
                    stk.push(-x);
                    pc++;
                    break;
                case MUL:
                    if (stk.size() < 2) {
                        throw new VMException(stk);
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
                        throw new VMException(stk);
                    }
                    x2 = stk.top();
                    stk.pop();
                    x1 = stk.top();
                    stk.pop();
                    if (x2 == 0) {
                        throw new VMException();
                    }
                    x = x1 / x2;
                    stk.push(x);
                    pc++;
                    break;
                case REM:
                    if (stk.size() < 2) {
                        throw new VMException(stk);
                    }
                    x2 = stk.top();
                    stk.pop();
                    x1 = stk.top();
                    stk.pop();
                    x = x1 % x2;
                    stk.push(x);
                    pc++;
                    break;
                case ADD:
                    if (stk.size() < 2) {
                        throw new VMException(stk);
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
                        throw new VMException(stk);
                    }
                    x2 = stk.top();
                    stk.pop();
                    x1 = stk.top();
                    stk.pop();
                    x = x1 - x2;
                    stk.push(x);
                    pc++;
                    break;
                case LT:
                    if (stk.size() < 2) {
                        throw new VMException(stk);
                    }
                    x2 = stk.top();
                    stk.pop();
                    x1 = stk.top();
                    stk.pop();
                    x = x1 < x2 ? 1 : 0;
                    stk.push(x);
                    pc++;
                    break;
                case GT:
                    if (stk.size() < 2) {
                        throw new VMException(stk);
                    }
                    x2 = stk.top();
                    stk.pop();
                    x1 = stk.top();
                    stk.pop();
                    x = x1 > x2 ? 1 : 0;
                    stk.push(x);
                    pc++;
                    break;
                case EQ:
                    if (stk.size() < 2) {
                        throw new VMException(stk);
                    }
                    x2 = stk.top();
                    stk.pop();
                    x1 = stk.top();
                    stk.pop();
                    x = x1 == x2 ? 1 : 0;
                    stk.push(x);
                    pc++;
                    break;
                case NEQ:
                    if (stk.size() < 2) {
                        throw new VMException(stk);
                    }
                    x2 = stk.top();
                    stk.pop();
                    x1 = stk.top();
                    stk.pop();
                    x = x1 != x2 ? 1 : 0;
                    stk.push(x);
                    pc++;
                    break;
                case AND:
                    if (stk.size() < 2) {
                        throw new VMException(stk);
                    }
                    x2 = stk.top();
                    stk.pop();
                    x1 = stk.top();
                    stk.pop();
                    x = (x1 != 0 && x2 != 0) ? 1 : 0;
                    stk.push(x);
                    pc++;
                    break;
                case OR:
                    if (stk.size() < 2) {
                        throw new VMException(stk);
                    }
                    x2 = stk.top();
                    stk.pop();
                    x1 = stk.top();
                    stk.pop();
                    x = (x1 != 0 || x2 != 0) ? 1 : 0;
                    stk.push(x);
                    pc++;
                    break;
                case JMP:
                    pc += com.getNum();
                    break;
                case CJMP:
                    if (stk.size() < 1) {
                        throw new VMException(stk);
                    }
                    x = stk.top();
                    stk.pop();
                    if (x != 0) {
                        pc += com.getNum();
                    } else {
                        pc++;
                    }
                    break;
                case QUIT:
                    if (stk.size() != 0) {
                        throw new VMException(stk, stk.size());
                    }
                    return env;
                default:
                    throw new IllegalStateException("pc1: " + pc + ", cl1: " + comList);
            }
        }
    }

    public String toString() {
        return "pc: " + pc + ", stack: " + stk + ", env: " + env + ", cl: " + comList;
    }
}
