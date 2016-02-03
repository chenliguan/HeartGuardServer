package cn.itcast.service;

import cn.itcast.exception.UsernameExistException;

public interface SmsService {
	
	/**
	 * 发验证码
	 * @param code
	 * @throws UsernameExistException
	 */
	void SendCode(String username,int code);
	
	/**
	 * 发密码
	 * @param username
	 * @param password
	 */
	String SendPassword(String username);
}
