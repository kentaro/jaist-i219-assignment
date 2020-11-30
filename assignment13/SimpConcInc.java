/**
 * 栗林健太郎
 * 2030006
 * 2020年11月30日
 */

public class SimpConcInc extends Thread {
    private static int count = 0;

    public void run() {
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new SimpConcInc();
        t.start();
        count++;
        t.join();
        System.out.println("count: " + count);
        assert count == 2;
    }
}
