/**
 * 栗林健太郎
 * 2030006
 * 2020年11月23日
 */

public class PseudoAtomicCounter {
    private static int count = 0;

    public synchronized void inc() {
        count++;
    }

    public synchronized int get() {
        return count;
    }
}
