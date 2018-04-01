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

public class NewGameFrame {

	
	private ImagePanel pnlMain;
	private JPanel pnlTitle;
	private JPanel pnlContent;
	
	private JPanel pnlGameName;
	private JPanel pnlDifficulty;
	private JPanel pnlNext;
	private JPanel pnlBack;
	
	private JLabel lblTitle;
	private JLabel lblGameName;
	private JLabel lblDifficulty;
	
	private JTextField tfGameName;
	private JComboBox<String> jcDifficulty;
	private JButton btnNext;
	private JButton btnBackMenu;
	
	Dimension fieldDimension;
	Dimension btnDimension;
	
	private BorderLayout mainLayout;
	private GridLayout contentLayout;
	
	private Font titleFont;
	private Font contentFont;
	
	private Image iiNewGameBackground;

	private MenuFrame menuFrame;
	private NewPlayerFrame newPlayerFrame;
	private JFrame frame = new JFrame();
	
	public NewGameFrame(MenuFrame menuFrame) {
		frame.setTitle("Farm Simulator - Nouvelle Partie");
		frame.setSize(800, 500);
//		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		this.menuFrame = menuFrame;
		
		iiNewGameBackground = new ImageIcon("src\\images\\backgroundMenu.png").getImage();
		
		pnlMain = new ImagePanel(iiNewGameBackground);
		mainLayout = new BorderLayout();
		pnlMain.setLayout(mainLayout);
		
		pnlTitle = new JPanel();
		pnlTitle.setOpaque(false);
		lblTitle = new JLabel();
		lblTitle.setText("NOUVELLE PARTIE");
		titleFont = new Font(Font.SANS_SERIF, Font.BOLD, 50);
		lblTitle.setFont(titleFont);
		pnlTitle.add(lblTitle);
		
		pnlContent = new JPanel();
		pnlContent.setOpaque(false);
		contentLayout = new GridLayout(5, 1);
		pnlContent.setLayout(contentLayout);
		
		fieldDimension = new Dimension(300, 50);
		contentFont = new Font(Font.SANS_SERIF, Font.PLAIN, 20);
		
		pnlGameName = new JPanel();
		pnlGameName.setOpaque(false);
		pnlGameName.setLayout(new FlowLayout());
		
		lblGameName = new JLabel();
		lblGameName.setText("Nom de la partie : ");
		lblGameName.setFont(contentFont);
		pnlGameName.add(lblGameName);
		
		tfGameName = new JTextField();
		tfGameName.setPreferredSize(fieldDimension);
		tfGameName.setText("Partie de ");
		tfGameName.setFont(contentFont);
		pnlGameName.add(tfGameName);
		pnlContent.add(pnlGameName);
		
		pnlDifficulty = new JPanel();
		pnlDifficulty.setOpaque(false);
		pnlDifficulty.setLayout(new FlowLayout());
		
		lblDifficulty = new JLabel();   
		lblDifficulty.setText("           Difficulté : ");
		lblDifficulty.setFont(contentFont);
		pnlDifficulty.add(lblDifficulty);
		
		jcDifficulty = new JComboBox<>(DataGame.getDifficultyStrings());
		jcDifficulty.setPreferredSize(fieldDimension);
		jcDifficulty.setFont(contentFont);
		pnlDifficulty.add(jcDifficulty);
		pnlContent.add(pnlDifficulty);
		
		btnDimension = new Dimension(200, 50);
		
		pnlNext = buildPanel();
		
		btnNext = buildButton("Continuer");
		btnNext.setPreferredSize(btnDimension);
		btnNext.setFont(contentFont);
		pnlNext.add(btnNext);
		pnlContent.add(pnlNext);
		
		pnlBack = buildPanel();
		
		btnBackMenu = buildButton("Retour");
		pnlBack.add(btnBackMenu);
		pnlContent.add(pnlBack);
		
		btnNext.addActionListener(new NextAction());
		btnBackMenu.addActionListener(new BackMenuAction());
		
		pnlMain.add(pnlTitle, BorderLayout.NORTH);
		pnlMain.add(pnlContent, BorderLayout.CENTER);
		frame.setContentPane(pnlMain);
		frame.setVisible(true);
	}	
	
	public JPanel buildPanel() {
		JPanel pnl = new JPanel();
		pnl.setOpaque(false);
		pnl.setLayout(new FlowLayout());
		return pnl;
		
	}
	
	public JButton buildButton (String text) {
		JButton btn = new JButton();
		btn.setText(text);
		btn.setPreferredSize(btnDimension);
		btn.setFont(contentFont);
		return btn;
	}
	
	public class NextAction implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Game game = GameInitializer.newGame();
			game.setGameName(tfGameName.getText());
			game.setDifficulty(jcDifficulty.getSelectedIndex());
			game.setInfrastructures(GameInitializer.initInfrastructures());
			game.setPlayers(GameInitializer.initPlayers());
			game.setShop(GameInitializer.newShop());
			game.setMoney(DataGame.getStartingMoney(game.getDifficulty()));
			game.setEventState(-1);
			frame.setVisible(false);
			NewGameFrame.this.newPlayerFrame = new NewPlayerFrame(NewGameFrame.this, game);
		}
	}
	
	public class BackMenuAction implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			new NewGameFrame(menuFrame);
//			NewGameFrame.this.menuFrame.setVisible(true);
		}
	}
}
