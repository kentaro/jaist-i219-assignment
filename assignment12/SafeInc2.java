/**
 * 栗林健太郎
 * 2030006
 * 2020年11月23日
 */

public class SafeInc2 extends Thread {
    private NonatomicCounter counter;
    private int times;

    public SafeInc2(NonatomicCounter c, int n) {
        counter = c;
        times = n;
    }

    public void run() {
        for (int i = 0; i < times; i++) {
            synchronized(counter) {
                counter.inc();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        NonatomicCounter c = new NonatomicCounter();
        Thread t1 = new SafeInc2(c, 1000000);
        Thread t2 = new SafeInc2(c, 1000000);
        Thread t3 = new SafeInc2(c, 1000000);
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println("Counter: " + c.get());
    }
}
