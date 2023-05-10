package komponenten.buttons;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class FrameButton extends JFrame {
	private Container contentPane;

	private JButton btnTest;

	public FrameButton(String title) {
		super(title);

		btnTest = new JButton("Drueck mich!");

		contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		contentPane.add(btnTest);

		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Der Button wurde gedrueckt!");
			}
		});

		btnTest.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				ButtonModel model = btnTest.getModel();
				System.out.println("Aenderung: " + "Armed:   " + model.isArmed() + "\n" + "Enabled: "
						+ model.isEnabled() + "\n" + "Pressed: " + model.isPressed() + "\n" + "Rollover:"
						+ model.isRollover() + "\n" + "Selected:" + model.isSelected() + "\n");

			}

		});
	}

	public static void main(String[] args) {
		JFrame frame = new FrameButton("JButton");
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
