package food.model;


public class EmployeeManagement {
	public int id;
	public String employeename;
	public String employeephone;
	public String jobrole;
	public String email;
	public String filename;
	public String path;
	public EmployeeManagement(int id, String employeename, String employeephone, String jobrole, String email, String filename, String path) {
		super();
		this.id = id;
		this.employeename = employeename;
		this.employeephone = employeephone;
		this.jobrole = jobrole;
		this.email = email;
		this.filename = filename;
		this.path = path;
	}
	public EmployeeManagement(String employeename, String employeephone, String jobrole, String email, String filename, String path) {
		super();
		this.employeename = employeename;
		this.employeephone = employeephone;
		this.jobrole = jobrole;
		this.email = email;
		this.filename = filename;
		this.path = path;
	}
	
	
	public EmployeeManagement(int id, String employeename, String employeephone, String jobrole, String email) {
		super();
		this.id = id;
		this.employeename = employeename;
		this.employeephone = employeephone;
		this.jobrole = jobrole;
		this.email = email;
	}
	public EmployeeManagement(int id, String employeename, String employeephone, String jobrole, String email, String filename) {
		super();
		this.id = id;
		this.employeename = employeename;
		this.employeephone = employeephone;
		this.jobrole = jobrole;
		this.email = email;
		this.filename = filename;
	}
	public EmployeeManagement(String employeename, String employeephone, String jobrole, String email, String filename) {
		super();
		this.employeename = employeename;
		this.employeephone = employeephone;
		this.jobrole = jobrole;
		this.email = email;
		this.filename = filename;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	public String getEmployeePhone() {
		return employeephone;
	}
	public void setEmployeephone(String employeephone) {
		this.employeephone = employeephone;
	}
	public String getJobrole() {
		return jobrole;
	}
	public void setJobrole(String jobrole) {
		this.jobrole = jobrole;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

}