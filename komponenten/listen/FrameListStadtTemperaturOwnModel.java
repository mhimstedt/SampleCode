package komponenten.listen;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class FrameListStadtTemperaturOwnModel extends JFrame {

	// Komponenten
	private JList<StadtTemperatur> lstLeft;
	private JList<StadtTemperatur> lstRight;
	private Container contentPane;

	// Model
	private StadtTemperaturModel modelLeft;
	private StadtTemperaturModel modelRight;

	public FrameListStadtTemperaturOwnModel() {

		modelLeft = new StadtTemperaturModel();
		modelLeft.add(new StadtTemperatur("Flensburg", 5.0, 14.0, 13.0));
		modelLeft.add(new StadtTemperatur("Kiel", 5.5, 16.0, 12.5));
		modelLeft.add(new StadtTemperatur("Hamburg", 4.0, 17.0, 13.5));

		// Komponenten erzeugen
		lstLeft = new JList<>();
		lstRight = new JList<>();

		contentPane = getContentPane();

		JScrollPane lScrollPane = new JScrollPane(lstLeft);
		lScrollPane.setPreferredSize(new Dimension(110, 100));
		contentPane.add(lScrollPane, BorderLayout.WEST);

		JScrollPane rScrollPane = new JScrollPane(lstRight);
		rScrollPane.setPreferredSize(new Dimension(110, 100));
		contentPane.add(rScrollPane, BorderLayout.EAST);

		modelRight = new StadtTemperaturModel();

		lstLeft.setModel(modelLeft);
		lstRight.setModel(modelRight);

		// Ereignisverarbeitung
		lstLeft.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				System.out.println("ListSelectionEvent");
				if (e.getValueIsAdjusting())
					return;
				if (!lstLeft.isSelectionEmpty()) {
					int index = lstLeft.getSelectedIndex();
					StadtTemperatur obj = modelLeft.remove(index);
					modelRight.add(obj);
				}
				lstLeft.setSelectedIndices(new int[0]);

			}

		});

		lstRight.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				System.out.println("ListSelectionEvent");
				if (e.getValueIsAdjusting())
					return;
				if (!lstRight.isSelectionEmpty()) {
					int index = lstRight.getSelectedIndex();
					StadtTemperatur obj = modelRight.remove(index);
					modelLeft.add(obj);
				}
				lstRight.setSelectedIndices(new int[0]);

			}

		});

	}

	public static void main(String[] args) {
		FrameListStadtTemperaturOwnModel myFrame = new FrameListStadtTemperaturOwnModel();
		myFrame.pack();
		myFrame.setVisible(true);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
