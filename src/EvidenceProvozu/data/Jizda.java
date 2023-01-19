package EvidenceProvozu.data;

import java.io.Serializable;



public class Jizda implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 5240841581836428442L;
	public int poradi;
	public String vozidlo;
	private int najeto;
	private int tankovano;

	public static int celkemJizd;


	public Jizda(int poradi, String vozidlo, int najeto, int tankovano){
		this.poradi = poradi;
		this.vozidlo = vozidlo;
		this.najeto = najeto;
		this.tankovano = tankovano;
	}
	public Jizda(){

	}

	@Override
	public String toString() {
		return "#"+ Integer.toString(this.poradi) + "   Vozidlo: " + this.vozidlo + "   Najeto: " + this.najeto + "   Natankováno: " + this.tankovano;
	}

	public int getPoradi() {
		return poradi;
	}
	public void setPoradi(int poradi) {
		this.poradi = poradi;
	}
	public String getVozidlo() {
		return vozidlo;
	}
	public void setVozidlo(String vozidlo) {
		this.vozidlo = vozidlo;
	}
	public int getNajeto() {
		return najeto;
	}
	public void setNajeto(int najeto) {
		this.najeto = najeto;
	}
	public int getTankovano() {

		return tankovano;

	}
	public void setTankovano(int tankovano) {
		this.tankovano = tankovano;
	}
}


