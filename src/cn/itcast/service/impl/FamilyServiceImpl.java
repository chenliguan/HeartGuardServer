package cn.itcast.service.impl;

import java.util.List;

import cn.itcast.dao.FamilyDao;
import cn.itcast.dao.ResultDao;
import cn.itcast.domain.Family;
import cn.itcast.exception.UsernameExistException;
import cn.itcast.service.FamilyService;
import cn.itcast.util.DaoFactory;

public class FamilyServiceImpl implements FamilyService {

	private FamilyDao dao = DaoFactory.getInstance().getFamilyDao();
	private ResultDao resultdao = DaoFactory.getInstance().getResultDao();;

	/**
	 * 保存家人信息到数据库中
	 * 
	 * @param family
	 * @throws UsernameExistException
	 */
	public void addFamily(Family family) throws UsernameExistException {
		// 判断用户名是否存在
		Family f = dao.findFamilyByUsername(family.getUsername(),
				family.getNick());
		if (f != null)
			throw new UsernameExistException("此家人已经存在了");
		// 调用Dao保存
		dao.addFamily(family);
	}

	/**
	 * 查询家人的信息
	 * 
	 * @param username
	 * @param nick
	 * @return
	 */
	public List<Family> FamilyInfo(String username) {
		return dao.findFamilyByUsernameList(username);
	}

	/**
	 * 根据用户名和昵称查询某个家人的信息
	 * 
	 * @param username
	 * @param nick
	 * @return
	 */
	public List<Family> FamilyOneInfo(String username, String nick) {
		return dao.findFamilyByUsernameList(username, nick);
	}

	/**
	 * 更改家人信息
	 * 
	 * @param family
	 * @return
	 */
	public void ModifyFamily(Family family, String nicked) {
		dao.modifyFamily(family, nicked); // 调用Dao修改家人信息
		if (!nicked.equals(family.getNick())) {
			resultdao.modifyResultNick(family, nicked); // 调用Dao修改昵称时修改结果中昵称
		}
	}

	/**
	 * 删除此家人
	 * 
	 * @param family
	 * @return
	 */
	public void DeleteFamily(Family family) {
	
		dao.deleteFamily(family); // 删除family记录表的信息
		resultdao.deleteResult(family); // 删除result记录表的信息
	}
}
