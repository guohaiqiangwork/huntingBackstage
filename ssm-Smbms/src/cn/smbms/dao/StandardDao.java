package cn.smbms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.smbms.pojo.Pagination;
import cn.smbms.pojo.Standard;

/**
 * 代办资质
 * 
 * @author 若水一涵
 *
 */
public interface StandardDao {
	// 插入
	int insert(Standard standard);

	// 修改
	int update(Standard standard);

	// 删除
	int delete(String idStandard);

	// 查询详情
	Standard standard(String idStandard);

	// 查询上一条
	Standard previous(@Param("standard") Standard standard);

	// 查询上下条
	Standard next(@Param("standard") Standard standard);

	// 查询列表
	List<Standard> standards(@Param("standard") Standard standard, @Param("pagination") Pagination pagination);
}
