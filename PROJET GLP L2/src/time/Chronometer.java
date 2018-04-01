package time;

public class Chronometer {
	private CyclicCounter year = new CyclicCounter(0, 10000, 0);
	private CyclicCounter month = new CyclicCounter(0, 12, 0);
	private CyclicCounter day = new CyclicCounter(0, 31, 0);
	private CyclicCounter hour = new CyclicCounter(0, 23, 0);
	private CyclicCounter minute = new CyclicCounter(0, 59, 0);

	public void increment() {
		minute.increment();
		if (minute.getValue() == 0) {
			hour.increment();
			if (hour.getValue() == 0) {
				day.increment();
				if (day.getValue() == 0) {
					month.increment();
					if (month.getValue() == 0) {
						year.increment();
					}
				}
			}
		}
	}

	public void decrement() {
		minute.decrement();
		if (minute.getValue() == 59) {
			hour.decrement();
			if (hour.getValue() == 23) {
				day.decrement();
				if (day.getValue() == 31) {
					month.decrement();
					if (month.getValue() == 12) {
						year.decrement();
					}
				}
			}
		}
	}
	
	public CyclicCounter getYear() {
		return year;
	}
	
	public CyclicCounter getMonth() {
		return month;
	}
	
	public CyclicCounter getDay() {
		return day;
	}

	public CyclicCounter getHour() {
		return hour;
	}

	public CyclicCounter getMinute() {
		return minute;
	}

	public String toString() {
		return "Year : " + year.toString() + ", " + "Day : " + day.toString() + " / " + month.toString() + hour.toString() + " : " + minute.toString();
	}

	public static String transform(int value) {
		String result = "";
		if (value < 10) {
			result = "0" + value;
		} else {
			result = String.valueOf(value);
		}
		return result;
	}

	public void init() {
		year.setValue(2018);
		month.setValue(1);
		day.setValue(1);
		hour.setValue(0);
		minute.setValue(0);
	}
}
