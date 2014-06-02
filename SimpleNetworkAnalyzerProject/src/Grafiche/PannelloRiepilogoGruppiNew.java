package Grafiche;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PannelloRiepilogoGruppiNew extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PannelloRiepilogoGruppiNew frame = new PannelloRiepilogoGruppiNew();
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
	public PannelloRiepilogoGruppiNew() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("68px:grow"),
				ColumnSpec.decode("114px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("92px"),},
			new RowSpec[] {
				RowSpec.decode("29px"),
				RowSpec.decode("29px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JComboBox comboBox = new JComboBox();
		contentPane.add(comboBox, "1, 2, fill, center");
		
		JButton btnCarica = new JButton("Carica");
		contentPane.add(btnCarica, "2, 2, fill, top");
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "1, 6, 4, 1, fill, fill");
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
	}
}
