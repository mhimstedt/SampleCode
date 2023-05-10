package aufgabe1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class UmrechnerApp extends JFrame {

	private JButton btnNachFahrenheit;
	private JButton btnNachCelsius;

	private JLabel lblCelsius;
	private JLabel lblFahrenheit;

	private JTextField txtCelsius;
	private JTextField txtFahrenheit;

	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;

	public UmrechnerApp() {

		lblCelsius = new JLabel("Celsius");
		lblFahrenheit = new JLabel("Fahrenheit");
		btnNachFahrenheit = new JButton("nach Fahrenheit");
		btnNachCelsius = new JButton("nach Celsius");
		txtCelsius = new JTextField(10);
		txtFahrenheit = new JTextField(10);

		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();

		Container contentPane = this.getContentPane();

		panel1.add(txtCelsius);
		panel1.add(lblCelsius);

		panel2.add(btnNachFahrenheit);
		panel2.add(btnNachCelsius);
		panel2.setLayout(new GridLayout(2, 1, 3, 3));

		panel3.add(txtFahrenheit);
		panel3.add(lblFahrenheit);

		contentPane.add(panel1, BorderLayout.NORTH);
		contentPane.add(panel2);
		contentPane.add(panel3, BorderLayout.SOUTH);

		// Setzen des Layoutmanagers
		// contentPane.setLayout(new BorderLayout());

		// Ereignisverarbeitung
		btnNachFahrenheit.addActionListener(e -> {
			String eingabe = txtCelsius.getText();
			double temperaturInCelsius = Double.parseDouble(eingabe);
			double temperaturInFahrenheit = temperaturInCelsius * 9.0 / 5.0 + 32.0;
			txtFahrenheit.setText("" + temperaturInFahrenheit);

		});

		btnNachCelsius.addActionListener(e -> {
			String eingabe = txtFahrenheit.getText();
			double temperaturInFahrenheit = Double.parseDouble(eingabe);
			double temperaturInCelsius = (temperaturInFahrenheit - 32.0) * 5.0 / 9.0;
			txtCelsius.setText("" + temperaturInCelsius);

		});

	}

	public static void main(String[] args) {
		UmrechnerApp umrechnerApp = new UmrechnerApp();
		umrechnerApp.setVisible(true);
		umrechnerApp.pack();
	}

}
