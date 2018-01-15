package cn.smbms.service;


import java.util.List;

import cn.smbms.pojo.Currency;
import cn.smbms.pojo.Dynamic;

/**
 * 资质动态
 * @author 若水一涵
 *
 */
public interface DynamicService {
	/**
	 * 添加
	 * @param dynamic
	 * @return
	 */
	public int addDynamic(Dynamic dynamic);
	
	/**
	 * 修改
	 * @param dynamic
	 * @return
	 */
	public int update(Dynamic dynamic);
	
	/**
	 * 删除
	 * @param idDynamic
	 * @return
	 */
	public int delete(String idDynamic);
	
	/**
	 * 查询详情
	 * @param idDynamic
	 * @return
	 */
	public Dynamic dynamic(String idDynamic);
	/**
	 * 查询列表
	 * @param currency
	 * @return
	 */
	public List<Dynamic> dynamics(Currency<Dynamic> currency);
}
