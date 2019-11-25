package cz.app.restauracka.demo.logika.zam;

import cz.app.restauracka.demo.logika.Pozice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestovaciEntity {
    @Autowired
    Zamestnanci zamestnanci;
    Zamestnanec karel = new Zamestnanec("Karel", "Novák", 1, Pozice.Kuchar, 792, "aa@se.cz", "1234");
    Zamestnanec vojta = new Zamestnanec("Vojta", "Novák", 1, Pozice.Manager, 792, "aa@se.cz", "1234");

    public TestovaciEntity() {
        System.out.println("Vytvarim: " + getClass().getName());
    }

    public void vlozZamestnance() {
        zamestnanci.vlozZamestnanceDoSetu(karel);
        zamestnanci.vlozZamestnanceDoSetu(vojta);
    }

}
