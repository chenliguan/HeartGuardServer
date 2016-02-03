package cn.itcast.domain;

import java.io.Serializable;

/**
 * 
 * @author Guan
 *
 */
@SuppressWarnings("serial")
public class Sms implements Serializable {
	private String username;//≤ªƒ‹÷ÿ∏¥
	private String code;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
