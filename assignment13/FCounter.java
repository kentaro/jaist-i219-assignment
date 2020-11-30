/**
 * 栗林健太郎
 * 2030006
 * 2020年11月30日
 */

public class FCounter {
    private static int x = 0;

    public static int get() {
        return x;
    }

    public synchronized void inc() {
        x++;
    }
}
