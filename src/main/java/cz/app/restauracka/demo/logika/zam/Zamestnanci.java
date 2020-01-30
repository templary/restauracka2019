package cz.app.restauracka.demo.logika.zam;

import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class Zamestnanci {


    private Set<Zamestnanec> zamestnanciSet = new HashSet<>();

    public Set<Zamestnanec> getZamestnanciSet() {
        return zamestnanciSet;
    }

    public void setZamestnanciSet(Set<Zamestnanec> zamestnanciSet) {
        this.zamestnanciSet = zamestnanciSet;
    }

    public void vlozZamestnanceDoSetu(Zamestnanec zamestnanec) {
        zamestnanciSet.add(zamestnanec);
    }


    public void odeberZamestnanceZSetu(Zamestnanec zamestnanec) {
        zamestnanciSet.remove(zamestnanec);
    }


    public Zamestnanec getZamestnanecPodleUzJmeno(String uzJmeno) {
        for (Zamestnanec zamestnanec : this.zamestnanciSet) {
            if (zamestnanec.getUzJmeno().equals(uzJmeno)) {
                return zamestnanec;
            }
        }
        return null;
    }

    public Zamestnanec getZamestnanecPodleID(int id) {
        for (Zamestnanec zamestnanec : this.zamestnanciSet) {
            if (zamestnanec.getId() == id) {
                return zamestnanec;
            }
        }
        return null;
    }

    public Set getSetJmenaZamestnancu() {
        return zamestnanciSet.stream()
                .map(Zamestnanec::getJmeno)
                .collect(Collectors.toSet());
    }

}
