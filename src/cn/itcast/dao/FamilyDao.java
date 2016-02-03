package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.Family;

public interface FamilyDao {
	/**
	 * 保存家人信息到数据库中
	 * 
	 * @param family
	 */
	void addFamily(Family family);

	/**
	 * 根据用户名查询家人(返回List<Family>)
	 * 
	 * @param username
	 * @return 存在返回Family，不存在返回null
	 */
	List<Family> findFamilyByUsernameList(String username);

	/**
	 * 根据用户名和昵称查询家人(返回Family)
	 * 
	 * @param username
	 * @return
	 */
	Family findFamilyByUsername(String username,String nick);
	
	/**
	 * 根据用户名和昵称查询家人(返回List<Family>)
	 * 
	 * @param username
	 * @return 存在返回Family，不存在返回null
	 */
	List<Family> findFamilyByUsernameList(String username,String nick);

	/**
	 * 修改家人信息
	 * 
	 * @param family
	 * @return 
	 */
	void modifyFamily(Family family,String nicked);
	
	/**
	 * 删除此家人
	 * @param family
	 */
	void deleteFamily(Family family);
}
