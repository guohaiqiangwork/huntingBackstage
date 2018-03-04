package cn.smbms.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.smbms.pojo.Currency;
import cn.smbms.pojo.Detail;
import cn.smbms.pojo.Dynamic;
import cn.smbms.pojo.Html;
import cn.smbms.pojo.Pagination;
import cn.smbms.service.DynamicService;
import cn.smbms.utils.PoiUtil;

/**
 * 资质动态控制器
 * 
 * @author 若水一涵
 *
 */
@MultipartConfig
@Controller
@RequestMapping("/dynamic")
@CrossOrigin
public class DynamicController extends BaseController {

	@Resource
	private DynamicService dynamicService;

	public void addData(Dynamic dynamic) {
		for (int i = 0; i < 30; i++) {

			Date date = new Date();
			// 设置id
			dynamic.setIdDynamic(date.getTime() + "");
			// 设置操作时间
			dynamic.setTime(date);
			dynamic.setType(i % 3 + 1);
			dynamic.setTitle("标题" + (i % 3 + 1));
			dynamic.setContent("容贼长的内容" + (i % 3 + 1));
			switch (i % 7) {
			case 0:
				dynamic.setDynamicAddress("北京资质");
				break;
			case 1:
				dynamic.setDynamicAddress("建设部资质");
				break;
			case 2:
				dynamic.setDynamicAddress("上海资质");
				break;
			case 3:
				dynamic.setDynamicAddress("山西资质");
				break;
			case 4:
				dynamic.setDynamicAddress("陕西资质");
				break;
			case 5:
				dynamic.setDynamicAddress("山东资质");
				break;
			case 6:
				dynamic.setDynamicAddress("河北资质");
				break;
			default:
				break;
			}

			dynamicService.addDynamic(dynamic);
		}
	}

	/**
	 * 添加资质动态
	 * 
	 * @return
	 */
	@RequestMapping(value = "/addDynamic", method = RequestMethod.POST)
	@ResponseBody
	public Object addDynamic(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		Date date = new Date();
		Dynamic dynamic = new Dynamic();
		// 设置id
		dynamic.setIdDynamic(date.getTime() + "");
		// 设置操作时间
		dynamic.setTime(date);
		// 设置浏览数量
		dynamic.setBrowsingNumber(1);
		// 设置标题
		dynamic.setTitle(request.getParameter("title"));
		// 设置地址
		dynamic.setDynamicAddress(request.getParameter("dynamicAddress"));
		// 设置类型
		String type = request.getParameter("type");
		dynamic.setType((type != null && !type.isEmpty())?Integer.parseInt(type):null);
		Html html = null;
		try {
			html = PoiUtil.getHtml(file, request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return retContent(201, "文件解析出问题了");
		}
		if (html != null) {
			dynamic.setContent(html.getHtml());
			dynamic.setHtmlUrl(html.getImagesParentFileUrl());
		} else {
			return retContent(201, "文件解析出问题了");
		}
		int result = dynamicService.addDynamic(dynamic);

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

		Detail<Dynamic> result = dynamicService.dynamic(dynamic.getIdDynamic() + "");
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
		if (null != result) {
			return retContent(200, result);
		}
		return retContent(201, result);
	}

	@RequestMapping(value = "/getDynamicMenu", method = RequestMethod.POST)
	@ResponseBody
	public Object dynamics() {
		ArrayList<String> result = dynamicService.dynamicMenu();
		if (null != result) {
			return retContent(200, result);
		}
		return retContent(201, result);
	}
}
