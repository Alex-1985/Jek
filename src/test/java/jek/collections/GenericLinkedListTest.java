package jek.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GenericLinkedListTest {

    GenericLinkedList<String> glls;

    @BeforeEach
    void creatingList(){
        glls = new GenericLinkedList<>();

        glls.add("залупа");
        glls.add("халупа");
        glls.add("жуй");
        glls.add("хуй");
    }


    @Test
    void size() {
        assertEquals(4, glls.size());
    }

    @Test
    void isEmptyShouldBeFalse() {
        assertFalse(glls.isEmpty());
    }

    @Test
    void contains() {

        assertTrue(glls.contains("жуй"));
    }

    @Test
    void iterator() {
    }

    @Test
    void toArray() {
        String expected = "[залупа, халупа, жуй, хуй]";
        assertEquals(expected, Arrays.toString(glls.toArray()));
    }

    @Test
    void testToArray() {
    }

    @Test
    void add() {
    }

    @Test
    void remove() {
    }

    @Test
    void containsAll() {
    }

    @Test
    void addAll() {
    }

    @Test
    void testAddAll() {
    }

    @Test
    void removeAll() {
    }

    @Test
    void retainAll() {
    }

    @Test
    void clear() {
    }

    @Test
    void get() {
        String expected = "халупа";
        assertEquals(expected, glls.get(1));
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
}