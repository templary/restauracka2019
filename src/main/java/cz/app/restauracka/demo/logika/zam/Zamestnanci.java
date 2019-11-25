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

    /**
     * Metoda vrací celý set
     *
     * @return
     */
    public Set<Zamestnanec> getZamestnanciSet() {
        return zamestnanciSet;
    }

    /**
     * metoda dle
     *
     * @param zamestnanec vloží zam. do setu
     */
    public void vlozZamestnanceDoSetu(Zamestnanec zamestnanec) {
        zamestnanciSet.add(zamestnanec);
    }

    /**
     * Metoda dle
     *
     * @param zamestnanec odebere zamestnance
     */
    public void odeberZamestnanceZSetu(Zamestnanec zamestnanec) {
        zamestnanciSet.remove(zamestnanec);
    }

    /**
     * metoda dle
     * @param jmeno
     * zjistí zda Zam je v setu pokud ano, vrátího
     * @return
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
     * metoda vrací jmena Zam.
     * @return
     */
    public Set getJmenaZamestnancu() {
        return zamestnanciSet.stream()
                .map(Zamestnanec::getJmeno)
                .collect(Collectors.toSet());
    }

}
