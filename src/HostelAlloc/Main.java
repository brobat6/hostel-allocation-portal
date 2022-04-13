package HostelAlloc;

import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Main {
	
	static JFrame jf = new JFrame();
	
	static JPanel mainPagePanel = new JPanel();
	
	static JComponent mainLabel = new JLabel("Hostel Allocation Portal");
	
	static JButton logInMain = new JButton("Log In");
	static JButton exitMainPage = new JButton("Exit");
	static Boolean wasMainPageDisplayedBefore = false;
	
	static JPanel loginPagePanel = new JPanel();
	static JLabel userNameLogin = new JLabel("Enter Username");
	static JLabel passWordLogin = new JLabel("Enter Password");
	static JTextField fillUserNameLogin = new JTextField();
	static JPasswordField fillPassWordLogin = new JPasswordField();
	static JButton logIn = new JButton("Log In");
	static JButton backLogin = new JButton("Back");
	static Boolean wasLoginPageDisplayedBefore = false;
	
	static JButton logOut = new JButton("Logout");
	static JButton exitMainMenu = new JButton("Exit");
	
	static JPanel adminMainMenuPanel = new JPanel();
	static JButton executeAllocation = new JButton("Execute Allocation");
	static Boolean wasAdminMainMenuDisplayedBefore = false;
	
	static JPanel studentBeforeExecMainMenuPanel = new JPanel();
	static JButton createWing = new JButton("Create Wing");
	static JButton joinWing = new JButton("Join Wing");
	static JButton viewWing = new JButton("View Wing");
	static Boolean wasStudentBeforeExecDisplayedBefore = false;
	
	static JButton backButton = new JButton("Back");
	
	static JPanel createWingPanel = new JPanel();
	static JLabel wingCode = new JLabel("Set Wing Code");
	static JLabel roomType = new JLabel("Select Room Type (S or D)");
	static JTextField fillWingCode = new JTextField();
	static JTextField fillRoomType = new JTextField();
	static JButton createWingButton = new JButton("Create New Wing");
	static Boolean wasCreateWingMenuDisplayedBefore = false;
	
	static JPanel viewWingPanel = new JPanel();
	static JLabel wingCodeValue = new JLabel();
	static JLabel preferredHostel = new JLabel("Type your Preferred Hostel ID");
	static JTextField fillPreferredHostel = new JTextField();
	static JButton submitPreference = new JButton("Submit Preference");
	static Boolean wasViewWingMenuDisplayedBefore = false;
	
	static JPanel studentAfterExecMainMenuPanel = new JPanel();
	static JLabel displayID = new JLabel();
	static JLabel displayRoomNo = new JLabel();
	static Boolean wasStudentAfterExecDisplayedBefore = false;
	
	static void modifyComponent(JComponent component, int buttonSize) {
		component.setForeground(Color.BLACK);
		component.setFont(new Font("Microsoft Tai Le", Font.PLAIN, buttonSize));
		component.setBackground(Color.BLUE);
	}
	
	static void mainPage() {
		jf.getContentPane().invalidate();
		jf.getContentPane().validate();
		jf.getContentPane().repaint();
		
		wasMainPageDisplayedBefore = true;
		
		mainPagePanel.setLayout(null);
		mainPagePanel.setBackground(Color.WHITE);
		jf.add(mainPagePanel);
		
		JLabel imgLabel = new JLabel(new ImageIcon("src/resources/logo.gif"));
		mainPagePanel.add(imgLabel);
		imgLabel.setVisible(true);
		imgLabel.setBounds(0, 0, 675, 200);
		
		mainLabel.setForeground(Color.BLACK);
		mainLabel.setFont(new Font("STXihei", Font.BOLD, 28));
		mainLabel.setBackground(Color.BLACK);
		mainLabel.setBounds(140, 190, 400, 64);
		mainPagePanel.add(mainLabel);	
		
		modifyComponent(logInMain, 25);
		logInMain.setBounds(200, 320, 220, 64);
		logInMain.setFocusable(false);
		mainPagePanel.add(logInMain);
		logInMain.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (wasLoginPageDisplayedBefore) {
					jf.add(loginPagePanel);
				}
				else {
					loginPage();
				}
				jf.remove(mainPagePanel);
			}
		});

		modifyComponent(exitMainPage, 25);
		exitMainPage.setBounds(200, 420, 220, 64);
		exitMainPage.setFocusable(false);
		mainPagePanel.add(exitMainPage);
		exitMainPage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	static void loginPage() {
		jf.getContentPane().invalidate();
		jf.getContentPane().validate();
		jf.getContentPane().repaint();
		
		wasLoginPageDisplayedBefore = true;
		
		loginPagePanel.setLayout(null);
		loginPagePanel.setBackground(Color.WHITE);
		jf.add(loginPagePanel);
		
		JLabel imgLabel = new JLabel(new ImageIcon("src/resources/logo.gif"));
		loginPagePanel.add(imgLabel);
		imgLabel.setVisible(true);
		imgLabel.setBounds(0, 0, 675, 200);
		
		modifyComponent(userNameLogin, 22);
		userNameLogin.setBounds(50, 220, 220, 64);
		loginPagePanel.add(userNameLogin);
		
		modifyComponent(passWordLogin, 22);
		passWordLogin.setBounds(50, 320, 220, 64);
		loginPagePanel.add(passWordLogin);
		
		fillUserNameLogin.setForeground(Color.BLACK);
		fillUserNameLogin.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 22));
		fillUserNameLogin.setBounds(320, 220, 220, 64);
		loginPagePanel.add(fillUserNameLogin);
		
		fillPassWordLogin.setForeground(Color.BLACK);
		fillPassWordLogin.setFont(new Font("Arial", Font.PLAIN, 22));
		fillPassWordLogin.setBounds(320, 320, 220, 64);
		loginPagePanel.add(fillPassWordLogin);
		
		modifyComponent(logIn, 20);
		logIn.setBounds(50, 430, 220, 64);
		logIn.setFocusable(false);
		loginPagePanel.add(logIn);
		logIn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (fillUserNameLogin.getText().equals("")) {
					JOptionPane.showMessageDialog(jf, "UserName Field is empty!");
				}
				else if (fillPassWordLogin.getText().equals("")) {
					JOptionPane.showMessageDialog(jf, "PassWord Field is empty!");
				}
				else if (fillUserNameLogin.getText().equals("admin") && fillPassWordLogin.getText().equals("abcd")) {
					DataBase.idNumber = "admin";
					DataBase.adminAccess = true;
					if (wasAdminMainMenuDisplayedBefore) {
						jf.add(adminMainMenuPanel);
					}
					else {
						adminMainMenu();
					}
					jf.remove(loginPagePanel);
				}
				else {
					try {
						if (!DataBase.checkIDAlreadyExists(fillUserNameLogin.getText())) {
							JOptionPane.showMessageDialog(jf, "UserName does not exist!");
						}
						else if (!DataBase.verifyIDPassWord(fillUserNameLogin.getText(),fillPassWordLogin.getText())) {
							JOptionPane.showMessageDialog(jf, "Incorrect Password!");
						}
						else {
							DataBase.idNumber = fillUserNameLogin.getText();
							DataBase.adminAccess = false;
							if (DataBase.allocationDone) {
								if (wasStudentAfterExecDisplayedBefore) {
									jf.add(studentAfterExecMainMenuPanel);
								}
								else {
									studentAfterExecMainMenu();
								}
							}
							else {
								if (wasStudentBeforeExecDisplayedBefore) {
									jf.add(studentBeforeExecMainMenuPanel);
								}
								else {
									studentBeforeExecMainMenu();
								}
							}
							jf.remove(loginPagePanel);
						}
					}
					catch (Exception e1) {
						e1.printStackTrace();
						System.out.println(e1);
					}
				}
			}
		});
		
		modifyComponent(backLogin, 20);
		backLogin.setBounds(320, 430, 220, 64);
		backLogin.setFocusable(false);
		loginPagePanel.add(backLogin);
		backLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (wasMainPageDisplayedBefore) {
					jf.add(mainPagePanel);
				}
				else {
					mainPage();
				}
				jf.remove(loginPagePanel);
			}
		});
	}
	
	static void adminMainMenu() {
		jf.getContentPane().invalidate();
		jf.getContentPane().validate();
		jf.getContentPane().repaint();
		
		wasAdminMainMenuDisplayedBefore = true;
		
		adminMainMenuPanel.setLayout(null);
		adminMainMenuPanel.setBackground(Color.WHITE);
		jf.add(adminMainMenuPanel);
		
		JLabel imgLabel = new JLabel(new ImageIcon("src/resources/logo.gif"));
		adminMainMenuPanel.add(imgLabel);
		imgLabel.setVisible(true);
		imgLabel.setBounds(0, 0, 675, 200);
		
		modifyComponent(executeAllocation, 25);
		executeAllocation.setBounds(160, 320, 300, 64);
		executeAllocation.setFocusable(false);
		adminMainMenuPanel.add(executeAllocation);
		executeAllocation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 try {
					DataBase.allocationofSingleRooms();
				}  catch (Exception e1) {
					e1.printStackTrace();
				}
			       try {
					DataBase.allocationOfDoubleRooms();
				}  catch (Exception e2) {
					e2.printStackTrace();
				}
			       try {
					DataBase.allocateRemainingRooms();
				}  catch (Exception e3) {
					e3.printStackTrace();
				}
				if (DataBase.allocationDone) {
					JOptionPane.showMessageDialog(jf, "Hostel Allocation Already Complete!");
				}
				else {
					DataBase.allocationDone = true;
					JOptionPane.showMessageDialog(jf, "Hostel Allocation Complete!");
				}
			}
		});
		
		modifyComponent(logOut, 25);
		logOut.setBounds(60, 420, 220, 64);
		logOut.setFocusable(false);
		adminMainMenuPanel.add(logOut);
		logOut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DataBase.idNumber = "";
				if (wasMainPageDisplayedBefore) {
					jf.add(mainPagePanel);
				}
				else {
					mainPage();
				}
				jf.remove(adminMainMenuPanel);
			}
		});
		
		modifyComponent(exitMainMenu, 25);
		exitMainMenu.setBounds(330, 420, 220, 64);//295
		exitMainMenu.setFocusable(false);
		adminMainMenuPanel.add(exitMainMenu);
		exitMainMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	static void studentBeforeExecMainMenu() {
		jf.getContentPane().invalidate();
		jf.getContentPane().validate();
		jf.getContentPane().repaint();
		
		wasStudentBeforeExecDisplayedBefore = true;
		
		studentBeforeExecMainMenuPanel.setLayout(null);
		studentBeforeExecMainMenuPanel.setBackground(Color.WHITE);
		jf.add(studentBeforeExecMainMenuPanel);
		
		modifyComponent(createWing, 25);
		createWing.setBounds(200, 120, 220, 64);
		createWing.setFocusable(false);
		studentBeforeExecMainMenuPanel.add(createWing);
		createWing.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (wasCreateWingMenuDisplayedBefore) {
					jf.add(createWingPanel);
				}
				else {
					createWingMenu();
				}
				jf.remove(studentBeforeExecMainMenuPanel);
			}
		});
		
		modifyComponent(joinWing, 25);
		joinWing.setBounds(200, 220, 220, 64);
		joinWing.setFocusable(false);
		studentBeforeExecMainMenuPanel.add(joinWing);
		joinWing.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String givenWingCode = JOptionPane.showInputDialog(jf, "Type WING CODE of the wing that you want to join");
				try {
					DataBase.joinNewWing(givenWingCode);
					JOptionPane.showMessageDialog(jf, "Wing Joined Successfully!");
				}
				catch (Exception eJoinNewWing) {
					JOptionPane.showMessageDialog(jf, eJoinNewWing.getMessage());
				}
			}
		});
		
		modifyComponent(viewWing, 25);
		viewWing.setBounds(200, 320, 220, 64);
		viewWing.setFocusable(false);
		studentBeforeExecMainMenuPanel.add(viewWing);
		viewWing.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (wasViewWingMenuDisplayedBefore) {
					jf.add(viewWingPanel);
				}
				else {
					viewWingMenu();
				}
				jf.remove(studentBeforeExecMainMenuPanel);
			}
		});
		
		modifyComponent(logOut, 25);
		logOut.setBounds(60, 420, 220, 64);
		logOut.setFocusable(false);
		studentBeforeExecMainMenuPanel.add(logOut);
		logOut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DataBase.idNumber = "";
				if (wasMainPageDisplayedBefore) {
					jf.add(mainPagePanel);
				}
				else {
					mainPage();
				}
				jf.remove(studentBeforeExecMainMenuPanel);
			}
		});
		
		modifyComponent(exitMainMenu, 25);
		exitMainMenu.setBounds(330, 420, 220, 64);//295
		exitMainMenu.setFocusable(false);
		studentBeforeExecMainMenuPanel.add(exitMainMenu);
		exitMainMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	static void createWingMenu() {
		jf.getContentPane().invalidate();
		jf.getContentPane().validate();
		jf.getContentPane().repaint();
		
		wasCreateWingMenuDisplayedBefore = true;
		
		createWingPanel.setLayout(null);
		createWingPanel.setBackground(Color.WHITE);
		jf.add(createWingPanel);
		
		JLabel imgLabel = new JLabel(new ImageIcon("src/resources/logo.gif"));
		createWingPanel.add(imgLabel);
		imgLabel.setVisible(true);
		imgLabel.setBounds(0, 0, 675, 200);
		
		modifyComponent(wingCode, 22);
		wingCode.setBounds(50, 220, 300, 64);
		createWingPanel.add(wingCode);
		
		modifyComponent(roomType, 22);
		roomType.setBounds(50, 320, 300, 64);
		createWingPanel.add(roomType);
		
		fillWingCode.setForeground(Color.BLACK);
		fillWingCode.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 22));
		fillWingCode.setBounds(375, 220, 220, 50);
		createWingPanel.add(fillWingCode);
		
		fillRoomType.setForeground(Color.BLACK);
		fillRoomType.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 22));
		fillRoomType.setBounds(375, 320, 220, 50);
		createWingPanel.add(fillRoomType);
		
		modifyComponent(createWingButton, 20);
		createWingButton.setBounds(50, 430, 220, 64);
		createWingButton.setFocusable(false);
		createWingPanel.add(createWingButton);
		createWingButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (fillWingCode.getText().equals("")) {
					JOptionPane.showMessageDialog(jf, "Wing Code field is empty!");
				}
				else if (fillRoomType.getText().equals("")) {
					JOptionPane.showMessageDialog(jf, "Room Type field is empty!");
				}
				else {
					try {
						DataBase.createNewWing(fillWingCode.getText(), fillRoomType.getText());
						JOptionPane.showMessageDialog(jf, "Wing Created Successfully!");
					}
					catch (Exception eCreateNewWing) {
						JOptionPane.showMessageDialog(jf, eCreateNewWing.getMessage());
					}
				}
			}
		});
			
		modifyComponent(backButton, 20);
		backButton.setBounds(320, 430, 220, 64);
		backButton.setFocusable(false);
		createWingPanel.add(backButton);
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (wasStudentBeforeExecDisplayedBefore) {
					jf.add(studentBeforeExecMainMenuPanel);
				}
				else {
					studentBeforeExecMainMenu();
				}
				jf.remove(createWingPanel);
			}
		});
	}
	
	static void viewWingMenu() {
		
		jf.getContentPane().invalidate();
		jf.getContentPane().validate();
		jf.getContentPane().repaint();
		
		wasViewWingMenuDisplayedBefore = true;
		
		viewWingPanel.setLayout(null);
		viewWingPanel.setBackground(Color.WHITE);
		jf.add(viewWingPanel);
		
		try {
			wingCodeValue.setText("Wing Code - " + DataBase.findWingCode());
		}
		catch (Exception eViewWing2) {
			System.out.println("BRUH");
		}
		wingCodeValue.setForeground(Color.BLACK);
		wingCodeValue.setFont(new Font("STXihei", Font.BOLD, 20));
		wingCodeValue.setBackground(Color.BLACK);
		wingCodeValue.setBounds(150, 0, 300, 152);
		viewWingPanel.add(wingCodeValue);	
		
		try {
			ResultSet rs;
			String[] columns = new String[2];
			columns[0] = "Student ID";
			columns[1] = "Student Name";
			String[][] members = new String[8][2];
			members[0][0] = DataBase.findWingLeader();
			members[0][1] = DataBase.findName(members[0][0]);
			rs = DataBase.viewWing();
			int pos = 1;
			while (rs.next()) {
				members[pos][0] = rs.getString(1);
				members[pos][1] = rs.getString(2);
				pos++;
			}
			JTable membersOfWing = new JTable(members, columns);
			membersOfWing.setEnabled(false);
		    JScrollPane sp=new JScrollPane(membersOfWing);
		    sp.setBounds(150, 100, 300, 152);
			viewWingPanel.add(sp);
		}
		catch (Exception eViewWing) {
			System.out.println(eViewWing);
		}
		
		modifyComponent(preferredHostel, 22);
		preferredHostel.setBounds(20, 300, 290, 64);
		viewWingPanel.add(preferredHostel);
		
		fillPreferredHostel.setForeground(Color.BLACK);
		fillPreferredHostel.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 22));
		fillPreferredHostel.setBounds(320, 300, 220, 64);
		viewWingPanel.add(fillPreferredHostel);
		
		modifyComponent(submitPreference, 20);
		submitPreference.setBounds(90, 430, 220, 64);
		submitPreference.setFocusable(false);
		viewWingPanel.add(submitPreference);
		submitPreference.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					DataBase.addPreferences(fillPreferredHostel.getText());
					JOptionPane.showMessageDialog(jf, "Preference submitted successfully!");
				}
				catch (Exception eViewWingMenu3) {
					JOptionPane.showMessageDialog(jf, eViewWingMenu3.getMessage());
				}
			}
		});
		
		modifyComponent(backButton, 20);
		backButton.setBounds(320, 430, 220, 64);
		backButton.setFocusable(false);
		viewWingPanel.add(backButton);
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (wasStudentBeforeExecDisplayedBefore) {
					jf.add(studentBeforeExecMainMenuPanel);
				}
				else {
					studentBeforeExecMainMenu();
				}
				jf.remove(viewWingPanel);
			}
		});
	}
	
	static void studentAfterExecMainMenu() {
		
		jf.getContentPane().invalidate();
		jf.getContentPane().validate();
		jf.getContentPane().repaint();
		
		wasStudentAfterExecDisplayedBefore = true;
		
		studentAfterExecMainMenuPanel.setLayout(null);
		studentAfterExecMainMenuPanel.setBackground(Color.WHITE);
		jf.add(studentAfterExecMainMenuPanel);
		
		JLabel imgLabel = new JLabel(new ImageIcon("src/resources/logo.gif"));
		studentAfterExecMainMenuPanel.add(imgLabel);
		imgLabel.setVisible(true);
		imgLabel.setBounds(0, 0, 675, 200);
		
		try {
			ResultSet rs = DataBase.viewAllocation();
			rs.next();
			displayID.setText("Student ID - " + rs.getString(1));
			displayID.setForeground(Color.BLACK);
			displayID.setFont(new Font("STXihei", Font.BOLD, 25));
			displayID.setBackground(Color.BLACK);
			displayID.setBounds(150, 180, 300, 152);
			studentAfterExecMainMenuPanel.add(displayID);
			displayRoomNo.setText("Room Number - " + rs.getString(2) + " " + rs.getString(3));
			displayRoomNo.setForeground(Color.BLACK);
			displayRoomNo.setFont(new Font("STXihei", Font.BOLD, 25));
			displayRoomNo.setBackground(Color.BLACK);
			displayRoomNo.setBounds(150, 250, 300, 152);
			studentAfterExecMainMenuPanel.add(displayRoomNo);
		}
		catch (Exception eViewWing) {
			System.out.println(eViewWing);
		}
		
		modifyComponent(logOut, 25);
		logOut.setBounds(220, 420, 220, 64);
		logOut.setFocusable(false);
		studentAfterExecMainMenuPanel.add(logOut);
		logOut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DataBase.idNumber = "";
				if (wasMainPageDisplayedBefore) {
					jf.add(mainPagePanel);
				}
				else {
					mainPage();
				}
				jf.remove(studentAfterExecMainMenuPanel);
			}
		});
	}
	
	public static void main (String args[]) throws Exception {
		SwingUtilities.invokeLater(new Runnable() {
				public void run() {
				try {
					DataBase.buildConnection();
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println(e);
				}
				try {
					DataBase.allocationDoneOrNot();
				} catch (Exception e) {
					e.printStackTrace();
				}
				jf.setVisible(true);
				jf.setLayout(new CardLayout());
				jf.setResizable(false);
		        jf.pack();
		        jf.setTitle("Hostel Allocation Portal");
		        jf.setSize(620, 640);
		        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				mainPage();
			}
		});
	}

}
