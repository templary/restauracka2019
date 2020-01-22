package cz.app.restauracka.demo.logika.obj;

public class ObjednaneJidlo {
    private Jidlo jidlo;
    private int stul;
    private String date;
    private String time;
    private Boolean stav;

    public ObjednaneJidlo(Jidlo jidlo, int stul, String date, String time) {
        this.jidlo = jidlo;
        this.stul = stul;
        this.date = date;
        this.time = time;
        stav = false;
    }

    public Jidlo getJidlo() {
        return jidlo;
    }

    public int getStul() {
        return stul;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public Boolean getStav() {
        return stav;
    }
}
