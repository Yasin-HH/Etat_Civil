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

public class BirthFrame extends JFrame {

	private JPanel contentPane;

	TownHall townHall;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		BirthFrame frame = new BirthFrame(null);
		frame.setVisible(true);

	}

	/**
	 * Create the frame.
	 */
	public BirthFrame(TownHall townHall) {
		this.townHall = townHall;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 659, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Birth");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(286, 11, 124, 53);
		contentPane.add(lblNewLabel);

		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame frame = new MainFrame(townHall);
				frame.setVisible(true);
				dispose();
			}
		});
		btnHome.setBounds(153, 301, 124, 44);
		contentPane.add(btnHome);

		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					int p1ID = Integer.parseInt(textField.getText());
					LocalDate date = LocalDate.parse(textField_1.getText());

					Citizen p1 = townHall.getPerson(p1ID);

					if (p1 == null) {
						JOptionPane.showMessageDialog(null, "Person does not exist!");
					} else if (p1.getMartialStatus() != MartialStatus.married) {
						JOptionPane.showMessageDialog(null, "Person1 is not married!");
					} else {

						townHall.addBirth(p1, date);
						JOptionPane.showMessageDialog(null, "Successfull!");
					}

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Invalid ID or Date");
				}

			}
		});
		btnDone.setBounds(369, 301, 124, 44);
		contentPane.add(btnDone);

		JLabel lblNewLabel_1 = new JLabel("Parent ID:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(153, 127, 96, 35);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Birth Date (YYYY-MM-DD)");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(153, 186, 179, 35);
		contentPane.add(lblNewLabel_1_1);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(342, 127, 151, 35);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(342, 186, 151, 35);
		contentPane.add(textField_1);
	}
}
