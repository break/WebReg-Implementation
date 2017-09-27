public class Period {
	private char day; 
	private char[] days = {'M','T','W','H','F','S'};
	private int timeSlot;
	private int output; 
	
	public Period (char day, int timeSlot) { 
		for (int i = 0; i < days.length; i++) { 
			if (days[i] == day) { 
				this.day = day; 
				break;
			}
		}
		this.timeSlot = timeSlot;
	}
	public char getDay() { 
		return day; 
	}
	public int getTimeSlot() { 
		return timeSlot;
	}
	public String toString() { 
		return Character.toString(this.day) + Integer.toString(this.timeSlot);
	}
	public int compareTo(Period other) {
		if (this.day == other.day) { 
			return (this.compareTimeSlot(other)); 
		}
		else if (this.compareDay(other)) { 
			output = -1; 
		}
		else { 
			output = 1;
		}
		return output;
	}
	public boolean compareDay(Period other) {
		int posCurr = 0;
		int posOther = 0; 
		char currentDay = this.day;
		char otherDay = other.day;
		for (int i = 0; i < days.length; i++) { 
			if (days[i] == currentDay) { 
				posCurr = i; 
			}
			if (days[i] == otherDay) { 
				posOther = i; 
			}
			if (posCurr != 0 && posOther != 0) {
				break;
			}
		}
		if (posCurr < posOther) { 
			return true;
		}
		else {
			return false;
		}
	}
	public int compareTimeSlot(Period other) { 
		if (this.timeSlot == other.timeSlot) { 
			return 0; 
		}
		else if (this.timeSlot < other.timeSlot) { 
			return -1; 
		}
		else { 
			return 1; 
		}
	}
	public static void main(String[] args) { 
		Period current = new Period ('T',1);
		Period other = new Period ('M', 8);
		System.out.println(current.compareTo(other));
	}
}