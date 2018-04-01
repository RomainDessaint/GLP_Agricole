package gui;

import java.awt.Color;


import javax.swing.JPanel;


public class PanelInfo {
	
	public PanelInfo() {
	}
	
	
	public static JPanel initPnlInfo(JPanel pnlInfo) {
		JPanel infoTime = new TimePanel();
		infoTime.setVisible(true);
		infoTime.setBounds(0, 0, 300, 100);
		infoTime.setBackground(Color.gray);
		pnlInfo.add(infoTime);
		
		MoneyPanel infoMoney = new MoneyPanel();
		infoMoney.getPanel().setVisible(true);
		infoMoney.getPanel().setBounds(infoTime.getWidth(), 0, 300, 100);
		infoMoney.getPanel().setBackground(Color.gray);
		pnlInfo.add(infoMoney.getPanel());
		
		EventPanel infoEvent = new EventPanel();
		infoEvent.getPanel().setVisible(true);
		infoEvent.getPanel().setBounds(infoTime.getWidth()*2, 0, 600, 100);
		infoEvent.getPanel().setBackground(Color.gray);
		pnlInfo.add(infoEvent.getPanel());
		return pnlInfo;	
	}
}