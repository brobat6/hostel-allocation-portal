package HostelAlloc;

import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Main {
	
	static JFrame jf = new JFrame();
	
	static JLabel mainLabel = new JLabel("Hostel Allocation Portal");
	(JComponent)mainLabel.setForeground(Color.BLACK);
	(JComponent)mainLabel.setFont(new Font("Times New Roman", Font.PLAIN, buttonSize));
	(JComponent)mainLabel.setBackground(Color.WHITE);
	
	static JPanel mainPagePanel = new JPanel();
	static JButton logInMain = new JButton("Log In");
//	static JButton createAccount = new JButton("Create Account");
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
	
	static JPanel createAccountPanel = new JPanel();
	static JLabel createUserName = new JLabel("Enter Username");
	static JLabel createPassWord = new JLabel("Enter Password");
	static JLabel rePassword = new JLabel("Re-Enter Password");
	static JTextField fillUserName = new JTextField();
	static JPasswordField fillPassWord = new JPasswordField();
	static JPasswordField fillRePassWord = new JPasswordField();
	static JButton submit = new JButton("Submit");
	static JButton backCreateAccount = new JButton("Back");
	static Boolean wasCreateAccountPageDisplayedBefore = false;
	
	static JPanel mainMenuPanel = new JPanel();
	static JButton play = new JButton("Play");
	static JButton viewHighscores = new JButton("View HighScores");
	static JButton logOut = new JButton("Logout");
	static JButton exitMainMenu = new JButton("Exit");
	static Boolean wasMainMenuPageDisplayedBefore = false;
	
	static JPanel setDifficultyPanel = new JPanel();
	static JLabel header = new JLabel("Choose Difficulty");
	static JButton easy = new JButton("Easy");
	static JButton medium = new JButton("Medium");
	static JButton hard = new JButton("Hard");
	static JButton backSetDifficulty = new JButton("Back");
	static Boolean wasSetDifficultyPageDisplayedBefore = false;
	
//	static Game game = new Game(0);
	
	static JPanel highScoresPanel = new JPanel();
	static String[] highScoresColumns = {"Rank", "UserName", "Score"}; 
	static String[][] highScoresTableData0 = {{"1.", "-", "0"}, {"2.", "-", "0"}, {"3.", "-", "0"}, {"4.", "-", "0"}, {"5.", "-", "0"}};
	static String[][] highScoresTableData1 = {{"1.", "-", "0"}, {"2.", "-", "0"}, {"3.", "-", "0"}, {"4.", "-", "0"}, {"5.", "-", "0"}};
	static String[][] highScoresTableData2 = {{"1.", "-", "0"}, {"2.", "-", "0"}, {"3.", "-", "0"}, {"4.", "-", "0"}, {"5.", "-", "0"}};
	static JButton backHighScores = new JButton("Back");
	static Boolean wasHighScoresPageDisplayedBefore = false;
	
	static void modifyComponent(JComponent component, int buttonSize) {
		component.setForeground(Color.BLACK);
		component.setFont(new Font("Times New Roman", Font.PLAIN, buttonSize));
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
		
		
		
		modifyComponent(logInMain, 25);
		logInMain.setBounds(200, 220, 220, 64);
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
		
//		modifyComponent(createAccount, 16);
//		createAccount.setBounds(200, 320, 220, 64);
//		createAccount.setFocusable(false);
//		mainPagePanel.add(createAccount);
//		createAccount.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				wasMainPageDisplayedBefore = true;
//				if (wasCreateAccountPageDisplayedBefore) {
//					jf.add(createAccountPanel);
//				}
//				else {
//					createAccount();
//				}
//				jf.remove(mainPagePanel);
//			}
//		});

		modifyComponent(exitMainPage, 25);
		exitMainPage.setBounds(200, 320, 220, 64);
		exitMainPage.setFocusable(false);
		mainPagePanel.add(exitMainPage);
		exitMainPage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		//ADD Snake Game at TOP
		//ADD our names at bottom
	}
	
	static void loginPage() {
		
		loginPagePanel.setLayout(null);
		loginPagePanel.setBackground(Color.BLACK);
		jf.add(loginPagePanel);
		
		JLabel imgLabel = new JLabel(new ImageIcon("src/resources/snakeLogo.png"));
		loginPagePanel.add(imgLabel);
		imgLabel.setVisible(true);
		imgLabel.setBounds(0, 0, 600, 200);
		
		modifyComponent(userNameLogin, 18);
		userNameLogin.setBounds(50, 220, 220, 64);
		loginPagePanel.add(userNameLogin);
		
		modifyComponent(passWordLogin, 18);
		passWordLogin.setBounds(50, 320, 220, 64);
		loginPagePanel.add(passWordLogin);
		
		fillUserNameLogin.setForeground(Color.RED);
		fillUserNameLogin.setFont(new Font("ROG Fonts", Font.PLAIN, 18));
		fillUserNameLogin.setBounds(320, 220, 220, 64);
		loginPagePanel.add(fillUserNameLogin);
		
		fillPassWordLogin.setForeground(Color.RED);
		fillPassWordLogin.setFont(new Font("Arial", Font.PLAIN, 18));
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
				else {
					try {
						if (!DataBase.checkUserNameAlreadyExists(fillUserNameLogin.getText())) {
							JOptionPane.showMessageDialog(jf, "UserName does not exist!");
						}
						else if (!DataBase.verifyUserNamePassWord(fillUserNameLogin.getText(),fillPassWordLogin.getText())) {
							JOptionPane.showMessageDialog(jf, "Incorrect PassWord!");
						}
						else {
							DataBase.userNamePlayer = fillUserNameLogin.getText();
							if (wasMainMenuPageDisplayedBefore) {
								jf.add(mainMenuPanel);
							}
							else {
								mainMenu();
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
		//ADD Snake Game at TOP
		//ADD our names at bottom
	}
	
	static void createAccount() {
		
		createAccountPanel.setLayout(null);
		createAccountPanel.setBackground(Color.BLACK);
		jf.add(createAccountPanel);
		
		JLabel imgLabel = new JLabel(new ImageIcon("src/resources/snakeLogo.png"));
		createAccountPanel.add(imgLabel);
		imgLabel.setVisible(true);
		imgLabel.setBounds(0, 0, 600, 200);
		
		modifyComponent(createUserName, 15);
		createUserName.setBounds(50, 220, 220, 64);
		createAccountPanel.add(createUserName);
		
		modifyComponent(createPassWord, 15);
		createPassWord.setBounds(50, 320, 220, 64);
		createAccountPanel.add(createPassWord);
		
		modifyComponent(rePassword, 15);
		rePassword.setBounds(50, 420, 220, 64);
		createAccountPanel.add(rePassword);
		
		fillUserName.setForeground(Color.RED);
		fillUserName.setFont(new Font("ROG Fonts", Font.PLAIN, 18));
		fillUserName.setBounds(320, 220, 220, 64);
		createAccountPanel.add(fillUserName);
		
		fillPassWord.setForeground(Color.RED);
		fillPassWord.setFont(new Font("Arial", Font.PLAIN, 18));
		fillPassWord.setBounds(320, 320, 220, 64);
		createAccountPanel.add(fillPassWord);
		
		fillRePassWord.setForeground(Color.RED);
		fillRePassWord.setFont(new Font("Arial", Font.PLAIN, 18));
		fillRePassWord.setBounds(320, 420, 220, 64);
		createAccountPanel.add(fillRePassWord);
		
		modifyComponent(submit, 18);
		submit.setBounds(50, 515, 220, 64);
		submit.setFocusable(false);
		createAccountPanel.add(submit);
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				wasCreateAccountPageDisplayedBefore = true;
				if (fillUserName.getText().equals("")) {
					JOptionPane.showMessageDialog(jf, "UserName Field is empty!");
				}
				else if (fillPassWord.getText().equals("")) {
					JOptionPane.showMessageDialog(jf, "PassWord Field is empty!");
				}
				else if (!fillPassWord.getText().equals(fillRePassWord.getText())) {
					JOptionPane.showMessageDialog(jf, "PassWords do not match!");
				}
				else {
					try {
						if (!DataBase.checkUserNameAlreadyExists(fillUserName.getText())) {
							DataBase.addNewUserToDataBase(fillUserName.getText(), fillPassWord.getText());
							DataBase.userNamePlayer = fillUserName.getText();
							JOptionPane.showMessageDialog(jf, "New account created sucessfully!");
							if (wasMainMenuPageDisplayedBefore) {
								jf.add(mainMenuPanel);
							}
							else {
								mainMenu();
							}
							jf.remove(createAccountPanel);
						}
						else {
							JOptionPane.showMessageDialog(jf, "UserName already taken!");
						}
					}
					catch (Exception e1) {
						e1.printStackTrace();
						System.out.println(e1);
					}
				}
			}
		});
		
		modifyComponent(backCreateAccount, 18);
		backCreateAccount.setBounds(320, 515, 220, 64);
		backCreateAccount.setFocusable(false);
		createAccountPanel.add(backCreateAccount);
		backCreateAccount.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				wasCreateAccountPageDisplayedBefore = true;
				if (wasMainPageDisplayedBefore) {
					jf.add(mainPagePanel);
				}
				else {
					mainPage();
				}
				jf.remove(createAccountPanel);
			}
		});
		//ADD Snake Game at TOP
		//ADD our names at bottom
	}
	
	static void mainMenu() {
		
		mainMenuPanel.setLayout(null);
		mainMenuPanel.setBackground(Color.BLACK);
		jf.add(mainMenuPanel);
		
		JLabel imgLabel = new JLabel(new ImageIcon("src/resources/snakeLogo.png"));
		mainMenuPanel.add(imgLabel);
		imgLabel.setVisible(true);
		imgLabel.setBounds(0, 0, 600, 200);
		
		modifyComponent(play, 25);
		play.setBounds(200, 220, 220, 64);
		play.setFocusable(false);
		mainMenuPanel.add(play);
		play.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (wasSetDifficultyPageDisplayedBefore) {
					jf.add(setDifficultyPanel);
				}
				else {
					setDifficulty();
				}
				jf.remove(mainMenuPanel);
			}
		});
		
		modifyComponent(viewHighscores, 15);
		viewHighscores.setBounds(200, 320, 220, 64);
		viewHighscores.setFocusable(false);
		mainMenuPanel.add(viewHighscores);
		viewHighscores.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				wasMainMenuPageDisplayedBefore = true;
				try {
					if (wasHighScoresPageDisplayedBefore) {
						jf.add(highScoresPanel);
					}
					else {
						highScores();
					}
					jf.remove(mainMenuPanel);
				} catch (Exception e1) {
					e1.printStackTrace();
					System.out.println(e1);
				}
			}
		});
			
		modifyComponent(logOut, 25);
		logOut.setBounds(60, 420, 220, 64);
		logOut.setFocusable(false);
		mainMenuPanel.add(logOut);
		logOut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				wasMainMenuPageDisplayedBefore = true;
				DataBase.userNamePlayer = "";
				if (wasMainPageDisplayedBefore) {
					jf.add(mainPagePanel);
				}
				else {
					mainPage();
				}
				jf.remove(mainMenuPanel);
			}
		});
		
		modifyComponent(exitMainMenu, 25);
		exitMainMenu.setBounds(330, 420, 220, 64);//295
		exitMainMenu.setFocusable(false);
		mainMenuPanel.add(exitMainMenu);
		exitMainMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		//ADD Snake Game at TOP
		//ADD our names at bottom
	}

//	static void runGame() {
//		jf.remove(setDifficultyPanel);
//		jf.add(game);
//		game.setGameFocus();
//		jf.pack();
//		jf.setSize(625, 650);
//		jf.setVisible(true);
//	}
	
	static void setDifficulty() {
		
		setDifficultyPanel.setLayout(null);
		setDifficultyPanel.setBackground(Color.BLACK);
		jf.add(setDifficultyPanel);
		
		JLabel imgLabel = new JLabel(new ImageIcon("src/resources/snakeLogo.png"));
		setDifficultyPanel.add(imgLabel);
		imgLabel.setVisible(true);
		imgLabel.setBounds(0, 0, 600, 200);
		
		modifyComponent(easy, 25);
		easy.setBounds(200, 220, 220, 64);
		easy.setFocusable(false);
		setDifficultyPanel.add(easy);
		easy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				wasSetDifficultyPageDisplayedBefore = true;
//				game.startNewGame(0);
//				runGame();
			}
		});
		
		modifyComponent(medium, 25);
		medium.setBounds(200, 320, 220, 64);
		medium.setFocusable(false);
		setDifficultyPanel.add(medium);
		medium.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				wasSetDifficultyPageDisplayedBefore = true;
//				game.startNewGame(1);
//				runGame();
			}
		});
		
		modifyComponent(hard, 25);
		hard.setBounds(200, 420, 220, 64);
		hard.setFocusable(false);
		setDifficultyPanel.add(hard);
		hard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				wasSetDifficultyPageDisplayedBefore = true;
//				game.startNewGame(2);
//				runGame();
			}
		});
		
		modifyComponent(backSetDifficulty, 25);
		backSetDifficulty.setBounds(200, 520, 220, 64);
		backSetDifficulty.setFocusable(false);
		setDifficultyPanel.add(backSetDifficulty);
		backSetDifficulty.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				wasSetDifficultyPageDisplayedBefore = true;
				if (wasMainMenuPageDisplayedBefore) {
					jf.add(mainMenuPanel);
				}
				else {
					mainMenu();
				}
				jf.remove(setDifficultyPanel);
			}
		});
		//ADD Snake Game at TOP
		//ADD our names at bottom
	}
	
	static void highScores() throws Exception {
		
		highScoresPanel.setLayout(null);
		highScoresPanel.setBackground(Color.BLACK);
		jf.add(highScoresPanel);
		
		JLabel imgLabel = new JLabel(new ImageIcon("src/resources/snakeLogo.png"));
		highScoresPanel.add(imgLabel);
		imgLabel.setVisible(true);
		imgLabel.setBounds(0, 0, 600, 200);
		
		DataBase.loadHighScores();
		
		JTable highScoresTable0 = new JTable(highScoresTableData0, highScoresColumns);
		JTable highScoresTable1 = new JTable(highScoresTableData1, highScoresColumns);
		JTable highScoresTable2 = new JTable(highScoresTableData2, highScoresColumns);

		highScoresTable0.setFillsViewportHeight(true);
		highScoresTable0.setBounds(110, 200, 400, 200);
		
		highScoresTable1.setFillsViewportHeight(true);
		highScoresTable1.setBounds(110, 200, 400, 200);
		
		highScoresTable2.setFillsViewportHeight(true);
		highScoresTable2.setBounds(110, 200, 400, 200);
		
		JTabbedPane tp=new JTabbedPane();  
	    tp.setBounds(160,210,300,108);
	    tp.add("Easy",highScoresTable0);  
	    tp.add("Medium",highScoresTable1);  
	    tp.add("Hard",highScoresTable2);    

		highScoresPanel.add(tp);
		
		modifyComponent(backHighScores, 25);
		backHighScores.setBounds(200, 410, 220, 64);
		backHighScores.setFocusable(false);
		highScoresPanel.add(backHighScores);
		backHighScores.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				wasHighScoresPageDisplayedBefore = true;
				if (wasMainMenuPageDisplayedBefore) {
					jf.add(mainMenuPanel);
				}
				else {
					mainMenu();
				}
				jf.remove(highScoresPanel);
			}
		});
		//ADD Snake Game at TOP
		//ADD our names at bottom
	}
	
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
//		        jf.add(new Game());
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