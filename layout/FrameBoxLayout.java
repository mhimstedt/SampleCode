package layout;


import javax.swing.*;
import java.awt.*;


public class FrameBoxLayout extends JFrame {
    
    //Komponenten
    
    private JButton btnEins;
    private JButton btnZwei;
    private JButton btnDrei;
    private JButton btnVier;
   
    
    private Container contentPane;
    
    public FrameBoxLayout(String title) {
        super(title);
        
        //Komponenten erzeugen
        btnEins = new JButton("Eins");
        btnZwei = new JButton("Zwei");
        btnDrei = new JButton("Drei");
        btnVier = new JButton("Vier");
        
        Box box = Box.createHorizontalBox();
               
        box.add(btnEins);
        box.add(btnZwei);
        box.add(Box.createHorizontalStrut(20));  //Abstand zwischen Button 3 und 4 (fix)
        box.add(btnVier);
        box.add(Box.createHorizontalGlue()); //Dehnbarer Zwischenraum
        box.add(btnDrei);
        
        contentPane = this.getContentPane();
        contentPane.add(box);

        // Ohne Verwendung des Containers 'Box'
//        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
//        contentPane.add(btnEins);
//        contentPane.add(btnZwei);
//        contentPane.add(Box.createHorizontalStrut(20));
//        contentPane.add(btnVier);
//        contentPane.add(Box.createHorizontalGlue()); //Dehnbarer Zwischenraum
//        contentPane.add(btnDrei);
        
    }
    
    public static void main(String argv[]) {
        FrameBoxLayout myFrame = new FrameBoxLayout("Borderlayout");
        myFrame.pack();
        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
