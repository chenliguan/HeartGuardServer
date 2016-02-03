package cn.itcast.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Family implements Serializable {
	private String username;//≤ªƒ‹÷ÿ∏¥
	private String nick;
	private String email;
	private String birthday;
	private String gender;
	private String high;
	private String weight;
	private String familygroup;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHigh() {
		return high;
	}
	public void setHigh(String high) {
		this.high = high;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getFamilygroup() {
		return familygroup;
	}
	public void setFamilygroup(String familygroup) {
		this.familygroup = familygroup;
	}
}
