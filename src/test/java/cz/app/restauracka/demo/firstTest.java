package cz.app.restauracka.demo;

import cz.app.restauracka.demo.logika.obj.Jidlo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class firstTest {

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
}
