package cz.app.restauracka.demo.logika.zam;


import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class Zamestnanec implements InterfaceZamestnanec {

	private Set<InterfaceZamestnanec> Zamestnanci;

	private String jmeno;

	private String prijmeni;

	private int id;

	private String pozice;

	private int telefon;

	private String mail;

	private String heslo;

	public Zamestnanec(String jmeno, String prijmeni, int id, String pozice, int telefon, String mail, String heslo) {
		this.jmeno = jmeno;
		this.prijmeni = prijmeni;
		this.id = id;
		this.pozice = pozice;
		this.telefon = telefon;
		this.mail = mail;
		this.heslo = heslo;
	}

	@Override
	public String getJmeno() {
		return jmeno;
	}

	@Override
	public void setJmeno(String jmeno) {
		this.jmeno = jmeno;
	}

	@Override
	public String getPrijmeni() {
		return prijmeni;
	}

	@Override
	public void setPrijmeni(String prijmeni) {
		this.prijmeni = prijmeni;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String getPozice() {
		return pozice;
	}

	@Override
	public void setPozice(String pozice) {
		this.pozice = pozice;
	}

	@Override
	public int getTelefon() {
		return telefon;
	}

	@Override
	public void setTelefon(int telefon) {
		this.telefon = telefon;
	}

	@Override
	public String getMail() {
		return mail;
	}

	@Override
	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String getHeslo() {
		return heslo;
	}

	@Override
	public void setHeslo(String heslo) {
		this.heslo = heslo;
	}
}
