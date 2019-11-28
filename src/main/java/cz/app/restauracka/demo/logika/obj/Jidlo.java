package cz.app.restauracka.demo.logika.obj;

/**
 * Pouze statická jídla která se přidají do Meníčka
 */
public class Jidlo {
    private int id;

    private String nazev;

    private String popis;

    private int cena;

    //private int alergeny; //TODO dodelat


    public Jidlo(int id, String nazev, String popis, int cena) {
        this.id = id;
        this.nazev = nazev;
        this.popis = popis;
        this.cena = cena;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    String getNazev() {
        return nazev;
    }

    String getCenaString() {
        return Integer.toString(cena);
    }

    String getNazevACena() {
        return nazev + " " + Integer.toString(cena);
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public String getPopis() {
        return popis;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }
}
