
public class Person {

	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String notes;
	
	@Override
	public String toString() {
		
		return this.getFirstName() +" "+ this.getLastName() +" " + 
		this.getEmail() +" "+ this.getPhone()+" "+ this.getNotes();
	}
	
	public Person(String firstName, String lastName, String email) {
		//super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Person(String firstName, String lastName, String email, String phone) {
		//super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
	}

	public Person(String firstName, String lastName, String email,
			String phone, String notes) {
		//super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.notes = notes;
	}
	
	
	
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
	
}
