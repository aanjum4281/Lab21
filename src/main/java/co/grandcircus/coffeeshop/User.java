package co.grandcircus.coffeeshop;

public class User {
	private String first;
	private String last;
	private String email;
	private String phone;
	private String password;
	private String age;
	private String date;
	private String username;
	
	public User () {}
	
	public User(String first, String last, String email, String phone, String password, String age, String date, String username) {
		super();
		this.first = first;
		this.last = last;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.age = age;
		this.date = date;
		this.username = username; 
	}

	
	
	public Object getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
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

	@Override
	public String toString() {
		return "User [first=" + first + ", last=" + last + ", email=" + email + ", phone=" + phone + ", passowrd="
				+ password + "]";
	}
	
}
