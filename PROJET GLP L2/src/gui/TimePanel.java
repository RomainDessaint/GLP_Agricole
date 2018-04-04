package gui;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import time.Chronometer;
import time.CyclicCounter;

public class TimePanel extends Thread implements Runnable {
	private JPanel panel = new JPanel();
	
	private static Font font = new Font(Font.MONOSPACED, Font.BOLD, 20);
	
	private int speed = 100;
	
	private Chronometer chronometer = new Chronometer();	
	
	private JLabel yearValue = new JLabel("");
	private JLabel monthValue = new JLabel("");
	private JLabel dayValue = new JLabel("");
	private JLabel hourValue = new JLabel("");
	private JLabel minuteValue = new JLabel("");
	
	private JLabel dateValue = new JLabel("");
	private JLabel timeValue = new JLabel("");
	
	private TimePanel instance = this;
	
	private boolean on = true;
	private boolean stop = false;
	
	private int currentYear;
	private int currentMonth;
	private int currentDay;
	private int currentHour;
	private int currentMinute;

	public TimePanel() {
		init();
		go();
	}
	
	public void init() {
		chronometer.init();
		updateValues();
		
		dateValue.setFont(font);
		panel.add(dateValue);
		
		timeValue.setFont(font);
		panel.add(timeValue);
	}
	
	private void updateValues() {
		CyclicCounter year = chronometer.getYear();
		yearValue.setText(year.toString());
		currentYear = chronometer.getYear().getValue();
		
		CyclicCounter month = chronometer.getMonth();
		monthValue.setText(month.toString());
		currentMonth = chronometer.getMonth().getValue();
		
		CyclicCounter day = chronometer.getDay();
		dayValue.setText(day.toString());
		currentDay = chronometer.getDay().getValue();
		
		CyclicCounter hour = chronometer.getHour();
		hourValue.setText(hour.toString());
		currentHour = chronometer.getHour().getValue();

		CyclicCounter minute = chronometer.getMinute();
		minuteValue.setText(minute.toString());
		currentMinute = chronometer.getMinute().getValue();
		
		dateValue.setText(dayValue.getText() + "/" + monthValue.getText() + "/" + yearValue.getText() + "  ");
		timeValue.setText(hourValue.getText() + ":" + minuteValue.getText());
		
		panel.repaint();
	}
	
	@Override
	public void run() {
		while (on) {
			if(!stop) {
				try {
					Thread.sleep(speed);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
				chronometer.increment();
				GameFrame.multiTick();
				updateValues();
			} else {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
	
	public void go() {
		Thread chronoThread = new Thread(instance);
		chronoThread.start();
	}

	public int getCurrentYear() {
		return currentYear;
	}

	public int getCurrentMonth() {
		return currentMonth;
	}

	public int getCurrentDay() {
		return currentDay;
	}

	public int getCurrentHour() {
		return currentHour;
	}
	
	public int getCurrentMinute() {
		return currentMinute;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public JPanel getPanel() {
		return panel;
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}	
}

