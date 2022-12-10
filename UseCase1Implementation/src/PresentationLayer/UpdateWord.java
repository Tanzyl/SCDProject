package PresentationLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;

public class UpdateWord extends JFrame {

	private JPanel contentPane;
	private JTextField updateWord;
	private JTable tblData;
	private JScrollPane scrollPane;
	private JButton btnNewButton_1;
	private JTextField idtext;
	private JLabel lblNewLabel;
	private JButton backBtn;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public UpdateWord() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		updateWord = new JTextField();
		updateWord.setColumns(10);
		updateWord.setBounds(274, 86, 150, 35);
		contentPane.add(updateWord);
		
		JButton btnNewButton = new JButton("Display");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/spellchecker?useSSL=false","root","");
				    Statement st=con.createStatement();
					String query="select * from words";
					ResultSet rs = st.executeQuery (query);
					ResultSetMetaData rsmd=rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel) tblData.getModel();
					
					int cols=rsmd.getColumnCount();
					String[] colName=new String[cols];
					for(int i=0;i<cols; i++)
					colName [i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers (colName);
					String id, word, frequency;
					while(rs.next())
					{
						id = rs.getString(1);
						word = rs.getString(2);
						frequency = rs.getString(3);
						String[] row = {id,word,frequency};
						model.addRow(row);
					
				}
					st.close();
					con.close();
					}
					catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(304, 176, 89, 23);
		contentPane.add(btnNewButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 254, 239);
		contentPane.add(scrollPane);
		
		tblData = new JTable();
		scrollPane.setViewportView(tblData);
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
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/spellchecker?useSSL=false","root","");
					String sql = "UPDATE `words` SET `word`= '"+ word +"' Where id = "+ id +"";
				    PreparedStatement pst = con.prepareStatement(sql);
					pst.execute();
		            con.isClosed();
					
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,"Updated");
				}
				}
			
		});
		btnNewButton_1.setBounds(304, 142, 89, 23);
		contentPane.add(btnNewButton_1);
		
		idtext = new JTextField();
		idtext.setBounds(274, 15, 150, 35);
		contentPane.add(idtext);
		idtext.setColumns(10);
		
		lblNewLabel = new JLabel("Word ID");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblNewLabel.setBounds(284, 61, 46, 14);
		contentPane.add(lblNewLabel);
		
		backBtn = new JButton("Back");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				InsertingData frame = new InsertingData();
				frame.setVisible(true);
			}
		});
		backBtn.setBackground(Color.RED);
		backBtn.setBounds(304, 227, 89, 23);
		contentPane.add(backBtn);
	}

}
