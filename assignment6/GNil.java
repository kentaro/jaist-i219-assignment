/**
 * 栗林健太郎
 * 2030006
 * 2020年10月25日
 */

public class GNil<E> implements GList<E> {
    public GList<E> cons(E e) {
        return new GNnList<E>(e, this);
    }

    public GList<E> append(GList<E> l) {
        return l;
    }
}
