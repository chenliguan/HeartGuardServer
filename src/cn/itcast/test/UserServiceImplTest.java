package cn.itcast.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import cn.itcast.domain.User;
import cn.itcast.exception.UsernameExistException;
import cn.itcast.service.UserService;
import cn.itcast.service.impl.UserServiceImpl;

public class UserServiceImplTest {
	private UserService s = new UserServiceImpl();
	@Test
	public void testLogin() {
		User user = s.login("zql", "123");
		assertNotNull(user);
		user = s.login("zql", "1233");
		assertNull(user);
	}

	@Test(expected=cn.itcast.exception.UsernameExistException.class)
	public void testRegist() throws UsernameExistException {
		User user = new User();
		user.setUsername("gfy");
		user.setPassword("123");
		user.setNick("∏∏∂“‘");
		user.setEmail("gfy@itcast.cn");
	
		s.regist(user);
	}
	@Test
	public void testRegist1() throws UsernameExistException {
		User user = new User();
		user.setUsername("zql");
		user.setPassword("123");
		user.setNick("÷Ï«…¡·");
		user.setEmail("zql@itcast.cn");
	
		s.regist(user);
	}
}
