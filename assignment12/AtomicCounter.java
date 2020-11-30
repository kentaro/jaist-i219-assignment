/**
 * 栗林健太郎
 * 2030006
 * 2020年11月23日
 */

public class AtomicCounter {
    private int count = 0;

    public synchronized void inc() {
        count++;
    }

    public synchronized int get() {
        return count;
    }
}
