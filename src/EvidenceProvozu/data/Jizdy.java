package EvidenceProvozu.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Trida pro seznam jizd
 *
 * @author Josef Janda for UHK
 *
 */
public class Jizdy implements Serializable {

	private static final long serialVersionUID = 1L;

	private ArrayList<Jizda> jizdy = new ArrayList<>();

	public void pridat(Jizda p) {
		jizdy.add(p);
	}

	public void smazat(Jizda p) {
		jizdy.remove(p);
	}

	/**
	 * smaze polozku dle zadaneho indexu
	 *
	 * @param i
	 *            index
	 * @return
	 */
	public void smazat(int i) {
		jizdy.remove(i);
	}

	public void smazatVse() {
		jizdy.removeAll(jizdy);
	}

	public Jizda ziskat(int index) {
		return jizdy.get(index);
	}

	public int pocetJizd() {
		return jizdy.size();
	}

	public ArrayList<Jizda> getJizdy(Hashtable<String, String> filter) {
		if (filter == null)
			return getJizdy();
		else
			return this.getJizdyFiltrovano(filter.get("najeto").toString(), filter.get("vozidlo").toString(),
					filter.get("poradoveCislo").toString(), filter.get("tankovano").toString());
	}

	public ArrayList<Jizda> getJizdy() {
		return jizdy;
	}

	public void setJizdy(ArrayList<Jizda> jizdy) {
		this.jizdy = jizdy;
	}

	public int getPocetJizd() {
		int pocet = jizdy.size();
		return pocet;
	}

	public int getNatankCelk(Hashtable<String, String> filter) {
		/// procházení pole a vytáhnutí tankováno
		int soucet = 0;
		for (Jizda j : this.getJizdy(filter)) {
			soucet += j.getTankovano();
		}
		return soucet;
	}
	public int getNajCelk(Hashtable<String, String> filter) {
		/// procházení pole a vytáhnutí tankováno
		int soucet = 0;
		for (Jizda j : this.getJizdy(filter)) {
			soucet += j.getNajeto();
		}
		return soucet;
	}
	public ArrayList<Jizda> getJizdyFiltrovano(String filterNajeto, String filterVozidlo, String filterPoradovecislo,
											   String filterTankovano) {
		ArrayList<Jizda> splnujiciJizdy = new ArrayList<>();
		for (Jizda j : this.jizdy) {
			boolean vPoradku = true;

			if (!filterVozidlo.equals("")) // Uplatnime pouze neprazdy filter
			{
				// Pokud se to nerovna vyhledavanemu, tak to odfiltrujeme
				if (!filterVozidlo.equals(j.getVozidlo())) {
					vPoradku = false;
				}
			}
			if (!filterPoradovecislo.equals("")) // Uplatnime pouze neprazdy
			// filter
			{
				// Pokud se to nerovna vyhledavanemu, tak to odfiltrujeme
				if (!filterPoradovecislo.equals(Integer.toString(j.getPoradi()))) {
					vPoradku = false;
				}
			}
			if (!filterNajeto.equals("")) // Uplatnime pouze neprazdy filter
			{
				// Pokud se to nerovna vyhledavanemu, tak to odfiltrujeme
				if (!filterNajeto.equals(Integer.toString(j.getNajeto()))) {
					vPoradku = false;
				}
			}
			if (!filterTankovano.equals("")) // Uplatnime pouze neprazdy filter
			{
				// Pokud se to nerovna vyhledavanemu, tak to odfiltrujeme
				if (!filterTankovano.equals(Integer.toString(j.getTankovano()))) {
					vPoradku = false;
				}
			}
			if (vPoradku) {
				splnujiciJizdy.add(j);
			}

		}
		return splnujiciJizdy;
	}
}
