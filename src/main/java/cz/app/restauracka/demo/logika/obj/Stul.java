package cz.app.restauracka.demo.logika.obj;

import java.util.Set;

public class Stul {

    private int idStolu;
    private Objednavka objednavka;
    private Set<Stul> Stoly;

    public int getIdStolu() {
        return idStolu;
    }

    public void setIdStolu(int idStolu) {
        this.idStolu = idStolu;
    }

    public Objednavka getObjednavka() {
        return objednavka;
    }

    public void setObjednavka(Objednavka objednavka) {
        this.objednavka = objednavka;
    }

    public Set<Stul> getStoly() {
        return Stoly;
    }

    public void setStoly(Set<Stul> stoly) {
        Stoly = stoly;
    }
}
