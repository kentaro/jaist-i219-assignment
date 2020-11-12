/**
 * 栗林健太郎
 * 2030006
 * 2020年11月12日
 */

public enum Item {
    MILK(40),
    JUICE(80),
    COFFEE(120);

    private final int cost;

    private Item(int c) {
        cost = c;
    }

    public Integer getCost() {
        return cost;
    }
}
