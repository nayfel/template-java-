package ms3.train.objects;

public class Skillset {

	String skill;
	int employeeId;
	String createdBy = "Jack Tokarz";
	
	public Skillset() {
		super();
	}
	
	public Skillset(String skill, int employeeId) {
		this.skill=skill;
		this.employeeId= employeeId;
		this.createdBy = "Jack Tokarz";
	}
	
	public String getSkill() {
		return this.skill;
	}
	public int getEmployeeId() {
		return this.employeeId;
	}
	public String getCreatedBy() {
		return this.getCreatedBy();
	}
	
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId= employeeId;
	}
}
