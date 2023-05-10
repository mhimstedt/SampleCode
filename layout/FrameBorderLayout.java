package layout;

import javax.swing.*;
import java.awt.*;

public class FrameBorderLayout extends JFrame {

	// Komponenten
	private JButton btnLineStart;
	private JButton btnLineEnd;
	private JButton btnPageStart;
	private JButton btnPageEnd;
	private JButton btnCenter;

	public FrameBorderLayout(String title) {
		super(title);

		Container contentPane = getContentPane();

		// Komponenten erzeugen
		btnLineStart = new JButton("West");
		btnLineEnd = new JButton("East");
		btnPageStart = new JButton("North");
		btnPageEnd = new JButton("South");
		btnCenter = new JButton("Center");

		btnCenter.setPreferredSize(new Dimension(200, 200));

		// Komponenten anordnen
		contentPane = getContentPane();
		BorderLayout borderLayout = new BorderLayout(5,5);
//		borderLayout.setVgap(5);
//		borderLayout.setHgap(5);
		contentPane.setLayout(borderLayout); // Eigentlich �berfl�ssig, da BorderLayout voreingestellt

		contentPane.add(btnLineStart, BorderLayout.WEST);
		contentPane.add(btnLineEnd, BorderLayout.LINE_END);
		contentPane.add(btnPageEnd, BorderLayout.PAGE_END);
		contentPane.add(btnPageStart, BorderLayout.PAGE_START);
		contentPane.add(btnCenter, BorderLayout.CENTER);

	}

	public static void main(String argv[]) {
		FrameBorderLayout myFrame = new FrameBorderLayout("Borderlayout");
		myFrame.pack();
		myFrame.setVisible(true);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
