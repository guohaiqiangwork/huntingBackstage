package cn.smbms.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.smbms.pojo.Area;
import cn.smbms.pojo.AreaAndClassifications;
import cn.smbms.pojo.Classification;
import cn.smbms.service.AreaAndClassificationService;

/**
 * 资质动态控制器
 * 
 * @author 若水一涵
 *
 */
@Controller
@RequestMapping("/areaAndClassification")
@CrossOrigin
public class AreaAndClassificationController extends BaseController {

	@Resource
	private AreaAndClassificationService ACService;

	/**
	 * 添加地区
	 * 
	 * @return
	 */
	@RequestMapping(value = "/addArea", method = RequestMethod.POST)
	@ResponseBody
	public Object addArea(@RequestBody Area area) {
		Date date = new Date();
		// 设置id
		area.setIdArea(date.getTime() + "");

		int result = ACService.addArea(area);

		return retContent(200, result);
	}

	/**
	 * 添加分类
	 * 
	 * @return
	 */
	@RequestMapping(value = "/addClassification", method = RequestMethod.POST)
	@ResponseBody
	public Object addClassification(@RequestBody Classification classification) {
		Date date = new Date();
		// 设置id
		classification.setIdClassification(date.getTime() + "");

		int result = ACService.addClassification(classification);

		return retContent(200, result);
	}

	/**
	 * 修改地区
	 * 
	 * @param area
	 * @return
	 */
	@RequestMapping(value = "/updateArea", method = RequestMethod.POST)
	@ResponseBody
	public Object updateArea(@RequestBody Area area) {

		int result = ACService.updateArea(area);

		return retContent(200, result);
	}

	/**
	 * 修改分类
	 * 
	 * @param classification
	 * @return
	 */
	@RequestMapping(value = "/updateClassification", method = RequestMethod.POST)
	@ResponseBody
	public Object updateClassification(@RequestBody Classification classification) {

		int result = ACService.updateClassification(classification);

		return retContent(200, result);
	}

	/**
	 * 删除地区
	 * 
	 * @param area
	 * @return
	 */
	@RequestMapping(value = "/deleteArea", method = RequestMethod.POST)
	@ResponseBody
	public Object deleteArea(@RequestBody Area area) {

		int result = ACService.deleteArea(area.getIdArea() + "");

		return retContent(200, result);
	}

	/**
	 * 删除分类
	 * 
	 * @param classification
	 * @return
	 */
	@RequestMapping(value = "/deleteClassification", method = RequestMethod.POST)
	@ResponseBody
	public Object deleteClassification(@RequestBody Classification classification) {

		int result = ACService.deleteClassification(classification.getIdClassification() + "");

		return retContent(200, result);
	}

	/**
	 * 查询列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getAreaAndClassifications", method = RequestMethod.POST)
	@ResponseBody
	public Object areaAndClassifications() {

		AreaAndClassifications result = ACService.areaAndClassifications();
		if (null != result) {
			return retContent(200, result);
		}
		return retContent(201, result);
	}
}
