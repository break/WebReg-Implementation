import java.util.ArrayList;

public class WebReg {
	public static Course lookupCourseByName(Course[] catalog, String courseName) { 
		for(int i = 0; i < catalog.length; i++){
			if (catalog[i].getName().equalsIgnoreCase(courseName)){
				return catalog[i];
			}
		}
		return null;
	}
	public static Course[] lookupCoursesByDept(Course[] catalog, int department) { 
		int count = 0;
		for (int i = 0; i < catalog.length; i++){
			if (catalog[i].getDepartment() == department){
				count++;
			}
		}
		if (count == 0){
			return null;
		}
		int counter = 0;
		Course[] a = new Course[count];
		for (int i = 0; i < catalog.length; i++){
			if (catalog[i].getDepartment() == department){
				a[counter] = catalog[i];
				counter++;
			}
		}
		return a;
	}
	public static int countCredits(Student s) { 
		int credit = 0;
		for(int i = 0; i < s.getSchedule().length; i++){
			if (s.getSchedule()[i] != null) {
				credit = credit + s.getSchedule()[i].getCredits();
			}
		}
		return credit;
	}
	public static boolean addCourse(Student s, Course c) { //FIX ADD COURSE [error conditions and implementation]
		if (conflictCourse(s.getSchedule(), c)) { //if the course already exists in your schedule OR conflicts, don't add
			return false;
		}
		for (int i = 0; i < c.getRoster().length; i++){ //if student is already on roster, don't add
			if (c.getRoster()[i] == s) { 
				return false;
			}
		}
		for (int i = 0; i < s.getSchedule().length; i++) { 
			if (s.getSchedule()[i] == null) { //if schedule period is null
				if (s.getSchedule().length <= 6) { //if your schedule is not overloaded
					s.getSchedule()[i] = c; //then add course to schedule
					for (int j = 0; i < c.getRoster().length; j++) { 
						if (c.getRoster().length <= 20) { //if class is not full
							if (c.getRoster()[j] == null) { //if a position is empty
								c.getRoster()[j] = s; //add student to roster in empty position
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}
	public static boolean conflictCourse(Course [] schedule, Course c) { 
		Period c1 = c.getPeriod(); 
		for (int i = 0; i < schedule.length; i++) { 
			if (schedule[i] != null) { 
				Period c2 = schedule[i].getPeriod();
				if (c1.compareTo(c2) == 0) { 
					return true; 
				}
			}
		}
		return false; 
	}
	public static boolean dropCourse(Student s, Course c) {
		for (int i = 0; i < s.getSchedule().length-1; i++) {
			if (s.getSchedule()[i] != null) {
				if (s.getSchedule()[i].equals(c)) {
					s.getSchedule()[i] = null;
					for (int j = i; j < s.getSchedule().length-1; j++) {
						if(s.getSchedule()[j+1] == null || j+1 > s.getSchedule().length) {
							s.getSchedule()[j] = null;
							break;
						}
						s.getSchedule()[j] = s.getSchedule()[j+1];				
					}
				}
			}
		}
		for (int i = 0; i < c.getRoster().length-1; i++) {
			if (c.getRoster()[i] != null) {
				if (c.getRoster()[i].equals(s)) {
					c.getRoster()[i] = null;
					for (int j = i; j < c.getRoster().length-1; j++) {
						if (c.getRoster()[j+1] == null || j+1 > c.getRoster().length) {
							c.getRoster()[j] = null;
							break;
						}
						c.getRoster()[j] = c.getRoster()[j+1];				
					}
					return true;
				}
			}
		}
		return false;
	}
	public static Course[] commonCourses(Student one, Student two) { 
		Course[] schedOne = one.getSchedule(); 
		Course[] schedTwo = two.getSchedule();
		int count = 0;
		ArrayList<Course> sameCourses = new ArrayList <Course>();
		for (int i = 0; i < schedOne.length; i++) { 
			if (schedOne[i] != null) { 
				for (int j = 0; j < schedTwo.length; j++) { 
					if (schedTwo[j] != null) { 
						if (schedOne[i].equals(schedTwo[j])) {				
							sameCourses.add(schedOne[i]);
							count++;
						}
					}
				}
			}
		}
		if (count == 0) { 
			return null; 
		}
		Course[] sameCourse = new Course[count];
		for (int i = 0; i < count; i++) { 
			sameCourse[i] = sameCourses.get(i);
		}
		return sameCourse; 
	}
	public static void sortByNumber(Course[] catalog) { 
		Course[] temp = new Course[catalog.length];
		mergeSort(catalog, temp,  0,  catalog.length - 1); 	
	}
	public static void mergeSort(Course[] catalog, Course[] temp, int left, int right) { 
		if(left < right) {
			int center = (left + right) / 2;
			mergeSort(catalog, temp, left, center);
			mergeSort(catalog, temp, center + 1, right);
			merge(catalog, temp, left, center + 1, right);
		}
	}
	private static void merge(Course[] catalog, Course[ ] temp, int left, int right, int rightEnd) {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;
        while(left <= leftEnd && right <= rightEnd) {
            if(catalog[left].getDepartment() < catalog[right].getDepartment()) { 
            	temp[k++] = catalog[left++];
            }
            else if(catalog[left].getDepartment() == catalog[right].getDepartment()) { 
            	if (catalog[left].getCourseNumber() < catalog[right].getCourseNumber()) { 
            		temp[k++] = catalog[left++];
            	}
            	else { 
            		temp[k++] = catalog[right++];
            	}
            }
            else {
            	temp[k++] = catalog[right++];
            }  
        }
        while(left <= leftEnd) {  
            temp[k++] = catalog[left++];
        }
        while(right <= rightEnd) {  
            temp[k++] = catalog[right++];
        }
        for(int i = 0; i < num; i++, rightEnd--) { 
        	catalog[rightEnd] = temp[rightEnd];
        }
        	
    }
	public static void sortByTime(Course[] catalog) { 
		Course[] temp = new Course[catalog.length];
		mergeSortPeriod(catalog, temp,  0,  catalog.length - 1);	
	}
	public static void mergeSortPeriod(Course[] catalog, Course[] temp, int left, int right) { 
		if(left < right) {
			int center = (left + right) / 2;
			mergeSortPeriod(catalog, temp, left, center);
			mergeSortPeriod(catalog, temp, center + 1, right);
			mergePeriod(catalog, temp, left, center + 1, right);
		}
	}
	private static void mergePeriod(Course[ ] catalog, Course[ ] temp, int left, int right, int rightEnd) {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;
        while(left <= leftEnd && right <= rightEnd) {
            if(catalog[left].getPeriod().compareTo(catalog[right].getPeriod()) <= 0) { 
            	temp[k++] = catalog[left++];
            }
            else {
            	temp[k++] = catalog[right++];
            }  
        }
        while(left <= leftEnd) {  
            temp[k++] = catalog[left++];
        }
        while(right <= rightEnd) { 
            temp[k++] = catalog[right++];
        }
        for(int i = 0; i < num; i++, rightEnd--) {
        	catalog[rightEnd] = temp[rightEnd];
        }
    }
 }
