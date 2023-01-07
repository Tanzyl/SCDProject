package PresentationLayer;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DataAccessLayer.Database_tanzyl;

public class UpdateWord extends JFrame {

	private JPanel contentPane;
	private JTextField updateWord;
	private JTable tblData;
	private JScrollPane scrollPane;
	private JButton btnNewButton_1;
	private JTextField idtext;
	private JLabel lblNewLabel;
	private JButton backBtn;
	private Database_tanzyl dbt = new Database_tanzyl();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateWord frame = new UpdateWord();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public UpdateWord() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		updateWord = new JTextField();
		updateWord.setColumns(10);
		updateWord.setBounds(274, 95, 150, 35);
		contentPane.add(updateWord);

		JButton btnNewButton = new JButton("Display");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayData();
			}
		});
		btnNewButton.setBounds(306, 193, 89, 23);
		contentPane.add(btnNewButton);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 254, 239);
		contentPane.add(scrollPane);

		tblData = new JTable();
		scrollPane.setViewportView(tblData);
		//tblData.
		tblData.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"id", "word", "frequency"
				}
			));

			btnNewButton_1 = new JButton("Update");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String id = idtext.getText();
				    String word = updateWord.getText();
				    dbt.updateWordInDatabase(id, word);
				}
			});
			btnNewButton_1.setBounds(306, 159, 89, 23);
			contentPane.add(btnNewButton_1);

			idtext = new JTextField();
			idtext.setBounds(274, 31, 150, 35);
			contentPane.add(idtext);
			idtext.setColumns(10);

			lblNewLabel = new JLabel("Enter id:");
			lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lblNewLabel.setBounds(274, 11, 89, 14);
			contentPane.add(lblNewLabel);

			backBtn = new JButton("Back");
			backBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				InsertingData frame = new InsertingData();
					frame.setVisible(true);
				}
			});
			backBtn.setBounds(306, 227, 89, 23);
			contentPane.add(backBtn);
			
			JLabel lblEnterWord = new JLabel("Enter Word:");
			lblEnterWord.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lblEnterWord.setBounds(274, 70, 89, 14);
			contentPane.add(lblEnterWord);
			}

			private void displayData() {
				Database_tanzyl dbt = new Database_tanzyl();
				dbt.displayData(tblData);
			}
	}


