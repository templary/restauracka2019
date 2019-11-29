package cz.app.restauracka.demo.logika.ovladac;

import cz.app.restauracka.demo.logika.Pozice;
import cz.app.restauracka.demo.logika.zam.Zamestnanci;
import cz.app.restauracka.demo.logika.zam.Zamestnanec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OvladacZam {

    @Autowired
    Zamestnanci zamestnanci;


    public void vytvorNovehoUzivatele(String jmeno, String prijmeni, String uzJmeno, int id, Pozice pozice, String telefon, String mail, String heslo) {
        Zamestnanec zamestnanec = new Zamestnanec(jmeno, prijmeni, uzJmeno, id, pozice, telefon, mail, heslo);
        zamestnanci.vlozZamestnanceDoSetu(zamestnanec);
    }

    public int idGenerator() {
        int count = zamestnanci.getZamestnanciSet().size();
        return count + 1;
    }



    public void prijmoutObjednavku() {

    }





}
