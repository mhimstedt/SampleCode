package komponenten.listen;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class FrameComboBox extends JFrame {
	
	/**
    * 
    */
   private static final long serialVersionUID = 1L;
   private Container contentPane;
   private JComboBox cbxOS;
	
	
	public FrameComboBox(String title) {
		super(title);
		
		//Komponenten erzeugen
		String[] os =  {
				 "HP-UX", "JavaOS", "Linux", "MacOS X", "MVS",
		            "OS390", "Solaris", "Windows XP", "Windows Vista"
		};
		cbxOS = new JComboBox(os);
		
		//Komponenten anordnen
		contentPane = getContentPane();
		contentPane.add(cbxOS);
		
		//Ereignisverarbeitung
		cbxOS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(cbxOS.getSelectedItem());
			}
		});
		
		cbxOS.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED)
					System.out.println("JComboBox ItemEvent: " + cbxOS.getSelectedItem()
							+ " selektiert");
				if (e.getStateChange() == ItemEvent.DESELECTED)
					System.out.println("JComboBox ItemEvent: Es wurde deselektiert");
				
			}
		});
		
		
		
	}
	
	public static void main(String[] args) {
		FrameComboBox myFrame = new FrameComboBox("Combo-Test");
		myFrame.pack();
		myFrame.setVisible(true);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
