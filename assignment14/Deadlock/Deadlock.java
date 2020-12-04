/**
 * 栗林健太郎
 * 2030006
 * 2020年11月23日
 */

public class Deadlock extends Thread {
    private String name;
    private Resource resource1;
    private Resource resource2;

    public Deadlock(String n, Resource r1, Resource r2) {
        name = n;
        resource1 = r1;
        resource2 = r2;
    }

    public void run() {
        synchronized(resource1) {
            System.out.println(name + " acquired the lock of " + resource1.getName());
            synchronized(resource2) {
                System.out.println(name + " acquired the lock of " + resource1.getName());
                resource1.increment();
                resource2.increment();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Resource resource1 = new Resource("Resource1");
        Resource resource2 = new Resource("Resource2");
        Resource resource3 = new Resource("Resource3");

        // If uncommented, these lines cause a deadlock.
        // Thread thread1 = new Deadlock("Thread1", resource1, resource2);
        // Thread thread2 = new Deadlock("Thread2", resource2, resource3);
        // Thread thread3 = new Deadlock("Thread3", resource3, resource1);

        Thread thread1 = new Deadlock("Thread1", resource1, resource2);
        Thread thread2 = new Deadlock("Thread2", resource2, resource3);
        Thread thread3 = new Deadlock("Thread3", resource1, resource3);

        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("Resource1: " + resource1.getCount() + ", Resource2: " + resource2.getCount() + ", Resource3: " + resource3.getCount());

        assert (resource1.getCount() + resource2.getCount() + resource3.getCount()) == 6;
    }
}
