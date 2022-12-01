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
import java.awt.event.ActionEvent;

public class FrontView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrontView frame = new FrontView();
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
	public FrontView() {
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
				Mutants obj = new Mutants();
				Mutants.control();
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
