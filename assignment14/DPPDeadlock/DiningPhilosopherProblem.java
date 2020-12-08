/**
 * 栗林健太郎
 * 2030006
 * 2020年12月8日
 */

public class DiningPhilosopherProblem {
    public void begin(int n, int m) {
        // changed the argument `n - 1` to `n`
        // to confirm it if causes a deadlock.
        DiningRoom dr = new DiningRoom(n);
        Chopstick left;
        Chopstick right = new Chopstick();
        Chopstick tmp = right;

        for (int i = 0; i < (n - 1); i++) {
            left = right;
            right = new Chopstick();
            (new Philosopher(m, left, right, dr)).start();
        }
        left = right;
        right = tmp;
        (new Philosopher(m, left, right, dr)).start();
    }
}
