import javax.swing.JFrame;

import gui.TimePanel;

public class Main {
	
	public static void main(String[] args) {
		JFrame jf = new JFrame();
		TimePanel tp = new TimePanel();
		jf.setContentPane(tp);
		jf.setSize(700, 300);
		jf.setVisible(true);	
		tp.go();
	}
}
