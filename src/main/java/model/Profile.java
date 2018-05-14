package model;

import org.json.JSONObject;

public class Profile {
	private String firstName;
	private String middleName;
	private String lastName;
	private String fullName;
	private String id;
	private boolean active;
	private boolean blocked;
	private String balance;
	private String picture;
	private int age;
	private String email;
	private String phone;
	private String address;
	private String profile;
	
	public Profile() {
		;
	}

	public Profile(JSONObject param) {
		JSONObject name = param.getJSONObject("name");
		setFirstName(name.getString("first"));
		setMiddleName(name.getString("middle"));
		setLastName(name.getString("last"));
		setFullName(getFirstName() +" "+ getMiddleName() +" "+ getLastName());
		setId(param.getString("id"));
		setActive(param.getBoolean("active"));
		setBlocked(param.getBoolean("blocked"));
		setBalance(param.getString("balance"));
		setPicture(param.getString("picture"));
		setAge(param.getInt("age"));
		setEmail(param.getString("email"));
		setPhone(param.getString("phone"));
		setAddress(param.getString("address"));
		setProfile(param.getString("profile"));
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}
}
