package cn.itcast.service;

import java.util.List;

import cn.itcast.domain.Result;
import cn.itcast.exception.UsernameExistException;

public interface ResultService {

	/**
	 * �ӿͻ��˽��ձ�������
	 * 
	 * @param user
	 * @return
	 * @throws UsernameExistException�û��������׳����쳣
	 */
	Result Receive(Result result) throws UsernameExistException;
	
	/**
	 * �����������ݵ��ͻ���
	 * 
	 * @param username
	 * @return
	 */
	List<Result> TransmitResults(String username);
	
	/**
	 * ����Rate_grade���ݵ��ͻ���
	 * 
	 * @param username
	 * @return
	 */
	List<Result> Transmit_Rate_grade(String username);
}
