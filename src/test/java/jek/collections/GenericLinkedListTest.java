package jek.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

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
        String expected = "[object 0, object 1, object 2, object 3, OBJECT 666]";

        glls.add("OBJECT 666");
        assertEquals(expected, Arrays.toString(glls.toArray()));
    }

    @Test
    void remove() {
        String expected = "[object 0, object 2]";

        glls.remove("object 1");
        glls.remove("object 3");
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
    void setChangesObject() {
        String expected = "[object 0, OBJECT 666, object 2, object 3]";
        glls.set(1, "OBJECT 666");

        assertEquals(expected, Arrays.toString(glls.toArray()));
    }

    @Test
    void setReturnsObject() {
        assertEquals("object 1", glls.set(1, "new object"));
    }

    @Test
    void addByIndexToMid() {
        String expected = "[object 0, object 1, OBJECT 777, OBJECT 666, object 2, object 3]";

        glls.add(2, "OBJECT 666");
        glls.add(2, "OBJECT 777");

        assertEquals(expected, Arrays.toString(glls.toArray()));
    }

    @Test
    void addByIndexFirst() {
        String expected = "[OBJECT 666, object 0, object 1, object 2, object 3]";
        glls.add(0, "OBJECT 666");

        assertEquals(expected, Arrays.toString(glls.toArray()));
    }


    @Test
    void removeFirstByIndex() {
        String expected = "[object 1, object 2, object 3]";

        glls.remove(0);
        assertEquals(expected, Arrays.toString(glls.toArray()));
    }

    @Test
    void removeLastByIndex() {
        String expected = "[object 0, object 1, object 2]";

        glls.remove(3);
        assertEquals(expected, Arrays.toString(glls.toArray()));
    }

    @Test
    void removeFromMiddleByIndex() {
        String expected = "[object 0, object 3]";

        glls.remove(1);
        glls.remove(1);
        assertEquals(expected, Arrays.toString(glls.toArray()));
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
        ListIterator iter = glls.listIterator();
        String actual = "";
        String expected = "object 0, object 1, object 2, object 3, object 3, object 2, object 1, object 0, ";

        while (iter.hasNext())
            actual += iter.next() + ", ";

        while (iter.hasPrevious())
            actual += iter.previous() + ", ";

        assertEquals(expected, actual);
    }

    @Test
    void listIteratorRemove() {
        ListIterator iter = glls.listIterator();
        String expected = "[object 0, object 1]";

        iter.next();
        iter.next();
        iter.next();
        iter.remove();
        iter.next();
        iter.remove();

        assertEquals(expected, Arrays.toString(glls.toArray()));
    }

    @Test
    void testListIterator() {
    }

    @Test
    void subList() {
    }
}