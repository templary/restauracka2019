package cz.app.restauracka.demo.logika.obj;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ZobrazovaneObjednavky {

    private Set<ZobrazObjednavku> setZobrazovanychObjednavek = new HashSet<>();


    public void vlozObjednavaku(ZobrazObjednavku zobrazObjednavku) {
        setZobrazovanychObjednavek.add(zobrazObjednavku);
    }

    public void odeberObjednavku(ZobrazObjednavku zobrazObjednavku) {
        setZobrazovanychObjednavek.remove(zobrazObjednavku);
    }

    public Set<ZobrazObjednavku> getSetZobrazovanychObjednavek() {
        return setZobrazovanychObjednavek;
    }
}
