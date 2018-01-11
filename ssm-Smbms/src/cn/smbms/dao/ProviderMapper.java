package cn.smbms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.smbms.pojo.Provider;

public interface ProviderMapper {
    int deleteByPrimaryKey(String id);

    int insert(Provider record);

    int insertSelective(Provider record);

    Provider selectByPrimaryKey(String proId);

    int updateByPrimaryKeySelective(Provider record);

    int updateByPrimaryKey(Provider record);
    
    public Integer selectCount(@Param("pro")Provider pro);

	List<Provider> selectAllProviderInfo(@Param("pro")Provider pro, @Param("pageNum")Integer pageNum,@Param("pageSize")Integer pageSize);
}