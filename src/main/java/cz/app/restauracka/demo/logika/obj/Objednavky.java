package cz.app.restauracka.demo.logika.obj;

import cz.app.restauracka.demo.logika.ovladac.ZobrazovacObjednavek;
import cz.app.restauracka.demo.logika.ovladac.ZobrazovacObjednavekManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class Objednavky {

    @Autowired
    ZobrazovacObjednavekManager zobrazovacObjednavekManager;

    private Set<ObjednaneJidlo> setObjednanychJidel = new HashSet<>();

    public void vlozObjednaneJidlo(ObjednaneJidlo objednaneJidlo) {
        setObjednanychJidel.add(objednaneJidlo);
    }

    public void odeberObjednaneJidlo(ObjednaneJidlo objednaneJidlo) {
        setObjednanychJidel.remove(objednaneJidlo);
    }

    public Set<ObjednaneJidlo> getObjednaneJidloPodleStolu(int stul) {
        Set<ObjednaneJidlo> setJidelUStolu = new HashSet<>();

        for (ObjednaneJidlo objednaneJidlo : this.setObjednanychJidel) {
            if (objednaneJidlo.getStul() == stul) {
                setJidelUStolu.add(objednaneJidlo);
            }
        }
        return setJidelUStolu;
    }

    public void vlozObjednavkyDoZobrazovace(int stul) {
        Set<ObjednaneJidlo> objednaneJidloSet = getObjednaneJidloPodleStolu(stul);

        for (ObjednaneJidlo objednaneJidlo : objednaneJidloSet) {
            ZobrazovacObjednavek zobrazovacObjednavek = new ZobrazovacObjednavek(objednaneJidlo.getJidlo().getNazev(), objednaneJidlo.getJidlo().getCena());
            zobrazovacObjednavekManager.vlozZobrazovaneJidloDoSetu(zobrazovacObjednavek);
        }
    }

    public Set<ObjednaneJidlo> getSetObjednanychJidel() {
        return setObjednanychJidel;
    }
}
