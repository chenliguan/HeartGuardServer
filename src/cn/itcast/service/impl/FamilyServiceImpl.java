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
	 * ���������Ϣ�����ݿ���
	 * 
	 * @param family
	 * @throws UsernameExistException
	 */
	public void addFamily(Family family) throws UsernameExistException {
		// �ж��û����Ƿ����
		Family f = dao.findFamilyByUsername(family.getUsername(),
				family.getNick());
		if (f != null)
			throw new UsernameExistException("�˼����Ѿ�������");
		// ����Dao����
		dao.addFamily(family);
	}

	/**
	 * ��ѯ���˵���Ϣ
	 * 
	 * @param username
	 * @param nick
	 * @return
	 */
	public List<Family> FamilyInfo(String username) {
		return dao.findFamilyByUsernameList(username);
	}

	/**
	 * �����û������ǳƲ�ѯĳ�����˵���Ϣ
	 * 
	 * @param username
	 * @param nick
	 * @return
	 */
	public List<Family> FamilyOneInfo(String username, String nick) {
		return dao.findFamilyByUsernameList(username, nick);
	}

	/**
	 * ���ļ�����Ϣ
	 * 
	 * @param family
	 * @return
	 */
	public void ModifyFamily(Family family, String nicked) {
		dao.modifyFamily(family, nicked); // ����Dao�޸ļ�����Ϣ
		if (!nicked.equals(family.getNick())) {
			resultdao.modifyResultNick(family, nicked); // ����Dao�޸��ǳ�ʱ�޸Ľ�����ǳ�
		}
	}

	/**
	 * ɾ���˼���
	 * 
	 * @param family
	 * @return
	 */
	public void DeleteFamily(Family family) {
	
		dao.deleteFamily(family); // ɾ��family��¼������Ϣ
		resultdao.deleteResult(family); // ɾ��result��¼������Ϣ
	}
}