package komponenten.textfelder;

import java.awt.*;
import javax.swing.*;


public class FrameScrollText extends JFrame {
    
    private Container contentPane;            
    private JLabel lblInfo;            
    private JTextArea taTextArea;           
    private JScrollPane sp;         // ScrollPane
    
    //Konstruktor
    public FrameScrollText() {    
                     
        
        //Komponenten erzeugen
        lblInfo = new JLabel("Hier kann Text bearbeitet werden");
        
        taTextArea = new JTextArea("Lorem ipsum dolor sit amet, consectetur adipisici elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquid ex ea commodi consequat. Quis aute iure reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint obcaecat cupiditat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        taTextArea.setFont(new Font("SansSerif",Font.BOLD+Font.ITALIC,16));
        taTextArea.setLineWrap(true);        // Automatischer Zeilenumbruch
        taTextArea.setWrapStyleWord(true);   // wortweise
        
        sp = new JScrollPane(taTextArea);    // Scrollpane erzeugen
        
        
        //Komponenten anordnen
        contentPane = getContentPane();
        contentPane.add(lblInfo,BorderLayout.NORTH);
        contentPane.add(sp);
    }
    
    public static void main(String[] args) {
        FrameScrollText frame = new FrameScrollText();
        frame.setTitle("Frame mit ScrollTextArea");
        frame.setSize(250,160);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
