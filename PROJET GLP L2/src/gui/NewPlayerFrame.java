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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import datas.DataGame;
import system.Game;
import system.GameInitializer;
import system.Player;

public class NewPlayerFrame {
	
	
	private ImagePanel pnlMain;
	private JPanel pnlTitle;
	private JPanel pnlContent;
	
	private JPanel pnlName;
	private JPanel pnlGender;
	private JPanel pnlAge;
	private JPanel pnlNext;
	private JPanel pnlBack;
	
	private JLabel lblTitle;
	private JLabel lblName;
	private JLabel lblGender;
	private JLabel lblAge;
	
	private JTextField tfName;
	private JComboBox<String> jcGender;
	private JComboBox<Integer> jcAge;
	private JButton btnNext;
	private JButton btnBack;
	
	Dimension fieldDimension;
	Dimension btnDimension;
	
	private BorderLayout mainLayout;
	private GridLayout contentLayout;

	private Font titleFont;
	private Font contentFont;
	
	private Image iiNewGameBackground;
	private JFrame frame = new JFrame();
	
	NewGameFrame newGameFrame;
	GameFrame gameFrame;
	Game game;
	
	public NewPlayerFrame(NewGameFrame newGameFrame, Game game) {
		frame.setTitle("Farm Simulator - Nouveau Joueur");
		frame.setSize(800, 500);
//		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		this.newGameFrame = newGameFrame;
		this.game = game;
		
		iiNewGameBackground = new ImageIcon("src\\images\\backgroundMenu.png").getImage();
		
		pnlMain = new ImagePanel(iiNewGameBackground);
		mainLayout = new BorderLayout();
		pnlMain.setLayout(mainLayout);
		
		pnlTitle = new JPanel();
		pnlTitle.setOpaque(false);
		lblTitle = new JLabel();
		lblTitle.setText("NOUVEAU JOUEUR");
		titleFont = new Font(Font.SANS_SERIF, Font.BOLD, 50);
		lblTitle.setFont(titleFont);
		pnlTitle.add(lblTitle);
		
		pnlContent = new JPanel();
		pnlContent.setOpaque(false);
		contentLayout = new GridLayout(6, 1);
		pnlContent.setLayout(contentLayout);
		
		fieldDimension = new Dimension(300, 50);
		contentFont = new Font(Font.SANS_SERIF, Font.PLAIN, 20);
		
		pnlName = new JPanel();
		pnlName.setOpaque(false);
		pnlName.setLayout(new FlowLayout());
		
		lblName = new JLabel();
		lblName.setText("Prénom : ");
		lblName.setFont(contentFont);
		pnlName.add(lblName);
		
		tfName = new JTextField();
		tfName.setPreferredSize(fieldDimension);
		tfName.setFont(contentFont);
		pnlName.add(tfName);
		pnlContent.add(pnlName);
		
		pnlGender = new JPanel();
		pnlGender.setOpaque(false);
		pnlGender.setLayout(new FlowLayout());
		
		lblGender = new JLabel();
		lblGender.setText("    Sexe : ");
		lblGender.setFont(contentFont);
		pnlGender.add(lblGender);
		
		jcGender = new JComboBox<>(DataGame.getGenderStrings());
		jcGender.setPreferredSize(fieldDimension);
		jcGender.setFont(contentFont);
		pnlGender.add(jcGender);
		pnlContent.add(pnlGender);
		
		pnlAge = new JPanel();
		pnlAge.setOpaque(false);
		pnlAge.setLayout(new FlowLayout());
		
		lblAge = new JLabel();
		lblAge.setText("     Age : ");
		lblAge.setFont(contentFont);
		pnlAge.add(lblAge);
		
		jcAge = new JComboBox<>(DataGame.getAgePlayer());
		jcAge.setPreferredSize(fieldDimension);
		jcAge.setFont(contentFont);
		pnlAge.add(jcAge);
		pnlContent.add(pnlAge);
		
		btnDimension = new Dimension(200, 50);
		
		pnlNext = new JPanel();
		pnlNext.setOpaque(false);
		pnlNext.setLayout(new FlowLayout());
		
		btnNext = new JButton("Lancer la partie");
		btnNext.setPreferredSize(btnDimension);
		btnNext.setFont(contentFont);
		pnlNext.add(btnNext);
		pnlContent.add(pnlNext);
		
		pnlBack = new JPanel();
		pnlBack.setOpaque(false);
		pnlBack.setLayout(new FlowLayout());
		
		btnBack = new JButton("Retour");
		btnBack.setPreferredSize(btnDimension);
		btnBack.setFont(contentFont);
		pnlBack.add(btnBack);
		pnlContent.add(pnlBack);
		
		btnNext.addActionListener(new NextAction());
		btnBack.addActionListener(new BackAction());
		
		pnlMain.add(pnlTitle, BorderLayout.NORTH);
		pnlMain.add(pnlContent, BorderLayout.CENTER);
		frame.setContentPane(pnlMain);
		frame.setVisible(true);
	}
	
	public Game getGame() {
		return game;
	}
	
	public class NextAction implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Player player = GameInitializer.newPlayer();
			player.setPrincipal(true);
			player.setName(tfName.getText());
			player.setAge(jcAge.getSelectedIndex()+10);
			player.setGender(jcGender.getSelectedItem().toString());
			NewPlayerFrame.this.getGame().setPlayer(player);
			frame.setVisible(false);
			NewPlayerFrame.this.gameFrame = new GameFrame(NewPlayerFrame.this.getGame());
			
		}
	}
	
	public class BackAction implements ActionListener {

		public void actionPerformed(ActionEvent e) {
//			NewPlayerFrame.this.setVisible(false);
			frame.setVisible(false);
			NewPlayerFrame.this.frame.setVisible(true);
		}
		
	}
}
