package cz.app.restauracka.demo.logika.obj;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ZobrazovacObjednavekManager {
    private Set<ZobrazovacObjednavek> setZobrazovanychJidel = new HashSet<>();

    public Set<ZobrazovacObjednavek> getSetZobrazovanychJidel() {
        return setZobrazovanychJidel;
    }

    public void vlozZobrazovaneJidloDoSetu(ZobrazovacObjednavek zobrazovacObjednavek) {
        setZobrazovanychJidel.add(zobrazovacObjednavek);
    }

    public void odeberZobrazovaneJidloZeSetu(ZobrazovacObjednavek zobrazovacObjednavek) {
        setZobrazovanychJidel.remove(zobrazovacObjednavek);
    }

    public void vymazSetZobrazovanychJidel() {
        setZobrazovanychJidel.clear();
    }
}
