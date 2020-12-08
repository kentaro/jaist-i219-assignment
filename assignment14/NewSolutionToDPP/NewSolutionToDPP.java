/**
 * 栗林健太郎
 * 2030006
 * 2020年12月8日
 */

public class NewSolutionToDPP {
    public void begin(int n, int m) {
        // changed the argument `n - 1` to `n`
        // to confirm it if causes a deadlock.
        Chopstick left;
        Chopstick right = new Chopstick();
        Chopstick tmp = right;

        int i = 0;
        for (i = 0; i < (n - 1); i++) {
            left = right;
            right = new Chopstick();
            if (i % 2 == 0) {
                (new Philosopher(m, left, right)).start();
            } else {
                (new Philosopher(m, right, left)).start();
            }
        }
        left = right;
        right = tmp;

        if (i % 2 == 0) {
            (new Philosopher(m, left, right)).start();
        } else {
            (new Philosopher(m, right, left)).start();
        }
    }
}
