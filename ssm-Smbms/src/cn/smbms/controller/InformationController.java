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
import cn.smbms.pojo.Information;
import cn.smbms.pojo.Pagination;
import cn.smbms.service.InformationService;

/**
 * 个人挂靠、企业寻证、全球招聘控制器
 * 
 * @author 若水一涵
 *
 */
@Controller
@RequestMapping("/information")
@CrossOrigin
public class InformationController extends BaseController {

	@Resource
	private InformationService informationService;

	public void addData(Information information) {
		for (int i = 0; i < 30; i++) {

			Date date = new Date();
			// 设置id
			information.setIdInformation(date.getTime() + "");
			// 设置操作时间
			information.setTime(date);
			information.setType(i % 3 + 1);
			information.setTitle("标题" + (i % 3 + 1));

			informationService.add(information);
		}
	}

	/**
	 * 添加个人挂靠、企业寻证、全球招聘
	 * 
	 * @return
	 */
	@RequestMapping(value = "/addInformation", method = RequestMethod.POST)
	@ResponseBody
	public Object addDynamic(@RequestBody Information information) {
		Date date = new Date();
		// 设置id
		information.setIdInformation(date.getTime() + "");
		// 设置操作时间
		information.setTime(date);
		int result = informationService.add(information);
//		addData(information);
		if(result>0) {
			return retContent(200, "添加成功");
		}
		return retContent(2029, "添加失败");
	}

	/**
	 * 修改
	 * 
	 * @param dynamic
	 * @return
	 */
	@RequestMapping(value = "/updateInformation", method = RequestMethod.POST)
	@ResponseBody
	public Object update(@RequestBody Information information) {

		int result = informationService.update(information);

		return retContent(200, result);
	}

	/**
	 * 删除
	 * 
	 * @param dynamic
	 * @return
	 */
	@RequestMapping(value = "/deleteInformation", method = RequestMethod.POST)
	@ResponseBody
	public Object delete(@RequestBody Information information) {

		int result = informationService.delete(information.getIdInformation() + "");

		return retContent(200, result);
	}

	/**
	 * 查询详情
	 * 
	 * @param dynamic
	 * @return
	 */
	@RequestMapping(value = "/getInformation", method = RequestMethod.POST)
	@ResponseBody
	public Object information(@RequestBody Information information) {

		Information result = informationService.information(information.getIdInformation() + "");
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
	@RequestMapping(value = "/getInformations", method = RequestMethod.POST)
	@ResponseBody
	public Object informations(@RequestBody Currency<Information> currency) {
		// 修改分页索引
		Pagination pagination = currency.getPagination();
		if (pagination != null) {
			pagination.setPageIndex(pagination.getPageIndex() - 1);
			currency.setPagination(pagination);
		}
		List<Information> result = informationService.informations(currency);
		if (null != result) {
			return retContent(200, result);
		}
		return retContent(201, result);
	}
}
