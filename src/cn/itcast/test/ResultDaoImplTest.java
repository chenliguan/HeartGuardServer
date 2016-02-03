package cn.itcast.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import cn.itcast.dao.ResultDao;
import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.ResultDaoMySQLImpl;
import cn.itcast.dao.impl.UserDaoMySQLImpl;
import cn.itcast.domain.Result;
import cn.itcast.domain.User;

public class ResultDaoImplTest {
	private ResultDao dao = new ResultDaoMySQLImpl();
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

	@Test
	public void testFindUserByUsernameResult() {
		List<Result> results = dao.findResultByUsername("user");
		System.out.println(results.get(0).getUsername()  + " " + results.get(0).getRate_grade());
		System.out.println(results.get(1).getUsername()  + " " + results.get(1).getRate_grade());
		System.out.println(results.get(1).getUsername()  + " " + results.get(2).getRate_grade());
		System.out.println(results.get(1).getUsername()  + " " + results.get(3).getRate_grade());
		System.out.println(results.get(1).getUsername()  + " " + results.get(4).getRate_grade());
		System.out.println(results.get(1).getUsername()  + " " + results.get(5).getRate_grade());
		
	}

}
