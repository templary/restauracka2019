package cz.app.restauracka.demo.logika.obj;

import cz.app.restauracka.demo.logika.Pozice;
import cz.app.restauracka.demo.logika.zam.Zamestnanec;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * Testovací třída pro test vytváření entit prvního rádu.
 */
@RunWith(SpringRunner.class)
public class TvorbaEntitTest {

    @Test
    public void testJidlo() {
        Jidlo jidlo = new Jidlo("Řízek", 1, "RychlýPopis", 1);
        Jidlo jidlo1 = new Jidlo("Karbanátek", 2, "RychlýPopis", 15000000);
        Jidlo jidlo2 = new Jidlo("Svickova", 3, "RychlýPopis", 0);
        //test ceny
        assertEquals(jidlo.getCena(), 1);
        assertEquals(jidlo1.getCena(), 15000000);
        assertEquals(jidlo2.getCena(), 0);
        //test popisku
        assertEquals(jidlo.getPopis(), "RychlýPopis");
        //test id
        assertEquals(jidlo2.getId(), 3);

    }

    @Test
    public void testZamestnanec() {
        Zamestnanec zamestnanec1 = new Zamestnanec("Karel", "Novák", "novis1", 1, Pozice.Boss, "767676767", "mail1@mail.com", "heslo1");
        Zamestnanec zamestnanec2 = new Zamestnanec("Borek", "Petrka", "petr", 2, Pozice.Cisnik, "836283803", "mail2@mail.com", "heslo1");
        Zamestnanec zamestnanec3 = new Zamestnanec("Milos", "Zimoslav", "zimuoslav", 3, Pozice.Kuchar, "797676767", "mail3@mail.com", "heslo1");
        //test jmena
        assertEquals(zamestnanec1.getJmeno(), "Karel");
        //prijmeni
        assertEquals(zamestnanec1.getPrijmeni(), "Novák");
        //uzJmeno
        assertEquals(zamestnanec2.getUzJmeno(), "petr");
        //id
        assertEquals(zamestnanec3.getId(), 3);
        assertEquals(zamestnanec2.getId(), 2);
        //pozice
        assertEquals(zamestnanec1.getPozice(), Pozice.Boss);
        //telefon
        assertEquals(zamestnanec1.getTelefon(), "767676767");
        //mail
        assertEquals(zamestnanec2.getMail(), "mail2@mail.com");
        //heslo
        assertEquals(zamestnanec1.getHeslo(), "heslo1");
    }

    @Test
    public void testStul() {
        Stul stul1 = new Stul(1, 5);
        Stul stul2 = new Stul(2, 3);
        Stul stul3 = new Stul(3, 9);
        //id
        assertEquals(stul1.getId(), 1);
        //pocet mist
        assertEquals(stul2.getPocetMist(), 3);
    }

}
