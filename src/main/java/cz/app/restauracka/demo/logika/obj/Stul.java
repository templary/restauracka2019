package cz.app.restauracka.demo.logika.obj;

public class Stul {

    private int id;
    private int pocetMist;

    public Stul(int id, int pocetMist) {
        this.id = id;
        this.pocetMist = pocetMist;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPocetMist() {
        return pocetMist;
    }

    public void setPocetMist(int pocetMist) {
        this.pocetMist = pocetMist;
    }
}
