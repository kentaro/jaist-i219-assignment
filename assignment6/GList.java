/**
 * 栗林健太郎
 * 2030006
 * 2020年10月25日
 */

public interface GList<E> {
    GList<E> cons(E e);
    GList<E> append(GList<E> l);
}
