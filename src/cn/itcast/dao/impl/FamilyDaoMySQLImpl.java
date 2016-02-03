package cn.itcast.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.itcast.dao.FamilyDao;
import cn.itcast.domain.Family;
import cn.itcast.exception.DaoException;
import cn.itcast.util.JdbcUtil;

//利用PreparedStatement来实现（预制语句）
public class FamilyDaoMySQLImpl implements FamilyDao {

	/**
	 * 保存家人信息到数据库中
	 * 
	 * @param family
	 */
	public void addFamily(Family family) {
		System.out.println("保存家人信息到数据库中");
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = JdbcUtil.getConnection(); // 1、2
			stmt = conn
					.prepareStatement("insert into family (username,nick,birthday,gender,high,weight,familygroup) values(?,?,?,?,?,?,?)"); // 3
			stmt.setString(1, family.getUsername()); // 输入“？”的数据
			stmt.setString(2, family.getNick());
			stmt.setString(3, family.getBirthday());
			stmt.setString(4, family.getGender());
			stmt.setString(5, family.getHigh());
			stmt.setString(6, family.getWeight());
			stmt.setString(7, family.getFamilygroup());
			stmt.executeUpdate(); // 4、5
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtil.release(null, stmt, conn); // 6
		}

	}

	/**
	 * 根据用户名查询家人(返回List<Family>)
	 * 
	 * @param username
	 * @return 存在返回Family，不存在返回null
	 */
	public List<Family> findFamilyByUsernameList(String username) {
		System.out.println("根据用户名和昵称查询家人");
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn
					.prepareStatement("select * from family where username=?");
			stmt.setString(1, username);
			rs = stmt.executeQuery();
			List<Family> familys = new ArrayList<Family>();
			while (rs.next()) {
				Family family = new Family();
				family.setUsername(rs.getString("username"));
				family.setNick(rs.getString("nick"));
				family.setBirthday(rs.getString("birthday"));
				family.setGender(rs.getString("gender"));
				family.setHigh(rs.getString("high"));
				family.setWeight(rs.getString("weight"));
				family.setFamilygroup(rs.getString("familygroup"));
				familys.add(family);
			}
			return familys;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtil.release(rs, stmt, conn);
		}
	}

	/**
	 * 根据用户名和昵称查询家人(返回List<Family>)
	 * 
	 * @param username
	 * @return 存在返回Family，不存在返回null
	 */
	public List<Family> findFamilyByUsernameList(String username, String nick) {
		System.out.println("根据用户名和昵称查询家人");
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn
					.prepareStatement("select * from family where username=? and nick=?");
			stmt.setString(1, username);
			stmt.setString(2, nick);
			rs = stmt.executeQuery();
			List<Family> familys = new ArrayList<Family>();
			while (rs.next()) {
				Family family = new Family();
				family.setUsername(rs.getString("username"));
				family.setNick(rs.getString("nick"));
				family.setBirthday(rs.getString("birthday"));
				family.setGender(rs.getString("gender"));
				family.setHigh(rs.getString("high"));
				family.setWeight(rs.getString("weight"));
				family.setFamilygroup(rs.getString("familygroup"));
				familys.add(family);
			}
			return familys;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtil.release(rs, stmt, conn);
		}
	}

	/**
	 * 根据用户名和昵称查询家人(返回Family)
	 * 
	 * @param username
	 * @return
	 */
	public Family findFamilyByUsername(String username, String nick) {
		System.out.println("根据用户名和昵称查询家人");
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn
					.prepareStatement("select * from family where username=? and nick=?");
			stmt.setString(1, username);
			stmt.setString(2, nick);
			rs = stmt.executeQuery();
			if (rs.next()) {
				Family family = new Family();
				family.setUsername(rs.getString("username"));
				family.setNick(rs.getString("nick"));
				family.setBirthday(rs.getString("birthday"));
				family.setGender(rs.getString("gender"));
				family.setHigh(rs.getString("high"));
				family.setWeight(rs.getString("weight"));
				family.setFamilygroup(rs.getString("familygroup"));
				return family;
			} else
				return null;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtil.release(rs, stmt, conn);
		}
	}

	/**
	 * 修改家人信息
	 * 
	 * @param family
	 */
	public void modifyFamily(Family family, String nicked) {
		System.out.println("修改家人信息");
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = JdbcUtil.getConnection(); // 1、2
			stmt = conn
					.prepareStatement("update family set nick=?,gender=?,birthday=?,high=?,weight=? where username=? and nick=?"); // 3
			stmt.setString(1, family.getNick()); // 输入“？”的数据
			stmt.setString(2, family.getGender());
			stmt.setString(3, family.getBirthday());
			stmt.setString(4, family.getHigh());
			stmt.setString(5, family.getWeight());
			stmt.setString(6, family.getUsername());
			stmt.setString(7, nicked);
			stmt.executeUpdate(); // 4、5
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtil.release(null, stmt, conn); // 6
		}
	}

	/**
	 * 删除此家人
	 * 
	 * @param family
	 */
	public void deleteFamily(Family family) {
		System.out.println("删除此家人");
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = JdbcUtil.getConnection(); // 1、2
			stmt = conn
					.prepareStatement("delete from family where username=? and nick=?"); // 3
			stmt.setString(1, family.getUsername());
			stmt.setString(2, family.getNick());
			stmt.executeUpdate(); // 4、5
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtil.release(null, stmt, conn); // 6
		}
	}
}
