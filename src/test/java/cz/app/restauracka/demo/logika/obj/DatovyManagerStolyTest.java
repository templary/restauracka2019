package cz.app.restauracka.demo.logika.obj;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

class DatovyManagerStolyTest {


    @Test
    void vlozStul() {
        Stul stul1 = new Stul(1, 5);
        Stul stul2 = new Stul(2, 3);
        Stul stul3 = new Stul(3, 9);

        Stoly stoly = new Stoly();
        stoly.vlozStul(stul1);
        stoly.vlozStul(stul2);
        stoly.vlozStul(stul3);

        assertEquals(stoly.getSetStolu().size(), 3);
    }

    @Test
    void odeberStul() {
        Stul stul1 = new Stul(1, 5);
        Stul stul2 = new Stul(2, 3);
        Stul stul3 = new Stul(3, 9);

        Stoly stoly = new Stoly();
        stoly.vlozStul(stul1);
        stoly.vlozStul(stul2);
        stoly.vlozStul(stul3);

        assertEquals(stoly.getSetStolu().size(), 3);
        stoly.odeberStul(stul3);
        assertEquals(stoly.getSetStolu().size(), 2);
    }

    @Test
    void getStulPodleID() {
        Stul stul1 = new Stul(1, 5);
        Stul stul2 = new Stul(2, 3);
        Stul stul3 = new Stul(3, 9);

        Stoly stoly = new Stoly();
        stoly.vlozStul(stul1);
        stoly.vlozStul(stul2);
        stoly.vlozStul(stul3);

        assertEquals(stoly.getStulPodleID(2), stul2);
        assertEquals(stoly.getStulPodleID(3), stul3);
    }

    @Test
    void getSetStolu() {
        Stul stul1 = new Stul(1, 5);
        Stul stul2 = new Stul(2, 3);
        Stul stul3 = new Stul(3, 9);

        Stoly stoly = new Stoly();
        stoly.vlozStul(stul1);
        stoly.vlozStul(stul2);
        stoly.vlozStul(stul3);

        Set<Stul> set = new HashSet<>();
        set.add(stul1);
        set.add(stul2);
        set.add(stul3);

        assertEquals(set, stoly.getSetStolu());
    }

    @Test
    void setSetStolu() {
        Stul stul1 = new Stul(1, 5);
        Stul stul2 = new Stul(2, 3);
        Stul stul3 = new Stul(3, 9);

        Stoly stoly = new Stoly();

        Set<Stul> set = new HashSet<>();
        set.add(stul1);
        set.add(stul2);
        set.add(stul3);

        stoly.setSetStolu(set);

        assertEquals(stoly.getSetStolu().size(), 3);

    }
}