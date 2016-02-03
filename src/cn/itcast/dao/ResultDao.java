package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.Family;
import cn.itcast.domain.Result;

public interface ResultDao {
	/**
	 * 保存诊断数据到数据库中
	 * @param user
	 * @return 
	 */
	Result addResult(Result result);
	
	/**
	 * 根据用户名查询用户的诊断数据
	 * @param username
	 * @return
	 */
	List<Result> findResultByUsername(String username);
	
	/**
	 * 根据用户名查询用户的Rate_grade数据
	 * @param username
	 * @return
	 */
	List<Result> findRate_gradeByUsername(String username);
	
	/**
	 * 修改家人信息时修改结果中昵称
	 * 
	 * @param family
	 * @return 
	 */
	void modifyResultNick(Family family,String nicked);
	
	/**
	 * 删除此家人的结果
	 * @param family
	 */
	void deleteResult(Family family);
}
