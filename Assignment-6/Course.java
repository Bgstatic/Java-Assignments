
public class Course {

	private String department;
	private String name;
	private String surname;
	private int credits;
	private int prereqYear;
	private int maxEnrollment;
	private int reservedSeats;
	private Student[] studentList;
	private Student[] ReplacementList;
	private Faculty instructor;

	public Course(String department, String name, int credits, int prereqYear, int maxEnrollment, int reserverdSeats) {

		this.department = department;
		this.name = name;
		this.credits = credits;
		this.prereqYear = prereqYear;
		this.maxEnrollment = maxEnrollment;
		this.reservedSeats = reserverdSeats;

	}

	public RegisterInfo registerCourse(Student std) {
		
		RegisterInfo registerInfo = new RegisterInfo();
		
		if (prereqYear <= std.getYear()) {

			if (studentList == null) {
				
				studentList = new Student[1];
				
				studentList[0] = std;
				
				registerInfo.setResult("APPROVED");
				
				registerInfo.setRegisterMessage("REQUEST APPROVED");
				
				registerInfo.setCourse(this);
				
			} else {
				
				if (studentList.length < this.maxEnrollment) {
					
				
					if (studentList.length + this.reservedSeats < this.maxEnrollment) {
						
						Student temp[] = studentList;
						
						studentList = new Student[temp.length + 1];
						
						for (int i = 0; i < temp.length; i++) {
							
							studentList[i] = temp[i];
						}
						studentList[studentList.length - 1] = std;
						
						registerInfo.setResult("APPROVED");
						
						registerInfo.setRegisterMessage("REQUEST APPROVED");
						
						registerInfo.setCourse(this);
						
					} else {
						
						if (ReplacementList == null) {
							
							ReplacementList = new Student[1];
							
							ReplacementList[0] = std;
						}
						
						Student temp[] = ReplacementList;
						
						ReplacementList = new Student[temp.length + 1];
						
						for (int i = 0; i < temp.length; i++) {
							
							ReplacementList[i] = temp[i];
						}
						ReplacementList[ReplacementList.length - 1] = std;
						
						registerInfo.setResult("WAITING");
						
						registerInfo.setRegisterMessage("REQUEST WAITING");
						
						registerInfo.setCourse(this);
					}
					
				} else {
					
					registerInfo.setResult("REJECTED");
					
					registerInfo.setCourse(this);
					
					registerInfo.setRegisterMessage("REQUEST REJECTED - QUATO");
					
				}
			}
			
		} else {
			
			registerInfo.setResult("REJECTED");
			
			registerInfo.setCourse(this);
			
			registerInfo.setRegisterMessage("REQUEST REJECTED-PREREQUISITE");
			
		}

		std.addRegisterInfo(registerInfo);

		System.out.println("registerCourse METHOD -> Course : " + getName() + "\tStudent : " + std.getName() + "\t" + std.getSurName());
				                                          
		return registerInfo;

	}

	public AssignInfo AssignInstructor(Faculty instructor, boolean force) {

		AssignInfo assignInfo = new AssignInfo();
		if (instructor.getDepartmentName() == getDepartment()) {
			
			if (force) {
				
				this.instructor = instructor;
				assignInfo.setAssignResult("APPROVED");
				assignInfo.setCourse(this);
				assignInfo.setAssignMessage("INSTRUCTOR " + instructor.getName() + " " + instructor.getSurname() + " ASSIGNED");
						
				
			} else {
				
				if (this.instructor == null) {
					
					this.instructor = instructor;
					assignInfo.setCourse(this);
					assignInfo.setAssignMessage("INSTRUCTOR " + instructor.getName() + " " + instructor.getSurname() + " ASSIGNED");
							
					assignInfo.setAssignResult("APPROVED");
				} else {

					assignInfo.setAssignMessage("INSTRUCTOR " + instructor.getName() + " " + instructor.getSurname());
					assignInfo.setCourse(this);		
					assignInfo.setAssignResult("REJECTED");
					
				}
			}
		} else {
			assignInfo.setAssignMessage("INSTRUCTOR " + instructor.getName() + " " + instructor.getSurname());
			assignInfo.setAssignResult("REJECTED");
			assignInfo.setCourse(this);
		}

		instructor.addAssignInfo(assignInfo);

		return assignInfo;
	}

	

	public void RegisterReplacementList() {

		if (instructor == null) {
			
			System.out.println("RegisterReplacementList METHOD ->\r\n" + "INSTRUCTOR NOT ASSIGNED TO COURSE");
		}
	}

	public void printStudentList() {

		System.out.println("Students registered " + this.name + " are : ");

		for (int i = 0; i < studentList.length; i++) {

			System.out.println(studentList[i].getName());

		}

	}
   
	// getter and setter methods
	public String getDepartment() {

		return department;
	}

	public String getName() {

		return name;

	}

	public String getSurname() {

		return surname;
	}

	public int getCredits() {

		return credits;
	}

	public int getPreReqYear() {

		return prereqYear;
	}

	public int getMaxEnrollment() {

		return maxEnrollment;
	}

	public int getReservedSeats() {

		return reservedSeats;
	}

	public Student[] setStudentList() {

		return studentList;
	}

	public Student[] setReplacementList() {

		return ReplacementList;
	}

	public Faculty getInstructor() {

		return instructor;
	}

	public void setDepartment(String newDepartment) {

		department = newDepartment;
	}

	public void setName(String newName) {

		name = newName;
	}

	public void setSurname(String newSurname) {

		surname = newSurname;
	}

	public void setCredits(int newCredits) {

		credits = newCredits;

	}

	public void setPreReqYear(int newPreReqYear) {

		prereqYear = newPreReqYear;
	}

	public void setMaxEnrollment(int newMaxEnrollment) {

		maxEnrollment = newMaxEnrollment;
	}

	public void setReservedSeats(int newReservedSeats) {

		reservedSeats = newReservedSeats;
	}

	public void setStudentList(Student[] newStudentList) {

		studentList = newStudentList;
	}

	public void setReplacementList(Student[] newReplacementList) {

		ReplacementList = newReplacementList;
	}

	public void setInstructor(Faculty newInstructor) {

		instructor = newInstructor;
	}

}
