/**
 * 栗林健太郎
 * 2030006
 * 2020年11月23日
 */

public interface Queue<E> {
    Queue<E> enq(E e);
    Queue<E> deq();
    E top();
}
