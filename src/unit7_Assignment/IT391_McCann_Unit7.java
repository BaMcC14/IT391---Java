package unit7_Assignment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class IT391_McCann_Unit7 extends JFrame {

	private JPanel contentPane;
	private JTextField textMeanGrade;
	private JTextField textMaxGrade;
	private JTextField textMinGrade;
	private JLabel lblTitle;
	private JLabel lblName;
	private JLabel lblAge;
	private JLabel lblAddress;
	private JButton btnNewButton;
	
	private List<Float> gradeList;
	private String XMLURL = "http://localhost/studentGrades.xml";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IT391_McCann_Unit7 frame = new IT391_McCann_Unit7();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @return 
	 */
	
	public IT391_McCann_Unit7() {
		CreateGUI();
		
		SetGradeList();
		
		CalculateStatistics();
	}
	
	private void SetGradeList() {
		gradeList = new ArrayList<Float>();
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			org.w3c.dom.Document doc = db.parse(new URL(XMLURL).openStream());
			doc.getDocumentElement().normalize();
			
			NodeList nodeList = doc.getElementsByTagName("grade");
			
			for(int i = 0; i < nodeList.getLength(); i++) {
				Node nNode = nodeList.item(i);
				gradeList.add(Float.parseFloat(nNode.getTextContent()));
			}
			
		} catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public void CalculateStatistics() {
		float sumResult = 0;
		float meanResult = 0;
		float maxResult = 0;
		float minResult = 0;
		
		for(float num:gradeList)
			sumResult += num;
		
		meanResult = Math.round(sumResult/(float)gradeList.size());
		maxResult = Math.round(Collections.max(gradeList));
		minResult = Math.round(Collections.min(gradeList));
		textMeanGrade.setText(String.valueOf(meanResult));
		textMaxGrade.setText(String.valueOf(maxResult));
		textMinGrade.setText(String.valueOf(minResult));
	}

	public void CreateGUI() {
		setTitle("Unit 7 Assignment");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 375, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textMeanGrade = new JTextField();
		textMeanGrade.setHorizontalAlignment(SwingConstants.CENTER);
		textMeanGrade.setEditable(false);
		textMeanGrade.setBounds(200, 69, 100, 26);
		contentPane.add(textMeanGrade);
		textMeanGrade.setColumns(10);
		
		textMaxGrade = new JTextField();
		textMaxGrade.setHorizontalAlignment(SwingConstants.CENTER);
		textMaxGrade.setEditable(false);
		textMaxGrade.setColumns(10);
		textMaxGrade.setBounds(200, 139, 100, 26);
		contentPane.add(textMaxGrade);
		
		textMinGrade = new JTextField();
		textMinGrade.setEditable(false);
		textMinGrade.setHorizontalAlignment(SwingConstants.CENTER);
		textMinGrade.setColumns(10);
		textMinGrade.setBounds(200, 209, 100, 26);
		contentPane.add(textMinGrade);
		
		lblTitle = new JLabel("Grade Statistics");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitle.setBounds(115, 20, 140, 20);
		contentPane.add(lblTitle);
		
		lblName = new JLabel("Mean Grade:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblName.setBounds(50, 72, 120, 20);
		contentPane.add(lblName);
		
		lblAge = new JLabel("Maximum Grade:");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAge.setBounds(50, 142, 120, 20);
		contentPane.add(lblAge);
		
		lblAddress = new JLabel("Minimum Grade:");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAddress.setBounds(50, 212, 120, 20);
		contentPane.add(lblAddress);
		
		btnNewButton = new JButton("CLOSE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(130, 275, 100, 29);
		contentPane.add(btnNewButton);
	}
}
