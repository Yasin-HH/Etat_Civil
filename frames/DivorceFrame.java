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

public class DivorceFrame extends JFrame {

	private JPanel contentPane;

	TownHall townHall;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		DivorceFrame frame = new DivorceFrame(null);
		frame.setVisible(true);

	}

	/**
	 * Create the frame.
	 */
	public DivorceFrame(TownHall townHall) {
		this.townHall = townHall;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 659, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Divorce");
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
					int pID = Integer.parseInt(textField.getText());

					Citizen p1 = townHall.getPerson(pID);

					if (p1 == null) {
						JOptionPane.showMessageDialog(null, "Person does not exist!");
					} else if (p1.getMartialStatus() != MartialStatus.married) {
						JOptionPane.showMessageDialog(null, "Person is not married!");
					} else {

						townHall.setDivorce(pID);
						JOptionPane.showMessageDialog(null, "Successfull!");
					}

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Invalid ID");
				}

			}
		});
		btnDone.setBounds(361, 301, 124, 44);
		contentPane.add(btnDone);

		JLabel lblNewLabel_1 = new JLabel("Person ID:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(172, 127, 96, 35);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(307, 127, 124, 35);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
