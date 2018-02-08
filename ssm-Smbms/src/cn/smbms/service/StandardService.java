package cn.smbms.service;


import java.util.List;

import cn.smbms.pojo.Currency;
import cn.smbms.pojo.Detail;
import cn.smbms.pojo.Standard;

/**
 * 代办资质
 * @author 若水一涵
 *
 */
public interface StandardService {
	/**
	 * 添加
	 * @param standard
	 * @return
	 */
	public int add(Standard standard);
	
	/**
	 * 修改
	 * @param standard
	 * @return
	 */
	public int update(Standard standard);
	
	/**
	 * 删除
	 * @param idStandard
	 * @return
	 */
	public int delete(String idStandard);
	
	/**
	 * 查询详情
	 * @param idStandard
	 * @return
	 */
	public Detail<Standard> standard(String idStandard);
	/**
	 * 查询列表
	 * @param currency
	 * @return
	 */
	public List<Standard> standards(Currency<Standard> currency);
}
