package gui;

import java.awt.Color;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import datas.DataObjects;
import system.Game;

public class GameFrame {
	private JSplitPane pnlMain;
	private JSplitPane pnlCenter;
	private JPanel pnlDb = new JPanel();
	private JPanel pnlOpt = new JPanel();
	private JPanel pnlInfo = new JPanel();
	
	private JFrame frame = new JFrame();
	
	private HouseInfo houseInfo;
	private SiloInfo siloInfo ;
	private GarageInfo garagrInfo;
	
	private MarketFrame marketFrame;

	private JButton btnSpoilOpt;
	private JButton btnHideOpt;
	private JButton btnHouse;
	private JButton btnShop;
	private JButton btnMarket;
	private JButton btntypeDay;
	
	private ImageIcon iiFlecheD;
	private ImageIcon iiFlecheG;
	
	private GridBagLayout gridLayout;
	private GridBagConstraints gridConstraints;
	
	private FarmInitializer farmInitializer;
	
	

	static Game game;

	
	public GameFrame(Game game) {
		frame.setTitle("Farm Simulator");
		frame.setSize(1200, 600);
		frame.setLocation(50, 50);
//		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
		pnlInfo = PanelInfo.initPnlInfo(pnlInfo);
		pnlInfo.setBackground(Color.gray);
        pnlMain.setRightComponent(pnlInfo);
        
        //PANEL CENTER : CONTIENT PANEL DB + PANEL OPT
        pnlCenter = initSplitPanel(3, 1200);
		pnlCenter.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		pnlMain.setLeftComponent(pnlCenter);
        
        //PANEL DASHBOARD
		pnlDb.setLayout(null);
		
		
		farmInitializer = new FarmInitializer(pnlDb, frame.getWidth(), frame.getHeight());
		farmInitializer.InsertFence();
		farmInitializer.InsertFence();
		farmInitializer.InsertFence();
		farmInitializer.InsertFence();
		farmInitializer.InsertFence();
		farmInitializer.InsertFence();
		
		farmInitializer.InsertField();
		farmInitializer.InsertField();
		farmInitializer.InsertField();
		farmInitializer.InsertField();
		farmInitializer.InsertField();
		farmInitializer.InsertField();
		
		DataObjects.FieldMap.get(0).get(3).setIcon(new ImageIcon("src\\images\\Carotte.png"));
		DataObjects.FieldMap.get(0).get(4).setIcon(new ImageIcon("src\\images\\Carotte.png"));
		DataObjects.FieldMap.get(0).get(6).setIcon(new ImageIcon("src\\images\\Carotte.png"));
		DataObjects.FieldMap.get(0).get(8).setIcon(new ImageIcon("src\\images\\Carotte.png"));
		DataObjects.FieldMap.get(0).get(6).setIcon(new ImageIcon("src\\images\\Tomate.png"));
		DataObjects.FieldMap.get(0).get(0).setIcon(new ImageIcon("src\\images\\Carotte.png"));
		DataObjects.FieldMap.get(0).get(1).setIcon(new ImageIcon("src\\images\\Carotte.png"));
		DataObjects.FieldMap.get(0).get(2).setIcon(new ImageIcon("src\\images\\Pomme.png"));
		DataObjects.FieldMap.get(0).get(5).setIcon(new ImageIcon("src\\images\\Pomme.png"));
		DataObjects.FieldMap.get(0).get(6).setIcon(new ImageIcon("src\\images\\Tomate.png"));
		DataObjects.FieldMap.get(1).get(3).setIcon(new ImageIcon("src\\images\\Tomate.png"));
		DataObjects.FieldMap.get(1).get(2).setIcon(new ImageIcon("src\\images\\Tomate.png"));
		DataObjects.FieldMap.get(1).get(5).setIcon(new ImageIcon("src\\images\\Carotte.png"));
		DataObjects.FieldMap.get(1).get(8).setIcon(new ImageIcon("src\\images\\Carotte.png"));
		DataObjects.FieldMap.get(1).get(0).setIcon(new ImageIcon("src\\images\\Carotte.png"));
		DataObjects.FieldMap.get(0).get(0).setIcon(new ImageIcon("src\\images\\Carotte.png"));
		
		DataObjects.FieldMap.get(1).get(0).setIcon(new ImageIcon("src\\images\\Carotte.png"));
		DataObjects.FieldMap.get(1).get(1).setIcon(new ImageIcon("src\\images\\Carotte.png"));
		DataObjects.FieldMap.get(1).get(2).setIcon(new ImageIcon("src\\images\\Pomme.png"));
		DataObjects.FieldMap.get(2).get(5).setIcon(new ImageIcon("src\\images\\Pomme.png"));
		DataObjects.FieldMap.get(2).get(6).setIcon(new ImageIcon("src\\images\\Tomate.png"));
		DataObjects.FieldMap.get(2).get(3).setIcon(new ImageIcon("src\\images\\Tomate.png"));
		DataObjects.FieldMap.get(2).get(2).setIcon(new ImageIcon("src\\images\\Tomate.png"));
		DataObjects.FieldMap.get(2).get(5).setIcon(new ImageIcon("src\\images\\Tournesol.png"));
		DataObjects.FieldMap.get(1).get(8).setIcon(new ImageIcon("src\\images\\Tournesol.png"));
		DataObjects.FieldMap.get(1).get(0).setIcon(new ImageIcon("src\\images\\Tournesol.png"));
		DataObjects.FieldMap.get(0).get(0).setIcon(new ImageIcon("src\\images\\Tournesol.png"));
		
		DataObjects.FieldMap.get(3).get(0).setIcon(new ImageIcon("src\\images\\Carotte.png"));
		DataObjects.FieldMap.get(3).get(1).setIcon(new ImageIcon("src\\images\\Carotte.png"));
		DataObjects.FieldMap.get(3).get(2).setIcon(new ImageIcon("src\\images\\Tournesol.png"));
		DataObjects.FieldMap.get(4).get(5).setIcon(new ImageIcon("src\\images\\Tournesol.png"));
		DataObjects.FieldMap.get(3).get(6).setIcon(new ImageIcon("src\\images\\Tomate.png"));
		DataObjects.FieldMap.get(3).get(3).setIcon(new ImageIcon("src\\images\\Tomate.png"));
		DataObjects.FieldMap.get(4).get(2).setIcon(new ImageIcon("src\\images\\Tomate.png"));
		DataObjects.FieldMap.get(4).get(5).setIcon(new ImageIcon("src\\images\\Carotte.png"));
		DataObjects.FieldMap.get(4).get(8).setIcon(new ImageIcon("src\\images\\Carotte.png"));
		DataObjects.FieldMap.get(4).get(0).setIcon(new ImageIcon("src\\images\\Tournesol.png"));
		DataObjects.FieldMap.get(4).get(0).setIcon(new ImageIcon("src\\images\\Carotte.png"));
		
		
		
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
		pnlOpt.setBackground(Color.gray);
		btnShop = new JButton("Shop");
		pnlOpt.add(btnShop);
		btnMarket = new JButton("Market");
		pnlOpt.add(btnMarket);
		pnlCenter.setRightComponent(pnlOpt);
		
		//AJOUT DES ACTION LISTENER
        btnShop.addActionListener(new OpenShopAction());
        btnMarket.addActionListener(new OpenMarketAction());
		btnSpoilOpt.addActionListener(new SpoilOptAction(btnSpoilOpt, btnHideOpt));
		btnHideOpt.addActionListener(new HideOptAction(btnSpoilOpt, btnHideOpt));
		
		btnHouse.addActionListener(new OpenHouseAction());
		btnSilo.addActionListener(new OpenSiloAction());
		btnGarage.addActionListener(new OpenGarageAction());
		
		frame.setContentPane(pnlMain);
		frame.setVisible(true);
	}
	public FarmInitializer getFarmInitializer() {
		return farmInitializer;
	}
	public void setFarmInitializer(FarmInitializer farmInitializer) {
		this.farmInitializer = farmInitializer;
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
	
public class OpenGarageAction implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			GameFrame.this.garagrInfo = new GarageInfo();
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
			GameFrame.this.houseInfo = new HouseInfo();
		}
	}
	
	public class OpenMarketAction implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			GameFrame.this.marketFrame = new MarketFrame();
		}
	}
	
	public class ClickAction implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			System.out.println("HOUSE");
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
}