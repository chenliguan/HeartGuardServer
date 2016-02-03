package cn.itcast.service.impl;

import cn.itcast.dao.SmsDao;
import cn.itcast.domain.Sms;
import cn.itcast.service.SmsService;
import cn.itcast.util.DaoFactory;

public class SmsServiceImpl implements SmsService {

	private SmsDao dao = DaoFactory.getInstance().getCodeDao();

	/**
	 * 发验证码
	 */
	public void SendCode(String username, int code) {

		// 判断验证码是否存在
		Sms s = dao.findCodeByUsername(username);
		if (s == null) {
			dao.addCode(username, code); // 调用Dao保存
		} else {
			dao.updateCode(username, code); // 调用Dao修改
		}
	}

	/**
	 * 发密码
	 */
	public String SendPassword(String username) {

		// 判断密码是否存在
		Sms s = dao.findPasswordByUsername(username);
		if (s != null) {
			return s.getPassword();
		}
		return null;
	}
}
