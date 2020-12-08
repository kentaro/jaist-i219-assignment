/**
 * 栗林健太郎
 * 2030006
 * 2020年12月8日
 */

public class Chopstick {
    private boolean beingUsed;

    public Chopstick() {
        beingUsed = false;
    }

    public synchronized void acquire() throws InterruptedException {
        while (beingUsed) {
            this.wait();
        }
        beingUsed = true;
    }

    public synchronized void release() {
        beingUsed = false;
        this.notifyAll();
    }
}
