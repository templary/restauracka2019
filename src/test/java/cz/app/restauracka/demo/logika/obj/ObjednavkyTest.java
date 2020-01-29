package cz.app.restauracka.demo.logika.obj;

import cz.app.restauracka.demo.Funkce.ActualTime;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ObjednavkyTest {

    @Test
    void vlozObjednaneJidlo() {
        Jidlo jidlo1 = new Jidlo("Řízek", 1, "RychlýPopis", 1);
        Jidlo jidlo2 = new Jidlo("Karbanátek", 2, "RychlýPopis", 15000000);
        Jidlo jidlo3 = new Jidlo("Svickova", 3, "RychlýPopis", 0);

        Stul stul1 = new Stul(1, 5);
        Stul stul2 = new Stul(2, 3);
        Stul stul3 = new Stul(3, 9);

        ActualTime actualTime = new ActualTime();

        ObjednaneJidlo objednaneJidlo1 = new ObjednaneJidlo(jidlo1, stul1.getId(), actualTime.getCurrentDate(), actualTime.getCurrentTime(), 1);
        ObjednaneJidlo objednaneJidlo2 = new ObjednaneJidlo(jidlo2, stul2.getId(), actualTime.getCurrentDate(), actualTime.getCurrentTime(), 2);
        ObjednaneJidlo objednaneJidlo3 = new ObjednaneJidlo(jidlo3, stul3.getId(), actualTime.getCurrentDate(), actualTime.getCurrentTime(), 3);

        assertEquals(objednaneJidlo1.getStul(), 1);
        assertEquals(objednaneJidlo2.getStul(), 2);
        assertEquals(objednaneJidlo3.getStul(), 3);

        assertEquals(objednaneJidlo1.getId(), 1);
        assertEquals(objednaneJidlo2.getId(), 2);
        assertEquals(objednaneJidlo3.getId(), 3);

        assertEquals(objednaneJidlo1.getJidlo().getId(), 1);
        assertEquals(objednaneJidlo2.getJidlo().getId(), 2);
        assertEquals(objednaneJidlo3.getJidlo().getId(), 3);

        Set<ObjednaneJidlo> set = new HashSet<>();
        set.add(objednaneJidlo1);
        set.add(objednaneJidlo2);
        set.add(objednaneJidlo3);


        Objednavky objednavky = new Objednavky();
        objednavky.vlozObjednaneJidlo(objednaneJidlo1);
        objednavky.vlozObjednaneJidlo(objednaneJidlo2);
        objednavky.vlozObjednaneJidlo(objednaneJidlo3);

        assertEquals(objednavky.getSetObjednanychJidel().size(), set.size());
        assertEquals(objednavky.getSetObjednanychJidel(), set);
    }

    @Test
    void odeberObjednaneJidlo() {
        Jidlo jidlo1 = new Jidlo("Řízek", 1, "RychlýPopis", 1);
        Jidlo jidlo2 = new Jidlo("Karbanátek", 2, "RychlýPopis", 15000000);
        Jidlo jidlo3 = new Jidlo("Svickova", 3, "RychlýPopis", 0);

        Stul stul1 = new Stul(1, 5);
        Stul stul2 = new Stul(2, 3);
        Stul stul3 = new Stul(3, 9);

        ActualTime actualTime = new ActualTime();

        ObjednaneJidlo objednaneJidlo1 = new ObjednaneJidlo(jidlo1, stul1.getId(), actualTime.getCurrentDate(), actualTime.getCurrentTime(), 1);
        ObjednaneJidlo objednaneJidlo2 = new ObjednaneJidlo(jidlo2, stul2.getId(), actualTime.getCurrentDate(), actualTime.getCurrentTime(), 2);
        ObjednaneJidlo objednaneJidlo3 = new ObjednaneJidlo(jidlo3, stul3.getId(), actualTime.getCurrentDate(), actualTime.getCurrentTime(), 3);


        Set<ObjednaneJidlo> set = new HashSet<>();
        set.add(objednaneJidlo1);
        set.add(objednaneJidlo2);
        set.add(objednaneJidlo3);


        Objednavky objednavky = new Objednavky();
        objednavky.vlozObjednaneJidlo(objednaneJidlo1);
        objednavky.vlozObjednaneJidlo(objednaneJidlo2);
        objednavky.vlozObjednaneJidlo(objednaneJidlo3);

        objednavky.odeberObjednaneJidlo(objednaneJidlo3);
        set.remove(objednaneJidlo3);

        assertEquals(objednavky.getSetObjednanychJidel().size(), set.size());
        assertEquals(objednavky.getSetObjednanychJidel(), set);
    }

    @Test
    void getObjednaneJidloPodleStolu() {

        Jidlo jidlo1 = new Jidlo("Řízek", 1, "RychlýPopis", 1);
        Jidlo jidlo2 = new Jidlo("Karbanátek", 2, "RychlýPopis", 15000000);
        Jidlo jidlo3 = new Jidlo("Svickova", 3, "RychlýPopis", 0);

        Stul stul1 = new Stul(1, 5);
        Stul stul2 = new Stul(2, 3);
        Stul stul3 = new Stul(3, 9);

        ActualTime actualTime = new ActualTime();

        ObjednaneJidlo objednaneJidlo1 = new ObjednaneJidlo(jidlo1, stul1.getId(), actualTime.getCurrentDate(), actualTime.getCurrentTime(), 1);
        ObjednaneJidlo objednaneJidlo2 = new ObjednaneJidlo(jidlo2, stul2.getId(), actualTime.getCurrentDate(), actualTime.getCurrentTime(), 2);
        ObjednaneJidlo objednaneJidlo3 = new ObjednaneJidlo(jidlo3, stul3.getId(), actualTime.getCurrentDate(), actualTime.getCurrentTime(), 3);
        ObjednaneJidlo objednaneJidlo4 = new ObjednaneJidlo(jidlo3, stul2.getId(), actualTime.getCurrentDate(), actualTime.getCurrentTime(), 4);

        Set<ObjednaneJidlo> set = new HashSet<>();
        set.add(objednaneJidlo1);

        Set<ObjednaneJidlo> set2 = new HashSet<>();
        set2.add(objednaneJidlo2);
        set2.add(objednaneJidlo4);


        Objednavky objednavky = new Objednavky();
        objednavky.vlozObjednaneJidlo(objednaneJidlo1);
        objednavky.vlozObjednaneJidlo(objednaneJidlo2);
        objednavky.vlozObjednaneJidlo(objednaneJidlo3);
        objednavky.vlozObjednaneJidlo(objednaneJidlo4);


        assertEquals(objednavky.getObjednaneJidloPodleStolu(stul1.getId()), set);
        assertEquals(objednavky.getObjednaneJidloPodleStolu(stul2.getId()), set2);
    }


    @Test
    void pocetVeciVObjednavce() {

        Jidlo jidlo1 = new Jidlo("Řízek", 1, "RychlýPopis", 1);
        Jidlo jidlo2 = new Jidlo("Karbanátek", 2, "RychlýPopis", 15000000);
        Jidlo jidlo3 = new Jidlo("Svickova", 3, "RychlýPopis", 0);

        Stul stul1 = new Stul(1, 5);
        Stul stul2 = new Stul(2, 3);
        Stul stul3 = new Stul(3, 9);

        ActualTime actualTime = new ActualTime();

        ObjednaneJidlo objednaneJidlo1 = new ObjednaneJidlo(jidlo1, stul1.getId(), actualTime.getCurrentDate(), actualTime.getCurrentTime(), 1);
        ObjednaneJidlo objednaneJidlo2 = new ObjednaneJidlo(jidlo2, stul2.getId(), actualTime.getCurrentDate(), actualTime.getCurrentTime(), 2);
        ObjednaneJidlo objednaneJidlo3 = new ObjednaneJidlo(jidlo3, stul3.getId(), actualTime.getCurrentDate(), actualTime.getCurrentTime(), 3);
        ObjednaneJidlo objednaneJidlo4 = new ObjednaneJidlo(jidlo3, stul2.getId(), actualTime.getCurrentDate(), actualTime.getCurrentTime(), 4);

        Set<ObjednaneJidlo> set = new HashSet<>();
        set.add(objednaneJidlo1);

        Set<ObjednaneJidlo> set2 = new HashSet<>();
        set2.add(objednaneJidlo2);
        set2.add(objednaneJidlo4);


        Objednavky objednavky = new Objednavky();
        objednavky.vlozObjednaneJidlo(objednaneJidlo1);
        objednavky.vlozObjednaneJidlo(objednaneJidlo2);
        objednavky.vlozObjednaneJidlo(objednaneJidlo3);
        objednavky.vlozObjednaneJidlo(objednaneJidlo4);


        //TODO dodělat
    }

    @Test
    void getCenaObjednavky() {
        //TODO dodělat
    }

    @Test
    void vlozObjednavkyDoZobrazovace() {
        //TODO dodělat
    }
}