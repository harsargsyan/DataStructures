package map;

class MyEntry<K, V> {
    private final K key;
    private V value;

    MyEntry(K key, V value) {
        this.key=key;
        this.value=value;
    }

    K getKey() {
        return key;
    }

    V getValue() {
        return value;
    }

    void setValue(V value) {
        this.value = value;
    }
}
