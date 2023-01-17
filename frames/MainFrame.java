package frames;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.TownHall;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;

	TownHall townHall;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		MainFrame frame = new MainFrame(null);
		frame.setVisible(true);

	}

	/**
	 * Create the frame.
	 */
	public MainFrame(TownHall townHall) {
		this.townHall = townHall;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 659, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(269, 11, 124, 53);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("Marriage");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MarriageFrame frame = new MarriageFrame(townHall);
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(71, 124, 142, 44);
		contentPane.add(btnNewButton);

		JButton btnDivorce = new JButton("Divorce");
		btnDivorce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DivorceFrame frame = new DivorceFrame(townHall);
				frame.setVisible(true);
				dispose();
			}
		});
		btnDivorce.setBounds(255, 124, 142, 44);
		contentPane.add(btnDivorce);

		JButton btnBirth = new JButton("Birth");
		btnBirth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BirthFrame frame = new BirthFrame(townHall);
				frame.setVisible(true);
				dispose();
			}
		});
		btnBirth.setBounds(435, 124, 142, 44);
		contentPane.add(btnBirth);

		JButton btnPersonStatus = new JButton("Person Status");
		btnPersonStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonDetailsFrame frame = new PersonDetailsFrame(townHall);
				frame.setVisible(true);
				dispose();
			}
		});
		btnPersonStatus.setBounds(71, 220, 142, 44);
		contentPane.add(btnPersonStatus);

		JButton btnPersonsList = new JButton("Persons List");
		btnPersonsList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonsListFrame frame = new PersonsListFrame(townHall);
				frame.setVisible(true);
				dispose();
			}
		});
		btnPersonsList.setBounds(255, 220, 142, 44);
		contentPane.add(btnPersonsList);

		JButton btnPersonsSeizure = new JButton("Persons Seizure");
		btnPersonsSeizure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCitizenFrame frame = new AddCitizenFrame(townHall);
				frame.setVisible(true);
				dispose();
			}
		});
		btnPersonsSeizure.setBounds(435, 220, 142, 44);
		contentPane.add(btnPersonsSeizure);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				townHall.saveDataToFile();
				System.exit(0);
			}
		});
		btnExit.setBounds(255, 311, 142, 44);
		contentPane.add(btnExit);
	}
}
