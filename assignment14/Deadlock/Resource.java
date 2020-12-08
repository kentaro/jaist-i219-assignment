/**
 * 栗林健太郎
 * 2030006
 * 2020年12月8日
 */

public class Resource {
    private String name;
    private int count = 0;

    public Resource(String n) {
        name = n;
    }

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }
}
