/**
 * 栗林健太郎
 * 2030006
 * 2020年11月23日
 */

public class UnsafeInc extends Thread {
    private NonatomicCounter counter;
    private int times;

    public UnsafeInc(NonatomicCounter c, int n) {
        counter = c;
        times = n;
    }

    public void run() {
        for (int i = 0; i < times; i++) {
            counter.inc();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        NonatomicCounter c = new NonatomicCounter();
        Thread t1 = new UnsafeInc(c, 1000000);
        Thread t2 = new UnsafeInc(c, 1000000);
        Thread t3 = new UnsafeInc(c, 1000000);
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println("Counter: " + c.get());
    }
 }
