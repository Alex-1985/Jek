package jek.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class GenericLinkedListTest {

    GenericLinkedList<String> glls;

    @BeforeEach
    void creatingList(){
        glls = new GenericLinkedList<>();

        glls.add("object 0");
        glls.add("object 1");
        glls.add("object 2");
        glls.add("object 3");
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

        assertTrue(glls.contains("object 2"));
    }

    @Test
    void iterator() {
        Iterator iter = glls.iterator();
        String actual = "";
        String expected = "object 0, object 1, object 2, object 3, ";

        while (iter.hasNext()){
            actual += iter.next() + ", ";
        }
        assertEquals(expected, actual);
    }


    @Test
    void toArray() {
        String expected = "[object 0, object 1, object 2, object 3]";
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
        String expected = "object 1";
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