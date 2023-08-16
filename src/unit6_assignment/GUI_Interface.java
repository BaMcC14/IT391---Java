package unit6_assignment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class GUI_Interface extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblFirstname;
	private JLabel lblLastname;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JComboBox comboBoxState;
	private JLabel lblState;
	private JCheckBox chckbxDogs;
	private JCheckBox chckbxCats;
	private JCheckBox chckbxBirds;
	private JCheckBox chckbxFish;
	private JCheckBox chckbxNone;
	private JCheckBox chckbxOther;
	private JTextField textFieldFirstName;
	private JTextField textFieldLastName;
	private JTextField textFieldUsername;
	private JButton btnSubmit;
	private JPasswordField passwordField;
	private JLabel lblSelectPets;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Interface frame = new GUI_Interface();
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
	public GUI_Interface() {
		setTitle("Unit 6 Assignment");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setToolTipText("New User Form");
		contentPane.setBackground(new Color(220, 220, 228));
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("New User Form");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(95, 22, 400, 35);
		contentPane.add(lblNewLabel);
		
		lblFirstname = new JLabel("First Name:");
		lblFirstname.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFirstname.setBounds(10, 104, 102, 19);
		contentPane.add(lblFirstname);
		
		lblLastname = new JLabel("Last Name:");
		lblLastname.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLastname.setBounds(281, 104, 97, 19);
		contentPane.add(lblLastname);
		
		lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsername.setBounds(10, 176, 102, 19);
		contentPane.add(lblUsername);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(281, 176, 97, 19);
		contentPane.add(lblPassword);
		
		comboBoxState = new JComboBox();
		comboBoxState.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBoxState.setToolTipText("State");
		comboBoxState.setModel(new DefaultComboBoxModel(new String[] {"Select State", "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"}));
		comboBoxState.setBounds(98, 284, 160, 35);
		contentPane.add(comboBoxState);
		
		lblState = new JLabel("State:");
		lblState.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblState.setBounds(10, 288, 78, 24);
		contentPane.add(lblState);
		
		chckbxDogs = new JCheckBox("Dogs");
		chckbxDogs.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxDogs.setBounds(339, 301, 97, 23);
		contentPane.add(chckbxDogs);
		
		chckbxCats = new JCheckBox("Cats");
		chckbxCats.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxCats.setBounds(339, 327, 97, 23);
		contentPane.add(chckbxCats);
		
		chckbxBirds = new JCheckBox("Birds");
		chckbxBirds.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxBirds.setBounds(339, 353, 97, 23);
		contentPane.add(chckbxBirds);
		
		chckbxFish = new JCheckBox("Fish");
		chckbxFish.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxFish.setBounds(438, 301, 97, 23);
		contentPane.add(chckbxFish);
		
		chckbxNone = new JCheckBox("None");
		chckbxNone.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxNone.setBounds(438, 353, 97, 23);
		contentPane.add(chckbxNone);
		
		chckbxOther = new JCheckBox("Other");
		chckbxOther.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxOther.setBounds(438, 327, 97, 23);
		contentPane.add(chckbxOther);
		
		textFieldFirstName = new JTextField();
		textFieldFirstName.setToolTipText("First Name");
		textFieldFirstName.setBounds(118, 100, 140, 30);
		contentPane.add(textFieldFirstName);
		textFieldFirstName.setColumns(10);
		
		textFieldLastName = new JTextField();
		textFieldLastName.setToolTipText("Last Name");
		textFieldLastName.setColumns(10);
		textFieldLastName.setBounds(395, 100, 140, 30);
		contentPane.add(textFieldLastName);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setToolTipText("Username");
		textFieldUsername.setColumns(10);
		textFieldUsername.setBounds(118, 172, 140, 30);
		contentPane.add(textFieldUsername);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validateForm();
			}
		});
		btnSubmit.setBounds(190, 454, 217, 50);
		contentPane.add(btnSubmit);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Password");
		passwordField.setBounds(395, 172, 140, 30);
		contentPane.add(passwordField);
		
		lblSelectPets = new JLabel("Select Pets:");
		lblSelectPets.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectPets.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSelectPets.setBounds(383, 263, 102, 24);
		contentPane.add(lblSelectPets);
	}
	
	private void validateForm() {
		
				String errorMessage = new String();
				
				//First Name Validation
				if(textFieldFirstName.getText().isEmpty() == true) {
					errorMessage += "Please enter your First Name.\n";
				}
				String fName = textFieldFirstName.getText();
				for(int i = 0; i < fName.length(); i++) {
					char alpha = fName.charAt(i);
					if(alpha >= 'a' && alpha <= 'z' || alpha >= 'A' && alpha <= 'Z') {
						continue;
						
					} else {
						errorMessage += "Please enter only letters for your first name.\n";
						break;
					}
					
				}
				
				//Last Name Validation
				if(textFieldLastName.getText().isEmpty() == true) {
					errorMessage += "Please enter your Last Name.\n";
				}
				String lName = textFieldLastName.getText();
				for(int i = 0; i < lName.length(); i++) {
					char alpha = lName.charAt(i);
					if(alpha >= 'a' && alpha <= 'z' || alpha >= 'A' && alpha <= 'Z') {
						continue;
					} else {
						errorMessage += "Please enter only letters for your last name.\n";
						break;
					}
				}
				
				//Username Validation
				if(textFieldUsername.getText().isEmpty() == true) {
					errorMessage += "Please enter your username.\n";
				}
				
				//Password Validation
				String userPassword = passwordField.getText();
				if(userPassword.length() < 8 || passwordField.getText().isEmpty() == true) {
					errorMessage += "Please enter a password at least 8 characters long.\n";
				}
							
				//State Validation
				if(comboBoxState.getSelectedItem() ==  "Select State") {
					errorMessage += "Please Select a state.\n";
				}
				
				//Checkbox Validation
				if(chckbxDogs.isSelected() == false && chckbxCats.isSelected() == false && chckbxBirds.isSelected() == false && 
						chckbxFish.isSelected() == false && chckbxNone.isSelected() == false && chckbxOther.isSelected() == false) {
					errorMessage += "Please select the type of pet you have.\n";
				}
				
				if(errorMessage.isBlank() == false || errorMessage.isEmpty() == false) {
					JOptionPane.showMessageDialog(null, errorMessage);
				}
			}
}
