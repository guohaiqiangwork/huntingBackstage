package cn.smbms.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.smbms.pojo.Dynamic;
import cn.smbms.pojo.Pagination;

/**
 * 资质动态
 * 
 * @author 若水一涵
 *
 */
public interface DynamicDao {
	// 插入
	int insert(Dynamic dynamic);

	// 修改
	int update(Dynamic dynamic);

	// 删除
	int delete(String idDynamic);

	// 查询详情
	Dynamic dynamic(String idDynamic);

	// 查询上一条
	Dynamic previous(@Param("dynamic") Dynamic dynamic);

	// 查询上下条
	Dynamic next(@Param("dynamic") Dynamic dynamic);

	// 查询列表
	List<Dynamic> dynamics(@Param("dynamic") Dynamic dynamic, @Param("pagination") Pagination pagination);
	
	// 查询左侧菜单
	ArrayList<String> dynamicMenu();
}
