package cz.app.restauracka.demo.logika.zam;

import java.util.Set;

public interface IZamestnanec {
    String getJmeno();

    String getPrijmeni();

    String getID();

    String getPozice();

    int getTelefon();

    String getMail();

    Zamestnanec getZamestnanec();

    Set getSetZamestnanci();
}
