/**
 * 栗林健太郎
 * 2030006
 * 2020年11月23日
 */

public class EmpQueue<E> implements Queue<E> {
    public Queue<E> enq(E e) {
        return new NeQueue<E>(e, this);
    }

    public Queue<E> deq() {
        return this;
    }

    public E top() {
        return null;
    }
}
