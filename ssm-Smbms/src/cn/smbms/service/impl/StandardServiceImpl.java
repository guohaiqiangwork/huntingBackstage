package cn.smbms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.smbms.dao.StandardDao;
import cn.smbms.pojo.Currency;
import cn.smbms.pojo.Standard;
import cn.smbms.service.StandardService;
/**
 * 资质动态实现类
 * @author 若水一涵
 *
 */
@Service("standardService")
public class StandardServiceImpl implements StandardService {

	@Resource
	private StandardDao standardDao;

	@Override
	public int add(Standard standard) {
		// TODO Auto-generated method stub
		return standardDao.insert(standard);
	}

	@Override
	public int update(Standard standard) {
		// TODO Auto-generated method stub
		return standardDao.update(standard);
	}

	@Override
	public int delete(String idStandard) {
		// TODO Auto-generated method stub
		return standardDao.delete(idStandard);
	}

	@Override
	public Standard standard(String idStandard) {
		// TODO Auto-generated method stub
		return standardDao.standard(idStandard);
	}

	@Override
	public List<Standard> standards(Currency<Standard> currency) {
		// TODO Auto-generated method stub
		return standardDao.standards(currency.getData(),currency.getPagination());
	}
	

}
