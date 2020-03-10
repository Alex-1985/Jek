package jek.collections;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class GenericHashMapTest {

    GenericHashMap<String, String> ghm;

    public GenericHashMapTest () {
        ghm = new GenericHashMap<>(10);

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
    void containsValueFalse() {
        assertEquals(false, ghm.containsValue("Stanislaw Lem, 1961"));
    }

    @Test
    void containsValueTrue() {
        assertEquals(true, ghm.containsValue("William Gibson, 1984"));

    }

    @Test
    void containsLinkedValue() {
        assertEquals(true, ghm.containsValue(" dune "));
    }

    @Test
    void get() {
        assertEquals("William Gibson, 1984", ghm.get("Neuromancer"));
    }

    @Test
    void getNull() {
        assertEquals(null, ghm.get("Solaris"));
    }



    @Test
    void put() {

        //ghm.put();

        System.out.println(Arrays.toString(ghm.entrys));

        assertEquals(20, ghm.entrys.length);
    }

    @Test
    void remove() {
        String expected =
                "[The Left Hand of Darkness, Neuromancer, Consider Phlebas, A Scanner Darkly,  neuromancer ,  dune ]";
        ghm.remove("Dune");

        Set set = ghm.keySet();
        assertEquals(expected, set.toString());
    }

    @Test
    void putAll() {
    }

    @Test
    void clear() {
        ghm.clear();
        assertEquals(true, ghm.isEmpty());
    }

    @Test
    void keySet() {
        Set set = ghm.keySet();
        String expected = "[The Left Hand of Darkness, Neuromancer, Consider Phlebas, A Scanner Darkly, Dune,  neuromancer ,  dune ]";

        assertEquals(expected, set.toString());
    }

    @Test
    void values() {


        String expected =
                "[Ursula K. Le Guin, 1969, William Gibson, 1984, " +
                        "Philip K Dick, 1977, Frank Herb, Iain Banks, 1987, " +
                        " Frank Herbert, 1965, Will Gibson]";
        assertEquals(expected, ghm.values().toString());
    }

    @Test
    void entrySet() {

        Set set = ghm.entrySet();
        String expected =
                "[The Left Hand of Darkness: Ursula K. Le Guin, 1969, Neuromancer: William Gibson, 1984, " +
                        "A Scanner Darkly: Philip K Dick, 1977,  dune : Frank Herb, Consider Phlebas: Iain Banks, 1987, " +
                        "Dune: Frank Herbert, 1965,  neuromancer : Will Gibson]";

        assertEquals(expected, set.toString());

    }
}