public class Student {
	private String firstName; 
	private String lastName;
	private int id; 
	private int gradYear; 
	public Course[] schedule = new Course[6];
	
	public Student(String firstName, String lastName, int id, int gradYear) { 
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.gradYear = gradYear;
	}
	public String getFirstName() { 
		return firstName;
	}
	public String getLastName() { 
		return lastName;
	}
	public int getId() { 
		return id; 
	}
	public int getGradYear() { 
		return gradYear;
	}
	public Course[] getSchedule() { 
		return schedule;
	}
	public String toString() { 
		return id + ": " + lastName + ", " + firstName + " - " + gradYear;
	}
	public boolean equals(Student other) { 
		if (this.id == other.id) { 
			return true;
		}
		return false;
	}
}

