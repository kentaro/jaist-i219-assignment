/**
 * 栗林健太郎
 * 2030006
 * 2020年11月23日
 */

public class AtomicBBuf<E> {
    private Queue<E> queue;
    private int noe = 0;
    private final int capacity;

    public AtomicBBuf(int cap) {
        queue = new EmpQueue<E>();
        capacity = cap;
    }

    public synchronized void put(E e) {
        if (noe < capacity) {
            queue = queue.enq(e);
            noe++;
        }
    }

    public synchronized E get() {
        if (noe > 0) {
            E e = queue.top();
            queue = queue.deq();
            noe--;
            return e;
        }
        return null;
    }
}
