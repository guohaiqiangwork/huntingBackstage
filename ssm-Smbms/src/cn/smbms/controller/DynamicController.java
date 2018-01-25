package cn.smbms.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

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
public class DynamicController extends BaseController {

	@Resource
	private DynamicService dynamicService;

	// public void addData(Currency<Dynamic> currency) {
	// for(int i=0;i<30;i++) {
	//
	//
	// Date date = new Date();
	// // 设置id
	// currency.getData().setIdDynamic(date.getTime() + "");
	// // 设置操作时间
	// currency.getData().setTime(date);
	// currency.getData().setType(i%3+1);
	// currency.getData().setTitle("标题"+(i%3+1));
	// currency.getData().setContent("容贼长的内容"+(i%3+1));
	// switch (i%7) {
	// case 0:
	// currency.getData().setDynamicAddress("北京资质");
	// break;
	// case 1:
	// currency.getData().setDynamicAddress("建设部资质");
	// break;
	// case 2:
	// currency.getData().setDynamicAddress("上海资质");
	// break;
	// case 3:
	// currency.getData().setDynamicAddress("山西资质");
	// break;
	// case 4:
	// currency.getData().setDynamicAddress("陕西资质");
	// break;
	// case 5:
	// currency.getData().setDynamicAddress("山东资质");
	// break;
	// case 6:
	// currency.getData().setDynamicAddress("河北资质");
	// break;
	// default:
	// break;
	// }
	//
	// dynamicService.addDynamic(currency.getData());
	// }
	// }

	/**
	 * 添加资质动态
	 * 
	 * @return
	 */
	@RequestMapping(value = "/addDynamic", method = RequestMethod.POST)
	@ResponseBody
	public Object addDynamic(@RequestBody Currency<Dynamic> currency) {
		Date date = new Date();
		// 设置id
		currency.getData().setIdDynamic(date.getTime() + "");
		// 设置操作时间
		currency.getData().setTime(date);
		int result = dynamicService.addDynamic(currency.getData());

		return retContent(200, result);
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

		return retContent(200, result);
	}

	/**
	 * 删除
	 * 
	 * @param dynamic
	 * @return
	 */
	@RequestMapping(value = "/deleteDynamic", method = RequestMethod.POST)
	@ResponseBody
	public Object delete(@RequestBody Dynamic dynamic) {

		int result = dynamicService.delete(dynamic.getIdDynamic() + "");

		return retContent(200, result);
	}

	/**
	 * 查询详情
	 * 
	 * @param dynamic
	 * @return
	 */
	@RequestMapping(value = "/getDynamic", method = RequestMethod.POST)
	@ResponseBody
	public Object dynamic(@RequestBody Dynamic dynamic) {

		Dynamic result = dynamicService.dynamic(dynamic.getIdDynamic() + "");
		if(null!=result) {
			return retContent(200, result);
		}
		return retContent(201, result);
	}

	/**
	 * 查询列表
	 * 
	 * @param currency
	 * @return
	 */
	@RequestMapping(value = "/getDynamics", method = RequestMethod.POST)
	@ResponseBody
	public Object dynamics(@RequestBody Currency<Dynamic> currency) {
		// 修改分页索引
		Pagination pagination = currency.getPagination();
		if (pagination != null) {
			pagination.setPageIndex(pagination.getPageIndex() - 1);
			currency.setPagination(pagination);
		}
		List<Dynamic> result = dynamicService.dynamics(currency);
		if(null!=result) {
			return retContent(200, result);
		}
		return retContent(201, result);
	}
}
