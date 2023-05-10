package layout;

import javax.swing.*;
import java.awt.*;


public class FrameGridBagLayout extends JFrame {
    
    //Komponenten
    private Container contentPane;
    private JButton btnEins;
    private JButton btnZwei;
    private JButton btnDrei;
    private JButton btnVier;
    private JButton btnFuenf;
    
    public FrameGridBagLayout (String title) {
        super(title);
        
        //Komponenten erzeugen
        btnEins = new JButton("Eins");
        btnZwei = new JButton("Zwei");
        btnDrei = new JButton("Drei");
        btnVier = new JButton("Vier");
 
        contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());

        //Button Eins Zeile 1 Spalte 1
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;  //Spalte
        c.gridy = 0;  //Zeile
        contentPane.add(btnEins,c);
        
        //Button Zwei Zeile 1 Spalte 2
        c = new GridBagConstraints();
        c.gridx = 1;
        contentPane.add(btnZwei,c);
       
        //Button Drei Zeile 2 Spalte 1 Breite 3 Spalten
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 3;
        c.weightx = 1.0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        contentPane.add(btnDrei, c);
        
        //Button Vier Zeile 3 Spalte 3
        c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = 2;
        c.weighty = 1.0;
        c.weightx = 1.0;
        c.fill = GridBagConstraints.BOTH;
        contentPane.add(btnVier,c);
               
    }
    
    public static void main(String argv[]) {
        FrameGridBagLayout mainFrame = new FrameGridBagLayout("Borderlayout");
        mainFrame.pack();
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
