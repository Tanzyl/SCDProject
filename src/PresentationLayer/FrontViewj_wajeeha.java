package PresentationLayer;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LogicLayer.Mutants;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class FrontViewj_wajeeha extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrontViewj_wajeeha frame = new FrontViewj_wajeeha();
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
	public FrontViewj_wajeeha() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("GENERATE");
		btnNewButton.setFont(new Font("Serif", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mutants obj = Mutants.getInstance();
				try {
					obj.control();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    JOptionPane.showMessageDialog(null,"Mutants generated successfully");
			}
		});
		btnNewButton.setBounds(156, 134, 111, 45);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("MUTANT GENERATOR");
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel.setBounds(128, 56, 180, 67);
		contentPane.add(lblNewLabel);
	}
}
