package cz.app.restauracka.demo.logika.obj;

public class Jidlo {

    private int id;

    private String jmeno;

    private String popis;

    private int cena;

    private int alergeny;

    private boolean jePripravovano;

    private boolean jeVydano;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
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

    public int getAlergeny() {
        return alergeny;
    }

    public void setAlergeny(int alergeny) {
        this.alergeny = alergeny;
    }

    public boolean isJePripravovano() {
        return jePripravovano;
    }

    public void setJePripravovano(boolean jePripravovano) {
        this.jePripravovano = jePripravovano;
    }

    public boolean isJeVydano() {
        return jeVydano;
    }

    public void setJeVydano(boolean jeVydano) {
        this.jeVydano = jeVydano;
    }
}
