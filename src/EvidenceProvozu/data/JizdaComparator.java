package EvidenceProvozu.data;
import java.text.Collator;
import java.util.Comparator;

public class JizdaComparator implements Comparator<Jizda> {

	private Collator collator = Collator.getInstance();

	private int typ;

	public JizdaComparator(int typ) {
		this.typ = typ;
	}

	@Override
	public int compare(Jizda o1, Jizda o2) {
		int compare = 0;
		switch (this.typ) {
			case 0: //podle poradi
				compare = compareString(Integer.toString(o1.getPoradi()), Integer.toString(o2.getPoradi()));
				break;
			case 1: //podle vozidla
				compare = compareString(o1.getVozidlo(), o2.getVozidlo());
				break;
			case 2: //podle najeto
				//compare = compareString(Integer.toString(o1.getNajeto()),Integer.toString ( o2.getNajeto()));
				compare =  o1.getNajeto()-o2.getNajeto();//od nejmensiho
				break;
			case 3: //podle natankovano
				//compare = compareString(Integer.toString(o1.getTankovano()),Integer.toString(o2.getTankovano()));
				//compare = o2.getTankovano()-o1.getTankovano();//od nejvetsiho
				compare = o1.getTankovano()-o2.getTankovano();
				break;
			default:
				break;
		}

		return compare;
	}

	private int compareString(String o1, String o2) {
		return collator.compare(o1, o2);
	}
}