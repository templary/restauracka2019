package cz.app.restauracka.demo.logika.obj;

import org.springframework.beans.factory.annotation.Autowired;

public class Stul {

    @Autowired
    Objednavky objednavky;

    private int id;
    private int pocetMist;
    private Objednavka objednavka;

    public Stul(int id, int pocetMist) {
        this.id = id;
        this.pocetMist = pocetMist;
    }

    int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Objednavka getObjednavka() {
        return objednavka;
    }

    public void setObjednavka(Objednavka objednavka) {
        this.objednavka = objednavka;
    }

    public int getPocetMist() {
        return pocetMist;
    }

    public void setPocetMist(int pocetMist) {
        this.pocetMist = pocetMist;
    }
}
