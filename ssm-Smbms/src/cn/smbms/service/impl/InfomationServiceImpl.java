package cn.smbms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.smbms.dao.InformationDao;
import cn.smbms.pojo.Currency;
import cn.smbms.pojo.Information;
import cn.smbms.service.InformationService;
/**
 * 个人挂靠、企业寻证、全球招聘实现类
 * @author 若水一涵
 *
 */
@Service("informationService")
public class InfomationServiceImpl implements InformationService {

	@Resource
	private InformationDao infomationDao;

	@Override
	public int add(Information information) {
		// TODO Auto-generated method stub
		return infomationDao.insert(information);
	}

	@Override
	public int update(Information information) {
		// TODO Auto-generated method stub
		return infomationDao.update(information);
	}

	@Override
	public int delete(String idInformation) {
		// TODO Auto-generated method stub
		return infomationDao.delete(idInformation);
	}

	@Override
	public Information information(String idInformation) {
		// TODO Auto-generated method stub
		return infomationDao.information(idInformation);
	}

	@Override
	public List<Information> informations(Currency<Information> currency) {
		// TODO Auto-generated method stub
		return infomationDao.informations(currency.getData(), currency.getPagination());
	}


}
