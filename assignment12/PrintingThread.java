/**
 * 栗林健太郎
 * 2030006
 * 2020年11月23日
 */

public class PrintingThread extends Thread {
    private int times;

    public PrintingThread(int n) {
        times = n;
    }

    public void run() {
        long myId = this.getId();
        for (int i = 0; i < times; i++) {
            System.out.println(i + ": I am $" + myId + " thread.");
        }
    }

    public static void main(String[] args) {
        Thread t1 = new PrintingThread(50);
        Thread t2 = new PrintingThread(50);
        Thread t3 = new PrintingThread(50);
        t1.start();
        t2.start();
        t3.start();
    }
}
