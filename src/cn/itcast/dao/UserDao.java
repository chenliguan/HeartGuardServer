package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.User;

public interface UserDao {
	/**
	 * 保存用户信息到数据库中
	 * @param user
	 */
	void addUser(User user);
	/**
	 * 根据用户名查询用户(返回List<User>)
	 * @param username
	 * @return 存在返回User，不存在返回null
	 */
	List<User> findUserByUsernameList(String username);
	/**
	 * 根据用户名查询用户(返回User)
	 * @param username
	 * @return
	 */
	User findUserByUsername(String username);
	/**
	 * 根据用户名和密码查询用户
	 * @param username
	 * @param password
	 * @return 存在返回User，不存在返回null
	 */
	User findUser(String username,String password);
	/**
	 * 修改用户信息
	 * @param user
	 */
	void modifyUser(User user);
	/**
	 * 修改密码
	 * @param userstring
	 * @param old_password
	 * @param new_password
	 * @param ok_new_password
	 */
	void modifypassword(String userstring, String old_password,
			String new_password, String ok_new_password);
}
