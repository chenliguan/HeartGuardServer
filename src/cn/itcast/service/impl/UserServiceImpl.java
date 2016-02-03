package cn.itcast.service.impl;

import java.util.List;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.exception.UsernameExistException;
import cn.itcast.service.UserService;
import cn.itcast.util.DaoFactory;

public class UserServiceImpl implements UserService {
	
	private UserDao dao = DaoFactory.getInstance().getUserDao();
	
	/**
	 * �û���¼
	 * @param username
	 * @param password
	 * @return ��¼�ɹ�����user�����ɹ�����null
	 */
	public User login(String username, String password) {
		return dao.findUser(username, password);
	}
	
	/**
	 * �û�ע�᣺���ж��û����Ƿ����
	 * @param user
	 * @throws UsernameExistException�û��������׳����쳣
	 */
	public void regist(User user) throws UsernameExistException {
		//�ж��û����Ƿ����
		User u = dao.findUserByUsername(user.getUsername());
		if(u!=null)
			throw new UsernameExistException("�û����Ѿ�������");
		//����Dao����
		dao.addUser(user);
	}
	
	/**
	 * ��ѯ�û�����Ϣ
	 * @param username
	 * @return
	 */
	public List<User> UserInfo(String username) {
		return dao.findUserByUsernameList(username);
	}
	
	/**
	 * �����û���Ϣ
	 * @return
	 */
	public void ModifyUser(User user) {
		dao.modifyUser(user); //����Dao����
	}

	/**
	 * �޸�����
	 */
	public void ModifyPassword(String userstring, String old_password,
			String new_password, String ok_new_password) {
		dao.modifypassword(userstring,old_password,new_password,ok_new_password); //����Dao����
	}
}
