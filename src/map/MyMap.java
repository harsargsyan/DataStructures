package map;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MyMap<K, V> {
    private int size;
    private final int DEFAULT_SIZE = 20;
    @SuppressWarnings("unchecked")
    private MyEntry<K, V>[] entries = new MyEntry[DEFAULT_SIZE];

    public V get(K key) {
        for (MyEntry<K, V> entry : entries) {
            if (entry != null) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    public void put(K key, V value) {
        boolean keyDoesNotExist = true;
        for (MyEntry<K, V> entry : entries) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                keyDoesNotExist = false;
            }
        }
        if (keyDoesNotExist) {
            checkCapacity();
            entries[size++] = new MyEntry<>(key, value);
        }
    }

    public void remove(K key) {
        for (int i=0; i<size; i++) {
            if (entries[i].getKey().equals(key)) {
                entries[i] = null;
                size--;
                condenseArray(i);
            }
        }
    }

    public Set<K> keySet() {
        Set<K> mySet = new HashSet<>();
        for (MyEntry<K, V> entry : entries) {
            mySet.add(entry.getKey());
        }
        return mySet;
    }

    // utility methods

    private void checkCapacity() {
        if (size == entries.length) {
            int newSize = size * 2;
            entries = Arrays.copyOf(entries, newSize);
        }
    }

    private void condenseArray(int start) {
        for (int i=start; i<size; i++) {
            entries[i] = entries[i+1];
        }
    }

    private int getSize() {
        return size;
    }
}
