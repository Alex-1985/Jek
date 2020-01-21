package jek.collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntArrayListTest {

    @Test
    void size() {
        IntArrayList il = new IntArrayList();
        il.add(1);
        il.add(5);
        assertEquals(1, il.size());
    }

    @Test
    void isEmpty() {
        IntArrayList ial = new IntArrayList();

        assertTrue(ial.isEmpty());
    }

    @Test
    void contains() {
    }

    @Test
    void iterator() {
    }

    @Test
    void toArray() {
    }

    @Test
    void add() {
        IntArrayList ial = new IntArrayList();

        assertTrue(ial.add(6));
    }

    @Test
    void remove() {
    }

    @Test
    void addAll() {
    }

    @Test
    void testAddAll() {
    }

    @Test
    void clear() {
    }

    @Test
    void get() {
    }

    @Test
    void set() {
    }

    @Test
    void testAdd() {
    }

    @Test
    void testRemove() {
    }

    @Test
    void indexOf() {
    }

    @Test
    void lastIndexOf() {
    }

    @Test
    void listIterator() {
    }

    @Test
    void testListIterator() {
    }

    @Test
    void subList() {
    }

    @Test
    void retainAll() {
    }

    @Test
    void removeAll() {
    }

    @Test
    void containsAll() {
    }

    @Test
    void testToArray() {
    }
}