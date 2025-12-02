import java.util.LinkedList;

public class SortedListPQ<K extends Comparable<K>, V> implements PriorityQueue<K, V> {

    private LinkedList<MyEntry<K, V>> list = new LinkedList<>();

    public boolean isEmpty() { return list.isEmpty(); }

    // O(n)
    public void insert(K key, V value) {
        MyEntry<K, V> newEntry = new MyEntry<>(key, value);

        int i = 0;
        while (i < list.size() && list.get(i).compareTo(newEntry) <= 0) {
            i++;
        }

        list.add(i, newEntry);
    }

    // O(1)
    public MyEntry<K, V> min() {
        return isEmpty() ? null : list.getFirst();
    }

    // O(1)
    public MyEntry<K, V> removeMin() {
        return isEmpty() ? null : list.removeFirst();
    }
}