package layout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class JGoodiesLayout extends JFrame {

	private JPanel contentPane;
	private JTextField tWidth;
	private JTextField tHeight;
	private JComboBox cbType = new JComboBox();
	private JTextField tAddObjectName = new JTextField();
	private JSpinner spX = new JSpinner();
	private JSpinner spY = new JSpinner();	
	private JPanel pOcean = new JPanel();
	private JPanel oceanCanvas = new JPanel();
	private int oceanWidth = 800;
	private int oceanHeight = 400;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JGoodiesLayout frame = new JGoodiesLayout();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JGoodiesLayout() {

		/*
		 * Main frame
		 */
		setTitle("Ocean App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);

		/*
		 * Main panel
		 */
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(
			new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		

		/*
		 * Panel "Ocean Dimension"
		 */
		JPanel pOceanDimension = new JPanel();
		pOceanDimension.setBorder(new TitledBorder(null, "Ocean Dimension", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pOceanDimension, "2, 2, fill, fill");
		pOceanDimension.setLayout(new FormLayout(
			new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lWidth = new JLabel("Width");
		pOceanDimension.add(lWidth, "2, 2, right, default");
		
		tWidth = new JTextField();
		pOceanDimension.add(tWidth, "4, 2, fill, default");
		tWidth.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Height");
		pOceanDimension.add(lblNewLabel, "2, 4, right, default");
		
		tHeight = new JTextField();
		pOceanDimension.add(tHeight, "4, 4, fill, default");
		tHeight.setColumns(10);
		
		JButton bSetOceanDimension = new JButton("OK");
		pOceanDimension.add(bSetOceanDimension, "4, 6, left, default");

		
		/*
		 * Panel "Add Ocean Object"
		 */
		JPanel pAddOceanObject = new JPanel();
		pAddOceanObject.setBorder(BorderFactory.createTitledBorder("Add Ocean Object"));
		contentPane.add(pAddOceanObject, "4, 2, fill, fill");
		pAddOceanObject.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));

		JLabel lType = new JLabel("Type");
		pAddOceanObject.add(lType, "2, 2, right, default");

		pAddOceanObject.add(cbType, "4, 2");

		JLabel lX = new JLabel("X");
		pAddOceanObject.add(lX, "6, 2, right, default");

		spX.setModel(new SpinnerNumberModel(oceanWidth / 2, 0, oceanWidth, 1));
		pAddOceanObject.add(spX, "8, 2");

		JLabel lName = new JLabel("Name");
		pAddOceanObject.add(lName, "2, 4, right, default");

		pAddOceanObject.add(tAddObjectName, "4, 4");
		tAddObjectName.setColumns(10);

		JLabel lY = new JLabel("Y");
		pAddOceanObject.add(lY, "6, 4");

		spY.setModel(new SpinnerNumberModel(oceanHeight / 2, 0, oceanHeight, 1));
		pAddOceanObject.add(spY, "8, 4");

		JButton bAddObject = new JButton("Add");
		pAddOceanObject.add(bAddObject, "4, 6, left, default");

		contentPane.add(pOcean, "2, 6, 9, 1, left, top");
		pOcean.add(oceanCanvas);
		
		oceanCanvas.setBackground(Color.blue);
		oceanCanvas.setPreferredSize(new Dimension(oceanWidth, oceanHeight));
				
	}

}
