package ereignisse.adapter;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class FrameWithMouseEvent extends JFrame {
	private JButton btnTest;
	private JTextField txtTest;

	public FrameWithMouseEvent(String title) {
		super(title);

		btnTest = new JButton("Drueck mich!");
		txtTest = new JTextField(20);

		Container contentPane;
		contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		contentPane.add(btnTest);
		contentPane.add(txtTest);

		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Der Button wurde gedrueckt!");
			}
		});
		
//		btnTest.addMouseListener(new MouseListener() {
//
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				System.out.println("Ein Mouse Entered-Event!");
//			}
//
//			@Override
//			public void mouseExited(MouseEvent e) {
//				System.out.println("Ein Mouse Exited-Event!");
//			}
//
//			@Override
//			public void mouseClicked(MouseEvent e) {}
//
//			@Override
//			public void mousePressed(MouseEvent e) {}
//
//			@Override
//			public void mouseReleased(MouseEvent e) {}
//			
//		});

		// Einfacher ueber entsprechende Adapter-Klasse (==> Mouse-Adapter ist Klasse, kein Interface mehr)
		btnTest.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("Ein Mouse Entered-Event!");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("Ein Mouse Exited-Event!");
			}
			
		});
		
		// tastatur-eingaben abfangen
		
		txtTest.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				System.out.println("Taste gedrueckt: " + e.getKeyChar());
			}

			@Override
			public void keyPressed(KeyEvent e) {}

			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println("Taste losgelassen: " + e.getKeyChar());
			}
			
		});
		
	}

	public static void main(String[] args) {
		JFrame myframe = new FrameWithMouseEvent("Ereignisberarbeitung");
		myframe.setVisible(true);
		myframe.pack();
		myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
