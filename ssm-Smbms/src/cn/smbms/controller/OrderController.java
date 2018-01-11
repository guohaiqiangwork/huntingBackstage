package cn.smbms.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.smbms.pojo.Bill;
import cn.smbms.pojo.Provider;
import cn.smbms.service.OrderService;
import cn.smbms.service.ProviderService;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Resource(name="orderService")
	private OrderService orderService;
	
	@Resource(name="providerService")
	private ProviderService providerService;
	
	@RequestMapping("/list")
	public String getOrderList(Model model,Bill bill,
				@RequestParam(value="pager.offset",defaultValue="0")Integer pageNum){
		
		List<Bill> list = orderService.getListOrder(bill,pageNum>=0?pageNum:0,5);
		
		int count  = orderService.getOrderCount(bill);
		
		model.addAttribute("total",count);
		model.addAttribute("order",list);
		
		return "order/orderList";
		
	}
	
	@RequestMapping("/orderInfo/{billCode}")
	public String orderInfo(@PathVariable(name="billCode") String code,Model model,Provider pro) throws Exception{
		
		Bill bill = orderService.getOrderByCode(code);
		
		int proCount = providerService.findAllCount(pro);
		
		List<Provider> list = providerService.getAllProvider(pro, 0, proCount);
		
		model.addAttribute("o",bill);
		model.addAttribute("pros",list);
		return "order/orderInfo";
		
	}
	
	
	@RequestMapping("/updateOrder")
	public String updateOrder(Bill bill,Model model){
		bill.setModifyby(1l);
		bill.setModifydate(new Date());
		
		
		boolean boo = orderService.updateOrderInfo(bill);
		if(boo){
			return "redirect:/order/orderInfo/"+bill.getBillcode();
			
		}
		model.addAttribute("updateErr","添加失败");
		
		return "forward:/order/orderInfo"+bill.getBillcode();
	}
	
	
	
	
}
