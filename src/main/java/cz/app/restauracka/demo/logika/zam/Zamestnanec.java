package cz.app.restauracka.demo.logika.zam;


import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public abstract class Zamestnanec {

	private Set<Zamestnanec> Zamestnanci;

	private String jmeno;

	private String prijmeni;

	private int id;

	private String pozice;

	private int telefon;

	private String mail;

	private String heslo;


	public Zamestnanec(String jmeno, String prijmeni, int id, String pozice, int telefon, String mail, String heslo) {
		System.out.println("Vytvarim entitu třídy " + this.getClass().getName());

	}

	public String getJmeno() {
		return jmeno;
	}


	public void setJmeno(String jmeno) {
		this.jmeno = jmeno;
	}


	public String getPrijmeni() {
		return prijmeni;
	}


	public void setPrijmeni(String prijmeni) {
		this.prijmeni = prijmeni;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPozice() {
		return pozice;
	}


	public void setPozice(String pozice) {
		this.pozice = pozice;
	}


	public int getTelefon() {
		return telefon;
	}


	public void setTelefon(int telefon) {
		this.telefon = telefon;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getHeslo() {
		return heslo;
	}


	public void setHeslo(String heslo) {
		this.heslo = heslo;
	}
}
