package cz.app.restauracka.demo.logika.obj;

import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class MenuJidla {

    private Set<Jidlo> menuSet = new HashSet<>();

    public Set<Jidlo> getMenuSet() {
        return menuSet;
    }

    public void vlozJidloDoMenu(Jidlo jidlo) {
        menuSet.add(jidlo);
    }

    public void odeberJidlozMenu(Jidlo jidlo) {
        menuSet.remove(jidlo);
    }

    //TODO až bude gui možná přdělat na něco vhodnějšího než String.
    public Jidlo getJidloPokudJeVMenu(String string) {
        for (Jidlo jidlo : this.menuSet) {
            if (jidlo.getNazev().equals(string)) {
                return jidlo;
            }
        }
        return null;
    }

    public Jidlo getJidloPodleID(int id) {
        for (Jidlo jidlo : this.menuSet) {
            if (jidlo.getId() == id) {
                return jidlo;
            }
        }
        return null;
    }

    public void setMenuSet(Set<Jidlo> menuSet) {
        this.menuSet = menuSet;
    }

    public Set getNazvyJidel() {
        return menuSet.stream()
                .map(Jidlo::getNazev)
                .collect(Collectors.toSet());
    }
}
