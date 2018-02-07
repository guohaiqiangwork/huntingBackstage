package cn.smbms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.smbms.pojo.Information;
import cn.smbms.pojo.Pagination;
/**
 * 个人挂靠、企业寻证、全球招聘
 * @author 若水一涵
 *
 */
public interface InformationDao {
	// 插入
	int insert(Information information);
	
	// 修改
	int update(Information information);
	
	// 删除
	int delete(String idInformation);
	
	// 查询详情
	Information information(String idInformation);
	
	// 查询列表
	List<Information> informations(@Param("information")Information information, @Param("pagination")Pagination pagination);
}
