package cn.itcast.service.impl;

import cn.itcast.dao.SmsDao;
import cn.itcast.domain.Sms;
import cn.itcast.service.SmsService;
import cn.itcast.util.DaoFactory;

public class SmsServiceImpl implements SmsService {

	private SmsDao dao = DaoFactory.getInstance().getCodeDao();

	/**
	 * ����֤��
	 */
	public void SendCode(String username, int code) {

		// �ж���֤���Ƿ����
		Sms s = dao.findCodeByUsername(username);
		if (s == null) {
			dao.addCode(username, code); // ����Dao����
		} else {
			dao.updateCode(username, code); // ����Dao�޸�
		}
	}

	/**
	 * ������
	 */
	public String SendPassword(String username) {

		// �ж������Ƿ����
		Sms s = dao.findPasswordByUsername(username);
		if (s != null) {
			return s.getPassword();
		}
		return null;
	}
}
