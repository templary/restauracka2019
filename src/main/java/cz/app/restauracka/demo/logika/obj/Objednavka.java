package cz.app.restauracka.demo.logika.obj;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Objednavka {

    @Autowired
    MenuJidla menuJidla;

    private int cenaObjednavky = 0;
    private Set<Jidlo> jidloVObjednavce = new HashSet<>();
    private int id;

    public Objednavka(Set<Jidlo> jidloVObjednavce, int id) {
        this.jidloVObjednavce = jidloVObjednavce;
        this.id = id; //TODO všude generovat automaticky ID - vymyslet.
    }

    int getId() {
        return id;
    }

    public void pridejDoObjednavky(Jidlo jidlo) {
        jidloVObjednavce.add(jidlo);
    }

    public void odeberZObjednavky(Jidlo jidlo) {
        jidloVObjednavce.remove(jidlo);
    }

    public Set getObsahObjednavky() {
        return jidloVObjednavce.stream()
                .map(Jidlo::getNazev)
                .collect(Collectors.toSet());
    }


    public int getCelkovaCena() {
        for (Jidlo jidlo : this.jidloVObjednavce) {
            cenaObjednavky = cenaObjednavky + jidlo.getCena();
        }
        return cenaObjednavky;
    }

}
