package cz.app.restauracka.demo.logika.ovladac;

import cz.app.restauracka.demo.UI.MainController;
import cz.app.restauracka.demo.logika.obj.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OvladacObjednavani {
    @Autowired
    Stoly stoly;
    @Autowired
    MenuJidla menuJidla;
    @Autowired
    MainController mainController;
    @Autowired
    Objednavky objednavky;

    public void objednejPotravinu(Jidlo jidlo, Stul stul) {
        int cisloStolu = mainController.getZvolenyStul();

        if (cisloStolu == 0) {
            System.out.println("Nevybral jsi stůl"); //TODO vypsat někam do aplikace.
        } else {
            //stoly.getStulPodleID(cisloStolu).;
            //TODO vymslet jinak systém přidávání do objednávek, takhle to asi fungovate nebude.
        }


    }


}
