package cz.app.restauracka.demo.Funkce;

import org.springframework.stereotype.Component;

@Component
public class Numeric {

    public boolean jeCislo (String cislo){
        String string = "12345.15";
        boolean numeric = true;
        try {
            Double num = Double.parseDouble(cislo);
        } catch (NumberFormatException e) {
            numeric = false;
        }
        if(numeric)
            return true;
        else
            return false;
    }
}
