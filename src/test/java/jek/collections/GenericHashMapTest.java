package jek.collections;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class GenericHashMapTest {

    GenericHashMap<String, String> ghm;

    public GenericHashMapTest () {
        ghm = new GenericHashMap<>();

        ghm.put("Dune", "Frank Herbert, 1965");
        ghm.put("The Left Hand of Darkness", "Ursula K. Le Guin, 1969");
        ghm.put("A Scanner Darkly", "Philip K Dick, 1977");
        ghm.put("Neuromancer", "William Gibson, 1984");
        ghm.put("Consider Phlebas", "Iain Banks, 1987");

        ghm.put(" neuromancer ", "Will Gibson");    // both added as 'next'
        ghm.put(" dune ", "Frank Herb");

        System.out.println(Arrays.toString(ghm.entrys));
    }

    @Test
    void size() {
        assertEquals(7, ghm.size());
    }

    @Test
    void isEmpty() {
        assertEquals(false, ghm.isEmpty());
    }

    @Test
    void isEmptyTrue() {
        ghm.clear();
        assertEquals(true, ghm.isEmpty());
    }

    @Test
    void containsKey() {
        assertEquals(true, ghm.containsKey("Neuromancer"));
    }

    @Test
    void containsKeyAsNext() {
        assertEquals(true, ghm.containsKey(" neuromancer "));
    }

    @Test
    void containsKeyFalse() {
        assertEquals(false, ghm.containsKey("Dune2"));
    }

    @Test
    void containsValue() {
    }

    @Test
    void get() {
        assertEquals("William Gibson, 1984", ghm.get("Neuromancer"));
    }



    @Test
    void put() {
    }

    @Test
    void remove() {
        String expected =
                "[The Left Hand of Darkness, Neuromancer, Consider Phlebas, A Scanner Darkly, Dune,  neuromancer ,  dune ]";
        //ghm.remove("Dune");
        Set set = ghm.keySet();
        assertEquals(expected, set);
    }

    @Test
    void putAll() {
    }

    @Test
    void clear() {
    }

    @Test
    void keySet() {
        Set set = ghm.keySet();
        String expected = "[The Left Hand of Darkness, Neuromancer, Consider Phlebas, A Scanner Darkly, Dune,  neuromancer ,  dune ]";

        assertEquals(expected, set.toString());
    }

    @Test
    void values() {
    }

    @Test
    void entrySet() {
    }
}