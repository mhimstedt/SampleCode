package windowbuilder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BeispielWindowBuilder {

	private JFrame frame;
	private JTextField textField;
	private final JButton btnNewButton_1 = new JButton("New button");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BeispielWindowBuilder window = new BeispielWindowBuilder();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BeispielWindowBuilder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 771, 596);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelNorth = new JPanel();
		frame.getContentPane().add(panelNorth, BorderLayout.NORTH);
		
		textField = new JTextField();
		panelNorth.add(textField);
		textField.setColumns(10);
		
		JPanel panelCenter = new JPanel();
		frame.getContentPane().add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new GridLayout(4, 3, 0, 0));
		
		JButton btnNewButton = new JButton("New button");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panelCenter.add(btnNewButton);
		panelCenter.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		panelCenter.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		panelCenter.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		panelCenter.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("New button");
		panelCenter.add(btnNewButton_5);
	}

}
