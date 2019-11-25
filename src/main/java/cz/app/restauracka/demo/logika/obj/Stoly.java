package cz.app.restauracka.demo.logika.obj;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class Stoly {
    private Set<Stul> setStolu = new HashSet<>();

    public void vlozStul(Stul stul) {
        setStolu.add(stul);
    }

    public void odeberStul(Stul stul) {
        setStolu.remove(stul);
    }

    public Stul getStulPodleID(int id) {
        for (Stul stul : this.setStolu) {
            if (stul.getId() == id) {
                return stul;
            }
        }
        return null;
    }
}
