package cz.app.restauracka.demo.logika.obj;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ZobrazovacObjednavekTest {

    @Test
    void getNazevJidla() {
        ZobrazovacObjednavek zobrazovacObjednavek1 = new ZobrazovacObjednavek("Jidlo1", 3, 120, 360);
        ZobrazovacObjednavek zobrazovacObjednavek2 = new ZobrazovacObjednavek("Jidlo2", 2, 100, 200);
        ZobrazovacObjednavek zobrazovacObjednavek3 = new ZobrazovacObjednavek("Jidlo3", 5, 50, 250);

        assertEquals(zobrazovacObjednavek1.getNazevJidla(), "Jidlo1");
        assertEquals(zobrazovacObjednavek3.getNazevJidla(), "Jidlo3");
    }

    @Test
    void getMnozstviJidla() {
        ZobrazovacObjednavek zobrazovacObjednavek1 = new ZobrazovacObjednavek("Jidlo1", 3, 120, 360);
        ZobrazovacObjednavek zobrazovacObjednavek2 = new ZobrazovacObjednavek("Jidlo2", 2, 100, 200);
        ZobrazovacObjednavek zobrazovacObjednavek3 = new ZobrazovacObjednavek("Jidlo3", 5, 50, 250);

        assertEquals(zobrazovacObjednavek1.getMnozstviJidla(), 3);
        assertEquals(zobrazovacObjednavek2.getMnozstviJidla(), 2);
    }

    @Test
    void getCenaZaJednotku() {
        ZobrazovacObjednavek zobrazovacObjednavek1 = new ZobrazovacObjednavek("Jidlo1", 3, 120, 360);
        ZobrazovacObjednavek zobrazovacObjednavek2 = new ZobrazovacObjednavek("Jidlo2", 2, 100, 200);
        ZobrazovacObjednavek zobrazovacObjednavek3 = new ZobrazovacObjednavek("Jidlo3", 5, 50, 250);

        assertEquals(zobrazovacObjednavek1.getCenaZaJednotku(), 120);
        assertEquals(zobrazovacObjednavek3.getCenaZaJednotku(), 50);
    }

    @Test
    void getCelkovaCena() {
        ZobrazovacObjednavek zobrazovacObjednavek1 = new ZobrazovacObjednavek("Jidlo1", 3, 120, 360);
        ZobrazovacObjednavek zobrazovacObjednavek2 = new ZobrazovacObjednavek("Jidlo2", 2, 100, 200);
        ZobrazovacObjednavek zobrazovacObjednavek3 = new ZobrazovacObjednavek("Jidlo3", 5, 50, 250);

        assertEquals(zobrazovacObjednavek2.getCelkovaCena(), 200);
        assertEquals(zobrazovacObjednavek3.getCelkovaCena(), 250);
    }
}