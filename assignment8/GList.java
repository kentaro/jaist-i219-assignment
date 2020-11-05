/**
 * 栗林健太郎
 * 2030006
 * 2020年11月5日
 */

public interface GList<E> {
    GList<E> cons(E e);
    GList<E> append(GList<E> l);
}
