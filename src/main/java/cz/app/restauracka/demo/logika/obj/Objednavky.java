package cz.app.restauracka.demo.logika.obj;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class Objednavky {
    private Set<Objednavka> setObjednavek = new HashSet<>();

    public void vlozObjednavku(Objednavka objednavka) {
        setObjednavek.add(objednavka);
    }

    public void odeberObjednavku(Objednavka objednavka) {
        setObjednavek.remove(objednavka);
    }

    public Objednavka getObjednavkaPodleID(int id) {
        for (Objednavka objednavka : this.setObjednavek) {
            if (objednavka.getId() == id) {
                return objednavka;
            }
        }
        return null;
    }
}
