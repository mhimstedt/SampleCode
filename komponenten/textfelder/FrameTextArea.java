package komponenten.textfelder;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class FrameTextArea extends JFrame {
    
    private Container contentPane;            
    private JLabel lblInfo;           
    private JTextArea taTextArea;            
    
    //Konstruktor
    public FrameTextArea() {    
                     
        //Komponenten erzeugen
        lblInfo = new JLabel("Hier kann Text bearbeitet werden");
        
        taTextArea = new JTextArea("Lorem ipsum ollit anim id est laborum.");
        taTextArea.setFont(new Font("SansSerif",Font.BOLD+Font.ITALIC,16));
        taTextArea.setLineWrap(true);  // Automatischen Umbruch aktivieren
        taTextArea.setWrapStyleWord(true);
        
        //Komponenten anordnen
        contentPane = getContentPane();
        contentPane.add(lblInfo,BorderLayout.NORTH);
        contentPane.add(taTextArea);
        
        taTextArea.addCaretListener( new CaretListener() {
        	public void caretUpdate(CaretEvent e) {
        		System.out.println("Cursor hat position verändert!"+ e);		
        	}
        });
        
        taTextArea.addKeyListener(new KeyAdapter() {
        	public void keyTyped(KeyEvent e) {
        		System.out.println("Key-Event:" + e.getKeyChar());
        	}
        });
        
        
    }
    
    public static void main(String[] args) {
        FrameTextArea frame = new FrameTextArea();
        frame.setTitle("Frame mit TextArea");
        frame.setSize(200,160);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
