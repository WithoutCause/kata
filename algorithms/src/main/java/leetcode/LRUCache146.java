package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache146 extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    public LRUCache146(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {

        LRUCache146 cache = new LRUCache146(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1 }
        cache.get(1);       // returns -1 (not found)

        System.out.println(cache);
    }
}
