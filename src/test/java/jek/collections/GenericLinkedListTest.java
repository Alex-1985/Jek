package jek.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

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
        String expected = "[object 0, object 3]";

        glls.remove("object 1");
        glls.remove("object 2");
        assertEquals(expected, Arrays.toString(glls.toArray()));
    }

    @Test
    void containsAll() {
        List<String> contains = new ArrayList();

        contains.add("object 3");
        contains.add("object 2");

        assertTrue(glls.containsAll(contains));
    }

    @Test
    void addAll() {
        String expected = "[object 0, object 1, object 2, object 3, OBJECT 666, OBJECT 666, OBJECT 666]";
        List<String> toAdd = new ArrayList();
        toAdd.add("OBJECT 666");
        toAdd.add("OBJECT 666");
        toAdd.add("OBJECT 666");

        glls.addAll(toAdd);
        assertEquals(expected, Arrays.toString(glls.toArray()));
    }

    @Test
    void testAddAll() {
        String expected = "[object 0, object 1, OBJECT 666, OBJECT 666, OBJECT 666, object 2, object 3]";
        List<String> toAdd = new ArrayList();

        toAdd.add("OBJECT 666");
        toAdd.add("OBJECT 666");
        toAdd.add("OBJECT 666");


        glls.addAll(2, toAdd);

        assertEquals(expected, Arrays.toString(glls.toArray()));
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
        String expected = "[object 0, object 1, OBJECT 666, object 2, object 3]";

        glls.add(2, "OBJECT 666");

        assertEquals(expected, Arrays.toString(glls.toArray()));
    }

    @Test
    void testRemove() {
    }

    @Test
    void indexOf() {
        assertEquals(2, glls.indexOf("object 2"));
    }
    @Test
    void indexOfNoSuchElem() {

        assertEquals(-1, glls.indexOf("object 666"));
    }

    @Test
    void lastIndexOf() {
        assertEquals(3, glls.indexOf("object 3"));
    }

    @Test
    void lastIndexOfNoSuchElem() {
        assertEquals(-1, glls.indexOf("object 666"));
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