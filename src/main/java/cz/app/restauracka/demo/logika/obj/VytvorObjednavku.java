package cz.app.restauracka.demo.logika.obj;

public class VytvorObjednavku {

    private Jidlo jidlo;
    private int IDStolu;
    private int cenaZaJednotku;
    private int mnozstvi;
    private String nazev;
    private int celkem;

    public VytvorObjednavku(Jidlo jidlo, int IDStolu) {
        this.jidlo = jidlo;
        this.IDStolu = IDStolu;
        cenaZaJednotku = jidlo.getCena();
        nazev = jidlo.getNazev();
        mnozstvi = 1; //TODO predelat!
        celkem = jidlo.getCena(); //TODO pouze pro test, dodělat přepočty.
        predejObjednavku();
    }

    private ZobrazObjednavku predejObjednavku() {
        ZobrazObjednavku zobrazObjednavku = new ZobrazObjednavku(jidlo, IDStolu, cenaZaJednotku, mnozstvi, nazev, celkem);

        return zobrazObjednavku;
    }


    public Jidlo getJidlo() {
        return jidlo;
    }

    public int getIDStolu() {
        return IDStolu;
    }
}
