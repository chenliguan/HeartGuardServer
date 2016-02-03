package cn.itcast.service;

import java.util.List;

import cn.itcast.domain.Result;
import cn.itcast.exception.UsernameExistException;

public interface ResultService {

	/**
	 * 从客户端接收报告数据
	 * 
	 * @param user
	 * @return
	 * @throws UsernameExistException用户名存在抛出此异常
	 */
	Result Receive(Result result) throws UsernameExistException;
	
	/**
	 * 传送所有数据到客户端
	 * 
	 * @param username
	 * @return
	 */
	List<Result> TransmitResults(String username);
	
	/**
	 * 传送Rate_grade数据到客户端
	 * 
	 * @param username
	 * @return
	 */
	List<Result> Transmit_Rate_grade(String username);
}
