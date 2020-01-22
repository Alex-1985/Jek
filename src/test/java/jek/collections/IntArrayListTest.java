package jek.collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntArrayListTest {

    @Test
    void sizeShouldBeZero() {
        IntArrayList ial = new IntArrayList();

        assertEquals(0, ial.size());
    }

    @Test
    void sizeShouldContainSmthng() {
        IntArrayList ial = new IntArrayList();
        ial.add(1);
        ial.add(5);
        ial.add(54);

        assertEquals(3, ial.size());
    }

    @Test
    void isEmptyShouldBeTrue() {
        IntArrayList ial = new IntArrayList();

        assertTrue(ial.isEmpty());
    }

    @Test
    void isEmptyShouldBeFalse() {
        IntArrayList ial = new IntArrayList();
        ial.add(1);
        ial.add(5);
        ial.add(54);

        assertFalse(ial.isEmpty());
    }

    @Test
    void contains() {
        IntArrayList ial = new IntArrayList();
        ial.add(1);
        ial.add(5);
        ial.add(54);
        ial.add(11);
        ial.add(75);
        ial.add(59);

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
        IntArrayList ial = new IntArrayList();
        ial.add(1);
        ial.add(5);
        ial.add(54);
        ial.add(11);
        ial.add(75);
        ial.add(59);

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
        IntArrayList ial = new IntArrayList();
        ial.add(1);
        ial.add(5);
        ial.add(54);

        String expectedMessage = "ты пытаешься получить то, чего у тебя нет!";

        try {
            ial.get(55);
        } catch (IndexOutOfBoundsException thrown) {
            assertEquals(expectedMessage, thrown.getMessage());
        }
}

    @Test
    void getShouldReturnObject(){
        IntArrayList ial = new IntArrayList();
        ial.add(1);
        ial.add(5);
        ial.add(54);

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
        IntArrayList ial = new IntArrayList();
        ial.add(1);
        ial.add(5);
        ial.add(54);
        ial.add(11);
        ial.add(75);
        ial.add(59);

        assertEquals(3, ial.indexOf(11));
    }

    @Test
    void lastIndexOf() {
        IntArrayList ial = new IntArrayList();
        ial.add(1);
        ial.add(5);
        ial.add(54);
        ial.add(11);
        ial.add(5);
        ial.add(59);
        ial.add(54);

        assertEquals(4, ial.lastIndexOf(5));
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