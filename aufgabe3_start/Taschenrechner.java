package aufgabe3_start;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Taschenrechner extends JFrame {

	private JButton[] tastenfeld;
	private JTextField txtAusgabe;
//	private JLabel txtAusgabe;
	private JButton btnAddieren;
	private JButton btnMultiplizieren;
	private JButton btnDividieren;
	private JButton btnSubtrahieren;
	private JButton btnAusgabe;

	private JPanel panelTastenfeld;
	private JPanel panelAusgabe;
	private Box boxOperatoren;

	private JMenuBar menubar;
	private JMenu menuDatei;
	private JMenuItem mitemLaden;
	private JMenuItem mitemSpeichern;
	private JMenuItem mitemBeenden;

	public Taschenrechner(String titel) {
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
//		txtAusgabe = new JLabel(" ");

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

		contentPane.add(panelAusgabe, BorderLayout.PAGE_START);
		contentPane.add(panelTastenfeld);
		contentPane.add(boxOperatoren, BorderLayout.LINE_END);

		// Men� zusammenbauen
		menubar = new JMenuBar();
		menuDatei = new JMenu("Datei");
		mitemLaden = new JMenuItem("Laden");
		mitemSpeichern = new JMenuItem("Speichern");
		mitemBeenden = new JMenuItem("Beenden");

		menuDatei.add(mitemLaden);
		menuDatei.add(mitemSpeichern);
		menuDatei.add(mitemBeenden);

		menubar.add(menuDatei);

		this.setJMenuBar(menubar);

		// Ereignisverarbeitung
//		ActionListener listener = new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				txtAusgabe.setText(txtAusgabe.getText() + e.getActionCommand());
//			}
//
//		};		
		ActionListener listener = e -> {
			txtAusgabe.setText(txtAusgabe.getText() + e.getActionCommand());
		};

		for (JButton button : tastenfeld) {
			button.addActionListener(listener);
		}

		mitemBeenden.addActionListener(e -> {
			System.exit(0);
		});

	}

	public static void main(String[] args) {
		Taschenrechner mainFrame = new Taschenrechner("Taschenrechner");
		mainFrame.pack();
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
