public interface GList<E> {
    GList<E> cons(E e);
    GList<E> append(GList<E> l);
}
