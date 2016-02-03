package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.User;

public interface UserDao {
	/**
	 * �����û���Ϣ�����ݿ���
	 * @param user
	 */
	void addUser(User user);
	/**
	 * �����û�����ѯ�û�(����List<User>)
	 * @param username
	 * @return ���ڷ���User�������ڷ���null
	 */
	List<User> findUserByUsernameList(String username);
	/**
	 * �����û�����ѯ�û�(����User)
	 * @param username
	 * @return
	 */
	User findUserByUsername(String username);
	/**
	 * �����û����������ѯ�û�
	 * @param username
	 * @param password
	 * @return ���ڷ���User�������ڷ���null
	 */
	User findUser(String username,String password);
	/**
	 * �޸��û���Ϣ
	 * @param user
	 */
	void modifyUser(User user);
	/**
	 * �޸�����
	 * @param userstring
	 * @param old_password
	 * @param new_password
	 * @param ok_new_password
	 */
	void modifypassword(String userstring, String old_password,
			String new_password, String ok_new_password);
}
