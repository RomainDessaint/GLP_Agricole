package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuFrame {
	
	private ImagePanel pnlMain;
	private JPanel pnlTitle;
	private JPanel pnlContent;
	
	
	private JPanel pnlNewGame;
	private JPanel pnlLoadGame;
	private JPanel pnlSettings;
	private JPanel pnlExit;
	private JFrame frame  = new JFrame();
	
	private JButton btnNewGame;
	private JButton btnLoadGame;
	private JButton btnSettings;
	private JButton btnExit;
	
	Dimension btnDimension;
	
	private JLabel lblTitle;
	
	private BorderLayout mainLayout;
	private GridLayout contentLayout;
	
	private Font titleFont;
	private Font contentFont;
	
	private Image iiMenuBackground;
	
	private NewGameFrame newGameFrame;
	
	public MenuFrame() {
		frame.setTitle("Farm Simulator - Menu");
		frame.setSize(800, 500);
//		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		iiMenuBackground = new ImageIcon("src\\images\\backgroundMenu.png").getImage();
		
		pnlMain = new ImagePanel(iiMenuBackground);
		mainLayout = new BorderLayout();
		pnlMain.setLayout(mainLayout);
		
		pnlTitle = new JPanel();
		pnlTitle.setOpaque(false);
		lblTitle = new JLabel();
		lblTitle.setText("FARM SIMULATOR");
		titleFont = new Font(Font.SANS_SERIF, Font.BOLD, 50);
		lblTitle.setFont(titleFont);
		pnlTitle.add(lblTitle);
		
		pnlContent = new JPanel();
		pnlContent.setOpaque(false);
		contentLayout = new GridLayout(5, 1);
		pnlContent.setLayout(contentLayout);
		
		btnNewGame = new JButton("Nouvelle partie");
		btnLoadGame = new JButton("Charger une partie");
		btnSettings = new JButton("Aide & options");
		btnExit = new JButton("Quitter");
		
		contentFont = new Font(Font.SANS_SERIF, Font.PLAIN, 20);
		btnDimension = new Dimension(200, 50);
		
		pnlNewGame = buildPanel(pnlContent, btnNewGame);
		btnNewGame.addActionListener(new NewGameAction());
	
		pnlLoadGame = buildPanel(pnlContent, btnLoadGame);
		btnLoadGame.addActionListener(new LoadGameAction());
		
		pnlSettings = buildPanel(pnlContent, btnSettings);
		btnSettings.addActionListener(new SettingsAction());
		
		pnlExit = buildPanel(pnlContent, btnExit);
		btnExit.addActionListener(new ExitAction());
		
		pnlMain.add(pnlTitle, BorderLayout.NORTH);
		pnlMain.add(pnlContent, BorderLayout.CENTER);
		frame.setContentPane(pnlMain);
		frame.setVisible(true);
	}
	
	public JPanel buildPanel (JPanel pnlContent, JButton btn) {
		JPanel pnl = new JPanel();
		pnl.setOpaque(false);
		pnl.setLayout(new FlowLayout());
		btn.setPreferredSize(btnDimension);
		btn.setFont(contentFont);
		pnl.add(btn);
		pnlContent.add(pnl);
		return pnl;
	}
	
	public class NewGameAction implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			MenuFrame.this.frame.setVisible(false);
			MenuFrame.this.newGameFrame = new NewGameFrame(MenuFrame.this);
		}
	}
	
	public class LoadGameAction implements ActionListener {

		public void actionPerformed(ActionEvent e) {
		}
	}
	
	public class SettingsAction implements ActionListener {

		public void actionPerformed(ActionEvent e) {
		}
	}
	
	public class ExitAction implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
}
