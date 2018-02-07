package cn.smbms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.smbms.pojo.Pagination;
import cn.smbms.pojo.Train;
/**
 * 证书培训
 * @author 若水一涵
 *
 */
public interface TrainDao {
	// 插入
	int insert(Train train);
	
	// 修改
	int update(Train train);
	
	// 删除
	int delete(String idTrain);
	
	// 查询详情
	Train train(String idTrain);
	
	// 查询上一条
	Train previous(@Param("train")Train train);
	
	// 查询上下条
	Train next(@Param("train")Train train);
	
	// 查询列表
	List<Train> trains(@Param("train")Train train, @Param("pagination")Pagination pagination);
}
