import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.Component;

import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Choice;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import javax.swing.JInternalFrame;
import javax.swing.JSplitPane;
import java.awt.Dimension;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Admin {

	private JFrame frmSportEventManagement;
	private JTable table;
	private JTextField uid;
	private JTextField uname;
	private JTextField utname;
	private JTextField upay;
	private JTextField delcms;
	private JTextField upcms;
	private JTextField updated;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin window = new Admin();
					window.frmSportEventManagement.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Admin() {
		initialize();
	}
	
	/*DATABASE Connection*/
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/sems";
	String username = "root";
	String password = "";
	
	Connection con ;
	Statement stmt ;
	ResultSet res ;
	
	
	/*Global Variables and Components*/
	private JTabbedPane Users, Instructor, Events ,Teams;
	JPanel Home;
	private JTextField usprt , uclg;
	private JTextField iid;
	private JTextField iname;
	private JTextField idpt;
	private JTextField idelcms;
	private JTextField iupid;
	private JTextField iupdated;
	private JTable table_1;
	private JTable table_2;
	private JTextField eid;
	private JTextField ename;
	private JTextField evenue;
	private JTextField eedate;
	private JTextField estdate;
	private JTextField etype;
	private JTextField edelid;
	private JTextField eupid;
	private JTextField eupdated;
	private JTable table_3;
	private JTextField iuni;
	private JTextField isprt;
	private JTextField udept;
	

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("serial")
	private void initialize() {
		frmSportEventManagement = new JFrame();
		frmSportEventManagement.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\icon.png"));
		frmSportEventManagement.setTitle("Sport Event Management System/Main");
		frmSportEventManagement.setResizable(false);
		frmSportEventManagement.getContentPane();
		frmSportEventManagement.setBounds(100, 100, 721, 485);
		frmSportEventManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSportEventManagement.getContentPane().setLayout(null);
		ImageIcon i = new ImageIcon("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\c.jpg");
		frmSportEventManagement.setContentPane(new JLabel(i));
		
		
		JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setBounds(-10008, -10055, 89, 50);
		addPopup(frmSportEventManagement.getContentPane(), popupMenu);
		
				
		
		/* ************* HOME START ***********************/
		Home = new JPanel();
		Home.setBackground(new Color(225,0,225,1));
		Home.setBounds(0, 0, 705, 422);
		frmSportEventManagement.getContentPane().add(Home);
		Home.setLayout(null);
		
		JPopupMenu popupMenu_1 = new JPopupMenu();
		Home.add(popupMenu_1);
		popupMenu_1.setBounds(0, 0, 89, 50);
		
		JMenuItem menuItem = new JMenuItem("Refresh");
		popupMenu_1.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("Exit");
		popupMenu_1.add(menuItem_1);
				
		JLabel lblSportsEventsManagement = new JLabel("SPORTS' EVENTS MANAGEMENT SYSTEM");
		lblSportsEventsManagement.setBackground(Color.GREEN);
		lblSportsEventsManagement.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblSportsEventsManagement.setBounds(42, 11, 600, 47);
		lblSportsEventsManagement.setHorizontalAlignment(SwingConstants.CENTER);
		lblSportsEventsManagement.setFont(new Font("Viner Hand ITC", Font.BOLD, 22));
		Home.add(lblSportsEventsManagement);
		
		JLabel lblShah = new JLabel("");
		lblShah.setHorizontalAlignment(SwingConstants.CENTER);
		lblShah.setIcon(new ImageIcon("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\ss.png"));
		lblShah.setBounds(235, 136, 115, 111);
		Home.add(lblShah);
		
		JLabel lblAProjectBy = new JLabel("A Project By:");
		lblAProjectBy.setBounds(253, 95, 151, 30);
		lblAProjectBy.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		lblAProjectBy.setHorizontalAlignment(SwingConstants.CENTER);
		Home.add(lblAProjectBy);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\mushi.png"));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(307, 136, 115, 111);
		Home.add(label);
		
		JLabel label1 = new JLabel("");
		label1.setIcon(new ImageIcon("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\hm bg.jpg"));
		label1.setBounds(0, 0, 705, 422);
		Home.add(label1);
		/* *********************** HOME END *********************************************/
		
		
		/* *********************** User start *******************************************/
		Users = new JTabbedPane(JTabbedPane.TOP);
		Users.setBounds(49, 36, 609, 343);
		frmSportEventManagement.getContentPane().add(Users);
		Users.setVisible(false);
		
		JScrollPane scrollPane = new JScrollPane();
		Users.addTab("Users view", new ImageIcon("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\view.png"), scrollPane, null);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setViewportBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		DefaultTableModel Umodel = new DefaultTableModel(); 
		JTable Utable = new JTable(Umodel); 
		Utable.setBackground(new Color(173, 255, 47));
		scrollPane.setViewportView(Utable);
		

		// Create a couple of columns 
		Umodel.addColumn("CMS-ID"); 
		Umodel.addColumn("Name");
		Umodel.addColumn("College/University");
		Umodel.addColumn("Department");
		Umodel.addColumn("Sport Type");
		Umodel.addColumn("Team Name");
		Umodel.addColumn("Payments");
			
		
		/***************** OPtions *******************/
		JTabbedPane userOpt = new JTabbedPane(JTabbedPane.TOP);
		Users.addTab("User Options", new ImageIcon("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\opts.png"), userOpt, null);
		
		/****** New *********/
		JPanel new_panel = new JPanel();
		userOpt.addTab("New\r\n", new ImageIcon("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\new.png"), new_panel, null);
		new_panel.setLayout(null);
		
		JLabel lblCmsId = new JLabel("CMS ID: ");
		lblCmsId.setBounds(58, 35, 74, 21);
		new_panel.add(lblCmsId);
		
		JLabel lblName = new JLabel("Name : ");
		lblName.setBounds(58, 72, 74, 21);
		new_panel.add(lblName);
		
		JLabel lblCollegeuni = new JLabel("College/Uni : ");
		lblCollegeuni.setBounds(58, 114, 74, 21);
		new_panel.add(lblCollegeuni);
		
		JLabel lblSport = new JLabel("Sport : ");
		lblSport.setBounds(325, 113, 74, 21);
		new_panel.add(lblSport);
		
		JLabel lblTeamName = new JLabel("Team Name : ");
		lblTeamName.setBounds(325, 38, 74, 21);
		new_panel.add(lblTeamName);
		
		JLabel lblPayaments = new JLabel("Payaments : ");
		lblPayaments.setBounds(325, 72, 74, 21);
		new_panel.add(lblPayaments);
		
		uid = new JTextField();
		uid.setBounds(142, 35, 118, 20);
		new_panel.add(uid);
		uid.setColumns(10);
		
		uname = new JTextField();
		uname.setColumns(10);
		uname.setBounds(142, 72, 118, 20);
		new_panel.add(uname);
		
		uclg = new JTextField();
		uclg.setColumns(10);
		uclg.setBounds(142, 114, 118, 20);
		new_panel.add(uclg);
		
		usprt = new JTextField();
		usprt.setColumns(10);
		usprt.setBounds(409, 114, 118, 20);
		new_panel.add(usprt);
		
		utname = new JTextField();
		utname.setColumns(10);
		utname.setBounds(409, 35, 118, 20);
		new_panel.add(utname);
		
		upay = new JTextField();
		upay.setColumns(10);
		upay.setBounds(409, 72, 118, 20);
		new_panel.add(upay);
		
		JLabel lblDepartment = new JLabel("Department : ");
		lblDepartment.setBounds(58, 150, 74, 21);
		new_panel.add(lblDepartment);
		
		udept = new JTextField();
		udept.setColumns(10);
		udept.setBounds(142, 150, 118, 20);
		new_panel.add(udept);
		
		JButton btnAdd = new JButton("OK");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!(uid.getText().equals("")) && !(uname.getText().equals("")) 
						&& !(uclg.getText().equals(""))	&& !(udept.getText().equals("")) 
						&& !(usprt.getText().equals(""))&& !(upay.getText().equals(""))
						&& !(utname.getText().equals(""))) {
					
					try {
						Class.forName("com.mysql.jdbc.Driver");
						con = DriverManager.getConnection(url,username,password);
						
						String id = uid.getText();
						String name = uname.getText();
						String clg = uclg.getText();
						String dpt = udept.getText();
						String sprt = usprt.getText();
						String team = utname.getText();
						String pay = upay.getText();
						
						stmt = con.createStatement();
						String sql = "insert into users"+" values ('" + id +"','" + name + "','" + clg + "','"+dpt+"','"+ sprt+"','"+team+"','"+pay+"')";
						stmt.executeUpdate(sql);
						
						JOptionPane.showMessageDialog(null, "Inserted Row Successfully !", null, JOptionPane.INFORMATION_MESSAGE);											
						
					} catch (Exception e) {e.getMessage();}
					finally {
				         try {
				             if (stmt != null)
				                con.close();
				          } catch (SQLException se) {}
				          try {
				             if (con != null)
				                con.close();
				          } catch (SQLException se) {
				             se.printStackTrace();
				          }  
				       }					
				}else {
					JOptionPane.showMessageDialog(null, "Fill all the feilds!", "Warning !" , JOptionPane.WARNING_MESSAGE);
		
				}
			}
		});
		btnAdd.setIcon(new ImageIcon("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\ok.png"));
		btnAdd.setBounds(312, 198, 98, 23);
		new_panel.add(btnAdd);
		
		JButton btnCancel_1 = new JButton("Cancel");
		btnCancel_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				uid.setText("");
				uname.setText("");
				uclg.setText("");
				upay.setText("");
				usprt.setText("");
				udept.setText("");
				utname.setText("");
			}
		});
		btnCancel_1.setIcon(new ImageIcon("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\cancel.png"));
		btnCancel_1.setBounds(192, 198, 110, 23);
		new_panel.add(btnCancel_1);
		
				
		
		/************ Delete ******************/
		
		JPanel del_panel = new JPanel();
		userOpt.addTab("Delete\r\n", new ImageIcon("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\del.png"), del_panel, null);
		del_panel.setLayout(null);
		
		JLabel lblCmsId_1 = new JLabel("CMS ID :");
		lblCmsId_1.setBounds(188, 79, 70, 21);
		del_panel.add(lblCmsId_1);
		
		delcms = new JTextField();
		delcms.setBounds(284, 79, 126, 20);
		del_panel.add(delcms);
		delcms.setColumns(10);
		
		JButton btnDone = new JButton("OK");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!delcms.getText().equals("")) {
					try {
						Class.forName(driver);
						con = DriverManager.getConnection(url,username,password);
						System.out.println("Connected...");
						
						stmt = con.createStatement();
						String delsql = "DELETE FROM users WHERE cmsid='"+delcms.getText()+"'";
						int a=0 ;
						int res = JOptionPane.showConfirmDialog(null, "Do you want to delete ? ", "Confirmation",
							      JOptionPane.YES_NO_CANCEL_OPTION,
							      JOptionPane.PLAIN_MESSAGE);
						if(res == 0) {
							 a = stmt.executeUpdate(delsql);
							 if(a !=0) {
								JOptionPane.showMessageDialog(null, "Removed Successfully...", "Informations...", JOptionPane.INFORMATION_MESSAGE);
							}else {
								JOptionPane.showMessageDialog(null, "Record Not Found !", "Warnings...", JOptionPane.WARNING_MESSAGE);
							}
						}
						
						con.close();
						stmt.close();
				
					}catch(Exception ex) {ex.getMessage();}
				}else {
					JOptionPane.showMessageDialog(null, "Fill the given fields !" , "Warnings...", JOptionPane.WARNING_MESSAGE);
				}				
			}
		});
		btnDone.setIcon(new ImageIcon("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\ok.png"));
		btnDone.setBounds(303, 145, 89, 23);
		del_panel.add(btnDone);
		
		JButton btnCancel_2 = new JButton("Cancel");
		btnCancel_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delcms.setText("");
			}
		});
		btnCancel_2.setIcon(new ImageIcon("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\cancel.png"));
		btnCancel_2.setBounds(188, 145, 100, 23);
		del_panel.add(btnCancel_2);
		
		
		/************* Update *************************/
		JPanel Upd_panel = new JPanel();
		userOpt.addTab("Update", new ImageIcon("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\upd.png"), Upd_panel, null);
		Upd_panel.setLayout(null);
		
		JLabel lblCmsId_2 = new JLabel("CMS ID : ");
		lblCmsId_2.setBounds(186, 80, 71, 22);
		Upd_panel.add(lblCmsId_2);
		
		upcms = new JTextField();
		upcms.setBounds(304, 81, 108, 20);
		Upd_panel.add(upcms);
		upcms.setColumns(10);
		
		JLabel lblColToBe = new JLabel("Col to be Updated");
		lblColToBe.setBounds(186, 126, 108, 22);
		Upd_panel.add(lblColToBe);
		
		Choice upchoice = new Choice();
		upchoice.add("CMS ID");
		upchoice.add("Name");
		upchoice.add("College/Uni");
		upchoice.add("Sport");
		upchoice.add("Team Name");
		upchoice.add("Payment");
		upchoice.add("department");
		upchoice.setBounds(304, 126, 108, 20);
		Upd_panel.add(upchoice);
		
		JLabel lblNewValue = new JLabel("Updated Value : \r\n");
		lblNewValue.setBounds(186, 171, 108, 22);
		Upd_panel.add(lblNewValue);
		
		updated = new JTextField();
		updated.setColumns(10);
		updated.setBounds(304, 172, 108, 20);
		Upd_panel.add(updated);
		
		JButton btnDone_1 = new JButton("Done !");
		btnDone_1.setIcon(new ImageIcon("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\ok.png"));
		btnDone_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!upcms.getText().equals("")) {
					try {
						Class.forName(driver);
						con = DriverManager.getConnection(url, username, password);
						
						stmt = con.createStatement();
						String upsql=null ;
						if(upchoice.getSelectedItem().equals("CMS ID")) {
							upsql = "UPDATE users "+ "SET cmsid='"+updated.getText()+"' WHERE cmsid='"+upcms.getText()+"'";
						}else if(upchoice.getSelectedItem().equals("Name")) {
							upsql = "UPDATE users "+ "SET Name='"+updated.getText()+"' WHERE cmsid='"+upcms.getText()+"'";
						}else if(upchoice.getSelectedItem().equals("College/Uni")) {
							upsql = "UPDATE users "+ "SET uni='"+updated.getText()+"' WHERE cmsid='"+upcms.getText()+"'";
						}else if(upchoice.getSelectedItem().equals("department")) {
							upsql = "UPDATE users "+ "SET dept='"+updated.getText()+"' WHERE cmsid='"+upcms.getText()+"'";
						}else if(upchoice.getSelectedItem().equals("Sport")) {
							upsql = "UPDATE users "+ "SET sport='"+updated.getText()+"' WHERE cmsid='"+upcms.getText()+"'";
						}else if(upchoice.getSelectedItem().equals("Team Name")) {
							upsql = "UPDATE users "+ "SET team='"+updated.getText()+"' WHERE cmsid='"+upcms.getText()+"'";
						}else if(upchoice.getSelectedItem().equals("Payment")) {
							upsql = "UPDATE users "+ "SET payments='"+updated.getText()+"' WHERE cmsid='"+upcms.getText()+"'";
						}	
						
						int a=0 ;
						int res = JOptionPane.showConfirmDialog(null, "Do you want to Update it ? ", "Confirmation",
							      JOptionPane.YES_NO_CANCEL_OPTION,
							      JOptionPane.PLAIN_MESSAGE);
						if(res == 0) {
							 a = stmt.executeUpdate(upsql);
							 if(a !=0) {
								JOptionPane.showMessageDialog(null, "Updated Successfully...", "Informations...", JOptionPane.INFORMATION_MESSAGE);
							}else {
								JOptionPane.showMessageDialog(null, "Record Not Found !", "Warnings...", JOptionPane.WARNING_MESSAGE);
							}
						}
						
						con.close();
						stmt.close();
						
					}catch(Exception ex){
						ex.getMessage();
					}
				}else {
					JOptionPane.showMessageDialog(null, "Fill the fields !", "Warnings...", JOptionPane.WARNING_MESSAGE);					
				}
			}
		});
		btnDone_1.setBounds(323, 231, 89, 23);
		Upd_panel.add(btnDone_1);
		
		JButton btnCancel = new JButton("Cancel\r\n");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				upcms.setText("");
				updated.setText("");
			}
		});
		btnCancel.setIcon(new ImageIcon("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\cancel.png"));
		btnCancel.setBounds(186, 231, 108, 23);
		Upd_panel.add(btnCancel);
		
		
		/* ******** USER END ************************************************************/
		
		
		/* *********** Instructor START *************************************************/
		Instructor = new JTabbedPane(JTabbedPane.TOP);
		Instructor.setBounds(143, 42, 403, 322);
		frmSportEventManagement.getContentPane().add(Instructor);
		Instructor.setVisible(false);
		
		JScrollPane scrollPane1 = new JScrollPane();
		Instructor.addTab("Instructors' View", new ImageIcon("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\view.png"), scrollPane1, null);
		
		DefaultTableModel Imodel = new DefaultTableModel(); 
		JTable Itable = new JTable(Imodel); 
		Itable.setBackground(new Color(173, 255, 47));
		scrollPane1.setViewportView(Itable);

		// Create a couple of columns 
		Imodel.addColumn("INS-ID"); 
		Imodel.addColumn("Name");
		Imodel.addColumn("College/University");
		Imodel.addColumn("Department");
		Imodel.addColumn("Sport Type");
		
		/**** OPtions ******/
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		Instructor.addTab("Instructor Options\r\n", new ImageIcon("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\opts.png"), tabbedPane_1, null);
		
		/******* new panel *****/
		JPanel newpanel = new JPanel();
		tabbedPane_1.addTab("New\r\n", new ImageIcon("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\new.png"), newpanel, null);
		newpanel.setLayout(null);
		
		JLabel inslblInsid = new JLabel("INS-ID :");
		inslblInsid.setBounds(66, 30, 95, 20);
		newpanel.add(inslblInsid);
		
		JLabel inslabel = new JLabel("Name : ");
		inslabel.setBounds(66, 61, 95, 20);
		newpanel.add(inslabel);
		
		JLabel inslabel_1 = new JLabel("Department : ");
		inslabel_1.setBounds(66, 92, 95, 20);
		newpanel.add(inslabel_1);
		
		iid = new JTextField();
		iid.setBounds(192, 30, 138, 20);
		newpanel.add(iid);
		iid.setColumns(10);
		
		iname = new JTextField();
		iname.setColumns(10);
		iname.setBounds(192, 61, 138, 20);
		newpanel.add(iname);
		
		idpt = new JTextField();
		idpt.setColumns(10);
		idpt.setBounds(192, 92, 138, 20);
		newpanel.add(idpt);
		
		JLabel lblCollegeuni1 = new JLabel("College/Uni\r\n");
		lblCollegeuni1.setBounds(66, 123, 95, 20);
		newpanel.add(lblCollegeuni1);
		
		iuni = new JTextField();
		iuni.setColumns(10);
		iuni.setBounds(192, 123, 138, 20);
		newpanel.add(iuni);
		
		JLabel lblSports = new JLabel("Sports : ");
		lblSports.setBounds(66, 155, 95, 20);
		newpanel.add(lblSports);
		
		isprt = new JTextField();
		isprt.setColumns(10);
		isprt.setBounds(192, 154, 138, 20);
		newpanel.add(isprt);
		
		JButton insbtnDone = new JButton("Done !");
		insbtnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(iid.getText().equals("")) && !(iname.getText().equals("")) 
						&& !(iuni.getText().equals(""))	&& !(idpt.getText().equals("")) 
						&& !(isprt.getText().equals(""))) {
					
					try {
						Class.forName(driver);
						con = DriverManager.getConnection(url,username,password);
						
						String id = iid.getText();
						String name = iname.getText();
						String clg = iuni.getText();
						String dpt = idpt.getText();
						String sprt = isprt.getText();
						
						stmt = con.createStatement();
						String Isql = "insert into instructor"+" values ('" + id +"','" + name + "','" + clg + "','"+dpt+"','"+ sprt+"')";
						stmt.executeUpdate(Isql);
						
						JOptionPane.showMessageDialog(null, "Inserted Row Successfully !", null, JOptionPane.INFORMATION_MESSAGE);											
						
					} catch (Exception exp) {exp.getMessage();}
					finally {
				         try {
				             if (stmt != null)
				                con.close();
				          } catch (SQLException se) {}
				          try {
				             if (con != null)
				                con.close();
				          } catch (SQLException se) {
				             se.printStackTrace();
				          }  
				       }					
				}else {
					JOptionPane.showMessageDialog(null, "Fill all the feilds!", "Warning !" , JOptionPane.WARNING_MESSAGE);
		
				}
				
			}
		});
		insbtnDone.setIcon(new ImageIcon("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\ok.png"));
		insbtnDone.setBounds(215, 211, 89, 23);
		newpanel.add(insbtnDone);
		
		JButton insbtnCancel = new JButton("Cancel\r\n");
		insbtnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iid.setText("");
				iname.setText("");
				idpt.setText("");
				isprt.setText("");
				iuni.setText("");
			}
		});
		insbtnCancel.setIcon(new ImageIcon("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\cancel.png"));
		insbtnCancel.setBounds(101, 211, 104, 23);
		newpanel.add(insbtnCancel);
		
		/********** Delete **************/
		JPanel panel = new JPanel();
		tabbedPane_1.addTab("Delete\r\n", new ImageIcon("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\del.png"), panel, null);
		panel.setLayout(null);
		
		JLabel inslblInsid_1 = new JLabel("INS-ID : ");
		inslblInsid_1.setBounds(89, 57, 91, 24);
		panel.add(inslblInsid_1);
		
		idelcms = new JTextField();
		idelcms.setBounds(190, 57, 116, 24);
		panel.add(idelcms);
		idelcms.setColumns(10);
		
		JButton insbtnDone_1 = new JButton("Done!");
		insbtnDone_1.setIcon(new ImageIcon("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\ok.png"));
		insbtnDone_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!idelcms.getText().equals("")) {
					try {
						Class.forName(driver);
						con = DriverManager.getConnection(url,username,password);
						
						stmt = con.createStatement();
						String idelsql = "DELETE FROM instructor WHERE insid='"+idelcms.getText()+"'";
						int a=0 ;
						int res = JOptionPane.showConfirmDialog(null, "Do you want to delete ? ", "Confirmation",
							      JOptionPane.YES_NO_CANCEL_OPTION,
							      JOptionPane.PLAIN_MESSAGE);
						if(res == 0) {
							 a = stmt.executeUpdate(idelsql);
							 if(a !=0) {
								JOptionPane.showMessageDialog(null, "Removed Successfully...", "Informations...", JOptionPane.INFORMATION_MESSAGE);
							}else {
								JOptionPane.showMessageDialog(null, "Record Not Found !", "Warnings...", JOptionPane.WARNING_MESSAGE);
							}
						}
						
						con.close();
						stmt.close();
				
					}catch(Exception ex) {ex.getMessage();}
				}else {
					JOptionPane.showMessageDialog(null, "Fill the given fields !" , "Warnings...", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		insbtnDone_1.setBounds(217, 143, 89, 23);
		panel.add(insbtnDone_1);
		
		JButton insbtnCancel_1 = new JButton("Cancel");
		insbtnCancel_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idelcms.setText("");
			}
		});
		insbtnCancel_1.setIcon(new ImageIcon("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\cancel.png"));
		insbtnCancel_1.setBounds(113, 143, 89, 23);
		panel.add(insbtnCancel_1);
		
		
		/***** Update ************/
		JPanel panel_1 = new JPanel();
		tabbedPane_1.addTab("Update", new ImageIcon("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\upd.png"), panel_1, null);
		panel_1.setLayout(null);
		
		JLabel inslblInsid_2 = new JLabel("INS_iD : ");
		inslblInsid_2.setBounds(78, 65, 87, 19);
		panel_1.add(inslblInsid_2);
		
		JLabel inslabel_2 = new JLabel("Cols to be  Updated :");
		inslabel_2.setBounds(78, 109, 127, 19);
		panel_1.add(inslabel_2);
		
		JLabel inslabel_1_1 = new JLabel("New Entry : ");
		inslabel_1_1.setBounds(78, 154, 87, 19);
		panel_1.add(inslabel_1_1);
		
		iupid = new JTextField();
		iupid.setBounds(188, 64, 127, 20);
		panel_1.add(iupid);
		iupid.setColumns(10);
		
		iupdated = new JTextField();
		iupdated.setColumns(10);
		iupdated.setBounds(188, 153, 127, 20);
		panel_1.add(iupdated);
		
		Choice inschoice = new Choice();
		inschoice.add("INS-ID");
		inschoice.add("Name");
		inschoice.add("Department");
		inschoice.add("Sport");
		inschoice.add("College/Uni");
		inschoice.setBounds(215, 109, 100, 20);
		panel_1.add(inschoice);
		
		JButton btnCancel1 = new JButton("cancel");
		btnCancel1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iupid.setText("");
				iupdated.setText("");
			}
		});
		btnCancel1.setIcon(new ImageIcon("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\cancel.png"));
		btnCancel1.setBounds(96, 213, 89, 23);
		panel_1.add(btnCancel1);
		
		JButton btnOk = new JButton("OK\r\n");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!iupid.getText().equals("")) {
					try {
						Class.forName(driver);
						con = DriverManager.getConnection(url, username, password);
						
						stmt = con.createStatement();
						String upsql=null ;
						if(inschoice.getSelectedItem().equals("INS-ID")) {
							upsql = "UPDATE instructor "+ "SET insid='"+iupdated.getText()+"' WHERE insid='"+iupid.getText()+"'";
						}else if(inschoice.getSelectedItem().equals("Name")) {
							upsql = "UPDATE instructor "+ "SET Name='"+iupdated.getText()+"' WHERE insid='"+iupid.getText()+"'";
						}else if(inschoice.getSelectedItem().equals("College/Uni")) {
							upsql = "UPDATE instructor "+ "SET uni='"+iupdated.getText()+"' WHERE insid='"+iupid.getText()+"'";
						}else if(inschoice.getSelectedItem().equals("Department")) {
							upsql = "UPDATE instructor "+ "SET dept='"+iupdated.getText()+"' WHERE insid='"+iupid.getText()+"'";
						}else if(inschoice.getSelectedItem().equals("Sport")) {
							upsql = "UPDATE instructor "+ "SET sport='"+iupdated.getText()+"' WHERE insid='"+iupid.getText()+"'";
						}	
						
						int a=0 ;
						int res = JOptionPane.showConfirmDialog(null, "Do you want to Update it ? ", "Confirmation",
							      JOptionPane.YES_NO_CANCEL_OPTION,
							      JOptionPane.PLAIN_MESSAGE);
						if(res == 0) {
							 a = stmt.executeUpdate(upsql);
							 if(a !=0) {
								JOptionPane.showMessageDialog(null, "Updated Successfully...", "Informations...", JOptionPane.INFORMATION_MESSAGE);
							}else {
								JOptionPane.showMessageDialog(null, "Record Not Found !", "Warnings...", JOptionPane.WARNING_MESSAGE);
							}
						}
						
						con.close();
						stmt.close();
						
					}catch(Exception ex){
						ex.getMessage();
					}
				}else {
					JOptionPane.showMessageDialog(null, "Fill the fields !", "Warnings...", JOptionPane.WARNING_MESSAGE);					
				}
				
			}
		});
		btnOk.setIcon(new ImageIcon("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\ok.png"));
		btnOk.setBounds(206, 213, 89, 23);
		panel_1.add(btnOk);
		
		
		/* **************** Instructor END ****************** */ 
		

		/* *********** EVENTS START *************** */
		Events = new JTabbedPane(JTabbedPane.TOP);
		Events.setBounds(66, 35, 598, 333);
		frmSportEventManagement.getContentPane().add(Events);
		Events.setVisible(false);
		
		JScrollPane scrollPane11 = new JScrollPane();
		Events.addTab("Events View", new ImageIcon("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\view.png"), scrollPane11, null);
		
		DefaultTableModel Emodel = new DefaultTableModel(); 
		JTable Etable = new JTable(Emodel); 
		Etable.setBackground(new Color(173, 255, 47));
		scrollPane11.setViewportView(Etable);

		// Create a couple of columns 
		Emodel.addColumn("Event Id"); 
		Emodel.addColumn("Name");
		Emodel.addColumn("Venue");
		Emodel.addColumn("Type");		
		Emodel.addColumn("Start Date");
		Emodel.addColumn("End Date");
		
		/****** Options *********/
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		Events.addTab("Events Options", new ImageIcon("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\opts.png"), tabbedPane_2, null);
		
		/*** New Panel *********/
		JPanel panel_2 = new JPanel();
		tabbedPane_2.addTab("New Events", new ImageIcon("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\new.png"), panel_2, null);
		panel_2.setLayout(null);
		
		JLabel evlblName = new JLabel("Event ID : ");
		evlblName.setBounds(90, 53, 81, 20);
		panel_2.add(evlblName);
		
		JLabel evtlblType = new JLabel("Event Name : ");
		evtlblType.setBounds(90, 92, 81, 20);
		panel_2.add(evtlblType);
		
		JLabel evtlblVenue = new JLabel("Venue : ");
		evtlblVenue.setBounds(90, 131, 81, 20);
		panel_2.add(evtlblVenue);
		
		JLabel evtlblStartDate = new JLabel("Start Date : ");
		evtlblStartDate.setBounds(346, 53, 81, 20);
		panel_2.add(evtlblStartDate);
		
		JLabel evtlblEndDate = new JLabel("End Date : ");
		evtlblEndDate.setBounds(346, 131, 81, 20);
		panel_2.add(evtlblEndDate);
		
		JLabel evtlblInstructor = new JLabel("Event Type : ");
		evtlblInstructor.setBounds(346, 95, 81, 20);
		panel_2.add(evtlblInstructor);
		
		eid = new JTextField();
		eid.setBounds(164, 53, 108, 20);
		panel_2.add(eid);
		eid.setColumns(10);
		
		ename = new JTextField();
		ename.setColumns(10);
		ename.setBounds(164, 92, 108, 20);
		panel_2.add(ename);
		
		evenue = new JTextField();
		evenue.setColumns(10);
		evenue.setBounds(164, 131, 108, 20);
		panel_2.add(evenue);
		
		eedate = new JTextField();
		eedate.setColumns(10);
		eedate.setBounds(415, 131, 108, 20);
		panel_2.add(eedate);
		
		estdate = new JTextField();
		estdate.setColumns(10);
		estdate.setBounds(415, 53, 108, 20);
		panel_2.add(estdate);
		
		etype = new JTextField();
		etype.setColumns(10);
		etype.setBounds(415, 92, 108, 20);
		panel_2.add(etype);
		
		JButton button = new JButton("Cancel");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eid.setText("");
				ename.setText("");
				evenue.setText("");
				etype.setText("");
				estdate.setText("");
				eedate.setText("");
			}
		});
		button.setIcon(new ImageIcon("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\cancel.png"));
		button.setBounds(194, 194, 89, 23);
		panel_2.add(button);
		
		JButton btnOk_1 = new JButton("OK");
		btnOk_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(eid.getText().equals("")) && !(ename.getText().equals("")) 
						&& !(evenue.getText().equals(""))	&& !(etype.getText().equals("")) 
						&& !(estdate.getText().equals(""))  && !(eedate.getText().equals(""))) {
					
					try {
						Class.forName(driver);
						con = DriverManager.getConnection(url,username,password);
						
						String id = eid.getText();
						String name = ename.getText();
						String venue = evenue.getText();
						String type = etype.getText();
						String stdate = estdate.getText();
						String edate = eedate.getText();
						
						stmt = con.createStatement();
						String Evsql = "insert into event"+" values ('" + id +"','" + name + "','" + venue + "','"+type+"','"+ stdate+"','"+edate+"')";
						stmt.executeUpdate(Evsql);
						
						JOptionPane.showMessageDialog(null, "Inserted Row Successfully !", null, JOptionPane.INFORMATION_MESSAGE);											
						
					} catch (Exception exp) {exp.getMessage();}
					finally {
				         try {
				             if (stmt != null)
				                con.close();
				          } catch (SQLException se) {}
				          try {
				             if (con != null)
				                con.close();
				          } catch (SQLException se) {
				             se.printStackTrace();
				          }  
				       }					
				}else {
					JOptionPane.showMessageDialog(null, "Fill all the feilds!", "Warning !" , JOptionPane.WARNING_MESSAGE);
		
				}
				
			}
		});
		btnOk_1.setIcon(new ImageIcon("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\ok.png"));
		btnOk_1.setBounds(301, 194, 89, 23);
		panel_2.add(btnOk_1);
		
		
		/****** Delete Panel ***********/
		JPanel panel_11 = new JPanel();
		tabbedPane_2.addTab("Delete Events", new ImageIcon("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\del.png"), panel_11, null);
		panel_11.setLayout(null);
		
		JLabel evtlblEventId = new JLabel("Event ID :");
		evtlblEventId.setBounds(179, 71, 75, 22);
		panel_11.add(evtlblEventId);
		
		JButton evtbtnOk = new JButton("OK");
		evtbtnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!edelid.getText().equals("")) {
					try {
						Class.forName(driver);
						con = DriverManager.getConnection(url,username,password);
						
						stmt = con.createStatement();
						String edelsql = "DELETE FROM event WHERE eventid='"+edelid.getText()+"'";
						int a=0 ;
						int res = JOptionPane.showConfirmDialog(null, "Do you want to delete ? ", "Confirmation",
							      JOptionPane.YES_NO_CANCEL_OPTION,
							      JOptionPane.PLAIN_MESSAGE);
						if(res == 0) {
							System.out.println(res);
							 a = stmt.executeUpdate(edelsql);
							 System.out.println(a);
							 if(a !=0) {
								JOptionPane.showMessageDialog(null, "Removed Successfully...", "Informations...", JOptionPane.INFORMATION_MESSAGE);
							}else {
								JOptionPane.showMessageDialog(null, "Record Not Found !", "Warnings...", JOptionPane.WARNING_MESSAGE);
							}
						}
						
						con.close();
						stmt.close();
				
					}catch(Exception ex) {ex.getMessage();}
				}else {
					JOptionPane.showMessageDialog(null, "Fill the given fields !" , "Warnings...", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		evtbtnOk.setIcon(new ImageIcon("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\ok.png"));
		evtbtnOk.setBounds(289, 167, 89, 23);
		panel_11.add(evtbtnOk);
		
		JButton evtbtnCancel = new JButton("Cancel");
		evtbtnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edelid.setText("");
			}
		});
		evtbtnCancel.setIcon(new ImageIcon("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\cancel.png"));
		evtbtnCancel.setBounds(179, 167, 89, 23);
		panel_11.add(evtbtnCancel);
		
		edelid = new JTextField();
		edelid.setBounds(274, 72, 86, 20);
		panel_11.add(edelid);
		edelid.setColumns(10);
		
		/******** Update Panel *************/
		JPanel panel1 = new JPanel();
		tabbedPane_2.addTab("Updates Events\r\n", new ImageIcon("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\upd.png"), panel1, null);
		panel1.setLayout(null);
		
		JLabel evtlblEventId_1 = new JLabel("Event ID : ");
		evtlblEventId_1.setBounds(167, 68, 83, 21);
		panel1.add(evtlblEventId_1);
		
		JLabel evtlblColumn = new JLabel("Column : ");
		evtlblColumn.setBounds(167, 114, 83, 21);
		panel1.add(evtlblColumn);
		
		JLabel evtlblUpdated = new JLabel("Updated : ");
		evtlblUpdated.setBounds(167, 156, 83, 21);
		panel1.add(evtlblUpdated);
		
		eupid = new JTextField();
		eupid.setBounds(279, 68, 115, 20);
		panel1.add(eupid);
		eupid.setColumns(10);
		
		eupdated = new JTextField();
		eupdated.setColumns(10);
		eupdated.setBounds(279, 156, 115, 20);
		panel1.add(eupdated);
		
		Choice evtchoice = new Choice();
		evtchoice.add("Event ID");
		evtchoice.add("Name");
		evtchoice.add("Type");
		evtchoice.add("Venue");
		evtchoice.add("Start Date");
		evtchoice.add("End Date");
		evtchoice.setBounds(279, 114, 115, 20);
		panel1.add(evtchoice);
		
		JButton btnCancel11 = new JButton("Cancel");
		btnCancel11.setIcon(new ImageIcon("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\cancel.png"));
		btnCancel11.setBounds(196, 217, 89, 23);
		panel1.add(btnCancel11);
		
		JButton btnOk1 = new JButton("OK\r\n");
		btnOk1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!eupid.getText().equals("")) {
					try {
						Class.forName(driver);
						con = DriverManager.getConnection(url, username, password);
						
						stmt = con.createStatement();
						String eupsql=null ;
						if(evtchoice.getSelectedItem().equals("Event ID")) {
							eupsql = "UPDATE event "+ "SET eventid='"+eupdated.getText()+"' WHERE eventid='"+eupid.getText()+"'";
						}else if(evtchoice.getSelectedItem().equals("Name")) {
							eupsql = "UPDATE event "+ "SET Name='"+eupdated.getText()+"' WHERE eventid='"+eupid.getText()+"'";
						}else if(evtchoice.getSelectedItem().equals("Type")) {
							eupsql = "UPDATE event "+ "SET type='"+eupdated.getText()+"' WHERE eventid='"+eupid.getText()+"'";
						}else if(evtchoice.getSelectedItem().equals("Venue")) {
							eupsql = "UPDATE event "+ "SET venue='"+eupdated.getText()+"' WHERE eventid='"+eupid.getText()+"'";
						}else if(evtchoice.getSelectedItem().equals("Start Date")) {
							eupsql = "UPDATE event "+ "SET stdate='"+eupdated.getText()+"' WHERE eventid='"+eupid.getText()+"'";
						}else if(evtchoice.getSelectedItem().equals("End Date")) {
							eupsql = "UPDATE event "+ "SET enddate='"+eupdated.getText()+"' WHERE eventid='"+eupid.getText()+"'";
						}
						
						int a=0 ;
						int res = JOptionPane.showConfirmDialog(null, "Do you want to Update it ? ", "Confirmation",
							      JOptionPane.YES_NO_CANCEL_OPTION,
							      JOptionPane.PLAIN_MESSAGE);
						if(res == 0) {
							 a = stmt.executeUpdate(eupsql);
							 if(a !=0) {
								JOptionPane.showMessageDialog(null, "Updated Successfully...", "Informations...", JOptionPane.INFORMATION_MESSAGE);
							}else {
								JOptionPane.showMessageDialog(null, "Record Not Found !", "Warnings...", JOptionPane.WARNING_MESSAGE);
							}
						}
						
						con.close();
						stmt.close();
						
					}catch(Exception ex){
						ex.getMessage();
					}
				}else {
					JOptionPane.showMessageDialog(null, "Fill the fields !", "Warnings...", JOptionPane.WARNING_MESSAGE);					
				}
				
			}
		});
		btnOk1.setIcon(new ImageIcon("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\ok.png"));
		btnOk1.setBounds(295, 217, 89, 23);
		panel1.add(btnOk1);
		
		
		/* **************** Events END ****************** */ 
		
		
		
		/* ************* Team's START ********************/
		Teams = new JTabbedPane(JTabbedPane.TOP);
		Teams.setBounds(63, 44, 580, 307);
		frmSportEventManagement.getContentPane().add(Teams);
		Teams.setVisible(false);
		
		JScrollPane scrollPane111 = new JScrollPane();
		Teams.addTab("Teams' View\r\n", new ImageIcon("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\view.png"), scrollPane111, null);
		
		DefaultTableModel Tmodel = new DefaultTableModel(); 
		JTable ttable = new JTable(Tmodel); 
		ttable.setBackground(new Color(173, 255, 47));
		scrollPane111.setViewportView(ttable);
		
		// Create a couple of columns 
		Tmodel.addColumn("Team Name"); 
		Tmodel.addColumn("College/Uni");
		Tmodel.addColumn("Event");
		Tmodel.addColumn("Venue");		
		Tmodel.addColumn("Sport");

		/* ************** Team's END **********************/
		
		
/******************************************************************************************
 ******************************** Main Menu START *****************************************
 ******************************************************************************************/
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(173, 255, 47));
		menuBar.setFont(new Font("Segoe UI", Font.BOLD, 16));
		frmSportEventManagement.setJMenuBar(menuBar);
		
		JMenu mnUsers = new JMenu("Main Menu\r\n");
		mnUsers.setIcon(new ImageIcon("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\menu.png"));
		mnUsers.setHorizontalAlignment(SwingConstants.CENTER);
		mnUsers.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mnUsers);
		
		JMenuItem mntmAddNew = new JMenuItem("Users");
		mntmAddNew.setIcon(new ImageIcon("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\users.png"));
		mntmAddNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Home.setVisible(false);	
				Instructor.setVisible(false);
				Events.setVisible(false);
				Teams.setVisible(false);
				Users.setVisible(true);
			}
		});
		
		JMenuItem mntmHome = new JMenuItem("Home");
		mntmHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Home.setVisible(true);
				Instructor.setVisible(false);
				Users.setVisible(false);				
				Events.setVisible(false);
				Teams.setVisible(false);
			}
		});
		mntmHome.setIcon(new ImageIcon("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\home.png"));
		mnUsers.add(mntmHome);
		mnUsers.add(mntmAddNew);
		
		JMenuItem mntmDelete = new JMenuItem("Instructors");
		mntmDelete.setIcon(new ImageIcon("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\inst.png"));
		mntmDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home.setVisible(false);	
				Users.setVisible(false);
				Events.setVisible(false);
				Teams.setVisible(false);
				Instructor.setVisible(true);
				
			}
		});
		mnUsers.add(mntmDelete);
		
		JMenuItem mntmUpdateUser = new JMenuItem("Events");
		mntmUpdateUser.setIcon(new ImageIcon("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\evt.png"));
		mntmUpdateUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {											
				Home.setVisible(false);		
				Instructor.setVisible(false);
				Users.setVisible(false);
				Teams.setVisible(false);
				Events.setVisible(true);
				
			}
		});
		mnUsers.add(mntmUpdateUser);
		
		JMenuItem mntmTeams = new JMenuItem("Teams");
		mntmTeams.setIcon(new ImageIcon("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\teams.png"));
		mntmTeams.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home.setVisible(false);		
				Instructor.setVisible(false);
				Users.setVisible(false);				
				Events.setVisible(false);
				Teams.setVisible(true);
			}
		});
		mnUsers.add(mntmTeams);
		
		/* ********************** END MAIN MENU ************************/
		
		JMenuItem mntmRefresh = new JMenuItem("Refresh");
		mntmRefresh.setIcon(new ImageIcon("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\refresh.png"));
		mntmRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSportEventManagement.setVisible(false);
				frmSportEventManagement.setVisible(true);
				
				/*For Users*/
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection(url,username,password);
					
					stmt = con.createStatement();
					String sql = "SELECT * FROM users";
					res = stmt.executeQuery(sql);
					
					Umodel.setNumRows(0);
					while(res.next()) {
						String id1 = res.getString(1);
						String name1 = res.getString(2);
						String clg1 = res.getString(3);
						String dpt1 = res.getString(4);
						String sprt1 = res.getString(5);
						String team1 = res.getString(6);
						String pay1 = res.getString(7);

						Umodel.addRow(new Object[]{id1,name1, clg1, dpt1, sprt1, team1, pay1});
					}
					con.close();
					stmt.close();
					res.close();
					
				} catch (Exception ex) {ex.getMessage();}
				
				
				/*For Instructors*/
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection(url,username,password);
					
					stmt = con.createStatement();
					String Isql = "SELECT * FROM instructor";
					res = stmt.executeQuery(Isql);
					
					Imodel.setNumRows(0);
					while(res.next()) {
						String id1 = res.getString(1);
						String name1 = res.getString(2);
						String clg1 = res.getString(3);
						String dpt1 = res.getString(4);
						String sprt1 = res.getString(5);
						
						Imodel.addRow(new Object[]{id1,name1, clg1, dpt1, sprt1});
					}
					con.close();
					stmt.close();
					res.close();
					
				} catch (Exception ex) {ex.getMessage();}
				
				
				/* For Events */
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection(url,username,password);
					
					stmt = con.createStatement();
					String Isql = "SELECT * FROM event";
					res = stmt.executeQuery(Isql);
					
					Emodel.setNumRows(0);
					while(res.next()) {
						String id1 = res.getString(1);
						String name1 = res.getString(2);
						String type = res.getString(3);
						String venue = res.getString(4);
						String sdate = res.getString(5);
						String edate = res.getString(6);
						
						Emodel.addRow(new Object[]{id1,name1, type, venue, sdate,edate });
					}
					con.close();
					stmt.close();
					res.close();
					
				} catch (Exception ex) {ex.getMessage();}
				
				/* For Teams */
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection(url,username,password);
					
					stmt = con.createStatement();
					String Isql = "SELECT u.team, u.uni, e.Name, e.venue, u.sport  FROM users u JOIN event e WHERE e.type=u.sport";
					res = stmt.executeQuery(Isql);
					
					Tmodel.setNumRows(0);
					while(res.next()) {
						String team = res.getString(1);
						String clg = res.getString(2);						
						String name = res.getString(3);
						String venue = res.getString(4);
						String type = res.getString(5);
						
						Tmodel.addRow(new Object[]{team,clg,name ,venue, type});
					}
					
					con.close();
					stmt.close();
					res.close();
					
				} catch (Exception ex) {ex.getMessage();}	
			}
		});
		popupMenu.add(mntmRefresh);

		JMenuItem mntmExit_1 = new JMenuItem("Exit");
		mntmExit_1.setIcon(new ImageIcon("E:\\Eclipse\\javaProjects\\DB Project_SEMS\\src\\Icons&Images\\exit.png"));
		mntmExit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSportEventManagement.dispose();
			}
		});		
		popupMenu.add(mntmExit_1);
		
	}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
