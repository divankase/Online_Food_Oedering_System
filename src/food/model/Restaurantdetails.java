package food.model;


public class Restaurantdetails {
	public int id;
	public String restaurantname;
	public String phone;
	public String workingdays;
	public String location;
	public String filename;
	public String path;
	
	public Restaurantdetails(int id, String restaurantname, String phone, String workingdays, String location, String filename, String path) {
		//super();
		this.id = id;
		this.restaurantname = restaurantname;
		this.phone = phone;
		this.workingdays = workingdays;
		this.location = location;
		this.filename = filename;
		this.path = path;
	}
	public Restaurantdetails(String restaurantname, String phone, String workingdays, String location, String filename, String path) {
		//super();
		this.restaurantname = restaurantname;
		this.phone = phone;
		this.workingdays = workingdays;
		this.location = location;
		this.filename = filename;
		this.path = path;
	}
	
	
	/*public Restaurantdetails(int id, String restaurantname, String phone, String workingdays, String location) {
		super();
		this.id = id;
		this.restaurantname = restaurantname;
		this.phone = phone;
		this.workingdays = workingdays;
		this.location = location;
	}
	public Restaurantdetails(int id, String restaurantname, String phone, String workingdays, String location, String filename) {
		super();
		this.id = id;
		this.restaurantname = restaurantname;
		this.phone = phone;
		this.workingdays = workingdays;
		this.location = location;
		this.filename = filename;
	}
	public Restaurantdetails(String restaurantname, String phone, String workingdays, String location, String filename) {
		super();
		this.restaurantname = restaurantname;
		this.phone = phone;
		this.workingdays = workingdays;
		this.location = location;
		this.filename = filename;
	}*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRestaurantname() {
		return restaurantname;
	}
	public void setRestaurantname(String restaurantname) {
		this.restaurantname = restaurantname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWorkingdays() {
		return workingdays;
	}
	public void setWorkingdays(String workingdays) {
		this.workingdays = workingdays;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
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