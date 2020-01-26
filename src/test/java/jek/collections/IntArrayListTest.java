package jek.collections;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

import static org.junit.jupiter.api.Assertions.*;

class IntArrayListTest {

    IntArrayList ial;

    @BeforeEach
    void creatingArray() {

        ial = new IntArrayList();    // 7 elems
        ial.add(1);
        ial.add(5);
        ial.add(54);
        ial.add(11);
        ial.add(5);
        ial.add(59);
        ial.add(54);
    }



    @Test
    void sizeShouldBeZero() {

        ial = new IntArrayList();
         assertEquals(0, ial.size());
    }

    @Test
    void sizeShouldContainSmthng() {

        assertEquals(7, ial.size());
    }

    @Test
    void isEmptyShouldBeTrue() {

        ial = new IntArrayList();
        assertTrue(ial.isEmpty());
    }

    @Test
    void isEmptyShouldBeFalse() {

        assertFalse(ial.isEmpty());
    }

    @Test
    void contains() {

        assertTrue(ial.contains(54));
    }

    @Test
    void iterator() {
        Iterator iter = ial.iterator();
        String actual = "";
        String expected = "1, 5, 54, 11, 5, 59, 54, ";

        while (iter.hasNext()){
            actual += iter.next() + ", ";
        }
        assertEquals(expected, actual);
    }

    @Test
    void toArray() {
       String expected = "[1, 5, 54, 11, 5, 59, 54]";

        assertEquals(expected, Arrays.toString(ial.toArray()));
    }

    @Test
    void add() {
        ial.add(666);
        assertEquals(666, ial.get(ial.size()-1));
    }

    @Test
    void removeShouldReturnObject() {

        assertEquals(59, ial.remove(5));
    }

    @Test
    void removeShouldThrowException(){
        String expected = "ты пытаешься удалить то, чего у тебя нет!";
        try {ial.remove(10);
        } catch (IndexOutOfBoundsException thrown) {
            assertEquals(expected, thrown.getMessage());
        }


    }

    @Test
    void addAll() {
        String expected = "[1, 5, 54, 11, 5, 59, 54, 666, 666, 666, 666]";
        IntArrayList c = new IntArrayList();
        c.add(666);
        c.add(666);
        c.add(666);
        c.add(666);

        ial.addAll(c);
        assertEquals(expected, Arrays.toString(ial.toArray()));
    }

    @Test
    void testAddAll() {
        String expected = "[1, 5, 54, 11, 666, 666, 666, 666, 5, 59, 54]";

        IntArrayList c = new IntArrayList();
        c.add(666);
        c.add(666);
        c.add(666);
        c.add(666);

        ial.addAll(4, c);

        assertEquals(expected, Arrays.toString(ial.toArray()));
    }

    @Test
    void clear() {
        ial.clear();
        assertEquals(0, ial.size());
    }

    @Test
    void getShouldThrowException() {

        String expectedMessage = "ты пытаешься получить то, чего у тебя нет!";

        try {
            ial.get(55);
        } catch (IndexOutOfBoundsException thrown) {
            assertEquals(expectedMessage, thrown.getMessage());
        }
}

    @Test
    void getShouldReturnObject(){

        assertEquals(5, ial.get(1));
    }

    @Test
    void set() {
        ial.set(3, 666);

        assertEquals(666, ial.get(3));
    }

    @Test
    void setShouldThrowExeption () {

        try{ial.set(11, 666);
        } catch(IndexOutOfBoundsException thrown) {
            assertEquals(null, thrown.getMessage());
        }
    }

    @Test
    void testAdd() {
        ial.add(4, 666);
        assertEquals(666, ial.get(4));
    }

    @Test
    void addShouldThrowExeption() {
        try{ial.add(11, 666);
        } catch(IndexOutOfBoundsException thrown) {
            assertEquals(null, thrown.getMessage());
        }
    }
    @Test
    void testRemove() {
        String expected = "[1, 54, 5, 59, 54]";

        ial.remove((Integer) 11);
        ial.remove((Integer) 5);
        assertEquals(expected, Arrays.toString(ial.toArray()));
    }

    @Test
    void indexOf() {

        assertEquals(3, ial.indexOf(11));
    }

    @Test
    void indexOfNoSuchElem() {
        assertEquals(-1, ial.indexOf(666));
    }

    @Test
    void lastIndexOf() {

        assertEquals(4, ial.lastIndexOf(5));
    }

    @Test
    void lastIndexOfNoSuchElem() {
        assertEquals(-1, ial.indexOf(666));
    }

    @Test
    void listIteratorRunForwardAndBackwards() {
        ListIterator iter = ial.listIterator();
        String actual = "";
        String expected = "1, 5, 54, 11, 5, 59, 54, 54, 59, 5, 11, 54, 5, 1, ";

        while (iter.hasNext()){
            actual += iter.next() + ", ";
        }
        while (iter.hasPrevious()){
            actual += iter.previous() + ", ";
        }

        assertEquals(expected, actual);
    }

    @Test
    void listIteratorRemove() {
        ListIterator iter = ial.listIterator();
        String expected = "[1, 5, 11, 5, 59, 54]";

        iter.next();
        iter.next();
        iter.next();
        iter.remove();

        assertEquals(expected, Arrays.toString(ial.toArray()));
    }

    @Test
    void listIteratorRemoveShouldThrowException() {
        ListIterator iter = ial.listIterator();

       try { iter.remove();
       } catch (IllegalStateException thrown) {
           assertEquals(null, thrown.getMessage());
       }
    }

    @Test
    void listIteratorAdd() {
        ListIterator iter = ial.listIterator();
        String expected = "[1, 5, 54, 666, 11, 5, 59, 54]";

        iter.next();
        iter.next();
        iter.next();
        iter.add(666);

        assertEquals(expected, Arrays.toString(ial.toArray()));
    }
    @Test
    void listIteratorSet() {
        ListIterator iter = ial.listIterator();

        iter.next();
        iter.next();
        iter.next();
        iter.set(666);

        assertEquals(666, ial.get(2));
    }

    @Test
    void testListIterator() {
        ListIterator iter = ial.listIterator(3);
        String expected = "11, 5, 59, 54, ";
        String actual = "";

        while(iter.hasNext())
            actual+= iter.next() + ", ";

        assertEquals(expected, actual);
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