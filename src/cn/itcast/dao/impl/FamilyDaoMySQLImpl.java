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

//����PreparedStatement��ʵ�֣�Ԥ����䣩
public class FamilyDaoMySQLImpl implements FamilyDao {

	/**
	 * ���������Ϣ�����ݿ���
	 * 
	 * @param family
	 */
	public void addFamily(Family family) {
		System.out.println("���������Ϣ�����ݿ���");
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = JdbcUtil.getConnection(); // 1��2
			stmt = conn
					.prepareStatement("insert into family (username,nick,birthday,gender,high,weight,familygroup) values(?,?,?,?,?,?,?)"); // 3
			stmt.setString(1, family.getUsername()); // ���롰����������
			stmt.setString(2, family.getNick());
			stmt.setString(3, family.getBirthday());
			stmt.setString(4, family.getGender());
			stmt.setString(5, family.getHigh());
			stmt.setString(6, family.getWeight());
			stmt.setString(7, family.getFamilygroup());
			stmt.executeUpdate(); // 4��5
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtil.release(null, stmt, conn); // 6
		}

	}

	/**
	 * �����û�����ѯ����(����List<Family>)
	 * 
	 * @param username
	 * @return ���ڷ���Family�������ڷ���null
	 */
	public List<Family> findFamilyByUsernameList(String username) {
		System.out.println("�����û������ǳƲ�ѯ����");
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
	 * �����û������ǳƲ�ѯ����(����List<Family>)
	 * 
	 * @param username
	 * @return ���ڷ���Family�������ڷ���null
	 */
	public List<Family> findFamilyByUsernameList(String username, String nick) {
		System.out.println("�����û������ǳƲ�ѯ����");
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
	 * �����û������ǳƲ�ѯ����(����Family)
	 * 
	 * @param username
	 * @return
	 */
	public Family findFamilyByUsername(String username, String nick) {
		System.out.println("�����û������ǳƲ�ѯ����");
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
	 * �޸ļ�����Ϣ
	 * 
	 * @param family
	 */
	public void modifyFamily(Family family, String nicked) {
		System.out.println("�޸ļ�����Ϣ");
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = JdbcUtil.getConnection(); // 1��2
			stmt = conn
					.prepareStatement("update family set nick=?,gender=?,birthday=?,high=?,weight=? where username=? and nick=?"); // 3
			stmt.setString(1, family.getNick()); // ���롰����������
			stmt.setString(2, family.getGender());
			stmt.setString(3, family.getBirthday());
			stmt.setString(4, family.getHigh());
			stmt.setString(5, family.getWeight());
			stmt.setString(6, family.getUsername());
			stmt.setString(7, nicked);
			stmt.executeUpdate(); // 4��5
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtil.release(null, stmt, conn); // 6
		}
	}

	/**
	 * ɾ���˼���
	 * 
	 * @param family
	 */
	public void deleteFamily(Family family) {
		System.out.println("ɾ���˼���");
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = JdbcUtil.getConnection(); // 1��2
			stmt = conn
					.prepareStatement("delete from family where username=? and nick=?"); // 3
			stmt.setString(1, family.getUsername());
			stmt.setString(2, family.getNick());
			stmt.executeUpdate(); // 4��5
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtil.release(null, stmt, conn); // 6
		}
	}
}
