package gui;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import time.Chronometer;
import time.CyclicCounter;

public class TimePanel extends JPanel implements Runnable {

	
	private static Font font = new Font(Font.MONOSPACED, Font.BOLD, 20);
	private static final int CHRONO_SPEED = 100;
	
	private Chronometer chronometer = new Chronometer();	
	
	private JLabel yearValue = new JLabel("");
	private JLabel monthValue = new JLabel("");
	private JLabel dayValue = new JLabel("");
	private JLabel hourValue = new JLabel("");
	private JLabel minuteValue = new JLabel("");
	
	private JLabel dateValue = new JLabel("");
	private JLabel timeValue = new JLabel("");
	
	private TimePanel instance = this;
	
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
		this.add(dateValue);
		
		timeValue.setFont(font);
		this.add(timeValue);
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
		
		this.repaint();
	}
	
	@Override
	public void run() {
		while (!stop) {
			try {
				Thread.sleep(CHRONO_SPEED);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			chronometer.increment();
			updateValues();
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
}
