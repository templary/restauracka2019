package cz.app.restauracka.demo.logika.zam;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class Manager extends Zamestnanec {

	public Manager(String jmeno, String prijmeni, int id, String pozice, int telefon, String mail, String heslo) {
		super(jmeno, prijmeni, id, pozice, telefon, mail, heslo);
	}

	public void prijmoutZam() {

	}

	public void vyhoditZam() {

	}

	public void vypis() {

	}

	public void pridejJidlo() {

	}

	public void odeberJidlo() {

	}

	public void zmenCenuJidla() {

	}

	public void zmenAlergeny() {

	}

}
