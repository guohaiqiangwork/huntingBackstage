package cn.smbms.service;


import cn.smbms.pojo.Area;
import cn.smbms.pojo.AreaAndClassifications;
import cn.smbms.pojo.Classification;

/**
 * 资质动态
 * @author 若水一涵
 *
 */
public interface AreaAndClassificationService {
	/**
	 * 添加
	 * @param area
	 * @return
	 */
	public int addArea(Area area);
	
	/**
	 * 添加
	 * @param classification
	 * @return
	 */
	public int addClassification(Classification classification);
	
	/**
	 * 修改
	 * @param area
	 * @return
	 */
	public int updateArea(Area area);
	
	/**
	 * 修改
	 * @param classification
	 * @return
	 */
	public int updateClassification(Classification classification);
	
	/**
	 * 删除
	 * @param idArea
	 * @return
	 */
	public int deleteArea(String idArea);
	
	/**
	 * 删除
	 * @param idClassification
	 * @return
	 */
	public int deleteClassification(String idClassification);
	
	/**
	 * 查询列表
	 * @return
	 */
	public AreaAndClassifications areaAndClassifications();
}
