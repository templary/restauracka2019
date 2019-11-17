package cz.app.restauracka.demo.logika.zam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestovaciEntity {
    @Autowired
    InterfaceZamestnanec zamestnanec;
    @Autowired
    Manager manager;
    @Autowired
    Kuchar kuchar;
    @Autowired
    Cisnik cisnik;
    @Autowired
    Boss boss;


    //TODO jak vytvářet instance zaměstnanců pomocí Springu?
    Manager Karel = new Manager("Karel", "Novák", 1, "Manager", 792, "aa@se.cz", "1234");

}
