package cz.app.restauracka.demo.logika.ovladac;

import cz.app.restauracka.demo.logika.Data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OvladacData {

    @Autowired
    UlozDataMenu ulozDataMenu;
    @Autowired
    UlozDataStolu ulozDataStolu;
    @Autowired
    UlozDataZamestnancu ulozDataZamestnancu;
    @Autowired
    NactiDataZamestnancu nactiDataZamestnancu;
    @Autowired
    NactiDataMenu nactiDataMenu;
    @Autowired
    NactiDataStolu nactiDataStolu;

    public void ulozData() {
        //TODO ulozit data objednavek
        ulozDataMenu.saveData();
        ulozDataStolu.saveData();
        ulozDataZamestnancu.saveData();
    }

    public void nactiData() {
        nactiDataZamestnancu.loadData();
        nactiDataMenu.loadData();
        //TODO nacist data objednavek
        nactiDataStolu.loadData();
    }

}
