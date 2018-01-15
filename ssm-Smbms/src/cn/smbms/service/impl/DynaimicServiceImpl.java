package cn.smbms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.smbms.dao.DynamicDao;
import cn.smbms.pojo.Currency;
import cn.smbms.pojo.Dynamic;
import cn.smbms.service.DynamicService;
/**
 * 资质动态实现类
 * @author 若水一涵
 *
 */
@Service("dynamicService")
public class DynaimicServiceImpl implements DynamicService {

	@Resource
	private DynamicDao dynamicDao;
	
	@Override
	public int addDynamic(Dynamic dynamic) {
		// TODO Auto-generated method stub
		return dynamicDao.insert(dynamic);
	}

	@Override
	public int update(Dynamic dynamic) {
		// TODO Auto-generated method stub
		return dynamicDao.update(dynamic);
	}

	@Override
	public int delete(String idDynamic) {
		// TODO Auto-generated method stub
		return dynamicDao.delete(idDynamic);
	}

	@Override
	public Dynamic dynamic(String idDynamic) {
		// TODO Auto-generated method stub
		return dynamicDao.dynamic(idDynamic);
	}

	@Override
	public List<Dynamic> dynamics(Currency<Dynamic> currency) {
		// TODO Auto-generated method stub
		return dynamicDao.dynamics(currency.getData(),currency.getPagination());
	}

}
