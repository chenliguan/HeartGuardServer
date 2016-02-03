package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.Family;
import cn.itcast.domain.Result;

public interface ResultDao {
	/**
	 * ����������ݵ����ݿ���
	 * @param user
	 * @return 
	 */
	Result addResult(Result result);
	
	/**
	 * �����û�����ѯ�û����������
	 * @param username
	 * @return
	 */
	List<Result> findResultByUsername(String username);
	
	/**
	 * �����û�����ѯ�û���Rate_grade����
	 * @param username
	 * @return
	 */
	List<Result> findRate_gradeByUsername(String username);
	
	/**
	 * �޸ļ�����Ϣʱ�޸Ľ�����ǳ�
	 * 
	 * @param family
	 * @return 
	 */
	void modifyResultNick(Family family,String nicked);
	
	/**
	 * ɾ���˼��˵Ľ��
	 * @param family
	 */
	void deleteResult(Family family);
}