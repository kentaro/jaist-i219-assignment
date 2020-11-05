/**
 * 栗林健太郎
 * 2030006
 * 2020年11月5日
 */

public class GNnList<E> implements GList<E> {
    private E head;
    private GList<E> tail;

    public GNnList(E e, GList<E> l) {
        head = e;
        tail = l;
    }

    public E getHead() {
        return head;
    }

    public GList<E> getTail() {
        return tail;
    }

    public GNnList<E> cons(E e) {
        return new GNnList<E>(e, this);
    }

    public GNnList<E> append(GList<E> l) {
        return (GNnList<E>) tail.append(l).cons(head);
    }
}
