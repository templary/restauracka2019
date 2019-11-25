package cz.app.restauracka.demo.logika.zam;

import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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

    /**
     * Metoda pro zjištění zda zamestnanec existuje.
     * Pokud ano, vrací zamestnance.
     */
    public Zamestnanec getZamestnanecPokudExistuje(String jmeno) {
        for (Zamestnanec zamestnanec : this.zamestnanciSet) {
            if (zamestnanec.getJmeno().equals(jmeno)) {
                return zamestnanec;
            }
        }
        return null;
    }

    /**
     * Metoda vrací seznam zamestnancu
     */
    public Set getJmenaZamestnancu() {
        return zamestnanciSet.stream()
                .map(zamestnanec -> zamestnanec.getJmeno())
                .collect(Collectors.toSet());
    }

}
