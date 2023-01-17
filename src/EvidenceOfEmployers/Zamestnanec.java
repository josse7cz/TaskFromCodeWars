package EvidenceOfEmployers;

public class Zamestnanec {
	private String jmeno;
	private String prijmeni;
	private String adresa;
	private String narozen;

	public String toString() {
		return jmeno + prijmeni + adresa + narozen;
	}
	public Zamestnanec(){}
	
	public Zamestnanec(String jmeno,String prijmeni,String adresa,String narozen){
		this.jmeno = jmeno;
		this.prijmeni = prijmeni;
		this.adresa = adresa;
		this.narozen = narozen;


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

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getNarozen() {
		return narozen;
	}

	public void setNarozen(String narozen) {
		this.narozen = narozen;
	}

}
