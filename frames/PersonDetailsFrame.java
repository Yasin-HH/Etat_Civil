package frames;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Citizen;
//import model.MartialStatus;
import model.TownHall;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class PersonDetailsFrame extends JFrame {

	private JPanel contentPane;

	TownHall townHall;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		PersonDetailsFrame frame = new PersonDetailsFrame(null);
		frame.setVisible(true);

	}

	/**
	 * Create the frame.
	 */
	public PersonDetailsFrame(TownHall townHall) {
		this.townHall = townHall;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 659, 534);
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
		btnHome.setBounds(28, 440, 124, 44);
		contentPane.add(btnHome);

		JButton btnDone = new JButton("Search");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					int pID = Integer.parseInt(textField.getText());

					Citizen p1 = townHall.getPerson(pID);

					if (p1 == null) {
						JOptionPane.showMessageDialog(null, "Person does not exist!");
					} else {

						Citizen p2 = townHall.getPerson(p1.getSpouseIDNumber());

						textField_1.setText(p1.getLastName());
						textField_2.setText(p1.getFirstName());
						textField_3.setText(p1.getSex());
						textField_4.setText(p1.getDateOfBirthDate().toString());
						textField_5.setText(p1.getMartialStatus().toString());
						textField_6.setText("");
						textField_7.setText("");

						if (p2 != null) {

							textField_6.setText(p2.getLastName());
							textField_7.setText(p2.getFirstName());
						}

					}

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Invalid ID");
				}

			}
		});
		btnDone.setBounds(475, 85, 124, 44);
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

		JLabel lblNewLabel_1_5 = new JLabel("Spouse Lastname:");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_5.setBounds(172, 364, 130, 35);
		contentPane.add(lblNewLabel_1_5);

		JLabel lblNewLabel_1_6 = new JLabel("Spouse Firstname:");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_6.setBounds(172, 410, 130, 35);
		contentPane.add(lblNewLabel_1_6);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(302, 134, 124, 35);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(302, 180, 124, 35);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(302, 226, 124, 35);
		contentPane.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_4.setColumns(10);
		textField_4.setBounds(302, 272, 124, 35);
		contentPane.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_5.setColumns(10);
		textField_5.setBounds(302, 318, 124, 35);
		contentPane.add(textField_5);

		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_6.setColumns(10);
		textField_6.setBounds(302, 364, 124, 35);
		contentPane.add(textField_6);

		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(302, 410, 124, 35);
		contentPane.add(textField_7);

		JLabel lblNewLabel_1_3_1 = new JLabel("Martial Status:");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3_1.setBounds(172, 318, 96, 35);
		contentPane.add(lblNewLabel_1_3_1);
	}
}
