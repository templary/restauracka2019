package cz.app.restauracka.demo.logika.zam;

public interface iZamestnanec {

    String getJmeno();

    void setJmeno(String jmeno);

    String getPrijmeni();

    void setPrijmeni(String prijmeni);

    int getId();

    void setId(int id);

    String getPozice();

    void setPozice(String pozice);

    int getTelefon();

    void setTelefon(int telefon);

    String getMail();

    void setMail(String mail);

    String getHeslo();

    void setHeslo(String heslo);

    @Override
    String toString();
}
