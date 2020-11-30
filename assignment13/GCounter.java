/**
 * 栗林健太郎
 * 2030006
 * 2020年11月30日
 */

public class GCounter {
    private static int x = 0;
    private static Object lock = new Object();

    public static int get() {
        return x;
    }

    public void inc() {
        synchronized(lock) {
            x++;
        }
    }
}
