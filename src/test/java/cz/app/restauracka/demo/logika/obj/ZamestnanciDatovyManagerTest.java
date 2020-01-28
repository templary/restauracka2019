package cz.app.restauracka.demo.logika.obj;

import cz.app.restauracka.demo.logika.Pozice;
import cz.app.restauracka.demo.logika.zam.Zamestnanci;
import cz.app.restauracka.demo.logika.zam.Zamestnanec;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

class ZamestnanciDatovyManagerTest {

    @Test
    public void testZamestnanec() {
        Zamestnanec zamestnanec1 = new Zamestnanec("Karel", "Novák", "novis1", 1, Pozice.Boss, "767676767", "mail1@mail.com", "heslo1");
        Zamestnanec zamestnanec2 = new Zamestnanec("Borek", "Petrka", "petr", 2, Pozice.Cisnik, "836283803", "mail2@mail.com", "heslo1");
        Zamestnanec zamestnanec3 = new Zamestnanec("Milos", "Zimoslav", "zimuoslav", 3, Pozice.Kuchar, "797676767", "mail3@mail.com", "heslo1");

        Zamestnanci zamestnanci = new Zamestnanci();

        zamestnanci.vlozZamestnanceDoSetu(zamestnanec1);
        zamestnanci.vlozZamestnanceDoSetu(zamestnanec2);
        zamestnanci.vlozZamestnanceDoSetu(zamestnanec3);
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
    void getZamestnanciSet() {
        Zamestnanec zamestnanec1 = new Zamestnanec("Karel", "Novák", "novis1", 1, Pozice.Boss, "767676767", "mail1@mail.com", "heslo1");
        Zamestnanec zamestnanec2 = new Zamestnanec("Borek", "Petrka", "petr", 2, Pozice.Cisnik, "836283803", "mail2@mail.com", "heslo1");
        Zamestnanec zamestnanec3 = new Zamestnanec("Milos", "Zimoslav", "zimuoslav", 3, Pozice.Kuchar, "797676767", "mail3@mail.com", "heslo1");

        Zamestnanci zamestnanci = new Zamestnanci();

        zamestnanci.vlozZamestnanceDoSetu(zamestnanec1);
        zamestnanci.vlozZamestnanceDoSetu(zamestnanec2);
        zamestnanci.vlozZamestnanceDoSetu(zamestnanec3);

        assertEquals(zamestnanci.getZamestnanciSet().size(), 3);
        zamestnanci.odeberZamestnanceZSetu(zamestnanec1);
        zamestnanci.odeberZamestnanceZSetu(zamestnanec3);
        assertEquals(zamestnanci.getZamestnanciSet().size(), 1);

    }

    @Test
    void setZamestnanciSet() {
        Zamestnanec zamestnanec1 = new Zamestnanec("Karel", "Novák", "novis1", 1, Pozice.Boss, "767676767", "mail1@mail.com", "heslo1");
        Zamestnanec zamestnanec2 = new Zamestnanec("Borek", "Petrka", "petr", 2, Pozice.Cisnik, "836283803", "mail2@mail.com", "heslo1");
        Zamestnanec zamestnanec3 = new Zamestnanec("Milos", "Zimoslav", "zimuoslav", 3, Pozice.Kuchar, "797676767", "mail3@mail.com", "heslo1");

        Set<Zamestnanec> set = new HashSet<>();
        set.add(zamestnanec3);
        set.add(zamestnanec2);
        set.add(zamestnanec1);

        Zamestnanci zamestnanci = new Zamestnanci();
        assertEquals(zamestnanci.getZamestnanciSet().size(), 0);
        zamestnanci.setZamestnanciSet(set);

        assertEquals(zamestnanci.getZamestnanciSet().size(), 3);

    }


    @Test
    void getZamestnanecPodleJmena() {
        Zamestnanec zamestnanec1 = new Zamestnanec("Karel", "Novák", "novis1", 1, Pozice.Boss, "767676767", "mail1@mail.com", "heslo1");
        Zamestnanec zamestnanec2 = new Zamestnanec("Borek", "Petrka", "petr", 2, Pozice.Cisnik, "836283803", "mail2@mail.com", "heslo1");
        Zamestnanec zamestnanec3 = new Zamestnanec("Milos", "Zimoslav", "zimuoslav", 3, Pozice.Kuchar, "797676767", "mail3@mail.com", "heslo1");
        Zamestnanci zamestnanci = new Zamestnanci();

        zamestnanci.vlozZamestnanceDoSetu(zamestnanec1);
        zamestnanci.vlozZamestnanceDoSetu(zamestnanec2);
        zamestnanci.vlozZamestnanceDoSetu(zamestnanec3);

        assertEquals(zamestnanci.getZamestnanecPodleUzJmeno("novis1"), zamestnanec1);
        assertEquals(zamestnanci.getZamestnanecPodleUzJmeno("zimuoslav"), zamestnanec3);

    }

    @Test
    void getZamestnanecPodleUzJmeno() {
        Zamestnanec zamestnanec1 = new Zamestnanec("Karel", "Novák", "novis1", 1, Pozice.Boss, "767676767", "mail1@mail.com", "heslo1");
        Zamestnanec zamestnanec2 = new Zamestnanec("Borek", "Petrka", "petr", 2, Pozice.Cisnik, "836283803", "mail2@mail.com", "heslo1");
        Zamestnanec zamestnanec3 = new Zamestnanec("Milos", "Zimoslav", "zimuoslav", 3, Pozice.Kuchar, "797676767", "mail3@mail.com", "heslo1");
        Zamestnanci zamestnanci = new Zamestnanci();

        zamestnanci.vlozZamestnanceDoSetu(zamestnanec1);
        zamestnanci.vlozZamestnanceDoSetu(zamestnanec2);
        zamestnanci.vlozZamestnanceDoSetu(zamestnanec3);

        assertEquals(zamestnanci.getZamestnanecPodleUzJmeno("novis1"), zamestnanec1);
        assertEquals(zamestnanci.getZamestnanecPodleUzJmeno("zimuoslav"), zamestnanec3);
        assertNull(zamestnanci.getZamestnanecPodleUzJmeno("zimuoslavujemespolecne"));

    }

    @Test
    void getZamestnanecPodleID() {
        Zamestnanec zamestnanec1 = new Zamestnanec("Karel", "Novák", "novis1", 1, Pozice.Boss, "767676767", "mail1@mail.com", "heslo1");
        Zamestnanec zamestnanec2 = new Zamestnanec("Borek", "Petrka", "petr", 2, Pozice.Cisnik, "836283803", "mail2@mail.com", "heslo1");
        Zamestnanec zamestnanec3 = new Zamestnanec("Milos", "Zimoslav", "zimuoslav", 3, Pozice.Kuchar, "797676767", "mail3@mail.com", "heslo1");
        Zamestnanci zamestnanci = new Zamestnanci();

        zamestnanci.vlozZamestnanceDoSetu(zamestnanec1);
        zamestnanci.vlozZamestnanceDoSetu(zamestnanec2);
        zamestnanci.vlozZamestnanceDoSetu(zamestnanec3);

        assertEquals(zamestnanci.getZamestnanecPodleID(1), zamestnanec1);
        assertEquals(zamestnanci.getZamestnanecPodleID(3), zamestnanec3);
        assertNull(zamestnanci.getZamestnanecPodleID(190000));
    }

    @Test
    void getSetJmenaZamestnancu() {
        Zamestnanec zamestnanec1 = new Zamestnanec("Karel", "Novák", "novis1", 1, Pozice.Boss, "767676767", "mail1@mail.com", "heslo1");
        Zamestnanec zamestnanec2 = new Zamestnanec("Borek", "Petrka", "petr", 2, Pozice.Cisnik, "836283803", "mail2@mail.com", "heslo1");
        Zamestnanec zamestnanec3 = new Zamestnanec("Milos", "Zimoslav", "zimuoslav", 3, Pozice.Kuchar, "797676767", "mail3@mail.com", "heslo1");
        Zamestnanci zamestnanci = new Zamestnanci();

        zamestnanci.vlozZamestnanceDoSetu(zamestnanec1);
        zamestnanci.vlozZamestnanceDoSetu(zamestnanec2);
        zamestnanci.vlozZamestnanceDoSetu(zamestnanec3);

        Set<String> jmena = new HashSet<>();
        jmena.add("Karel");
        jmena.add("Borek");
        jmena.add("Milos");

        assertEquals(jmena, zamestnanci.getSetJmenaZamestnancu());

    }
}