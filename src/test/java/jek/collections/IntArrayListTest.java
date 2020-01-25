package jek.collections;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;

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

    }

    @Test
    void testAddAll() {
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