/**
 * 栗林健太郎
 * 2030006
 * 2020年12月8日
 */

public class Philosopher extends Thread {
    private static int nextId = 0;
    private final int myId;
    private final int howManyDinners;
    private Chopstick left;
    private Chopstick right;

    public Philosopher(int n, Chopstick l, Chopstick r) {
        myId = nextId++;
        howManyDinners = n;
        left = l;
        right = r;
    }

    public void run() {
        for (int i = 0; i < howManyDinners; i++) {
            // thinking
            try {
                left.acquire();
            } catch (InterruptedException e) {}
            try {
                right.acquire();
            } catch (InterruptedException e) {}
            // taking a dinner
            right.release();
            left.release();
        }
    }
}
