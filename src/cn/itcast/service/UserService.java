package cn.itcast.service;

import java.util.List;

import cn.itcast.domain.User;
import cn.itcast.exception.UsernameExistException;

public interface UserService {
	/**
	 * �û���¼
	 * @param username
	 * @param password
	 * @return ��¼�ɹ�����user�����ɹ�����null
	 */
	User login(String username,String password);
	/**
	 * �û�ע�᣺���ж��û����Ƿ����
	 * @param user
	 * @throws UsernameExistException�û��������׳����쳣
	 */
	void regist(User user) throws UsernameExistException;
	/**
	 * ��ѯ�û�����Ϣ
	 * @param username
	 * @return
	 */
	List<User> UserInfo(String username);
	/**
	 * �����û���Ϣ
	 * @param user
	 * @return
	 */
	void ModifyUser(User user);
	
	/**
	 * �޸�����
	 * @param user
	 * @return
	 */
	void ModifyPassword(String userstring,
			String old_password, String new_password, String ok_new_password);
}
