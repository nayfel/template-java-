package ms3.train.objects;

public class Employee {
	String firstName;
	String lastName;
	String employeeId;
	

	public Employee() {
		super();
	}
	
	public Employee(String firstName, String lastName, String employeeId) {
		this.firstName = firstName;
		this.lastName= lastName;
		this.employeeId= employeeId;
	}
	
	public void setFirstName(String firstName) {
		this.firstName= firstName;
	}
	public void setLastName(String lastName) {
		this.lastName= lastName;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId= employeeId;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public String getEmployeeId() {
		return this.employeeId;
	}
}
