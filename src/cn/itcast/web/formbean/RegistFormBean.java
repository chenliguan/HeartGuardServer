package cn.itcast.web.formbean;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class RegistFormBean {
	private String username;
	private String nick;
	private String password;
	private String password1;
	private String email;
	private String birthday;
	private String code;
	private Map<String, String> errors = new HashMap<String, String>();//key:������ֶ��� value��������Ϣ
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Map<String, String> getErrors() {
		return errors;
	}
	
	public boolean validate(){
		//����д����Map����Ӷ���
		//*�û���(3~8λ��ĸ)
		if(username==null||"".equals(username.trim())){
			errors.put("username", "�������û���");
		}else{
			if(!username.matches("[a-zA-Z]{3,8}")){
				errors.put("username", "�û���������3~8λ����ĸ���");
			}
		}
		//*����(3~8λ����)
		if(password==null||"".equals(password.trim())){
			errors.put("password", "����������");
		}else{
			if(!password.matches("\\d{3,8}")){
				errors.put("password", "���������3~8λ���������");
			}
		}
		//*�ظ�����
		if(!password.equals(password1)){
			errors.put("password1", "�����������һ��");
		}
		//*����
		if(email==null||"".equals(email.trim())){
			errors.put("email", "����������");
		}else{
			if(!email.matches("\\w+@\\w+(.\\w+)+")){
				errors.put("email", "��������ȷ������");
			}
		}
		//*��������
		if(birthday==null||"".equals(birthday.trim())){
			errors.put("birthday", "�������������");
		}else{
			DateLocaleConverter dlc = new DateLocaleConverter();
			
			try {
				dlc.convert(birthday);
			} catch (Exception e) {
				errors.put("birthday", "��������ȷ��ʽ������.���磺2012-09-31");
			}
		}
		return errors.isEmpty();
	}
	
}
