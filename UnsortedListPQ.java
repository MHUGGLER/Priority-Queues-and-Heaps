import java.util.LinkedList;

public class UnsortedListPQ<K extends Comparable<K>, V> implements PriorityQueue<K, V> {

    private LinkedList<MyEntry<K, V>> list = new LinkedList<>();

    public boolean isEmpty() { return list.isEmpty(); }

    // O(1)
    public void insert(K key, V value) {
        list.addLast(new MyEntry<>(key, value));
    }

    // O(n)
    public MyEntry<K, V> min() {
        if (isEmpty()) return null;

        MyEntry<K, V> min = list.getFirst();
        for (MyEntry<K, V> entry : list) {
            if (entry.compareTo(min) < 0) {
                min = entry;
            }
        }
        return min;
    }

    // O(n)
    public MyEntry<K, V> removeMin() {
        if (isEmpty()) return null;

        MyEntry<K, V> minEntry = min();
        list.remove(minEntry);
        return minEntry;
    }
}