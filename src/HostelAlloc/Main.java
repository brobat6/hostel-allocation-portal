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
	//View all student tables
	
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
//	static Boolean wasStudentBeforeExecDisplayedBefore = false;
	
	static JPanel viewWingPanel = new JPanel();
//	static JLabel wingCode = new JLabel("Set Wing Code");
//	static JLabel roomType = new JLabel("Select Room Type (S or D)");
//	static JTextField fillWingCode = new JTextField();
//	static JTextField fillRoomType = new JTextField();
//	static JButton createWingButton = new JButton("Create New Wing");
	
	static JPanel studentAfterExecMainMenuPanel = new JPanel();
	static Boolean wasStudentAfterExecDisplayedBefore = false;
//	static JButton executeAllocation = new JButton("Execute Allocation");
	
	static JPanel highScoresPanel = new JPanel();
	static String[] highScoresColumns = {"Rank", "UserName", "Score"}; 
	static String[][] highScoresTableData0 = {{"1.", "-", "0"}, {"2.", "-", "0"}, {"3.", "-", "0"}, {"4.", "-", "0"}, {"5.", "-", "0"}};
	static String[][] highScoresTableData1 = {{"1.", "-", "0"}, {"2.", "-", "0"}, {"3.", "-", "0"}, {"4.", "-", "0"}, {"5.", "-", "0"}};
	static String[][] highScoresTableData2 = {{"1.", "-", "0"}, {"2.", "-", "0"}, {"3.", "-", "0"}, {"4.", "-", "0"}, {"5.", "-", "0"}};
	static JButton backHighScores = new JButton("Back");
	static Boolean wasHighScoresPageDisplayedBefore = false;
	
	static void modifyComponent(JComponent component, int buttonSize) {
		component.setForeground(Color.BLACK);
		component.setFont(new Font("Microsoft Tai Le", Font.PLAIN, buttonSize));
		component.setBackground(Color.BLUE);
	}
	
	static void mainPage() {
		
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
				wasMainPageDisplayedBefore = true;
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
				wasLoginPageDisplayedBefore = true;
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
					mainMenu();
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
//							if (wasMainMenuPageDisplayedBefore) {
//								jf.add(mainMenuPanel);
//							}
//							else {
//								mainMenu();
//							}
							mainMenu();
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
				wasLoginPageDisplayedBefore = true;
				if (wasMainPageDisplayedBefore) {
					jf.add(mainPagePanel);
				}
				else {
					mainPage();
				}
				jf.remove(loginPagePanel);
				jf.revalidate();
			}
		});
	}
	
	static void mainMenu() {
		
		if (DataBase.adminAccess) {
			adminMainMenu();
		}
		else {
			if (DataBase.allocationDone) {
//				studentAfterExecMainMenu();
			}
			else {
				studentBeforeExecMainMenu();
			}
		}
	}
	
	static void adminMainMenu() {
		
		adminMainMenuPanel.removeAll();
		adminMainMenuPanel.setLayout(null);
		adminMainMenuPanel.setBackground(Color.WHITE);
		jf.add(adminMainMenuPanel);
		
		modifyComponent(executeAllocation, 25);
		executeAllocation.setBounds(200, 320, 220, 64);
		executeAllocation.setFocusable(false);
		adminMainMenuPanel.add(executeAllocation);
		executeAllocation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//executeAllocationDatabase()
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
//				wasMainMenuPageDisplayedBefore = true;
				DataBase.idNumber = "";
				mainPage();
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
//				wasLoginPageDisplayedBefore = true;
//				if (wasMainPageDisplayedBefore) {
//					jf.add(mainPagePanel);
//				}
//				else {
//					mainPage();
//				}
				createWingMenu();
				jf.remove(studentBeforeExecMainMenuPanel);
				jf.revalidate();
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
				
			}
		});
		
		modifyComponent(logOut, 25);
		logOut.setBounds(60, 420, 220, 64);
		logOut.setFocusable(false);
		studentBeforeExecMainMenuPanel.add(logOut);
		logOut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				wasMainMenuPageDisplayedBefore = true;
//				DataBase.userNamePlayer = "";
				mainPage();
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
		
		createWingPanel.setLayout(null);
		createWingPanel.setBackground(Color.WHITE);
		jf.add(createWingPanel);
		
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
//				wasLoginPageDisplayedBefore = true;
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
//				wasLoginPageDisplayedBefore = true;
//				if (wasMainPageDisplayedBefore) {
//					jf.add(mainPagePanel);
//				}
//				else {
//					mainPage();
//				}
				studentBeforeExecMainMenu();
				jf.remove(createWingPanel);
				jf.revalidate();
			}
		});
	}
	
static void viewWingMenu() {
		
		viewWingPanel.setLayout(null);
		viewWingPanel.setBackground(Color.WHITE);
		jf.add(viewWingPanel);
		
		
			
		modifyComponent(backButton, 20);
		backButton.setBounds(320, 430, 220, 64);
		backButton.setFocusable(false);
		createWingPanel.add(backButton);
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				wasLoginPageDisplayedBefore = true;
//				if (wasMainPageDisplayedBefore) {
//					jf.add(mainPagePanel);
//				}
//				else {
//					mainPage();
//				}
				studentBeforeExecMainMenu();
				jf.remove(createWingPanel);
				jf.revalidate();
			}
		});
	}
	
//	static void highScores() throws Exception {
//		
//		highScoresPanel.setLayout(null);
//		highScoresPanel.setBackground(Color.BLACK);
//		jf.add(highScoresPanel);
//		
//		JLabel imgLabel = new JLabel(new ImageIcon("src/resources/snakeLogo.png"));
//		highScoresPanel.add(imgLabel);
//		imgLabel.setVisible(true);
//		imgLabel.setBounds(0, 0, 600, 200);
//		
//		DataBase.loadHighScores();
//		
//		JTable highScoresTable0 = new JTable(highScoresTableData0, highScoresColumns);
//		JTable highScoresTable1 = new JTable(highScoresTableData1, highScoresColumns);
//		JTable highScoresTable2 = new JTable(highScoresTableData2, highScoresColumns);
//
//		highScoresTable0.setFillsViewportHeight(true);
//		highScoresTable0.setBounds(110, 200, 400, 200);
//		
//		highScoresTable1.setFillsViewportHeight(true);
//		highScoresTable1.setBounds(110, 200, 400, 200);
//		
//		highScoresTable2.setFillsViewportHeight(true);
//		highScoresTable2.setBounds(110, 200, 400, 200);
//		
//		JTabbedPane tp=new JTabbedPane();  
//	    tp.setBounds(160,210,300,108);
//	    tp.add("Easy",highScoresTable0);  
//	    tp.add("Medium",highScoresTable1);  
//	    tp.add("Hard",highScoresTable2);    
//
//		highScoresPanel.add(tp);
//		
//		modifyComponent(backHighScores, 25);
//		backHighScores.setBounds(200, 410, 220, 64);
//		backHighScores.setFocusable(false);
//		highScoresPanel.add(backHighScores);
//		backHighScores.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				wasHighScoresPageDisplayedBefore = true;
//				if (wasMainMenuPageDisplayedBefore) {
//					jf.add(mainMenuPanel);
//				}
//				else {
//					mainMenu();
//				}
//				jf.remove(highScoresPanel);
//			}
//		});
//		//ADD Snake Game at TOP
//		//ADD our names at bottom
//	}
	
	public static void main (String args[]) throws Exception {
//		DataBase.buildConnection();
//		DataBase.makeQuery("SELECT * FROM dataBaseSnakeGame");
		SwingUtilities.invokeLater(new Runnable() {
				public void run() {
				try {
					DataBase.buildConnection();
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println(e);
				}
				jf.setVisible(true);
				jf.setLayout(new CardLayout());
				jf.setResizable(false);
		        jf.pack();
		        jf.setTitle("Hostel Allocation Portal");
		        jf.setSize(620, 640);
		        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				mainPage();
//				System.out.println("OUT");
//				jf.add(new JLabel());
//		        mainPage();
//				loginPage();
//				createAccount();
//				mainMenu();
//				setDifficulty();
//				highScores();
			}
		});
	}

}
