package cn.smbms.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.smbms.pojo.Currency;
import cn.smbms.pojo.Pagination;
import cn.smbms.pojo.Standard;
import cn.smbms.service.StandardService;

/**
 * 资质动态控制器
 * 
 * @author 若水一涵
 *
 */
@Controller
@RequestMapping("/standard")
@CrossOrigin
public class StandardController extends BaseController {

	@Resource
	private StandardService standardService;

	public void addData(Currency<Standard> currency) {
		for (int i = 0; i < 30; i++) {

			Date date = new Date();
			// 设置id
			currency.getData().setIdStandard(date.getTime() + "");
			// 设置操作时间
			currency.getData().setTime(date);
			currency.getData().setType(i % 8 + 1);
			currency.getData().setTitle("标题" + (i % 3 + 1));
			currency.getData().setContent("容贼长的内容" + (i % 3 + 1));

			standardService.add(currency.getData());
		}
	}

	/**
	 * 添加资质动态
	 * 
	 * @return
	 */
	@RequestMapping(value = "/addStandard", method = RequestMethod.POST)
	@ResponseBody
	public Object addDynamic(@RequestBody Currency<Standard> currency) {
		Date date = new Date();
		// 设置id
		currency.getData().setIdStandard(date.getTime() + "");
		// 设置操作时间
		currency.getData().setTime(date);
		int result = standardService.add(currency.getData());
//		addData(currency);
		
		return retContent(200, result);
	}

	/**
	 * 修改
	 * 
	 * @param dynamic
	 * @return
	 */
	@RequestMapping(value = "/updateStandard", method = RequestMethod.POST)
	@ResponseBody
	public Object update(@RequestBody Standard standard) {

		int result = standardService.update(standard);

		return retContent(200, result);
	}

	/**
	 * 删除
	 * 
	 * @param dynamic
	 * @return
	 */
	@RequestMapping(value = "/deleteStandard", method = RequestMethod.POST)
	@ResponseBody
	public Object delete(@RequestBody Standard standard) {

		int result = standardService.delete(standard.getIdStandard() + "");

		return retContent(200, result);
	}

	/**
	 * 查询详情
	 * 
	 * @param dynamic
	 * @return
	 */
	@RequestMapping(value = "/getStandard", method = RequestMethod.POST)
	@ResponseBody
	public Object standard(@RequestBody Standard standard) {

		Standard result = standardService.standard(standard.getIdStandard() + "");
		if (null != result) {
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
	@RequestMapping(value = "/getStandards", method = RequestMethod.POST)
	@ResponseBody
	public Object standards(@RequestBody Currency<Standard> currency) {
		// 修改分页索引
		Pagination pagination = currency.getPagination();
		if (pagination != null) {
			pagination.setPageIndex(pagination.getPageIndex() - 1);
			currency.setPagination(pagination);
		}
		List<Standard> result = standardService.standards(currency);
		if (null != result) {
			return retContent(200, result);
		}
		return retContent(201, result);
	}
}
