package ereignisse.varianten;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExternerListener implements ActionListener {

	private UmrechnerApp umrechner;
	
	public ExternerListener(UmrechnerApp umrechner) {
		this.umrechner = umrechner;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String eingabe = umrechner.getTxtEingabe().getText();
		double temperaturInCelsius = Double.parseDouble(eingabe);
		double temperaturInFahrenheit = temperaturInCelsius * 9.0 / 5.0 + 32.0;
		umrechner.getTxtAusgabe().setText("" + temperaturInFahrenheit);
		
		// Eine Information des ActionEvent-Objekts ausgeben
		System.out.println(e.getActionCommand());		
	}

}
