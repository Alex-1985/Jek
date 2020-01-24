package jek.collections;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    }

    @Test
    void toArray() {
    }

    @Test
    void add() {
    }

    @Test
    void removeShouldReturnObject() {

        assertEquals(59, ial.remove(5));
    }

    @Test
    void removeShouldThrowException(){

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
    }

    @Test
    void testAdd() {
    }

    @Test
    void testRemove() {
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