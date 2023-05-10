package komponenten.textfelder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class FrameTextFields extends JFrame {
    
    private Container contentPane;            
    private JLabel lblName, lblPasswd;    
    private JTextField txtName;          
    private JPasswordField pwfPassword;      
    
   
    public FrameTextFields() 
    {    

        // Komponenten erzeugen
        lblName = new JLabel("Name:",JLabel.RIGHT);
        lblPasswd = new JLabel("Passwort:",JLabel.RIGHT);
        txtName = new JTextField();
        pwfPassword = new JPasswordField();
        
        //Schriftart setzen
        Font schrift = new Font("SansSerif",Font.BOLD,18);
        lblName.setFont(schrift);
        lblPasswd.setFont(schrift);
        txtName.setFont(schrift);
        pwfPassword.setFont(schrift);
        
        //Komponenten anordnen
        contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(2,2)); 
        contentPane.add(lblName);
        contentPane.add(txtName);
        contentPane.add(lblPasswd);
        contentPane.add(pwfPassword);
        
        //Ereignisverarbeitung
        txtName.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Eingegebener Text: " + txtName.getText());
				pwfPassword.requestFocusInWindow();
				
				
			}});
        
        pwfPassword.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Passwort:" + pwfPassword.getText() + " " + new String(pwfPassword.getPassword()));
				
			}
        	
        });
    }
    
    public static void main(String[] args) {
        FrameTextFields frame = new FrameTextFields();
        frame.setTitle("Frame mit Textfeldern");
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
