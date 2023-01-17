package frames;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Citizen;
import model.MartialStatus;
import model.TownHall;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AddCitizenFrame extends JFrame {

	private JPanel contentPane;

	TownHall townHall;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;

	JComboBox<String> gendercombobox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		AddCitizenFrame frame = new AddCitizenFrame(null);
		frame.setVisible(true);

	}

	/**
	 * Create the frame.
	 */
	public AddCitizenFrame(TownHall townHall) {
		this.townHall = townHall;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 659, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Person Details");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(240, 11, 216, 53);
		contentPane.add(lblNewLabel);

		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame frame = new MainFrame(townHall);
				frame.setVisible(true);
				dispose();
			}
		});
		btnHome.setBounds(144, 368, 124, 44);
		contentPane.add(btnHome);

		JButton btnDone = new JButton("Add");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					int pID = Integer.parseInt(textField.getText());

					Citizen p1 = townHall.getPerson(pID);

					if (p1 != null) {
						JOptionPane.showMessageDialog(null, "Person ID already exist!");
					} else {

						Citizen p2 = new Citizen();

						p2.setCitizenID(pID);
						p2.setLastName(textField_1.getText());
						p2.setFirstName(textField_2.getText());
						p2.setDateOfBirthDate(LocalDate.parse(textField_4.getText()));
						p2.setSex(gendercombobox.getSelectedItem().toString());

						p2.setMartialStatus(MartialStatus.single);
						p2.setSpouseIDNumber(-1);
						
						townHall.addCitizen(p2);

						JOptionPane.showMessageDialog(null, "Successfull");
					}

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Invalid Data");
				}

			}
		});
		btnDone.setBounds(355, 368, 124, 44);
		contentPane.add(btnDone);

		JLabel lblNewLabel_1 = new JLabel("Person ID:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(172, 88, 96, 35);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(302, 88, 124, 35);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Lastname:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(172, 134, 96, 35);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Firstname:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(172, 180, 96, 35);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Sex:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(172, 226, 96, 35);
		contentPane.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("Date of birth:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4.setBounds(172, 272, 96, 35);
		contentPane.add(lblNewLabel_1_4);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(302, 134, 124, 35);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(302, 180, 124, 35);
		contentPane.add(textField_2);

		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_4.setColumns(10);
		textField_4.setBounds(302, 272, 124, 35);
		contentPane.add(textField_4);

		JLabel lblNewLabel_1_4_1 = new JLabel("(YYYY-MM-DD)");
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4_1.setBounds(458, 272, 135, 35);
		contentPane.add(lblNewLabel_1_4_1);

		gendercombobox = new JComboBox<String>();
		gendercombobox.setModel(new DefaultComboBoxModel<String>(new String[] { "Male", "Female" }));
		gendercombobox.setBounds(302, 226, 124, 30);
		contentPane.add(gendercombobox);
	}
}
