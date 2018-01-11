package cn.smbms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.smbms.pojo.Bill;

public interface BillMapper {
    int deleteByPrimaryKey(String code);

    int insert(Bill record);

    int insertSelective(Bill record);

    Bill selectByPrimaryKey(String code);
    
    List<Bill> selectAllBill(@Param("bi")Bill bill, @Param("pageNum")Integer pageNum, @Param("pageSize")Integer pageSize);

    int selecdCountByBillCodeAndProName(@Param("bi")Bill bill);
    
    
    int updateByPrimaryKeySelective(Bill record);

    int updateByPrimaryKey(Bill record);
}