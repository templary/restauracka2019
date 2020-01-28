package cz.app.restauracka.demo.logika.obj;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ZobrazovacObjednavekManagerTest {

    @Test
    void getSetZobrazovanychJidel() {
        ZobrazovacObjednavek zobrazovacObjednavek1 = new ZobrazovacObjednavek("Jidlo1", 3, 120, 360);
        ZobrazovacObjednavek zobrazovacObjednavek2 = new ZobrazovacObjednavek("Jidlo2", 2, 100, 200);
        ZobrazovacObjednavek zobrazovacObjednavek3 = new ZobrazovacObjednavek("Jidlo3", 5, 50, 250);
        Set<ZobrazovacObjednavek> set = new HashSet<>();
        set.add(zobrazovacObjednavek1);
        set.add(zobrazovacObjednavek2);
        set.add(zobrazovacObjednavek3);

        ZobrazovacObjednavekManager zobrazovacObjednavekManager = new ZobrazovacObjednavekManager();
        zobrazovacObjednavekManager.vlozZobrazovaneJidloDoSetu(zobrazovacObjednavek1);
        zobrazovacObjednavekManager.vlozZobrazovaneJidloDoSetu(zobrazovacObjednavek2);
        zobrazovacObjednavekManager.vlozZobrazovaneJidloDoSetu(zobrazovacObjednavek3);

        assertEquals(zobrazovacObjednavekManager.getSetZobrazovanychJidel(), set);
    }

    @Test
    void odeberZobrazovaneJidloZeSetu() {
        ZobrazovacObjednavek zobrazovacObjednavek1 = new ZobrazovacObjednavek("Jidlo1", 3, 120, 360);
        ZobrazovacObjednavek zobrazovacObjednavek2 = new ZobrazovacObjednavek("Jidlo2", 2, 100, 200);
        ZobrazovacObjednavek zobrazovacObjednavek3 = new ZobrazovacObjednavek("Jidlo3", 5, 50, 250);

        ZobrazovacObjednavekManager zobrazovacObjednavekManager = new ZobrazovacObjednavekManager();
        zobrazovacObjednavekManager.vlozZobrazovaneJidloDoSetu(zobrazovacObjednavek1);
        zobrazovacObjednavekManager.vlozZobrazovaneJidloDoSetu(zobrazovacObjednavek2);
        zobrazovacObjednavekManager.vlozZobrazovaneJidloDoSetu(zobrazovacObjednavek3);

        assertEquals(zobrazovacObjednavekManager.getSetZobrazovanychJidel().size(), 3);

        zobrazovacObjednavekManager.odeberZobrazovaneJidloZeSetu(zobrazovacObjednavek3);

        assertEquals(zobrazovacObjednavekManager.getSetZobrazovanychJidel().size(), 2);
    }

    @Test
    void vymazSetZobrazovanychJidel() {
    }
}