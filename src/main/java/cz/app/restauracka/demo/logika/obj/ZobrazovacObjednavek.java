package cz.app.restauracka.demo.logika.obj;

public class ZobrazovacObjednavek {
    private final String nazevJidla;
    private final int mnozstviJidla;
    private final int cenaZaJednotku;
    private final int celkovaCena;

    public ZobrazovacObjednavek(String nazevJidla, int mnozstviJidla, int cenaZaJednotku, int celkovaCena) {
        this.nazevJidla = nazevJidla;
        this.mnozstviJidla = mnozstviJidla;
        this.cenaZaJednotku = cenaZaJednotku;
        this.celkovaCena = celkovaCena;
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
