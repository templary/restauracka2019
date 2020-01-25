package cz.app.restauracka.demo.logika.ovladac;

public class ZobrazovacObjednavek {
    private String nazevJidla;
    private int mnozstviJidla;
    private int cenaZaJednotku;
    private int celkovaCena;

    public ZobrazovacObjednavek(String nazevJidla, String mnozstviJidla, int cenaZaJednotku, int celkovaCena) {
        this.nazevJidla = nazevJidla;
        //this.mnozstviJidla = mnozstviJidla;
        this.cenaZaJednotku = cenaZaJednotku;
        //this.celkovaCena = celkovaCena;
    }

    public String getNazevJidla() {
        return nazevJidla;
    }

    public int getMnozstviJidla() {
        return mnozstviJidla;
    }

    public int getCenaZaJednotku() {
        return cenaZaJednotku;
    }

    public int getCelkovaCena() {
        return celkovaCena;
    }
}
