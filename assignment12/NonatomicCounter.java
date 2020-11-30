/**
 * 栗林健太郎
 * 2030006
 * 2020年11月23日
 */

public class NonatomicCounter {
    private int count = 0;

    public void inc() {
        count++;
    }

    public int get() {
        return count;
    }
}
