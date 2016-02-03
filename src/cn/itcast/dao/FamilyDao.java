package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.Family;

public interface FamilyDao {
	/**
	 * ���������Ϣ�����ݿ���
	 * 
	 * @param family
	 */
	void addFamily(Family family);

	/**
	 * �����û�����ѯ����(����List<Family>)
	 * 
	 * @param username
	 * @return ���ڷ���Family�������ڷ���null
	 */
	List<Family> findFamilyByUsernameList(String username);

	/**
	 * �����û������ǳƲ�ѯ����(����Family)
	 * 
	 * @param username
	 * @return
	 */
	Family findFamilyByUsername(String username,String nick);
	
	/**
	 * �����û������ǳƲ�ѯ����(����List<Family>)
	 * 
	 * @param username
	 * @return ���ڷ���Family�������ڷ���null
	 */
	List<Family> findFamilyByUsernameList(String username,String nick);

	/**
	 * �޸ļ�����Ϣ
	 * 
	 * @param family
	 * @return 
	 */
	void modifyFamily(Family family,String nicked);
	
	/**
	 * ɾ���˼���
	 * @param family
	 */
	void deleteFamily(Family family);
}
