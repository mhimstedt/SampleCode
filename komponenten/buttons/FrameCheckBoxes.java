package komponenten.buttons;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FrameCheckBoxes extends JFrame {

	private Container contentPane;

	// Feld fuer Check-Boxes, die im Fenster erscheinen sollen
	private JCheckBox checkBoxes[] = new JCheckBox[4];

	// Konstruktor
	public FrameCheckBoxes() {
		// Komponenten erzeugen
		for (int i = 0; i < 4; i++)
			checkBoxes[i] = new JCheckBox("Box " + (i + 1));

		checkBoxes[0].setSelected(true);
		checkBoxes[2].setSelected(true);

		// Komponenten anordnen
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		for (int i = 0; i < 4; i++) {
			contentPane.add(checkBoxes[i]);
//			this.add(checkBoxes[i]); // einfacher
		}

		// Ereignisverarbeitung
		ItemListener itemListener = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {

				// Checkboxnname ausgeben, welche (de)selektiert wurde
				if (e.getStateChange() == ItemEvent.SELECTED) {
					System.out.println(((JCheckBox) e.getSource()).getText() + " selektiert");

				} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					System.out.println(((JCheckBox) e.getSource()).getText() + " deselektiert");
				}

			}

		};

		for (int i = 0; i < 4; i++) {
			checkBoxes[i].addItemListener(itemListener);
		}

	}

	public static void main(String[] args) {
		FrameCheckBoxes frame = new FrameCheckBoxes();
		frame.setTitle("Frame mit CheckBoxes");
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
