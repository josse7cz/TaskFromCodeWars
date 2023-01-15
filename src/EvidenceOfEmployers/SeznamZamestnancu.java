package EvidenceOfEmployers;

import java.util.ArrayList;
import java.util.List;

/**
 * Trida seznam zamestnancu
 * @author Josef Janda
 *
 */

public class SeznamZamestnancu {
	private List<Zamestnanec> zamestnanci = new ArrayList<>();
	
	public void pridat(Zamestnanec p){
		zamestnanci.add(p);
	}
	public void smazat (Zamestnanec p){
		zamestnanci.remove(p);
	}
	public void smazat(int i){
		zamestnanci.remove(i);
	}
	public Zamestnanec ziskat (int index){
		return zamestnanci.get(index);
	}
	public int pocetZamestnancu(){
		return zamestnanci.size();
	}
	public List<Zamestnanec> getZamestnanec(){
	return zamestnanci;
	}
	public void setZamestnanci(List<Zamestnanec>zamestnanci){
		this.zamestnanci = zamestnanci;
	}
	
}