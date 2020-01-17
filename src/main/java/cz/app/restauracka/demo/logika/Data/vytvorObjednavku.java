package cz.app.restauracka.demo.logika.Data;

import cz.app.restauracka.demo.logika.obj.MenuJidla;
import cz.app.restauracka.demo.logika.obj.Stoly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class vytvorObjednavku {
    @Autowired
    MenuJidla menuJidla;
    @Autowired
    Stoly stoly;


}
