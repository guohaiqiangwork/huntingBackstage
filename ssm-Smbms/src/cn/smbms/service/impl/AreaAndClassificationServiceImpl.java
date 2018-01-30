package cn.smbms.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.smbms.dao.AreaAndClassificationDao;
import cn.smbms.pojo.Area;
import cn.smbms.pojo.AreaAndClassifications;
import cn.smbms.pojo.Classification;
import cn.smbms.service.AreaAndClassificationService;
/**
 * 全职招聘
 * @author 若水一涵
 *
 */
@Service("areaAndClassificationService")
public class AreaAndClassificationServiceImpl implements AreaAndClassificationService {

	@Resource
	private AreaAndClassificationDao areaAndClassificationDao;
	
	@Override
	public int addArea(Area area) {
		// TODO Auto-generated method stub
		return areaAndClassificationDao.insertArea(area);
	}

	@Override
	public int addClassification(Classification classification) {
		// TODO Auto-generated method stub
		return areaAndClassificationDao.insertClassification(classification);
	}

	@Override
	public int updateArea(Area area) {
		// TODO Auto-generated method stub
		return areaAndClassificationDao.updateArea(area);
	}

	@Override
	public int updateClassification(Classification classification) {
		// TODO Auto-generated method stub
		return areaAndClassificationDao.updateClassification(classification);
	}

	@Override
	public int deleteArea(String idArea) {
		// TODO Auto-generated method stub
		return areaAndClassificationDao.deleteArea(idArea);
	}

	@Override
	public int deleteClassification(String idClassification) {
		// TODO Auto-generated method stub
		return areaAndClassificationDao.deleteClassification(idClassification);
	}

	@Override
	public AreaAndClassifications areaAndClassifications() {
		// TODO Auto-generated method stub
		
		AreaAndClassifications ac = new AreaAndClassifications();
		ac.setArea(areaAndClassificationDao.areas());
		ac.setClassification(areaAndClassificationDao.classifications());
		
		return ac;
	}

}
