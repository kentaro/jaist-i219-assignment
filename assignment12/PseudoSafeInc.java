/**
 * 栗林健太郎
 * 2030006
 * 2020年11月23日
 */

public class PseudoSafeInc extends Thread {
    private PseudoAtomicCounter counter;
    private int times;

    public PseudoSafeInc(PseudoAtomicCounter c, int n) {
        counter = c;
        times = n;
    }

    public void run() {
        for (int i = 0; i < times; i++) {
            counter.inc();
        }
    }

    public static void main(String[] args) throws InterruptedException{
        PseudoAtomicCounter c1 = new PseudoAtomicCounter();
        PseudoAtomicCounter c2 = new PseudoAtomicCounter();
        PseudoAtomicCounter c3 = new PseudoAtomicCounter();
        Thread t1 = new PseudoSafeInc(c1, 1000000);
        Thread t2 = new PseudoSafeInc(c2, 1000000);
        Thread t3 = new PseudoSafeInc(c3, 1000000);
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println("Counter: " + c1.get());
    }
}
