public class CommonCourseDriver {
	public static void main(String[] args){
		Student s1 = new Student("Shreya", "Bajpai", 166000171, 2020);
		Course c1 = new Course(198, 111, "Introduction to Computer Science", 'M', 8, 3); 
		Course c2 = new Course(123, 134 , "Cerebral Palsy and its Effects", 'H', 4, 4); 
		Course c3 = new Course(456, 233, "Dance & Music", 'W', 1, 3); 
		Course c4 = new Course(113, 691, "Shreya party", 'F', 1, 4); 
		s1.schedule[0] = c1;
		s1.schedule[1] = c2; 
		s1.schedule[2] = c3; 
		s1.schedule[3] = c4; 
		Student s2 = new Student("Bob", "Smith", 184345123, 2021);
		Course r1 = new Course(110, 450 , "Dancing in the rain", 'M', 3, 4); 
		Course r2 = new Course(198, 111, "Introduction to Computer Science", 'M', 8, 3); 
		Course r3 = new Course(222, 111, "Discrete Structures", 'M', 2, 3);
		Course r4 = new Course(113, 691, "Shreya party", 'F', 1, 4); 
		s2.schedule[0] = r1;
		s2.schedule[1] = r2; 
		s2.schedule[2] = r3;
		s2.schedule[3] = r4;
		//WebRegApp.printArray(WebReg.commonCourses(s1, s2));
		
		
		
	}
}
