package cz.app.restauracka.demo.logika.ovladac;

import cz.app.restauracka.demo.logika.obj.Jidlo;
import cz.app.restauracka.demo.logika.obj.MenuJidla;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OvladacObj {
    @Autowired
    MenuJidla menuJidla;

    public int idGenerator() {
        int count = menuJidla.getMenuSet().size();
        return count + 1;
    }

    public void vytvorNoveJidlo(int id, String nazev, String popis, int cena) {
        Jidlo jidlo = new Jidlo(nazev, id, popis, cena);
        menuJidla.vlozJidloDoMenu(jidlo);
    }
}
