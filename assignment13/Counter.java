/**
 * 栗林健太郎
 * 2030006
 * 2020年11月30日
 */

public class Counter {
    private int x = 0;

    public synchronized int get() {
        return x;
    }

    public synchronized void inc() {
        x++;
    }
}
