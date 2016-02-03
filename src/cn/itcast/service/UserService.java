package cn.itcast.service;

import java.util.List;

import cn.itcast.domain.User;
import cn.itcast.exception.UsernameExistException;

public interface UserService {
	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @return 登录成功返回user，不成功返回null
	 */
	User login(String username,String password);
	/**
	 * 用户注册：先判断用户名是否存在
	 * @param user
	 * @throws UsernameExistException用户名存在抛出此异常
	 */
	void regist(User user) throws UsernameExistException;
	/**
	 * 查询用户的信息
	 * @param username
	 * @return
	 */
	List<User> UserInfo(String username);
	/**
	 * 更改用户信息
	 * @param user
	 * @return
	 */
	void ModifyUser(User user);
	
	/**
	 * 修改密码
	 * @param user
	 * @return
	 */
	void ModifyPassword(String userstring,
			String old_password, String new_password, String ok_new_password);
}
