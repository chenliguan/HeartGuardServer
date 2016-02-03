package cn.itcast.service.impl;

import java.util.List;

import cn.itcast.dao.ResultDao;
import cn.itcast.domain.Result;
import cn.itcast.exception.UsernameExistException;
import cn.itcast.service.ResultService;
import cn.itcast.util.DaoFactory;

public class ResultServiceImpl implements ResultService {
	
	private ResultDao dao = DaoFactory.getInstance().getResultDao();

	public Result Receive(Result result) throws UsernameExistException {
		return dao.addResult(result);
	}

	public List<Result> TransmitResults(String username) {
		return dao.findResultByUsername(username);
	}

	public List<Result> Transmit_Rate_grade(String username) {
		return dao.findRate_gradeByUsername(username);
	}
}
