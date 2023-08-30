package unit8_assignment;

import java.awt.Desktop;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.rmi.UnknownHostException;
import java.awt.event.ActionEvent;
import org.w3c.dom.Element;
import javax.swing.DefaultComboBoxModel;

public class Form extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldAddress;
	private JLabel lblAddress;
	private JTextField textFieldCity;
	private JLabel lblCity;
	private JComboBox comboBoxState;
	private JLabel lblState;
	private JTextField textFieldZip;
	private JLabel lblZip;
	private JLabel lblTitle;
	private JButton btnSubmit;

	/**
	 * Launch the application.
	 */
	
	private String strLatitude;
	private String strLongitude;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form frame = new Form();
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
	public Form() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setBounds(144, 46, 181, 20);
		contentPane.add(textFieldAddress);
		textFieldAddress.setColumns(10);
		
		lblAddress = new JLabel("Address:");
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAddress.setBounds(44, 47, 66, 19);
		contentPane.add(lblAddress);
		
		textFieldCity = new JTextField();
		textFieldCity.setBounds(144, 90, 181, 20);
		contentPane.add(textFieldCity);
		textFieldCity.setColumns(10);
		
		lblCity = new JLabel("City:");
		lblCity.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCity.setBounds(64, 91, 46, 19);
		contentPane.add(lblCity);
		
		comboBoxState = new JComboBox();
		comboBoxState.setModel(new DefaultComboBoxModel(new String[] {"Select State", "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana",
				"Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island",
				"South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"}));
		comboBoxState.setBounds(144, 133, 126, 22);
		contentPane.add(comboBoxState);
		
		lblState = new JLabel("State:");
		lblState.setHorizontalAlignment(SwingConstants.RIGHT);
		lblState.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblState.setBounds(44, 132, 66, 20);
		contentPane.add(lblState);
		
		textFieldZip = new JTextField();
		textFieldZip.setBounds(144, 183, 181, 20);
		contentPane.add(textFieldZip);
		textFieldZip.setColumns(10);
		
		lblZip = new JLabel("Zip Code:");
		lblZip.setHorizontalAlignment(SwingConstants.RIGHT);
		lblZip.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblZip.setBounds(32, 184, 78, 19);
		contentPane.add(lblZip);
		
		lblTitle = new JLabel("ADDRESS ENTRY FORM");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitle.setBounds(134, 11, 191, 14);
		contentPane.add(lblTitle);
		
		btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isValidInput()) {
					try {
						SetLatLong();
					} catch (UnsupportedEncodingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					openGoogleMaps();
				}
			}
		});
		
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSubmit.setBounds(144, 242, 116, 47);
		contentPane.add(btnSubmit);
	
	}
	
	private boolean isValidInput(){
			boolean isValidInput = true;
			if(textFieldAddress.getText().isEmpty() || textFieldCity.getText().isEmpty() || textFieldZip.getText().isEmpty() || comboBoxState.getSelectedItem() ==  "Select State") {
				isValidInput = false;
				JOptionPane.showMessageDialog(null, "Incomplete Address Input");
			}
			return isValidInput;
		}

	private void SetLatLong() throws UnsupportedEncodingException {
	
		
		String address = textFieldAddress.getText() + " " + textFieldCity.getText() + " " + comboBoxState.getSelectedItem() + " " + textFieldZip.getText();
		System.out.println(address);

		String gKey = "AIzaSyC6Gb_Dtv00W4QWtFoApeKvAH9Wr5z2Qw8";
		
		String encodedAddress = URLEncoder.encode(address, StandardCharsets.UTF_8.toString());
	    String requestUri = String.format("https://maps.googleapis.com/maps/api/geocode/xml?key=%s&address=%s&sensor=false", gKey, encodedAddress);
		
		try {
			URL url = new URL(requestUri);
	
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            org.w3c.dom.Document doc = builder.parse(connection.getInputStream());

          
            Element rootElement = doc.getDocumentElement(); // Get the root element of the document
            Element resultElement = (Element) rootElement.getElementsByTagName("result").item(0); // Find the <result> element
            
            Element geometryElement = (Element) resultElement.getElementsByTagName("geometry").item(0); // Find the <geometry> element
            Element locationElement = (Element) geometryElement.getElementsByTagName("location").item(0); // Find the <location> element
            
           
            
            strLatitude = locationElement.getElementsByTagName("lat").item(0).getTextContent();
            strLongitude = locationElement.getElementsByTagName("lng").item(0).getTextContent();
            
            System.out.println("Latitude: " + strLatitude);
            System.out.println("Longitude: " + strLongitude);
            
		}catch(UnknownHostException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void openGoogleMaps() {
		String uri = String.format("https://maps.google.com/maps/search/%s,%s", strLatitude, strLongitude);
		try {
			Desktop.getDesktop().browse(new URI(uri));
		} catch(IOException | URISyntaxException e){
			e.printStackTrace();
		}
	
		
	}
















}








