package cn.itcast.dao;

import cn.itcast.domain.Sms;

public interface SmsDao {
	
	/**
	 * 保存验证码到数据库中
	 * @param username
	 */
	void addCode(String username,int code);
	/**
	 * 根据用户名查询Sms，发送验证码
	 * @param username
	 * @return 存在返回User，不存在返回null
	 */
	Sms findCodeByUsername(String username);
	/**
	 * 根据用户名查询Sms，发送密码
	 * @param username
	 * @return 存在返回User，不存在返回null
	 */
	Sms findPasswordByUsername(String username);
	/**
	 * 更新已有手机号码的验证码
	 * @param username
	 * @param code
	 */
	void updateCode(String username,int code);
}
