package cn.itcast.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import cn.itcast.dao.FamilyDao;
import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.FamilyDaoMySQLImpl;
import cn.itcast.dao.impl.UserDaoMySQLImpl;
import cn.itcast.domain.Family;
import cn.itcast.domain.User;

public class FamilyDaoImplTest {
	private FamilyDao dao = new FamilyDaoMySQLImpl();
	@Test
	public void testAddFamily() {
		Family family = new Family();
		family.setUsername("13751338740");
		family.setGender("ÄÐ");
		family.setNick("¸ð¸¶ÒÔ");
		family.setEmail("gfy@itcast.cn");
		family.setBirthday("1992Äê");
		family.setHigh("176cm");
		family.setWeight("60kg");
		family.setFamilygroup("·ñ");
		dao.addFamily(family);
	}

	@Test
	public void testFindFamily() {
		Family family = dao.findFamilyByUsername("13751338740", "¸ð¸¶ÒÔ");
		System.out.println(family.getUsername()  + " " + family.getBirthday());
	}

	@Test
	public void testFindFamilyByUsernameList() {
		List<Family> familys = dao.findFamilyByUsernameList("13751338740");
		System.out.println(familys.get(0).getGender()  + " " + familys.get(0).getNick());
	}

	@Test
	public void testModifyFamily() {
		Family family = new Family();
		family.setUsername("13751338740");
		family.setGender("ÄÐ");
		family.setNick("Ð¡¹Ú");
		family.setEmail("1130314814@qq.com");
		family.setBirthday("1995Äê");
		family.setHigh("111cm");
		family.setWeight("1111kg");
		family.setFamilygroup("·ñ");
		dao.modifyFamily(family, "¸ð¸¶ÒÔ");
	}
}
