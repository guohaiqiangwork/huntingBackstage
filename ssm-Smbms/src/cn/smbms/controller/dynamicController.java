package cn.smbms.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.smbms.pojo.Currency;
import cn.smbms.pojo.Dynamic;
import cn.smbms.pojo.Pagination;
import cn.smbms.service.DynamicService;

/**
 * 资质动态控制器
 * 
 * @author 若水一涵
 *
 */
@Controller
@RequestMapping("/dynamic")
public class dynamicController {

	@Resource
	private DynamicService dynamicService;

	/**
	 * 添加资质动态
	 * 
	 * @return
	 */
	@RequestMapping(value = "/addDynamic", method = RequestMethod.POST)
	public @ResponseBody Object addDynamic(@RequestBody Currency<Dynamic> currency) {
		Date date = new Date();
		// 设置id
		currency.getData().setIdDynamic(date.getTime() + "");
		// 设置操作时间
		currency.getData().setTime(date);
		int result = dynamicService.addDynamic(currency.getData());

		return result > 0 ? "成功" : "失败";
	}

	/**
	 * 修改
	 * 
	 * @param dynamic
	 * @return
	 */
	@RequestMapping(value = "/updateDynamic", method = RequestMethod.POST)
	@ResponseBody
	public Object update(@RequestBody Dynamic dynamic) {

		int result = dynamicService.update(dynamic);

		return result > 0 ? "成功" : "失败";
	}

	/**
	 * 删除
	 * @param dynamic
	 * @return
	 */
	@RequestMapping(value = "/deleteDynamic", method = RequestMethod.POST)
	@ResponseBody
	public Object delete(@RequestBody Dynamic dynamic) {

		int result = dynamicService.delete(dynamic.getIdDynamic()+"");

		return result > 0 ? "成功" : "失败";
	}
	
	/**
	 * 查询详情
	 * @param dynamic
	 * @return
	 */
	@RequestMapping(value = "/getDynamic", method = RequestMethod.POST)
	@ResponseBody
	public Dynamic dynamic(@RequestBody Dynamic dynamic) {

		Dynamic result = dynamicService.dynamic(dynamic.getIdDynamic()+"");

		return result;
	}
	/**
	 * 查询列表
	 * @param currency
	 * @return
	 */
	@RequestMapping(value = "/getDynamics", method = RequestMethod.POST)
	@ResponseBody
	public List<Dynamic> dynamics(@RequestBody Currency<Dynamic> currency) {
		// 修改分页索引
		Pagination pagination = currency.getPagination();
		pagination.setPageIndex(pagination.getPageIndex()-1);
		currency.setPagination(pagination);
		
		List<Dynamic> result = dynamicService.dynamics(currency);

		return result;
	}
}
