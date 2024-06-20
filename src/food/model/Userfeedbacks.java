package food.model;

public class Userfeedbacks{
	public int id;
	public String customername;
	public String email;
	public String subject;
	public String message;

	public Userfeedbacks(int id, String customername, String email, String subject, String message) {

		super();

		this.id = id;
		this.customername = customername;
		this.email = email;
		this.subject = subject;
		this.message = message;

	}

	public Userfeedbacks(String customername, String email, String subject, String message) {

		super();
		
		this.customername = customername;
		this.email = email;
		this.subject = subject;
		this.message = message;

	}
	
	
/*	public Userfeedbacks(int id, String customername, String email, String subject, String message) {

		super();

		this.id = id;
		this.customername = customername;
		this.email = email;
		this.subject = subject;
		this.message = message;
		
	}
*/
	/*public Userfeedbacks(int id, String customername, String email, String subject, String message) {

		super();

		this.id = id;
		this.customername = customername;
		this.email = email;
		this.subject = subject;
		this.message = message;		
	}
*/
/*	public Userfeedbacks(String customername, String email, String subject, String message) {

		super();

		this.customername = customername;
		this.email = email;
		this.subject = subject;
		this.message = message;
		
	}
*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomerNname() {
		return customername;
	}
	public void setCustomerName(String customername) {
		this.customername = customername;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
