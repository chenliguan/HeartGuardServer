package cn.itcast.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.itcast.dao.ResultDao;
import cn.itcast.domain.Family;
import cn.itcast.domain.Result;
import cn.itcast.exception.DaoException;
import cn.itcast.util.JdbcUtil;

//利用PreparedStatement来实现（预制语句）
public class ResultDaoMySQLImpl implements ResultDao {

	/**
	 * 保存用户测量数据到数据库中
	 */
	public Result addResult(Result result) {
		System.out.println("利用PreparedStatement保存Result到了数据库中");
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = JdbcUtil.getConnection(); // 1、2
			stmt = conn
					.prepareStatement("insert into result (username,nick,time,rate_grade,symptoms_rhythm,rate_average,"
							+ "rate_min,rate_max,rhythm_heart,sinus_arrest,cardia_heart,heart_beat_number,"
							+ "psvc_number,pvc_number, QRS, RR, QT, PR,QTC, symptoms_heart,"
							+ " symptoms_heart_left,symptoms_heart_right, symptoms_heart_two)"
							+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); // 3
//			stmt.setInt(1, Random.RandomTest(10000));
			stmt.setString(1, result.getUsername());
			stmt.setString(2, result.getNick());
			stmt.setString(3, result.getTime());
			stmt.setString(4, result.getRate_grade());
			stmt.setString(5, result.getSymptoms_rhythm());
			stmt.setString(6, result.getRate_average());
			stmt.setString(7, result.getRate_min());
			stmt.setString(8, result.getRate_max());
			stmt.setString(9, result.getRhythm_heart());
			stmt.setString(10, result.getSinus_arrest());
			stmt.setString(11, result.getCardia_heart());
			stmt.setString(12, result.getHeart_beat_number());
			stmt.setString(13, result.getPsvc_number());
			stmt.setString(14, result.getPvc_number());
			stmt.setString(15, result.getQRS());
			stmt.setString(16, result.getRR());
			stmt.setString(17, result.getQT());
			stmt.setString(18, result.getPR());
			stmt.setString(19, result.getQTC());
			stmt.setString(20, result.getSymptoms_heart());
			stmt.setString(21, result.getSymptoms_heart_left());
			stmt.setString(22, result.getSymptoms_heart_right());
			stmt.setString(23, result.getSymptoms_heart_two());
			stmt.executeUpdate(); // 4、5
			return result;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtil.release(null, stmt, conn); // 6
		}
	}

	/**
	 * 根据用户名查询用户的测量数据
	 */
	public List<Result> findResultByUsername(String username) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement("select * from result where username=? and 1 order by id desc limit 0,10");
			stmt.setString(1, username);
			rs = stmt.executeQuery();
			List<Result> results=new ArrayList<Result>();
			while(rs.next()){                   // 这里写的是 if(rs.next())，要改为：while(rs.next())才会循环
				Result result = new Result();
				result.setUsername(rs.getString("username"));
				result.setNick(rs.getString("nick"));
				result.setTime(rs.getString("time"));
				result.setRate_grade(rs.getString("rate_grade"));
				result.setSymptoms_rhythm(rs.getString("symptoms_rhythm"));
				result.setRate_average(rs.getString("rate_average"));
				result.setRate_min(rs.getString("rate_min"));
				result.setRate_max(rs.getString("rate_max"));
				result.setRhythm_heart(rs.getString("rhythm_heart"));
				result.setSinus_arrest(rs.getString("sinus_arrest"));
				result.setCardia_heart(rs.getString("cardia_heart"));
				result.setHeart_beat_number(rs.getString("heart_beat_number"));
				result.setPsvc_number(rs.getString("psvc_number"));
				result.setPvc_number(rs.getString("pvc_number"));
				result.setQRS(rs.getString("QRS"));
				result.setRR(rs.getString("RR"));
				result.setQT(rs.getString("QT"));
				result.setPR(rs.getString("PR"));
				result.setQTC(rs.getString("QTC"));
				result.setSymptoms_heart(rs.getString("symptoms_heart"));
				result.setSymptoms_heart_left(rs.getString("symptoms_heart_left"));
				result.setSymptoms_heart_right(rs.getString("symptoms_heart_right"));
				result.setSymptoms_heart_two(rs.getString("symptoms_heart_two"));
				results.add(result);
			}
			return results;
		}catch(Exception e){
			throw new DaoException(e);
		}finally{
			JdbcUtil.release(rs, stmt, conn);
		}
	}

	/**
	 * 根据用户名查询用户的Rate_grade数据
	 */
	public List<Result> findRate_gradeByUsername(String username) {
		System.out.println("根据用户名查询用户的Rate_grade数据");
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement("select rate_grade from result where username=? and 1 order by id desc limit 0,10");
			stmt.setString(1, username);
			rs = stmt.executeQuery();
			List<Result> results=new ArrayList<Result>();
			while(rs.next()){                   // 这里写的是 if(rs.next())，要改为：while(rs.next())才会循环
				Result result = new Result();
				result.setRate_grade(rs.getString("rate_grade"));
				results.add(result);
			}
			return results;
		}catch(Exception e){
			throw new DaoException(e);
		}finally{
			JdbcUtil.release(rs, stmt, conn);
		}
	}
	
	/**
	 * 修改家人信息时修改结果中昵称
	 */
	public void modifyResultNick(Family family, String nicked) {
		System.out.println("修改家人信息时修改结果中昵称");
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = JdbcUtil.getConnection(); // 1、2
			stmt = conn
					.prepareStatement("update result set nick=? where username=? and nick=?"); // 3
			stmt.setString(1, family.getNick()); 
			stmt.setString(2, family.getUsername());
			stmt.setString(3, nicked);
			stmt.executeUpdate(); // 4、5
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtil.release(null, stmt, conn); // 6
		}
	}

	/**
	 * 删除此家人的结果
	 */
	public void deleteResult(Family family) {
		System.out.println("删除此家人结果");
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = JdbcUtil.getConnection(); // 1、2
			stmt = conn
					.prepareStatement("delete from result where username=? and nick=?"); // 3
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
