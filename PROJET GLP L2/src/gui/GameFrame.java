package gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import datas.DataObjects;
import system.Game;
import types.Animal;

public class GameFrame {
	private JSplitPane pnlMain;
	private JSplitPane pnlCenter;
	private JPanel pnlDb = new JPanel();
	private JPanel pnlOpt = new JPanel();
	private JPanel pnlInfo = new JPanel();
	private JPanel pnlOptS1 = new JPanel();
	private JPanel pnlOptS2 = new JPanel();
	private JPanel pnlOptS3 = new JPanel();
	private JPanel pnlOptS4 = new JPanel();
	
	TimePanel infoTime;
	MoneyPanel infoMoney;
	EventPanel infoEvent;
	
	private JFrame frame = new JFrame();
	
	private HouseInfo houseInfo;
	private SiloInfo siloInfo;
	private GarageInfo garageInfo;
	
	private MarketFrame marketFrame;

	private JButton btnSpoilOpt;
	private JButton btnHideOpt;
	private JButton btnHouse;
	private JButton btnShop;
	private JButton btnMarket;
	private JButton btnTimeMore;
	private JButton btnTimeStop;
	private JButton btnTimeLess;
	
	private static JButton farmer;
	
	private GridBagLayout gridLayout;
	private GridBagConstraints gridConstraints;
	
	private FarmInitializer farmInitializer;
	
	static boolean farmerOn = false;
	static int targetX;
	static int targetY;
	static int raw = 0;
	
	static JLabel location;
	
	static Game game;
	
	public GameFrame(Game game) {
		frame.setTitle("Farm Simulator");
		frame.setSize(1200, 600);
		frame.setLocation(50, 50);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		GameFrame.game = game;
		System.out.println(game.toString());

		//PANEL MAIN : CONTENT PANE
		pnlMain = initSplitPanel(3, 520);
        pnlMain.setOrientation(JSplitPane.VERTICAL_SPLIT);
		
		//PANEL INFO
		pnlInfo.setBackground(Color.BLACK);
		pnlInfo.setOpaque(true);
		pnlInfo.setLayout(null);
		
		infoTime = new TimePanel();
		infoMoney = new MoneyPanel();
		infoEvent = new EventPanel();
		
		pnlInfo = PanelInfo.initPnlInfo(pnlInfo, infoTime, infoMoney, infoEvent);
		
		pnlInfo.setBackground(Color.gray);
        pnlMain.setRightComponent(pnlInfo);
        
        //PANEL CENTER : CONTIENT PANEL DB + PANEL OPT
        pnlCenter = initSplitPanel(3, 1200);
		pnlCenter.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		pnlMain.setLeftComponent(pnlCenter);
        
        //PANEL DASHBOARD
		pnlDb.setLayout(null);
		
		//PANEL ANIMATION
		JPanel animePanel = new JPanel();
		animePanel.setBounds(0, 0, 1200, 600);
		animePanel.setBackground(new Color(100, 0, 0, 255));
		animePanel.setOpaque(false);
		animePanel.setLayout(null);
		
		farmer = initButton("src\\images\\linkright.png", animePanel);
		farmer.setBounds(100, 400, 50, 50);
		farmer.addActionListener(new FarmerAction());
		pnlDb.add(animePanel);
		
		farmInitializer = new FarmInitializer(pnlDb, frame.getWidth(), frame.getHeight());
		
		btnHouse = initButton("src\\images\\house.png", pnlDb);
		btnHouse.setBounds(10, 50, new ImageIcon("src\\images\\house.png").getIconWidth(), new ImageIcon("src\\images\\house.png").getIconHeight());
		
		JButton btnReserve = initButton("src\\images\\reserve.png", pnlDb);
		btnReserve.setBounds(new ImageIcon("src\\images\\house.png").getIconWidth()+30, 10, new ImageIcon("src\\images\\reserve.png").getIconWidth(), new ImageIcon("src\\images\\reserve.png").getIconHeight());
		btnReserve.setVisible(false);
		DataObjects.warehouse.put("Réserve", btnReserve);
		
		JButton btnGarage = initButton("src\\images\\garage.png", pnlDb);
		btnGarage.setBounds(btnReserve.getX()+30+btnReserve.getWidth(), 50, new ImageIcon("src\\images\\garage.png").getIconWidth(), new ImageIcon("src\\images\\garage.png").getIconHeight());
		btnGarage.setVisible(false);
		DataObjects.warehouse.put("Garage", btnGarage);
		
		JButton btnSilo = initButton("src\\images\\Silo.png", pnlDb);
		btnSilo.setBounds(btnGarage.getX()+btnGarage.getWidth()+30, 10, new ImageIcon("src\\images\\Silo.png").getIconWidth(), new ImageIcon("src\\images\\Silo.png").getIconHeight());
		btnSilo.setVisible(false);
		DataObjects.warehouse.put("Silo", btnSilo);
		
		btnSpoilOpt = initButton("src\\images\\spoil.png", pnlDb);
		btnSpoilOpt.setBounds(1130, 440, 50, 50);
		btnHideOpt = initButton("src\\images\\spoil.png", pnlDb);
		btnHideOpt.setBounds(940, 440, 50, 50);
		btnHideOpt.setVisible(false);
		pnlDb = farmInitializer.drawGround();
		
		pnlCenter.setLeftComponent(pnlDb);

		//PANEL OPTION
		pnlOpt.setLayout(new GridLayout(4, 1));
		pnlOpt.setBackground(Color.gray);
		
		//PANEL OPTION ETAGE 1
		pnlOptS1 = new JPanel();
		pnlOptS1.setBackground(Color.gray);
		pnlOptS2.setLayout(new GridLayout(1,2));
		btnShop = new JButton("Shop");
		btnMarket = new JButton("Market");
		pnlOptS1.add(btnShop);
		pnlOptS1.add(btnMarket);
		pnlOpt.add(pnlOptS1);
		
		//PANEL OPTION ETAGE 2
		pnlOptS2 = new JPanel();
		pnlOptS2.setBackground(Color.gray);
		pnlOpt.add(pnlOptS2);
		
		//PANEL OPTION ETAGE 3
		pnlOptS3 = new JPanel();
		pnlOptS3.setBackground(Color.gray);
		pnlOpt.add(pnlOptS3);
		
		//PANEL OPTION ETAGE 4
		pnlOptS4 = new JPanel();
		pnlOptS4.setBackground(Color.gray);
		pnlOptS4.setLayout(new GridLayout(1, 3));
		btnTimeLess = initButton("src\\images\\less.png", pnlOptS4);
		btnTimeStop = initButton("src\\images\\pause.png", pnlOptS4);
		btnTimeMore = initButton("src\\images\\plus.png", pnlOptS4);
		pnlOpt.add(pnlOptS4);
		
		//AJOUT DU PANEL OPTION AU PANEL CENTER
		pnlCenter.setRightComponent(pnlOpt);
		
		//AJOUT DES ACTION LISTENER
        btnShop.addActionListener(new OpenShopAction());
        btnMarket.addActionListener(new OpenMarketAction());
		btnSpoilOpt.addActionListener(new SpoilOptAction(btnSpoilOpt, btnHideOpt));
		btnHideOpt.addActionListener(new HideOptAction(btnSpoilOpt, btnHideOpt));
		btnTimeLess.addActionListener(new LessTimeAction(getInfoTime()));
		btnTimeStop.addActionListener(new StopTimeAction(getInfoTime(), btnTimeStop));
		btnTimeMore.addActionListener(new MoreTimeAction(getInfoTime()));
		
		btnHouse.addActionListener(new OpenHouseAction());
		btnSilo.addActionListener(new OpenSiloAction());
		btnGarage.addActionListener(new OpenGarageAction());
		
		frame.addWindowListener(new WindowAdapter());
		pnlDb.addMouseListener(new dbClickAction(this, pnlDb));
		
		frame.setContentPane(pnlMain);
		frame.setVisible(true);
	}
	
	public static boolean isFarmerOn() {
		return farmerOn;
	}
	public static void setFarmerOn(boolean on) {
		farmerOn = on;
	}
	public static int getTargetX() {
		return targetX;
	}
	public void setTargetX(int targetX) {
		GameFrame.targetX = targetX;
	}
	public static int getTargetY() {
		return targetY;
	}
	public void setTargetY(int targetY) {
		GameFrame.targetY = targetY;
	}
	public JPanel getDbPanel() {
		return pnlDb;
	}
	
	public static void moveFarmer(String direction, int posX, int posY) {
		int pas = 1;
		switch(direction) {
		case "N" : posY = posY - pas;
			farmer.setIcon(new ImageIcon("src\\images\\linkback.png"));
			break;
		case "S" : posY = posY + pas;
			farmer.setIcon(new ImageIcon("src\\images\\linkface.png"));
			break;
		case "E" : posX = posX + pas;
		farmer.setIcon(new ImageIcon("src\\images\\linkright.png"));
			break;
		case "W" : posX = posX - pas;
			farmer.setIcon(new ImageIcon("src\\images\\linkleft.png"));
			break;
		}		
		GameFrame.farmer.setBounds(posX, posY, 50, 50);
	}
	
	public static void tick() {
		for(int i=0; i<10; i++) {
			int posX = farmer.getX();
			int posY = farmer.getY();
			int targetX = getTargetX();
			int targetY = getTargetY();
			int precision = 5;	
			if(isFarmerOn()) {
				if(posX + farmer.getWidth()/2 < targetX)
					GameFrame.moveFarmer("E", posX, posY);
				if(posX + farmer.getWidth()/2> targetX)
					GameFrame.moveFarmer("W", posX, posY);
				if(posY + farmer.getHeight()/2 < targetY)
					GameFrame.moveFarmer("S", posX, posY);
				if(posY + farmer.getHeight()/2 > targetY)
					GameFrame.moveFarmer("N", posX, posY);
			}
			if((posX - precision <= targetX) && (targetX <= posX + precision)) {
				if ((posY - precision <= targetY ) && (targetY <= posY + precision)) {
					setFarmerOn(false);
				}
			}
		}
		incrementsRessources(GameFrame.raw);
		GameFrame.raw++;
	}
	
	public static void incrementsRessources(int raw) {
		if(GameFrame.raw%10 == 0) {
			for (Entry<String, Animal> e : DataObjects.Animals.entrySet()) {
				((Animal) e).incrementAge();
			}
		}
//		if(GameFrame.raw%)
	}
	
	public FarmInitializer getFarmInitializer() {
		return farmInitializer;
	}
	
	public void setFarmInitializer(FarmInitializer farmInitializer) {
		this.farmInitializer = farmInitializer;
	}
	
	public TimePanel getInfoTime() {
		return infoTime;
	}

	public JSplitPane initSplitPanel(int dividerSize, int dividerLocation) {
		JSplitPane jsp = new JSplitPane();
		jsp.setOpaque(false);
		jsp.setDividerSize(dividerSize);
		jsp.setDividerLocation(dividerLocation);
		return jsp;
	}
	
	public JButton initButton(String imagePATH, JPanel panelOpt) {
		ImageIcon image = new ImageIcon(imagePATH);
		JButton optB = new JButton(image);
		panelOpt.add(optB);
		optB.setOpaque(false);
		optB.setBackground(new Color(255, 0, 0, 0));
		optB.setBorder(null);
		return optB;
	}
	
	public class dbClickAction implements MouseListener {
		GameFrame gameFrame;
		JPanel pnlDb;
		int mouseX;
		int mouseY;

		public dbClickAction(GameFrame frame, JPanel pnlDb) {
			this.gameFrame = frame;
			this.pnlDb = pnlDb;
		}
		
		@Override
		public void mouseClicked(MouseEvent arg0) {
			mouseX = arg0.getX();
			mouseY = arg0.getY();
			GameFrame.setFarmerOn(true);
			gameFrame.setTargetX(mouseX);
			gameFrame.setTargetY(mouseY);
		}
		
		@Override
		public void mouseEntered(MouseEvent arg0) {
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
		}
		
		@Override
		public void mousePressed(MouseEvent arg0) {
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
		}
	}

	public class OpenGarageAction implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			GameFrame.this.garageInfo = new GarageInfo();
		}
	}
	
	public class OpenSiloAction implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			new SiloInfo();
		}
	}
	
	public class OpenShopAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new ShopFrame();
		}
	}
	
	public class OpenHouseAction implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			new HouseInfo();
		}
	}
	
	public class OpenMarketAction implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			new MarketFrame();
		}
	}
	
	public class FarmerAction implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			new FarmerInfo();
		}
	}
	
	public class ClickAction implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
		    ImageIcon img = new ImageIcon("images/attention.png");
		    JOptionPane.showMessageDialog(null, "Vous avez cliqué sur la maison", "Information", JOptionPane.INFORMATION_MESSAGE, img);
		}
	}
	
	public class HideOptAction implements ActionListener {
		JButton btnSpoilOpt;
		JButton btnHideOpt;
		
		public HideOptAction(JButton btnSpoilOpt, JButton btnHideOpt) {
			this.btnSpoilOpt = btnSpoilOpt;
			this.btnHideOpt = btnHideOpt;
		}
		
		public void actionPerformed(ActionEvent e) {
			pnlCenter.setDividerLocation(1200);
			btnHideOpt.setVisible(false);
			btnSpoilOpt.setVisible(true);
		}
	}
		
	public class SpoilOptAction implements ActionListener {
		JButton btnSpoilOpt;
		JButton btnHideOpt;
		
		public SpoilOptAction(JButton btnSpoilOpt, JButton btnHideOpt) {
			this.btnSpoilOpt = btnSpoilOpt;
			this.btnHideOpt = btnHideOpt;
		}
		
		public void actionPerformed(ActionEvent e) {
			pnlCenter.setDividerLocation(1000);
			btnSpoilOpt.setVisible(false);
			btnHideOpt.setVisible(true);
		}
	}
	
	public class MoreTimeAction implements ActionListener {
		private TimePanel infoTime;
		
		public MoreTimeAction(TimePanel infoTime) {
			this.infoTime = infoTime;
		}
		
		public void actionPerformed(ActionEvent e) {
			infoTime.setSpeed(infoTime.getSpeed()/5);
			if(infoTime.getSpeed()<5)
				infoTime.setSpeed(5);
		}
	}
	
	public class StopTimeAction implements ActionListener {
		private TimePanel infoTime;
		private JButton btnTimeStop;
		
		public StopTimeAction(TimePanel infoTime, JButton btnTimeStop) {
			this.btnTimeStop = btnTimeStop;
			this.infoTime = infoTime;
		}
		
		public void actionPerformed(ActionEvent e) {
			if(!this.infoTime.isStop()) {
				this.infoTime.setStop(true);
				System.out.println("STOPP");
				ImageIcon image1 = new ImageIcon("src\\images\\play.png");
				btnTimeStop.setIcon(image1);
			}
			else if(this.infoTime.isStop()) {
				this.infoTime.setStop(false);
				ImageIcon image2 = new ImageIcon("src\\images\\pause.png");
				btnTimeStop.setIcon(image2);
			}
		}
	}
	
	public class LessTimeAction implements ActionListener {
		private TimePanel infoTime;
	
		public LessTimeAction(TimePanel infoTime) {
			this.infoTime = infoTime;
		}
		
		public void actionPerformed(ActionEvent e) {
				this.infoTime.setSpeed(infoTime.getSpeed()*5);
			if(infoTime.getSpeed()>1000)
				this.infoTime.setSpeed(1000);
		}
	}
	
	public class WindowAdapter implements WindowListener {
	
		@Override
		public void windowClosing(WindowEvent e) {
			int reponse = JOptionPane.showConfirmDialog(frame,
			            "Voulez-vous quitter l'application",
			            "Confirmation",
			            JOptionPane.YES_NO_OPTION,
			            JOptionPane.QUESTION_MESSAGE);
			if (reponse==JOptionPane.YES_OPTION){
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}	
		}
	
		@Override
		public void windowActivated(WindowEvent e) {
		}
	
		@Override
		public void windowClosed(WindowEvent e) {
		}
	
		@Override
		public void windowDeactivated(WindowEvent e) {
		}
	
		@Override
		public void windowDeiconified(WindowEvent e) {
		}
	
		@Override
		public void windowIconified(WindowEvent e) {
		}
	
		@Override
		public void windowOpened(WindowEvent e) {
		}
	}
}