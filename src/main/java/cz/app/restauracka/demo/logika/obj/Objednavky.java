package cz.app.restauracka.demo.logika.obj;

import cz.app.restauracka.demo.logika.ovladac.ZobrazovacObjednavek;
import cz.app.restauracka.demo.logika.ovladac.ZobrazovacObjednavekManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Objednavky {

    @Autowired
    ZobrazovacObjednavekManager zobrazovacObjednavekManager;
    @Autowired
    MenuJidla menuJidla;

    private Set<ObjednaneJidlo> setObjednanychJidel = new HashSet<>();

    public void vlozObjednaneJidlo(ObjednaneJidlo objednaneJidlo) {
        setObjednanychJidel.add(objednaneJidlo);
    }

    public void odeberObjednaneJidlo(ObjednaneJidlo objednaneJidlo) {
        setObjednanychJidel.remove(objednaneJidlo);
    }

    public Set<ObjednaneJidlo> getObjednaneJidloPodleStolu(int stul) {
        Set<ObjednaneJidlo> setJidelUStolu = new HashSet<>();

        for (ObjednaneJidlo objednaneJidlo : this.setObjednanychJidel) {
            if (objednaneJidlo.getStul() == stul) {
                setJidelUStolu.add(objednaneJidlo);
            }
        }
        return setJidelUStolu;
    }

    public ArrayList getIDJidelUStolu(int stul) {
        ArrayList arrayList = new ArrayList<Integer>();
        for (ObjednaneJidlo objednaneJidlo : this.setObjednanychJidel) {
            arrayList.add(objednaneJidlo.getId());
        }
        return arrayList;
    }

    public Map pocetVeciVObjednavce(int stul) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (ObjednaneJidlo item : getObjednaneJidloPodleStolu(stul)) {

            if (countMap.containsKey(item.getId()))
                countMap.put(item.getId(), countMap.get(item.getId()) + 1);
            else
                countMap.put(item.getId(), 1);
        }
        return countMap;
    }

    public int getCenaObjednavky(int stul) {
        Set<ObjednaneJidlo> objednanaJidlaUStolu = getObjednaneJidloPodleStolu(stul);
        int celkovaCena = 0;

        for (ObjednaneJidlo objednaneJidlo : this.setObjednanychJidel) {
            celkovaCena += objednaneJidlo.getJidlo().getCena();
        }

        return celkovaCena;
    }

    public void vlozObjednavkyDoZobrazovace(int stul) {
        Set<ObjednaneJidlo> objednaneJidloSet = getObjednaneJidloPodleStolu(stul);
/*        Set<ObjednaneJidlo> objednaneJidloSetBezDuplicit = new HashSet<>();
        ArrayList list = new ArrayList<Integer>();

        for (ObjednaneJidlo objednaneJidlo : objednaneJidloSet){
            if (list.contains(objednaneJidlo.getId())){
                System.out.println("Obsahuje");
            }else {
                list.add(objednaneJidlo.getId());
                System.out.println("NEobsahuje");
            }
        }*/

        Map<Integer, Integer> pocetVeciVObjednavceMap2 = pocetVeciVObjednavce(stul);
        pocetVeciVObjednavceMap2.forEach((k, v) -> {
            Jidlo jidlo = menuJidla.getJidloPodleID(k);
            ZobrazovacObjednavek zobrazovacObjednavek = new ZobrazovacObjednavek(jidlo.getNazev(), Integer.toString(v), jidlo.getCena(), jidlo.getCena() * v);
            zobrazovacObjednavekManager.vlozZobrazovaneJidloDoSetu(zobrazovacObjednavek);
            System.out.println("Key: " + k + ", Value: " + v);
        });


 /*       for (ObjednaneJidlo objednaneJidlo : objednaneJidloSet) {
            ZobrazovacObjednavek zobrazovacObjednavek = new ZobrazovacObjednavek(objednaneJidlo.getJidlo().getNazev(), objednaneJidlo.getJidlo().getCena());
            zobrazovacObjednavekManager.vlozZobrazovaneJidloDoSetu(zobrazovacObjednavek);

        }*/
    }

    public Set<ObjednaneJidlo> getSetObjednanychJidel() {
        return setObjednanychJidel;
    }
}
