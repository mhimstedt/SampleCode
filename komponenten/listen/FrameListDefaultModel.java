package komponenten.listen;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class FrameListDefaultModel extends JFrame {
	
	//Komponenten
    private JList<String> lstLeft;
    private JList<String> lstRight;
    private Container contentPane;

    //Model
    private DefaultListModel<String> modelLeft;
    private DefaultListModel<String> modelRight;


    public FrameListDefaultModel(String title) {
        super(title);
        
        String[] os = {
                "Windows Vista", "Suse 11.0", "Windows XP", "Windows 2000", "MacOS X",
                "Solaris"
            };

        //Komponenten erzeugen
        lstLeft = new JList<>();
        lstLeft.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lstRight = new JList<>();
        
        contentPane = getContentPane();
    
        //Komponenten anordnen 
        JScrollPane lScrollPane = new JScrollPane(lstLeft);
        lScrollPane.setPreferredSize(new Dimension(90,100));
        contentPane.add(lScrollPane, BorderLayout.WEST);
        
        JScrollPane rScrollPane = new JScrollPane(lstRight);
        rScrollPane.setPreferredSize(new Dimension(90,100));
		contentPane.add(rScrollPane, BorderLayout.EAST);

        //Model erzeugen 
        modelLeft = new DefaultListModel<>();
        for (int i = 0; i < os.length; i++)
            modelLeft.add(0, os[i]);
        modelRight = new DefaultListModel<>();
        
        //Model mit View verbinden
        lstLeft.setModel(modelLeft);
        lstRight.setModel(modelRight);
        
        
        //Ereignisverarbeitung
        lstLeft.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!lstLeft.isSelectionEmpty()) {
                    int i = lstLeft.getMinSelectionIndex();
                    String obj = modelLeft.remove(i);
                    modelRight.add(0, obj);
                }
            }
        });

        lstRight.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!lstRight.isSelectionEmpty()) {
                    int i = lstRight.getMinSelectionIndex();
                    String obj = modelRight.remove(i);
                    modelLeft.add(0, obj);
                }
            }
        });

    }
    public static void main(String[] args) {
        FrameListDefaultModel frame = new FrameListDefaultModel("Listen-Modifikation");
        frame.setSize(200, 220);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
