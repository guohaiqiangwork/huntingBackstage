package cn.smbms.service;


import java.util.List;

import cn.smbms.pojo.Currency;
import cn.smbms.pojo.Information;

/**
 * 个人挂靠、企业寻证、全球招聘
 * @author 若水一涵
 *
 */
public interface InformationService {
	/**
	 * 添加
	 * @param information
	 * @return
	 */
	public int add(Information information);
	
	/**
	 * 修改
	 * @param information
	 * @return
	 */
	public int update(Information information);
	
	/**
	 * 删除
	 * @param idInformation
	 * @return
	 */
	public int delete(String idInformation);
	
	/**
	 * 查询详情
	 * @param idInformation
	 * @return
	 */
	public Information information(String idInformation);
	/**
	 * 查询列表
	 * @param currency
	 * @return
	 */
	public List<Information> informations(Currency<Information> currency);
}
