package jek.collections;

import org.junit.jupiter.api.Test;

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
    }

    @Test
    void size() {
        assertEquals(5, ghm.size());
    }

    @Test
    void isEmpty() {
    }

    @Test
    void containsKey() {
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
    }

    @Test
    void putAll() {
    }

    @Test
    void clear() {
    }

    @Test
    void keySet() {
    }

    @Test
    void values() {
    }

    @Test
    void entrySet() {
    }
}