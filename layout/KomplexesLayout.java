package layout;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.*;

public class KomplexesLayout extends JFrame {

	private JButton[] tastenfeld;
	private JTextField txtAusgabe;
	private JButton btnAddieren;
	private JButton btnMultiplizieren;
	private JButton btnDividieren;
	private JButton btnSubtrahieren;
	private JButton btnAusgabe;

	private JPanel panelTastenfeld;
	private JPanel panelAusgabe;
	private Box boxOperatoren;

	public KomplexesLayout(String titel) {
		super(titel);

		Container contentPane = getContentPane();

		// Komponenten erzeugen
		tastenfeld = new JButton[10];
		for (int i = 9; i >= 0; i--) {
			tastenfeld[i] = new JButton("" + i);
		}

		btnAddieren = new JButton("+");
		btnMultiplizieren = new JButton("*");
		btnSubtrahieren = new JButton("-");
		btnDividieren = new JButton("/");
		btnAusgabe = new JButton("=");
		txtAusgabe = new JTextField(20);

		panelTastenfeld = new JPanel();
		panelAusgabe = new JPanel();
		boxOperatoren = Box.createVerticalBox();

		// Layout
		panelTastenfeld.setLayout(new GridLayout(4, 3, 3, 3));

		for (int i = 9; i >= 0; i--) {
			panelTastenfeld.add(tastenfeld[i]);
		}

		panelAusgabe.add(txtAusgabe);

		boxOperatoren.add(btnAddieren);
		boxOperatoren.add(btnSubtrahieren);
		boxOperatoren.add(btnMultiplizieren);
		boxOperatoren.add(btnDividieren);
		boxOperatoren.add(Box.createVerticalStrut(20));
		boxOperatoren.add(btnAusgabe);

		contentPane.add(panelAusgabe, BorderLayout.NORTH);
		contentPane.add(panelTastenfeld, BorderLayout.CENTER);
		contentPane.add(boxOperatoren, BorderLayout.EAST);
	}

	public static void main(String[] args) {
		KomplexesLayout mainFrame = new KomplexesLayout("Taschenrechner");
		mainFrame.pack();
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
