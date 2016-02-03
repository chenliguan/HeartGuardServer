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
	 * 用户登录
	 * @param username
	 * @param password
	 * @return 登录成功返回user，不成功返回null
	 */
	public User login(String username, String password) {
		return dao.findUser(username, password);
	}
	
	/**
	 * 用户注册：先判断用户名是否存在
	 * @param user
	 * @throws UsernameExistException用户名存在抛出此异常
	 */
	public void regist(User user) throws UsernameExistException {
		//判断用户名是否存在
		User u = dao.findUserByUsername(user.getUsername());
		if(u!=null)
			throw new UsernameExistException("用户名已经存在了");
		//调用Dao保存
		dao.addUser(user);
	}
	
	/**
	 * 查询用户的信息
	 * @param username
	 * @return
	 */
	public List<User> UserInfo(String username) {
		return dao.findUserByUsernameList(username);
	}
	
	/**
	 * 更改用户信息
	 * @return
	 */
	public void ModifyUser(User user) {
		dao.modifyUser(user); //调用Dao保存
	}

	/**
	 * 修改密码
	 */
	public void ModifyPassword(String userstring, String old_password,
			String new_password, String ok_new_password) {
		dao.modifypassword(userstring,old_password,new_password,ok_new_password); //调用Dao保存
	}
}
