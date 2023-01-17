package frames;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Citizen;
//import model.MartialStatus;
import model.TownHall;

import javax.swing.JLabel;
//import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class PersonsListFrame extends JFrame {

	private JPanel contentPane;

	TownHall townHall;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		PersonsListFrame frame = new PersonsListFrame(null);
		frame.setVisible(true);

	}

	/**
	 * Create the frame.
	 */
	public PersonsListFrame(TownHall townHall) {
		this.townHall = townHall;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 659, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Persons List");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(269, 11, 162, 53);
		contentPane.add(lblNewLabel);

		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame frame = new MainFrame(townHall);
				frame.setVisible(true);
				dispose();
			}
		});
		btnHome.setBounds(292, 373, 124, 44);
		contentPane.add(btnHome);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 95, 546, 246);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Lastname", "Firstname", "Gender", "DOB", "Status", "Sp Lastname", "Sp Firstname" }));
		scrollPane.setViewportView(table);

		LoadData();
	}

	private void LoadData() {

		DefaultTableModel model = (DefaultTableModel) table.getModel();

		for (Citizen c1 : townHall.getPersonsList()) {

			Citizen c2 = townHall.getPerson(c1.getSpouseIDNumber());

			Object[] object = null;

			if (c2 == null) {
				object = new Object[] { c1.getLastName(), c1.getFirstName(), c1.getSex(), c1.getDateOfBirthDate(),
						c1.getMartialStatus(), "", "" };
			} else {
				object = new Object[] { c1.getLastName(), c1.getFirstName(), c1.getSex(), c1.getDateOfBirthDate(),
						c1.getMartialStatus(), c2.getLastName(), c2.getFirstName() };
			}

			model.addRow(object);
		}

	}
}
