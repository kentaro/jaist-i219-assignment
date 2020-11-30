/**
 * 栗林健太郎
 * 2030006
 * 2020年11月23日
 */

public class NeQueue<E> implements Queue<E> {
    private E head;
    private Queue<E> tail;

    public NeQueue(E e, Queue<E> q) {
        head = e;
        tail = q;
    }

    public NeQueue<E> enq(E e) {
        return new NeQueue<E>(head, tail.enq(e));
    }

    public Queue<E> deq() {
        return tail;
    }

    public E top() {
        return head;
    }
}
