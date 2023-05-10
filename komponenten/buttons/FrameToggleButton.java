package komponenten.buttons;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class FrameToggleButton extends JFrame {

	private Container contentPane;

	// Feld fuer Toggle-Buttons, die im Frame erscheinen sollen
	private JToggleButton toggleButtons[] = new JToggleButton[4];

	public FrameToggleButton() {

		// Komponenten erzeugen
		for (int i = 0; i < 4; i++) {
			toggleButtons[i] = new JToggleButton("Schalter " + (i + 1));
			toggleButtons[i].setFont(new Font("SansSerif", Font.ITALIC, 24));
		}
		toggleButtons[0].setSelected(true);
		toggleButtons[2].setSelected(true);

		// Komponenten anordnen
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		for (int i = 0; i < 4; i++) {
			contentPane.add(toggleButtons[i]);
		}

		// Ereignisverarbeitung
		ItemListener itemListener = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {

				// Checkboxnname ausgeben, welche (de)selektiert wurde
				if (e.getStateChange() == ItemEvent.SELECTED) {
					System.out.println(((JToggleButton) e.getSource()).getText() + " selektiert");

				} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					System.out.println(((JToggleButton) e.getSource()).getText() + " deselektiert");
				}

			}

		};

		for (int i = 0; i < 4; i++) {
			toggleButtons[i].addItemListener(itemListener);
		}

	}

	public static void main(String[] args) {
		FrameToggleButton fenster = new FrameToggleButton();
		fenster.setTitle("Frame mit Buttons");
		fenster.pack();
		fenster.setVisible(true);
		fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
