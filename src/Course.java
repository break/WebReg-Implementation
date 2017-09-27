public class Course {
	private String name;
	private int department;
	private int courseNum;
	private char day; 
	private int timeSlot;
	private int credits;
	private Period period = new Period(day,timeSlot);
	private Student[] studentEnrolled = new Student[20]; 
	
	public Course(int department, int courseNum, String name, char day, int timeSlot, int credits) { 
		this.name = name;
		this.period = new Period(day, timeSlot);
		this.department = department;
		this.courseNum = courseNum;
		this.credits = credits; 
	}
	public int getDepartment() { 
		return department;
	}
	public Period getPeriod() { 
		return period; 
	}
	public int getCourseNumber() { 
		return courseNum;
	}
	public String getName() {
		return name; 
	}
	public int getCredits() { 
		return credits; 
	}
	public Student[] getRoster() { 
		return studentEnrolled;
	}
	public String toString() { 
		return department + ":" + courseNum + " [" + name + "] " + period + " credits:" + credits; 
	}
	public boolean equals(Course other) { 
		if (this.department == other.department && this.courseNum == other.courseNum) { 
			return true;
		}
		return false;
	}
}