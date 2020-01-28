package cz.app.restauracka.demo.logika.obj;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Testovací třída pro test datových managerů
 */
public class DatovyManagerJidlaTest {

    @Test
    public void PridejAOdeberJidloTest() {
        Jidlo jidlo1 = new Jidlo("Řízek", 1, "RychlýPopis", 1);
        Jidlo jidlo2 = new Jidlo("Karbanátek", 2, "RychlýPopis", 15000000);
        Jidlo jidlo3 = new Jidlo("Svickova", 3, "RychlýPopis", 0);

        MenuJidla menuJidla = new MenuJidla();

        assertEquals(menuJidla.getMenuSet().size(), 0);

        menuJidla.vlozJidloDoMenu(jidlo1);
        menuJidla.vlozJidloDoMenu(jidlo2);
        menuJidla.vlozJidloDoMenu(jidlo3);

        assertEquals(menuJidla.getMenuSet().size(), 3);

        menuJidla.odeberJidlozMenu(jidlo2);

        assertEquals(menuJidla.getMenuSet().size(), 2);
        assertEquals(menuJidla.getJidloPodleID(1), jidlo1);
        assertEquals(menuJidla.getJidloPodleID(3), jidlo3);
    }


    @Test
    public void getJidloPokudJeVMenu() {
        Jidlo jidlo1 = new Jidlo("Řízek", 1, "RychlýPopis", 1);
        Jidlo jidlo2 = new Jidlo("Karbanátek", 2, "RychlýPopis", 15000000);
        Jidlo jidlo3 = new Jidlo("Svickova", 3, "RychlýPopis", 0);

        MenuJidla menuJidla = new MenuJidla();
        menuJidla.vlozJidloDoMenu(jidlo1);
        menuJidla.vlozJidloDoMenu(jidlo2);
        menuJidla.vlozJidloDoMenu(jidlo3);

        assertEquals(menuJidla.getJidloPokudJeVMenu("Řízek"), jidlo1);
        assertEquals(menuJidla.getJidloPokudJeVMenu("Svickova"), jidlo3);
        assertNull(menuJidla.getJidloPokudJeVMenu("NeniZde"));
        assertNull(menuJidla.getJidloPokudJeVMenu("Rizek"));
    }


    @Test
    public void setMenuSet() {
        Jidlo jidlo1 = new Jidlo("Řízek", 1, "RychlýPopis", 1);
        Jidlo jidlo2 = new Jidlo("Karbanátek", 2, "RychlýPopis", 15000000);
        Jidlo jidlo3 = new Jidlo("Svickova", 3, "RychlýPopis", 0);

        Set<Jidlo> menuJidlaTest = new HashSet<>();
        menuJidlaTest.add(jidlo1);
        menuJidlaTest.add(jidlo2);
        menuJidlaTest.add(jidlo3);

        assertEquals(menuJidlaTest.size(), 3);

        MenuJidla menuJidla1 = new MenuJidla();

        assertEquals(menuJidla1.getMenuSet().size(), 0);

        menuJidla1.setMenuSet(menuJidlaTest);

        assertEquals(menuJidla1.getMenuSet().size(), 3);
    }


}
