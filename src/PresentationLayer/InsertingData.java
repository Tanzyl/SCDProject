package PresentationLayer;
import DataAccessLayer.Database_tanzyl;
import LogicLayer.UrduString_haram;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class InsertingData extends JFrame {
	private static InsertingData instance = null;
	private JPanel contentPane;
	JTextField textField;
	private Database_tanzyl obj ; 
	static ArrayList Paragraph=new ArrayList();
	static ArrayList Word=new ArrayList();
	public static InsertingData getInstance() {
		if (instance == null) {
			instance = new InsertingData();
		}
		return instance;
	}
	public InsertingData() {
		obj = new Database_tanzyl();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(22, 127, 194, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Upload");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> row = new ArrayList<String>();
				  String path=textField.getText();
				  System.out.println(path);
				  File Folder= new File(path);
				  File[] files = Folder.listFiles();
				  for(File fXmlFile:files) {      
					  try {
					        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
					        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
					        Document doc = dBuilder.parse(fXmlFile); 
					        
					        doc.getDocumentElement().normalize(); 
					        NodeList nList = doc.getElementsByTagName("document");

					            for (int temp = 0; temp < nList.getLength(); temp++) {
					        Node nNode = nList.item(temp);
					        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					        Element eElement = (Element) nNode; 
					        row.clear();
					        row.add(eElement.getElementsByTagName("title").item(0).getTextContent());
					        row.add(eElement.getElementsByTagName("author").item(0).getTextContent());
					        row.add(eElement.getElementsByTagName("section").item(0).getTextContent());
					        
					        
					        String title = eElement.getElementsByTagName("title").item(0).getTextContent();
					        String author = eElement.getElementsByTagName("author").item(0).getTextContent();
					        String section = eElement.getElementsByTagName("section").item(0).getTextContent();
					        Paragraph.add(section);    
					   }
					            obj.insert(row);
					            }}
					  catch (Exception e4) {
					        e4.printStackTrace();
					       }
				  } 
				  System.out.println(Paragraph.size());
				 for(int i=0;i<Paragraph.size();i++) 
				 {
					 String S=(String) Paragraph.get(i);
					 String[] words = S.split(" ");
					 String temp;
					 for(int i1=0; i1<words.length; i1++) {
						 for (int j = i1 + 1; j < words.length; j++) {
						 if (words[i1].compareTo(words[j]) > 0) {
			                    // swapping
			                    temp = words[i1];
			                    words[i1] = words[j];
			                    words[j] = temp;
			                    Word.add(words[i1]);
			                }
					 }
					 }
					 
				 }
				 
				LinkedHashSet<String> set = new LinkedHashSet<String>();
		        for (int i = 0; i < Word.size(); i++) 
		        {
		            set.add((String) Word.get(i));
		        }
		        ArrayList S2=new ArrayList();
		        Iterator<String> it = set.iterator();
		        while (it.hasNext()) {
		        	 String CurrentElement;
		            CurrentElement = it.next();
		            S2.add(CurrentElement);
		        }
		        
		       Database_tanzyl obj2=new Database_tanzyl();
				 System.out.println(set.size());
				 System.out.println(S2.size());
		        for(int i=0;i<set.size();i++)
		        {
		        	String St=(String) S2.get(i);
		        	int fre=Collections.frequency(Word,St);
		        	
		        	obj2.Word(St,fre);
		        			        
		        }
			}
		});
		btnNewButton.setBounds(65, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Spell Checker");
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setFont(new Font("Baskerville Old Face", Font.BOLD | Font.ITALIC, 32));
		lblNewLabel.setBounds(105, 11, 220, 43);
		contentPane.add(lblNewLabel);
		
		JButton updateBtn = new JButton("Update Word");
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				UpdateWord frame = new UpdateWord();
				frame.setVisible(true);
				
			}
		});
		updateBtn.setBounds(294, 221, 130, 34);
		contentPane.add(updateBtn);
		
		JButton mutantsBtn = new JButton("Generate Mutants");
		mutantsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				FrontViewj_wajeeha frame = new FrontViewj_wajeeha();
				frame.setVisible(true);
			}
		});
		mutantsBtn.setBounds(294, 171, 130, 39);
		contentPane.add(mutantsBtn);
		
		JButton testTextBtn = new JButton("Test Text ");
		testTextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				final UrduString_haram txt = new UrduString_haram();
				Window_haram frame = new Window_haram(txt);
				frame.setVisible(true);
				//Window1j_haram.showWindow();
				
			}
		});
		testTextBtn.setBounds(294, 116, 130, 34);
		contentPane.add(testTextBtn);
		
		JLabel lblNewLabel_1 = new JLabel("Enter address to upload data in database:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(22, 102, 253, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton browseBtn = new JButton("Browse");
		browseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser file_upload = new JFileChooser();
				file_upload.setCurrentDirectory (new File("."));
				int res_2 = file_upload.showSaveDialog(null);
				if(res_2 == JFileChooser. APPROVE_OPTION) {
				File file_path = new File(file_upload.getSelectedFile().getAbsolutePath());
				System.out.println(file_path);
				}
			}
		});
		browseBtn.setBounds(65, 166, 89, 23);
		contentPane.add(browseBtn);
	}
}
