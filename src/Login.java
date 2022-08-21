import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Choice;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JPasswordField;

public class Login {

	private JFrame frmSportEventsManagement;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmSportEventsManagement.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}
	
	/*DATABASE Connection*/
	String url = "jdbc:mysql://localhost:3306/sems";
	String username = "root";
	String password = "";
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSportEventsManagement = new JFrame();
		frmSportEventsManagement.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\icon.png"));
		frmSportEventsManagement.setTitle("Sport Events Management System/Login");
		frmSportEventsManagement.setResizable(false);
		frmSportEventsManagement.setBounds(100, 100, 740, 419);
		frmSportEventsManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSportEventsManagement.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(152, 251, 152));
		panel.setBounds(0, 0, 424, 380);
		frmSportEventsManagement.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\hbg.jpg"));
		label.setBounds(-304, -332, 728, 712);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(173, 255, 47));
		panel_1.setBounds(371, 0, 353, 380);
		frmSportEventsManagement.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(135, 47, 129, 41);
		panel_1.add(lblLogin);
		
		JLabel lblUsername = new JLabel("Username : ");
		lblUsername.setIcon(new ImageIcon("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\uname.png"));
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(67, 153, 109, 22);
		panel_1.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password : ");
		lblPassword.setIcon(new ImageIcon("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\pass.png"));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(67, 199, 109, 22);
		panel_1.add(lblPassword);
		
		Choice choice = new Choice();	
		choice.add("Admin");
		choice.add("User");
		choice.setBounds(217, 106, 117, 20);		
		panel_1.add(choice);
		
		textField = new JTextField();
		textField.setBounds(215, 156, 119, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(215, 202, 119, 20);
		panel_1.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setHorizontalAlignment(SwingConstants.LEFT);
		btnLogin.setIcon(new ImageIcon("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\login.png"));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				if(!(textField.getText().equals("")) && !(passwordField.getText().equals("")) && choice.getSelectedItem().equals("Admin")) {
					
					try {
						String url = "jdbc:mysql://localhost:3306/sems";
						Class.forName("com.mysql.jdbc.Driver");						
						Connection conn = DriverManager.getConnection(url,"root","");
						
						Statement stmt = conn.createStatement();
						String sql = "SELECT * FROM login WHERE uname='"+textField.getText()+"' AND pass='"+passwordField.getText()+"'  " ;
						ResultSet res=stmt.executeQuery(sql);
						
						if(res.next()) {
							Admin.main(null);
							frmSportEventsManagement.dispose();
						}else {
							textField.setBackground(Color.red);
							passwordField.setBackground(Color.red);
							JOptionPane.showMessageDialog(null, "Incorect Name or Password !","Error ! ", JOptionPane.ERROR_MESSAGE);
							textField.setBackground(Color.white);
							passwordField.setBackground(Color.white);
							textField.setText("");
							passwordField.setText("");
						}
						
						conn.close();
						stmt.close();
						res.close();
												
					} catch (Exception e1) { e1.printStackTrace(); }
					
				}else {
					textField.setBackground(Color.red);
					passwordField.setBackground(Color.red);
					JOptionPane.showMessageDialog(null, "Incorect Name or Password !","Error ! ", JOptionPane.ERROR_MESSAGE);
					textField.setBackground(Color.white);
					passwordField.setBackground(Color.white);
					textField.setText("");
					passwordField.setText("");
				
				}
				
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogin.setBounds(164, 272, 89, 23);
		panel_1.add(btnLogin);
		
		JLabel lblUserType = new JLabel("User type : ");
		lblUserType.setIcon(new ImageIcon("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\uname.png"));
		lblUserType.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUserType.setBounds(67, 104, 109, 22);
		panel_1.add(lblUserType);
		
		
		
		
	}
}
