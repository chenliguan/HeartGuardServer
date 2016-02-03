package cn.itcast.service;

import java.util.List;

import cn.itcast.domain.Family;
import cn.itcast.exception.UsernameExistException;

public interface FamilyService {

	/**
	 * 保存家人信息到数据库中
	 * 
	 * @param family
	 * @throws UsernameExistException
	 */
	void addFamily(Family family) throws UsernameExistException;

	/**
	 * 根据用户名查询全部家人的信息
	 * 
	 * @param username
	 * @param nick
	 * @return
	 */
	List<Family> FamilyInfo(String username);

	/**
	 * 根据用户名和昵称查询某个家人的信息
	 * 
	 * @param username
	 * @param nick
	 * @return
	 */
	List<Family> FamilyOneInfo(String username, String nick);

	/**
	 * 更改家人信息
	 * 
	 * @param family
	 * @return
	 */
	void ModifyFamily(Family family, String nicked);
	
	/**
	 * 删除此家人
	 * 
	 * @param family
	 * @return
	 */
	void DeleteFamily(Family family);
}
