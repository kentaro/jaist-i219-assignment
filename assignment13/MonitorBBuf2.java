/**
 * 栗林健太郎
 * 2030006
 * 2020年11月30日
 */

import java.util.*;

public class MonitorBBuf2<E> {
    private Queue<E> queue;
    private int noe = 0;
    private final int capacity;
    private List<E> log;

    public MonitorBBuf2(int cap, List<E> l) {
        queue = new EmpQueue<E>();
        capacity = cap;
        log = l;
    }

    public synchronized void put(E e) throws InterruptedException {
        while (noe >= capacity) {
            this.wait();
        }

        if (noe < capacity) {
            queue = queue.enq(e);
            noe++;
            log.add(e);
            this.notifyAll();
        }
    }

    public synchronized E get() throws InterruptedException {
        while (noe <= 0) {
            this.wait();
        }

        if (noe > 0) {
            E e = queue.top();
            queue = queue.deq();
            noe--;
            this.notifyAll();
            return e;
        }
        return null;
    }
}
