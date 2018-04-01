package gui;

import java.awt.Color;


import javax.swing.JPanel;

import com.sun.javafx.image.impl.ByteIndexed.Getter;

public class PanelInfo {
	
	public PanelInfo() {
	}
	
	public static JPanel initPnlInfo(JPanel pnlInfo, TimePanel infoTime, MoneyPanel infoMoney, EventPanel infoEvent) {
		
		infoTime.getPanel().setVisible(true);
		infoTime.getPanel().setBounds(0, 0, 300, 100);
		infoTime.getPanel().setBackground(Color.gray);
		pnlInfo.add(infoTime.getPanel());
	
		infoMoney.getPanel().setVisible(true);
		infoMoney.getPanel().setBounds(infoTime.getPanel().getWidth(), 0, 300, 100);
		infoMoney.getPanel().setBackground(Color.gray);
		pnlInfo.add(infoMoney.getPanel());
	
		infoEvent.getPanel().setVisible(true);
		infoEvent.getPanel().setBounds(infoTime.getPanel().getWidth()*2, 0, 600, 100);
		infoEvent.getPanel().setBackground(Color.gray);
		pnlInfo.add(infoEvent.getPanel());
		
		return pnlInfo;	
	}
}