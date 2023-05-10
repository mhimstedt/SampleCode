package komponenten.buttons;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class FrameRadioButton extends JFrame {

	private Container contentPane;

	// Feld fuer Radio-Buttons, die im Frame erscheinen sollen
	private JRadioButton radioButtons[] = new JRadioButton[4];

	// Konstruktor
	public FrameRadioButton() {

		// Gruppe erzeugen
		ButtonGroup bg = new ButtonGroup();

		// Komponenten erzeugen
		for (int i = 0; i < 4; i++) {
			radioButtons[i] = new JRadioButton("Box " + (i + 1));
			bg.add(radioButtons[i]); // der Gruppe hinzufuegen
		}

		// Komponenten anordnen
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		for (int i = 0; i < 4; i++)
			contentPane.add(radioButtons[i]);

		// Ereignisverarbeitung
		ItemListener itemListener = new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {

					// Buttonname ausgeben, welcher (de)selektiert wurde
					// Komplizierter
//					for (int i = 0; i < radioButtons.length; i++) {
//						if (radioButtons[i].isSelected()) {
//							System.out.println(radioButtons[i].getText());
//						}
//					}

					// Einfacher
					System.out.println(((JRadioButton) e.getSource()).getText() + " selektiert");

				} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					System.out.println(((JRadioButton) e.getSource()).getText() + " deselektiert");
				}
			}

		};

		for (int i = 0; i < radioButtons.length; i++) {
			radioButtons[i].addItemListener(itemListener);
		}

	}

	public static void main(String[] args) {
		FrameRadioButton frame = new FrameRadioButton();
		frame.setTitle("Frame mit RadioButtons");
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
