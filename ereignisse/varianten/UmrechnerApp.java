package ereignisse.varianten;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class UmrechnerApp extends JFrame {	// implements ActionListener {	// Variante 3

	private JButton btnUmrechnen;
	private JLabel lblEingeben;
	private JTextField txtEingabe;
	private JTextField txtAusgabe;

	public UmrechnerApp() {

		lblEingeben = new JLabel("Temperatur in Celsius:");
		btnUmrechnen = new JButton("Umrechnen");
		txtEingabe = new JTextField("Wert ...");
		txtAusgabe = new JTextField("----------");

		Container contentPane = this.getContentPane();

		contentPane.add(lblEingeben);
		contentPane.add(txtEingabe);
		contentPane.add(btnUmrechnen);
		contentPane.add(txtAusgabe);
		contentPane.setLayout(new FlowLayout());

		// Variante 1 - Die Klasse selber implementiert das Interface (Bad Practice)
//		btnUmrechnen.addActionListener(this);

		// Variante 2 - Eine externe Klasse implementiert das Interface (--> besser für Wiederverwendung)
//		ExternerListener externerListener = new ExternerListener(this);
//		btnUmrechnen.addActionListener(externerListener);

		// Variante 3 - Eine innere Klasse implementiert das Interface
		InnererListener innererListener = new InnererListener();
		btnUmrechnen.addActionListener(innererListener);	

		// Variante 4 - Eine anonyme Klasse implementiert das Interface (=> kann nicht wiederverwendet werden)
//		btnUmrechnen.addActionListener(new ActionListener() {
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			String eingabe = txtEingabe.getText();
//			double temperaturInCelsius = Double.parseDouble(eingabe);
//			double temperaturInFahrenheit = temperaturInCelsius * 9.0 / 5.0 + 32.0;
//			txtAusgabe.setText("" + temperaturInFahrenheit);
//			
//			// Eine Information des ActionEvent-Objekts ausgeben
//			System.out.println(e.getActionCommand());				
//		}
//			
//		});

//		// Variante 5 - Lambda-Ausdruck
//		btnUmrechnen.addActionListener(e -> {
//			String eingabe = txtEingabe.getText();
//			double temperaturInCelsius = Double.parseDouble(eingabe);
//			double temperaturInFahrenheit = temperaturInCelsius * 9.0 / 5.0 + 32.0;
//			txtAusgabe.setText("" + temperaturInFahrenheit);
//
//			// Eine Information des ActionEvent-Objekts ausgeben
//			System.out.println(e.getActionCommand());
//		});
//		
		// Variante 5b - Lambda-Ausdruck
//		ActionListener testLambda = e -> {
//			String eingabe = txtEingabe.getText();
//			double temperaturInCelsius = Double.parseDouble(eingabe);
//			double temperaturInFahrenheit = temperaturInCelsius * 9.0 / 5.0 + 32.0;
//			txtAusgabe.setText("" + temperaturInFahrenheit);
//
//			// Eine Information des ActionEvent-Objekts ausgeben
//			System.out.println(e.getActionCommand());
//		};		
//		btnUmrechnen.addActionListener(testLambda);

	}

	// Variante 1
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		String eingabe = txtEingabe.getText();
//		double temperaturInCelsius = Double.parseDouble(eingabe);
//		double temperaturInFahrenheit = temperaturInCelsius * 9.0 / 5.0 + 32.0;
//		txtAusgabe.setText("" + temperaturInFahrenheit);
//
//		// Eine Information des ActionEvent-Objekts ausgeben
//		System.out.println(e.getActionCommand());
//	}

	// Variante 2: Zugriffsmethoden fuer den externen Listener
	public JTextField getTxtEingabe() {
		return txtEingabe;
	}

	public JTextField getTxtAusgabe() {
		return txtAusgabe;
	}

	// Variante 3
	public class InnererListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String eingabe = txtEingabe.getText();
			double temperaturInCelsius = Double.parseDouble(eingabe);
			double temperaturInFahrenheit = temperaturInCelsius * 9.0 / 5.0 + 32.0;
			txtAusgabe.setText("" + temperaturInFahrenheit);

			// Eine Information des ActionEvent-Objekts ausgeben
			System.out.println(e.getActionCommand());
		}

	}

	public static void main(String[] args) {
		UmrechnerApp umrechnerApp = new UmrechnerApp();
		umrechnerApp.setVisible(true);
		umrechnerApp.pack();
	}


}
