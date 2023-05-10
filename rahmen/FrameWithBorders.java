package rahmen;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import java.awt.*;

public class FrameWithBorders extends JFrame {

	// Komponenten
	private JLabel lblEins;
	private JLabel lblZwei;
	private JLabel lblDrei;
	private JLabel lblVier;

	private Container contentPane;

	public FrameWithBorders(String title) {
		super(title);

		// Komponenten erzeugen
		lblEins = new JLabel("Eins");
		lblZwei = new JLabel("Zwei");
		lblDrei = new JLabel("Drei");
		lblVier = new JLabel("Vier");
		
		Box box = Box.createHorizontalBox();
		box.add(lblEins);
		box.add(Box.createHorizontalStrut(20));
		box.add(lblZwei);
		box.add(Box.createHorizontalStrut(20));
		box.add(lblDrei);
		box.add(Box.createHorizontalStrut(20));
		box.add(lblVier);
		
		box.setBorder(BorderFactory.createEtchedBorder());
		
		lblEins.setBorder(BorderFactory.createRaisedBevelBorder());
		lblZwei.setBorder(BorderFactory.createLoweredBevelBorder());
		lblDrei.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED), "Test"));
		lblVier.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));

		contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		contentPane.add(box);
	}

	public static void main(String argv[]) {
		FrameWithBorders myFrame = new FrameWithBorders("Borderlayout");
		myFrame.pack();
		myFrame.setVisible(true);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
