/**
 * 栗林健太郎
 * 2030006
 * 2020年10月25日
 */

public interface TBSTree<K extends Comparable<K>, V> {
    TBSTree<K, V> put(K k, V v);
    V get(K k);
}
