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
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class MarriageFrame extends JFrame {

	private JPanel contentPane;

	TownHall townHall;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		MarriageFrame frame = new MarriageFrame(null);
		frame.setVisible(true);

	}

	/**
	 * Create the frame.
	 */
	public MarriageFrame(TownHall townHall) {
		this.townHall = townHall;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 659, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Marriage");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(269, 11, 124, 53);
		contentPane.add(lblNewLabel);

		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame frame = new MainFrame(townHall);
				frame.setVisible(true);
				dispose();
			}
		});
		btnHome.setBounds(156, 301, 124, 44);
		contentPane.add(btnHome);

		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					int p1ID = Integer.parseInt(textField.getText());
					int p2ID = Integer.parseInt(textField_1.getText());

					Citizen p1 = townHall.getPerson(p1ID);
					Citizen p2 = townHall.getPerson(p2ID);

					if (p1 == null) {
						JOptionPane.showMessageDialog(null, "Person1 does not exist!");
					} else if (p2 == null) {
						JOptionPane.showMessageDialog(null, "Person2 does not exist!");
					} else if (p1.getMartialStatus() == MartialStatus.married) {
						JOptionPane.showMessageDialog(null, "Person1 is already married!");
					} else if (p2.getMartialStatus() == MartialStatus.married) {
						JOptionPane.showMessageDialog(null, "Person2 is already married!");
					} else {

						townHall.addMarriage(p1ID, p2ID);
						JOptionPane.showMessageDialog(null, p1.getFirstName() + " is married to " + p2.getFirstName());
					}

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Invalid IDs");
				}

			}
		});
		btnDone.setBounds(361, 301, 124, 44);
		contentPane.add(btnDone);

		JLabel lblNewLabel_1 = new JLabel("Person1 ID:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(172, 127, 96, 35);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Person2 ID:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(172, 186, 96, 35);
		contentPane.add(lblNewLabel_1_1);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(307, 127, 124, 35);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(307, 186, 124, 35);
		contentPane.add(textField_1);
	}
}
