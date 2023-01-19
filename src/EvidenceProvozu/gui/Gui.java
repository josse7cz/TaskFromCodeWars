package EvidenceProvozu.gui;

import EvidenceProvozu.data.Jizda;
import EvidenceProvozu.data.JizdaComparator;
import EvidenceProvozu.data.Jizdy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;

import static EvidenceProvozu.data.Jizda.celkemJizd;

public class Gui implements ActionListener {

	JTextArea zapisnik;
	JList seznam;
	JPanel panel,panelTop;
	JLabel najeto,vozidlo,porCislo,tank,celkem;
	JTextField voz,tl,naj,ta;
	private Jizdy jizdy = new Jizdy();

	JButton hledat;


	public Gui() {
		JFrame okno1 = new JFrame("Evidence provozu");
		okno1.setSize(550, 350);
		okno1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okno1.setVisible(true);
		okno1.setLayout(new BorderLayout());

		Dimension obrazovka = Toolkit.getDefaultToolkit().getScreenSize();// zjistenivelikostimonitoru
		okno1.setLocation(obrazovka.width / 3, obrazovka.height / 3);// nastavenipoziceokna


		seznam = new JList();
		okno1.add(new JScrollPane(seznam), BorderLayout.CENTER);


		panelTop = new JPanel(new FlowLayout(FlowLayout.LEFT));// lista pod hlavnim panelem
		naj = new JTextField(4);
		porCislo = new JLabel("P.č.");
		tl = new JTextField(2);
		panelTop.add(porCislo);
		panelTop.add(tl);
		porCislo.setDisplayedMnemonic('P');
		porCislo.setLabelFor(tl);

		vozidlo = new JLabel("Vozidlo:");
		panelTop.add(vozidlo);
		vozidlo.setDisplayedMnemonic('V');
		voz = new JTextField(4);
		panelTop.add(voz);
		vozidlo.setLabelFor(voz);

		najeto = new JLabel("Najeto:");
		najeto.setDisplayedMnemonic('N');
		panelTop.add(najeto);
		panelTop.add(naj);
		najeto.setLabelFor(naj);

		tank = new JLabel("Tankováno:");
		panelTop.add(tank);
		tank.setDisplayedMnemonic('T');
		ta = new JTextField(4);
		panelTop.add(ta);
		tank.setLabelFor(ta);

		hledat = new JButton("Hledat");
		panelTop.add(hledat);
		hledat.setBackground(Color.lightGray);


		panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		okno1.add(panelTop, BorderLayout.NORTH);
		okno1.add(panel, BorderLayout.SOUTH);
		celkem = new JLabel();						//spodni Label
		panel.add(celkem);



		JMenuBar lista = new JMenuBar();// menu
		JMenu menu = new JMenu("Soubor");
		JMenu menu1 = new JMenu("Jízda");

		JMenuItem otevrit = new JMenuItem("Otevřít");// menu soubor
		JMenuItem ulozit = new JMenuItem("Uložit");
		JMenuItem konec = new JMenuItem("Konec");

		JMenuItem zadat = new JMenuItem("Zadat");// menu jízda
		JMenuItem upravit = new JMenuItem("Upravit");
		JMenuItem tridit = new JMenuItem("Setřídit");
		JMenuItem smazat = new JMenuItem("Smazat");
		JMenuItem smazatVse = new JMenuItem("Smazat vše");

		// položka v menu
		menu.add(otevrit);
		menu.add(ulozit);
		menu.add(konec);
		menu.setMnemonic(KeyEvent.VK_S);

		menu1.add(zadat);
		menu1.add(upravit);
		menu1.add(tridit);
		menu1.add(smazat);
		menu1.add(smazatVse);
		menu1.setMnemonic(KeyEvent.VK_J);

		// vložení menu do lišty
		lista.add(menu);
		lista.add(menu1);

		// přidání lišty do JFrame(ramecku)
		okno1.setJMenuBar(lista);

		// actionlistener

		otevrit.addActionListener(this);
		ulozit.addActionListener(this);
		konec.addActionListener(this);
		zadat.addActionListener(this);
		upravit.addActionListener(this);
		tridit.addActionListener(this);
		hledat.addActionListener(this);
		smazat.addActionListener(this);
		smazatVse.addActionListener(this);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new Gui();
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Otevřít")) // nacist soubor
			readFile();

		if (e.getActionCommand().equals("Uložit")) // ulozit soubor
			saveFile();

		/**
		 * ošetření tlačítka konec
		 */
		if (e.getActionCommand().equals("Konec"))
			konec();

		/**
		 * ošetření tlačítka zadat
		 */
		if (e.getActionCommand().equals("Zadat"))
			zadat();

		/**
		 * ošetření tlačítka upravit
		 */
		if (e.getActionCommand().equals("Upravit"))
			upravit();

		/**
		 * ošetření tlačítka setřídit
		 */
		if (e.getActionCommand().equals("Setřídit"))//Třízení položek
			tridit();
		/**
		 * ošetření tlačítka smazat
		 */
		if (e.getActionCommand().equals("Smazat")) // smazani polozky
			smazat();
		/**
		 * ošetření tlačítka smazat vše
		 */
		if (e.getActionCommand().equals("Smazat vše")) // smazání všeho
			smazatVse();
		/**
		 * ošetření tlačítka hledat
		 */
		if (e.getActionCommand().equals("Hledat")) // hledání
			hledat();
	}

	private void smazatVse() {
		jizdy.smazatVse();
		seznam.setListData(new String[0]);
	}

	/**
	 * Třída pro načítání souboru
	 */
	private void readFile() {
		// nacitani souboru
		JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(new java.io.File("C:\\Users\\josef\\Documents"));
		fc.setDialogTitle("Open");
		fc.setFileSelectionMode(JFileChooser.APPROVE_OPTION);
		this.jizdy = null;
		if (fc.showOpenDialog(zapisnik) == JFileChooser.APPROVE_OPTION) {

			try {
				FileInputStream fileIn = new FileInputStream(fc.getSelectedFile().getAbsolutePath());
				ObjectInputStream in = new ObjectInputStream(fileIn);
				this.jizdy = (Jizdy) in.readObject();
				in.close();
				fileIn.close();
			} catch (IOException i) {
				i.printStackTrace();
				return;
			} catch (ClassNotFoundException c) {
				System.out.println("Jizdy class not found");
				c.printStackTrace();
				return;
			}
		}

		vypisJizdy();
	}

	private void saveFile() {// ulozeni souboru

		JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(new java.io.File("C:\\Users\\josef\\Documents"));
		fc.setDialogTitle("Save");
		fc.setFileSelectionMode(JFileChooser.APPROVE_OPTION);
		if (fc.showSaveDialog(zapisnik) == JFileChooser.APPROVE_OPTION) {
			try {
				FileOutputStream fileOut = new FileOutputStream(fc.getSelectedFile().getAbsolutePath());
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				out.writeObject(this.jizdy);
				out.close();
				fileOut.close();
				JOptionPane.showMessageDialog(null, "Uloženo! ", "Informační okno", JOptionPane.INFORMATION_MESSAGE);
				System.out.printf("Serialized data is saved " + fc.getSelectedFile().getAbsolutePath());
			} catch (IOException i) {
				i.printStackTrace();
			}

		}
	}

	public void vypisJizdy()
	{

		this.vypisJizdy(null);
	}

	public void vypisJizdy(Hashtable filter) {
		seznam.setListData(jizdy.getJizdy(filter).toArray());
		celkem.setText("CELKEM   Tankováno: " + jizdy.getNatankCelk(filter)+ "litrů."+"      Najeto: "+ jizdy.getNajCelk(filter)+"km.");
	}

	/**
	 * Metoda pro zadani noveho zaznamu
	 */
	private void zadat() {
		zadat(null);
	}

	/**
	 * Metoda pro zadani záznamu
	 *
	 */
	private void zadat(Jizda upravovanaJizda) {// zadani zaznamu

		if (upravovanaJizda == null) {
			upravovanaJizda = new Jizda();
		}
		String whatTheUserEntered = JOptionPane.showInputDialog("Zadejte pořadové číslo položky:",
				upravovanaJizda.getPoradi());
		int a = Integer.valueOf(whatTheUserEntered);


		String whatTheUserEntered1 = JOptionPane.showInputDialog("Zadejte název vozidla:",
				upravovanaJizda.getVozidlo());

		String whatTheUserEntered2 = JOptionPane.showInputDialog("Zadejte množstí ujetých kilometrů:",
				upravovanaJizda.getNajeto());
		int b = Integer.valueOf(whatTheUserEntered2);
		String whatTheUserEntered3 = JOptionPane.showInputDialog("Zadejte množství tankovaných pohonných hmot:",
				upravovanaJizda.getTankovano());
		int c = Integer.valueOf(whatTheUserEntered3);

		Jizda p = new Jizda(a, whatTheUserEntered1, b, c);
		jizdy.pridat(p);
		celkemJizd++;

		this.vypisJizdy();
	}

	/**
	 * Metoda pro konec
	 *
	 */
	private void konec() {
		int g = JOptionPane.showConfirmDialog(null, "Uložili jste svou práci?\n Opravdu ukončit?", "Ukončit",
				JOptionPane.YES_NO_OPTION);
		if (g == 0) {
			System.exit(0);
		}
	}

	/**
	 * Metoda pro úpravu záznamu
	 *
	 */
	private void upravit() {// uprava zaznamu
		if (this.seznam.getSelectedIndex() > -1) {
			Jizda mazanaJizda = (Jizda) this.seznam.getSelectedValue();
			smazat();
			zadat(mazanaJizda);

		}
	}

	/**
	 * Metoda pro vyhledaní záznamu
	 * Ošetření chyb boolean
	 * @return
	 */
	private void hledat() {// String d, String a, String b, String c	//filtrování pomocí hashtable
		String filterNajeto = naj.getText(); // pole JT najeto
		String filterVozidlo = voz.getText(); // pole JT vozidlo
		String filterPoradovecislo = tl.getText(); // pole JT poř.číslo
		String filterTankovano = ta.getText(); // pole JT tankováno

		Hashtable<String, String> filter = new Hashtable<String, String>();
		filter.put("najeto", filterNajeto);
		filter.put("vozidlo", filterVozidlo);
		filter.put("poradoveCislo", filterPoradovecislo);
		filter.put("tankovano", filterTankovano);

		vypisJizdy(filter);
	}


	/**
	 * Metoda pro smazani záznamu
	 *
	 */
	private void smazat() {

		if (this.seznam.getSelectedIndex() > -1) {
			this.jizdy.smazat((Jizda) this.seznam.getSelectedValue());
			if (this.jizdy.getPocetJizd() == 0) {
				seznam.setListData(new String[0]);
			}
		}
		this.vypisJizdy();
	}

	/**
	 * Metoda pro setrizeni
	 *
	 */
	private void tridit() {
		String[] options = new String[] { "Pořadové číslo", "Vozidlo", "Najeto", "Natankováno" };
		int response = JOptionPane.showOptionDialog(null, "Vyberte, podle čeho setřídit", "Třídění",
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

		this.jizdy.getJizdy().sort(new JizdaComparator(response));
		vypisJizdy();

	}

}
