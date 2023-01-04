package PresentationLayer;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import LogicLayer.UrduString;

import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.Font;

public class Window1 extends JFrame {


	private JPanel contentPane;
	private static JTextField textField;
	private String urduTextTmp="";
	DefaultListModel listModel;
	DefaultListModel listModel2;
	String Old;
	String NewWord;
	
	public static void setTextField(String value,String oldVal) {
		
		Highlighter high=textField.getHighlighter();
		HighlightPainter painter=new DefaultHighlighter.DefaultHighlightPainter(Color.pink);
		int p0 = textField.getText().indexOf(oldVal);
		try {
			
			high.addHighlight(p0, p0 + oldVal.length(), painter);
        } catch (BadLocationException e1) {
            
        }
	}
	
	/**
	 * Launch the application.
	 */
	public static void showWindow(UrduString txt) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window1 frame = new Window1(txt);
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
	public Window1(UrduString urdutext) {
		setTitle("Ø§Ø±Ø¯Ùˆ Ø³Ù¾ÛŒÙ„ Ú†ÛŒÚ©Ø±");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 747, 535);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(40, 160, 683, 185);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Check");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(250, 240, 230));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					urdutext.setTxt(textField.getText(),listModel);
					
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		
		
		
		btnNewButton.setBounds(153, 427, 120, 50);
		contentPane.add(btnNewButton);
		listModel = new DefaultListModel();
		listModel2 = new DefaultListModel();
		
		JLabel lblNewLabel = new JLabel("Text Area");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(41, 130, 179, 20);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(461, 392, 96, 96);
		contentPane.add(scrollPane);
		
		JList list = new JList(listModel);
		list.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(list);
		
		list.addListSelectionListener(new ListSelectionListener() {
		      public void valueChanged(ListSelectionEvent evt) {
		    	  listModel2.clear();
		    	  
		        
		        String Word=(String) list.getSelectedValue();
		        		        Old=Word;
		        NewWord=UrduString.Check(Word);
		        listModel2.addElement(NewWord);
		        

		      }
		    });
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(597, 392, 87, 96);
		contentPane.add(scrollPane_1);
		
		JList list_1 = new JList(listModel2);
		scrollPane_1.setViewportView(list_1);
		
		JButton btnNewButton_1 = new JButton("Replace");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBackground(new Color(250, 240, 230));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Word=(String) list_1.getSelectedValue();
				if(Word!=null) {
				UrduString.SetTextField(textField,Old,Word);
				}
				listModel.clear();
				try {
					urdutext.setTxt(textField.getText(),listModel);
					
					
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(339, 427, 104, 50);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Error List");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(472, 369, 62, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Correct Word");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setBounds(600, 368, 104, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Urdu Spell Checker");
		lblNewLabel_3.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 27));
		lblNewLabel_3.setBounds(238, 36, 271, 70);
		contentPane.add(lblNewLabel_3);
		
	
	}
}
