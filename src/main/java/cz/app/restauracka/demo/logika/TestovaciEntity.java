package cz.app.restauracka.demo.logika;

import cz.app.restauracka.demo.logika.obj.*;
import cz.app.restauracka.demo.logika.zam.Zamestnanci;
import cz.app.restauracka.demo.logika.zam.Zamestnanec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class TestovaciEntity {
    @Autowired
    Zamestnanci zamestnanci;
    @Autowired
    MenuJidla menuJidla;
    @Autowired
    Stoly stoly;
    @Autowired
    Objednavky objednavky;


    Zamestnanec karel = new Zamestnanec("Karel", "Novák", 1, cz.app.restauracka.demo.logika.Pozice.Kuchar, 792, "aa@se.cz", "1234");
    Zamestnanec vojta = new Zamestnanec("Vojta", "Dvořák", 2, cz.app.restauracka.demo.logika.Pozice.Kuchar, 792, "aa@se.cz", "1234");
    Zamestnanec tomas = new Zamestnanec("Tomas", "Novotný", 3, cz.app.restauracka.demo.logika.Pozice.Boss, 792, "aa@se.cz", "1234");
    Zamestnanec adam = new Zamestnanec("Adam", "Rychlý", 4, cz.app.restauracka.demo.logika.Pozice.Cisnik, 792, "aa@se.cz", "1234");


    Jidlo svickova = new Jidlo(1, "Svíčková", "Dobré jídlo", 100);
    Jidlo burger = new Jidlo(2, "Burger", "Dobré jídlo", 120);
    Jidlo rizek = new Jidlo(3, "Rizek", "Dobré jídlo", 110);

    Stul stul1 = new Stul(1, 5);
    Stul stul2 = new Stul(2, 3);
    Stul stul3 = new Stul(3, 4);
    Stul stul4 = new Stul(4, 2);
    Stul stul5 = new Stul(5, 6);
    Stul stul6 = new Stul(5, 2);
    Stul stul7 = new Stul(5, 2);
    Stul stul8 = new Stul(5, 4);
    Stul stul9 = new Stul(5, 5);

    Set<Jidlo> objednavkovySet = new HashSet<>();







    public TestovaciEntity() {
        System.out.println("Vytvarim: " + getClass().getName());
    }

    public void vlozZamestnance() {
        zamestnanci.vlozZamestnanceDoSetu(karel);
        zamestnanci.vlozZamestnanceDoSetu(vojta);
        zamestnanci.vlozZamestnanceDoSetu(tomas);
        zamestnanci.vlozZamestnanceDoSetu(adam);
    }

    public void vlozJidloDoMenu() {
        menuJidla.vlozJidloDoMenu(svickova);
        menuJidla.vlozJidloDoMenu(burger);
        menuJidla.vlozJidloDoMenu(rizek);
    }

    public void vlozStulDoStolu() {
        stoly.vlozStul(stul1);
        stoly.vlozStul(stul2);
        stoly.vlozStul(stul3);
        stoly.vlozStul(stul4);
        stoly.vlozStul(stul5);
        stoly.vlozStul(stul6);
        stoly.vlozStul(stul7);
        stoly.vlozStul(stul8);
        stoly.vlozStul(stul9);
    }

    public void vytvorObjednavku() {
        objednavkovySet.add(rizek);
        objednavkovySet.add(burger);
        Objednavka objednavka1 = new Objednavka(objednavkovySet, 1);
        objednavky.vlozObjednavku(objednavka1);

    }

}
