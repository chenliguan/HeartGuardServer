package cn.itcast.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.itcast.dao.SmsDao;
import cn.itcast.domain.Sms;
import cn.itcast.exception.DaoException;
import cn.itcast.util.JdbcUtil;

//利用PreparedStatement来实现（预制语句）
public class SmsDaoMySQLImpl implements SmsDao {

	/**
	 * 保存验证码到数据库中
	 * @param username
	 */
	public void addCode(String username,int code) {
		System.out.println("保存Code信息到数据库中");
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = JdbcUtil.getConnection();   // 1、2
			stmt = conn.prepareStatement("insert into codes (username,code) values(?,?)");  // 3
			stmt.setString(1, username);  // 输入“？”的数据
			stmt.setInt(2, code);
			stmt.executeUpdate();    // 4、5
		}catch(Exception e){
			throw new DaoException(e);
		}finally{
			JdbcUtil.release(null, stmt, conn);   // 6
		}
	}
	
	/**
	 * 根据用户名查询codes
	 * 通过Sms发送验证码
	 */
	public Sms findCodeByUsername(String username) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement("select code from codes where username=?");
			stmt.setString(1, username);
			rs = stmt.executeQuery();
			if(rs.next()){
				Sms sms = new Sms();
				sms.setCode(rs.getString("code"));
				return sms;
			}else
				return null;
		}catch(Exception e){
			throw new DaoException(e);
		}finally{
			JdbcUtil.release(rs, stmt, conn);
		}
	}

	/**
	 * 根据用户名查询User 
	 * 通过Sms发送密码
	 */
	public Sms findPasswordByUsername(String username) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement("select password from user where username=?");
			stmt.setString(1, username);
			rs = stmt.executeQuery();
			if(rs.next()){
				Sms sms = new Sms();
				sms.setPassword(rs.getString("password"));
				return sms;
			}else
				return null;
		}catch(Exception e){
			throw new DaoException(e);
		}finally{
			JdbcUtil.release(rs, stmt, conn);
		}
	}
	
	/**
	 * 更新已有手机号码的验证码
	 */
	public void updateCode(String username, int code) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = JdbcUtil.getConnection();   // 1、2 
			stmt = conn.prepareStatement("update codes set code = ? where username= ?");  // 3
			stmt.setInt(1, code);  // 输入“？”的数据
			stmt.setString(2, username);
			stmt.executeUpdate();    // 4、5
		}catch(Exception e){
			throw new DaoException(e);
		}finally{
			JdbcUtil.release(null, stmt, conn);   // 6
		}
	}
	
}
