package cz.app.restauracka.demo.logika.zam;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class Cisnik extends Zamestnanec {

	public Cisnik(String jmeno, String prijmeni, int id, String pozice, int telefon, String mail, String heslo) {
		super(jmeno, prijmeni, id, pozice, telefon, mail, heslo);
	}

	public void prijmoutObjednavku() {

	}

}
