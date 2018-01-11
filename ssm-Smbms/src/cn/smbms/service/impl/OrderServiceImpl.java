package cn.smbms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.smbms.dao.BillMapper;
import cn.smbms.pojo.Bill;
import cn.smbms.service.OrderService;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
	
	
	@Resource(name="billMapper")
	private BillMapper billMapper;
	
	
	


	@Override
	public List<Bill> getListOrder(Bill bill, Integer pageNum, Integer pageSize) {
		return billMapper.selectAllBill(bill, pageNum ,pageSize);
	}





	@Override
	public int getOrderCount(Bill bill) {
		return billMapper.selecdCountByBillCodeAndProName(bill);
	}





	@Override
	public Bill getOrderByCode(String code) {
		return billMapper.selectByPrimaryKey(code);
	}





	@Override
	public boolean updateOrderInfo(Bill bill) {
		return billMapper.updateByPrimaryKeySelective(bill) > 0;
	}

}
