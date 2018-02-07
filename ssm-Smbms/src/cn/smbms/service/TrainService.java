package cn.smbms.service;


import java.util.List;

import cn.smbms.pojo.Currency;
import cn.smbms.pojo.Detail;
import cn.smbms.pojo.Train;

/**
 * 证书培训
 * @author 若水一涵
 *
 */
public interface TrainService {
	/**
	 * 添加
	 * @param train
	 * @return
	 */
	public int add(Train train);
	
	/**
	 * 修改
	 * @param train
	 * @return
	 */
	public int update(Train train);
	
	/**
	 * 删除
	 * @param idTrain
	 * @return
	 */
	public int delete(String idTrain);
	
	/**
	 * 查询详情
	 * @param idTrain
	 * @return
	 */
	public Detail<Train> train(String idTrain);
	/**
	 * 查询列表
	 * @param currency
	 * @return
	 */
	public List<Train> trains(Currency<Train> currency);
}
