package cn.itcast.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import cn.itcast.dao.FamilyDao;
import cn.itcast.dao.SmsDao;
import cn.itcast.dao.ResultDao;
import cn.itcast.dao.UserDao;

/**
 * 创建Dao具体事例的工厂
 * 
 * @author Guan
 * 
 */
public class DaoFactory {

	/**
	 * 饿汉子式单例类
	 */
	private static DaoFactory instance = new DaoFactory();

	private DaoFactory() {
	}

	public static DaoFactory getInstance() {
		return instance;
	}

	/**
	 * userDaoImplClassName
	 */
	private static String UserDaoImplClassName;
	static {
		try {
			InputStream in = DaoFactory.class.getClassLoader()
					.getResourceAsStream("dao.properties");
			Properties props = new Properties();
			props.load(in);
			UserDaoImplClassName = props.getProperty("UserDao");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public UserDao getUserDao() {
		try {
			return (UserDao) Class.forName(UserDaoImplClassName).newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * resultDaoImplClassName
	 */
	private static String ResultDaoImplClassName;
	static {
		try {
			InputStream in = DaoFactory.class.getClassLoader()
					.getResourceAsStream("dao.properties");
			Properties props = new Properties();
			props.load(in);
			ResultDaoImplClassName = props.getProperty("ResultDao");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ResultDao getResultDao() {
		try {
			return (ResultDao) Class.forName(ResultDaoImplClassName)
					.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * codeDaoImplClassName
	 */
	private static String SmsDaoImplClassName;
	static {
		try {
			InputStream in = DaoFactory.class.getClassLoader()
					.getResourceAsStream("dao.properties");
			Properties props = new Properties();
			props.load(in);
			SmsDaoImplClassName = props.getProperty("SmsDao");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public SmsDao getCodeDao() {
		try {
			return (SmsDao) Class.forName(SmsDaoImplClassName)
					.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * familyDaoImplClassName
	 */
	private static String FamilyDaoImplClassName;
	static {
		try {
			InputStream in = DaoFactory.class.getClassLoader()
					.getResourceAsStream("dao.properties");
			Properties props = new Properties();
			props.load(in);
			FamilyDaoImplClassName = props.getProperty("FamilyDao");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public FamilyDao getFamilyDao() {
		try {
			return (FamilyDao) Class.forName(FamilyDaoImplClassName)
					.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
