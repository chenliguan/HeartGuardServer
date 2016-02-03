package cn.itcast.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.exception.DaoException;
import cn.itcast.util.JdbcUtil;

//����PreparedStatement��ʵ�֣�Ԥ����䣩
public class UserDaoMySQLImpl implements UserDao {

	/**
	 * �����û���Ϣ�����ݿ���
	 */
	public void addUser(User user) {
		System.out.println("�����û���Ϣ�����ݿ���");
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = JdbcUtil.getConnection(); // 1��2
			stmt = conn
					.prepareStatement("insert into user (username,nick,password,code) values(?,?,?,?)"); // 3
			stmt.setString(1, user.getUsername()); // ���롰����������
			stmt.setString(2, user.getNick());
			stmt.setString(3, user.getPassword());
			stmt.setString(4, user.getCode());
			// stmt.setDate(5, new java.sql.Date(user.getBirthday().getTime()));
			stmt.executeUpdate(); // 4��5
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtil.release(null, stmt, conn); // 6
		}
	}

	/**
	 * �����û����������ѯ�û�
	 */
	public User findUser(String username, String password) {
		System.out.println("�����û����������ѯ�û�");
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn
					.prepareStatement("select * from user where username=? and password=?");
			stmt.setString(1, username);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			if (rs.next()) {
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setNick(rs.getString("nick"));
				user.setPassword(rs.getString("password"));
				user.setCode(rs.getString("code"));
				// user.setBirthday(rs.getDate("birthday"));
				return user;
			} else
				return null;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtil.release(rs, stmt, conn);
		}
	}

	/**
	 * �����û�����ѯ�û�
	 */
	public User findUserByUsername(String username) {
		System.out.println("�����û�����ѯ�û�");
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement("select * from user where username=?");
			stmt.setString(1, username);
			rs = stmt.executeQuery();
			if (rs.next()) {
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setNick(rs.getString("nick"));
				user.setPassword(rs.getString("password"));
				user.setCode(rs.getString("code"));
				// user.setBirthday(rs.getDate("birthday"));
				return user;
			} else
				return null;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtil.release(rs, stmt, conn);
		}
	}

	/**
	 * �����û�����ѯ�û�
	 */
	public List<User> findUserByUsernameList(String username) {
		System.out.println("�����û�����ѯ�û�");
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement("select * from user where username=?");
			stmt.setString(1, username);
			rs = stmt.executeQuery();
			List<User> users = new ArrayList<User>();
			while (rs.next()) {
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setNick(rs.getString("nick"));
				user.setPassword(rs.getString("password"));
				user.setCode(rs.getString("code"));
				user.setBirthday(rs.getString("birthday"));
				user.setGender(rs.getString("gender"));
				user.setHigh(rs.getString("high"));
				user.setWeight(rs.getString("weight"));
				users.add(user);
			}
			return users;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtil.release(rs, stmt, conn);
		}
	}

	/**
	 * �޸��û���Ϣ
	 * 
	 * @param user
	 */
	public void modifyUser(User user) {
		System.out.println("�޸��û���Ϣ");
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = JdbcUtil.getConnection(); // 1��2
			stmt = conn
					.prepareStatement("update user set nick=?,gender=?,birthday=?,high=?,weight=? where username=?"); // 3
			stmt.setString(1, user.getNick()); // ���롰����������
			stmt.setString(2, user.getGender());
			stmt.setString(3, user.getBirthday());
			stmt.setString(4, user.getHigh());
			stmt.setString(5, user.getWeight());
			stmt.setString(6, user.getUsername());
			stmt.executeUpdate(); // 4��5
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtil.release(null, stmt, conn); // 6
		}
	}

	/**
	 * �޸�����
	 * 
	 * @param userstring
	 * @param old_password
	 * @param new_password
	 * @param ok_new_password
	 */
	public void modifypassword(String userstring, String old_password,
			String new_password, String ok_new_password) {
		System.out.println("�޸�����" + userstring + " " +old_password+ " " +new_password+" "+ok_new_password);
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = JdbcUtil.getConnection(); // 1��2
			stmt = conn
					.prepareStatement("update user set password=? where username=? and password=?"); // 3
			stmt.setString(1, new_password); // ���롰����������
			stmt.setString(2, userstring);
			stmt.setString(3, old_password);
			stmt.executeUpdate(); // 4��5
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtil.release(null, stmt, conn); // 6
		}
	}
}
