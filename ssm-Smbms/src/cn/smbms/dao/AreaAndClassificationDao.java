package cn.smbms.dao;

import java.util.List;

import cn.smbms.pojo.Area;
import cn.smbms.pojo.Classification;

public interface AreaAndClassificationDao {
	// 插入
	int insertArea(Area area);

	// 插入
	int insertClassification(Classification classification);

	// 修改
	int updateArea(Area area);

	// 修改
	int updateClassification(Classification classification);

	// 删除
	int deleteArea(String idArea);

	// 删除
	int deleteClassification(String idClassification);

	// 查询所有地区
	List<Area> areas();

	// 查询分类
	List<Classification> classifications();
}
