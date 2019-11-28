package cz.app.restauracka.demo.logika.ovladac;

import cz.app.restauracka.demo.logika.Data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OvladacData {

    @Autowired
    UlozDataObjednavek ulozDataObjednavek;
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
    NactiDataObjednavek nactiDataObjednavek;
    @Autowired
    NactiDataStolu nactiDataStolu;

    public void ulozData() {
        ulozDataObjednavek.saveData();
        ulozDataMenu.saveData();
        ulozDataStolu.saveData();
        ulozDataZamestnancu.saveData();
    }

    public void nactiData() {
        nactiDataZamestnancu.loadData();
        nactiDataMenu.loadData();
        nactiDataObjednavek.loadData();
        nactiDataStolu.loadData();
    }

}
