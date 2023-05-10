package menu;
// MenueTest.java

import javax.swing.*;

public class MenuDemo {

	public static void main(String[] args) {
			
        //Menueleiste erzeugen
		JMenuBar mbar = new JMenuBar(); 
		//Menues erzeugen
		JMenu edit = new JMenu("Edit"); 
		JMenu opt = new JMenu("Einstellungen");
		JMenu all = new JMenu("Allgemeine Einstellungen");
		
		//Menuepunkte erzeugen
		JMenuItem cut = new JMenuItem("Ausschneiden"),
		copy = new JMenuItem("Kopieren", new ImageIcon("copy.gif")),
		paste = new JMenuItem("Einfuegen", new ImageIcon("paste.gif")),
		hilfe = new JMenuItem("Hilfe bei erweiterten Befehlen"),
		fehler = new JMenuItem("Debuggen bei Fehler"),
		sichern = new JMenuItem("Einstellungen sichern"),
		ro = new JCheckBoxMenuItem("Read only");
		
		//... und alles zusammenbauen
		edit.add(cut);
		edit.add(copy);
		edit.add(paste);
		all.add(hilfe);
		all.add(fehler);
		opt.add(ro);
		opt.add(all);
		opt.addSeparator();
		opt.add(sichern);
		
		mbar.add(edit);
		mbar.add(opt);
		
		JFrame f = new JFrame("Menue-Test");
		f.setSize(300, 200);
		f.setJMenuBar(mbar);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
