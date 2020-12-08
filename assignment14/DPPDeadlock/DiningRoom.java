/**
 * 栗林健太郎
 * 2030006
 * 2020年12月8日
 */

public class DiningRoom {
    private final int howManyPeopleCanEnter;
    private int cnt;

    public DiningRoom(int howMany) {
        howManyPeopleCanEnter = howMany;
        cnt = 0;
    }

    public synchronized void enter() throws InterruptedException {
        if (howManyPeopleCanEnter > cnt) {
            cnt++;
        } else {
            while (howManyPeopleCanEnter <= cnt) {
                this.wait();
            }
        }
    }

    public synchronized void leave() {
        cnt--;
        this.notifyAll();
    }
}
