package map;

public class MyMap<K, V> {
    private int size;
    private int defaultSize = 20;
    @SuppressWarnings("unchecked")
    private MyEntry<K, V>[] values = new MyEntry[defaultSize];

}
