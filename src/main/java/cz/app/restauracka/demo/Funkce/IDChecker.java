package cz.app.restauracka.demo.Funkce;


import cz.app.restauracka.demo.logika.obj.*;
import cz.app.restauracka.demo.logika.zam.Zamestnanci;
import cz.app.restauracka.demo.logika.zam.Zamestnanec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IDChecker {
    @Autowired
    MenuJidla menuJidla;
    @Autowired
    Stoly stoly;
    @Autowired
    Objednavky objednavky;
    @Autowired
    Zamestnanci zamestnanci;

    int id = 1;

    public int getProperIDJidlo() {

        for (Jidlo jidlo : menuJidla.getMenuSet()) {
            if (jidlo.getId() == id) {
                id++;
                getProperIDJidlo();
            }
        }

        return id;

    }

    public void getProperIDStul() {

        for (Stul stul : stoly.getSetStolu()) {
            if (stul.getId() == id) {
                id++;
                getProperIDStul();
            }
        }

    }

    public void getProperIDObjednavka() {

        for (ObjednaneJidlo objednaneJidlo : objednavky.getSetObjednanychJidel()) {
            if (objednaneJidlo.getId() == id) {
                id++;
                getProperIDObjednavka();
            }
        }

    }

    public int getProperIDZamestnanec() {

        for (Zamestnanec zamestnanec : zamestnanci.getZamestnanciSet()) {
            if (zamestnanec.getId() == id) {
                id++;
                getProperIDZamestnanec();
            }
        }

        return id;

    }

    public void setId() {
        id = 1;
    }
}
