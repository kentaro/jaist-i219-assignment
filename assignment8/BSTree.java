/**
 * 栗林健太郎
 * 2030006
 * 2020年11月5日
 */

public interface BSTree<K extends Comparable<? super K>, V> {
    BSTree<K, V> put(K k, V v);
    V get(K k);
}
