package cn.smbms.service;

import java.util.List;


import cn.smbms.pojo.Bill;


public interface OrderService {
	
	public List<Bill> getListOrder(Bill bill, Integer pageNum, Integer i);
	
	
	public int getOrderCount(Bill bill);


	public Bill getOrderByCode(String code);


	public boolean updateOrderInfo(Bill bill);
	
	

}
