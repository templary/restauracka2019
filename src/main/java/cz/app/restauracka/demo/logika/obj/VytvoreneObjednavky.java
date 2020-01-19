package cz.app.restauracka.demo.logika.obj;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class VytvoreneObjednavky {
    private Set<VytvorObjednavku> setVytvorenychObjednavek = new HashSet<>();

    public VytvorObjednavku getVytvorenaObjednavkaPodleIDStolu(int id) {
        for (VytvorObjednavku vytvorObjednavku : this.setVytvorenychObjednavek) {
            if (vytvorObjednavku.getIDStolu() == id) {
                return vytvorObjednavku;
            }
        }
        return null;
    }

    public void vlozObjednavaku(VytvorObjednavku vytvorObjednavku) {
        setVytvorenychObjednavek.add(vytvorObjednavku);
    }

    public void odeberObjednavku(VytvorObjednavku vytvorObjednavku) {
        setVytvorenychObjednavek.remove(vytvorObjednavku);
    }

    public Set<VytvorObjednavku> getSetVytvorenychObjednavek() {
        return setVytvorenychObjednavek;
    }
}
