package ru.job4j.cache;

import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {
    protected final Map<K, SoftReference<V>> cache = new HashMap<>();
    private final ReferenceQueue<V> queue = new ReferenceQueue<>();

    public void put(K key, V value) {
        cache.put(key, new SoftReference<V>(value, queue));
    }

    public V get(K key) throws IOException {
        if (cache.get(key) == null || cache.get(key).isEnqueued()) {
            put(key, load(key));
        }
       return cache.get(key).get();
    }

    protected abstract V load(K key) throws IOException;
}
