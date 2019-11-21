package cz.app.restauracka.demo.logika.zam;

import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class Zamestnanci {

    private Set<Zamestnanec> zamestnanciSet = new HashSet<>();

    public Zamestnanci() {
        System.out.println("Vytvarim: " + getClass().getName());
    }

    public Set<Zamestnanec> getZamestnanciSet() {
        return zamestnanciSet;
    }

    public void vlozZamestnanceDoSetu(Zamestnanec zamestnanec) {
        zamestnanciSet.add(zamestnanec);
    }


    public Zamestnanec getZamestnanecPokudExistuje(String jmeno) {
        for (Zamestnanec zamestnanec : this.zamestnanciSet) {
            if (zamestnanec.getJmeno().equals(jmeno)) {
                return zamestnanec;
            }
        }
        return null;
    }

}
