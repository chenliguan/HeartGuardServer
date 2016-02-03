package cn.itcast.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.UserDaoMySQLImpl;
import cn.itcast.domain.User;

public class UserDaoImplTest {
	private UserDao dao = new UserDaoMySQLImpl();
//	@Test
//	public void testAddUser() {
//		User user = new User();
//		user.setUsername("gfy11");
//		user.setPassword("123");
//		user.setNick("¸ð¸¶ÒÔ");
//		user.setEmail("gfy@itcast.cn");
//		user.setBirthday(new Date());
//		dao.addUser(user);
//	}
//
//	@Test
//	public void testFindUser() {
//		User user = dao.findUser("gfy", "123");
//		assertNotNull(user);
//		user = dao.findUser("gfy1", "123");
//		assertNull(user);
//		user = dao.findUser("gfy", "1233");
//		assertNull(user);
//		user = dao.findUser("gfy1", "1233");
//		assertNull(user);
//	}

//	@Test
//	public void testFindUserByUsernameResult() {
//		List<User> users = dao.findUserByUsernameResult("user");
//		System.out.println(users.get(0).getUsername()  + " " + users.get(0).getPassword());
//	    users = dao.findUserByUsernameResult("username");
//		System.out.println(users.get(0).getUsername()  + " " + users.get(0).getPassword());
//	}

}
