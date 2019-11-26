package cz.app.restauracka.demo.logika.zam;


import cz.app.restauracka.demo.logika.Pozice;

public class Zamestnanec {

	private String jmeno;

	private String prijmeni;

	private String uzJmeno;

	private int id;

    private Pozice pozice;

	private int telefon;

	private String mail;

	private String heslo;

	public Zamestnanec(String jmeno, String prijmeni, String uzJmeno, int id, Pozice pozice, int telefon, String mail, String heslo) {
		this.jmeno = jmeno;
		this.prijmeni = prijmeni;
		this.uzJmeno = uzJmeno;
		this.id = id;
		this.pozice = pozice;
		this.telefon = telefon;
		this.mail = mail;
		this.heslo = heslo;
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

    public Pozice getPozice() {
		return pozice;
	}

    public void setPozice(Pozice pozice) {
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

	public String getUzJmeno() {
		return uzJmeno;
	}

	public void setUzJmeno(String uzJmeno) {
		this.uzJmeno = uzJmeno;
	}
}
