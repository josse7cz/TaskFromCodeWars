package EvidenceOfEmployers;

public class TestClass {

    public static void main(String[] args) {


        SeznamZamestnancu l = new SeznamZamestnancu();

        l.pridat(new Zamestnanec("Josef", "Janda", "U Stadionu 720", "Most"));
        l.pridat(new Zamestnanec("Karel", "Novotny", "Kladno", "Stary Hrozenkov"));
        l.pridat(new Zamestnanec("Adam", "Zalesky", "Vyskov 20", "Pardubice"));

        for (int i = 0; i < l.pocetZamestnancu(); i++) {
            Zamestnanec p = l.ziskat(i);
            System.out.printf("%s %s, %s, %s\n", p.getJmeno(), p.getPrijmeni(), p.getAdresa(), p.getNarozen());
            System.out.println("i" + i);

        }




    }
}