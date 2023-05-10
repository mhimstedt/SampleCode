package ereignisse.keyEvents;

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

		// 1. Schnittstelle KeyListener
//		KeyListener keyListener = new KeyAdapter() {
//			@Override
//			public void keyPressed(KeyEvent e) {
//				txtAusgabe.setText(txtAusgabe.getText() + e.getKeyChar());
//			}
//		};
//
//		txtAusgabe.addKeyListener(keyListener);
	    	  
		// 1. Methode registerKeyboardAction
		// This method is now obsolete, please use a combination of getActionMap() and getInputMap() for similar behavior - see below.
//		ActionListener myAction = new ActionListener() {	    	
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				txtAusgabe.setText(txtAusgabe.getText() + e.getActionCommand());
//			}
//	    }; 
//		for(int i = 0; i < 10; i++)
//		    txtAusgabe.registerKeyboardAction(myAction, String.valueOf(i), KeyStroke.getKeyStroke("typed " + i), JComponent.WHEN_IN_FOCUSED_WINDOW);
		
	    // 3. Methoden getActionMap(), getInputMap()
		AbstractAction myActionNum = new AbstractAction() {	    	
			@Override
			public void actionPerformed(ActionEvent e) {
				txtAusgabe.setText(txtAusgabe.getText() + e.getActionCommand());
			}
	    }; 
	    for(int i = 0; i < 10; i++) {
		    txtAusgabe.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("typed " + i), "key num");		    
		    txtAusgabe.getActionMap().put("key num", myActionNum);		
	    }
	    
		AbstractAction myActionDel = new AbstractAction() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				String txt = txtAusgabe.getText();
				txtAusgabe.setText( txt.length() > 0 ? txt.substring(0, txt.length() - 1) : "");
			}
	    }; 
	    
	    // Addition: Delete key functionality
	    txtAusgabe.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(8, 0), "key del");
	    txtAusgabe.getActionMap().put("key del", myActionDel);
	    
	}

	public static void main(String[] args) {
		Taschenrechner mainFrame = new Taschenrechner("Taschenrechner");
		mainFrame.pack();
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
