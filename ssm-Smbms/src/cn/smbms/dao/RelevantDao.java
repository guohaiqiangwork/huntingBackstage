package cn.smbms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.smbms.pojo.Relevant;

/**
 * 关联文章
 * 
 * @author 若水一涵
 *
 */
public interface RelevantDao {
	// 插入
	int insert(Relevant relevant);

	// 修改
	int update(Relevant relevant);

	// 删除
	int delete(String relevantId);

	// 查询列表
	List<Relevant> relevants(@Param("relevant") Relevant relevant);
}
