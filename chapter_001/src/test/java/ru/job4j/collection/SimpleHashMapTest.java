package ru.job4j.collection;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleHashMapTest {
    @Test
    public void whenInsertThenGet() {
        SimpleHashMap<String, Integer> map = new SimpleHashMap<>();
        map.insert("Коля", 37);
        map.insert("Света", 20);
        map.insert("Гена", 28);
        assertThat(map.get("Коля"), is(37));
        assertThat(map.get("Света"), is(20));
        assertThat(map.get("Гена"), is(28));
    }

    @Test
    public void whenInsertThenDelete() {
        SimpleHashMap<String, Integer> map = new SimpleHashMap<>();
        map.insert("Коля", 37);
        map.insert("Света", 20);
        map.insert("Гена", 28);
        map.delete("Коля");
        map.delete("Света");
        Iterator<SimpleHashMap.Node<String, Integer>> it = map.iterator();
        SimpleHashMap.Node<String, Integer> node = it.next();
        assertThat(node.getKey(), is("Гена"));
        assertThat(node.getValue(), is(28));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        SimpleHashMap<String, Integer> map = new SimpleHashMap<>();
        map.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        SimpleHashMap<String, Integer> map = new SimpleHashMap<>();
        map.insert("Толя", 33);
        Iterator<SimpleHashMap.Node<String, Integer>> it = map.iterator();
        map.insert("Таня", 34);
        it.next();
    }
}