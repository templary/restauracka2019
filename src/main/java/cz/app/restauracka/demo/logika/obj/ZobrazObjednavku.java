package cz.app.restauracka.demo.logika.obj;

public class ZobrazObjednavku {
    private Jidlo jidlo;
    private int IDStolu;
    private int cenaZaJednotku;
    private int mnozstvi;
    private String nazev;
    private int celkem;

    public ZobrazObjednavku(Jidlo jidlo, int IDStolu, int cenaZaJednotku, int mnozstvi, String nazev, int celkem) {
        this.jidlo = jidlo;
        this.IDStolu = IDStolu;
        this.cenaZaJednotku = cenaZaJednotku;
        this.mnozstvi = mnozstvi;
        this.nazev = nazev;
        this.celkem = celkem;
    }

    public Jidlo getJidlo() {
        return jidlo;
    }

    public int getIDStolu() {
        return IDStolu;
    }

    public int getCenaZaJednotku() {
        return cenaZaJednotku;
    }

    public int getMnozstvi() {
        return mnozstvi;
    }

    public String getNazev() {
        return nazev;
    }

    public int getCelkem() {
        return celkem;
    }
}
