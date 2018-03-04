package cn.smbms.controller;

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
import cn.smbms.pojo.Html;
import cn.smbms.pojo.Pagination;
import cn.smbms.pojo.Train;
import cn.smbms.service.TrainService;
import cn.smbms.utils.PoiUtil;

/**
 * 证书培训控制器
 * 
 * @author 若水一涵
 *
 */
@MultipartConfig
@Controller
@RequestMapping("/train")
@CrossOrigin
public class TrainController extends BaseController {

	@Resource
	private TrainService trainService;

	public void addData(Train train) {
		for (int i = 0; i < 30; i++) {

			Date date = new Date();
			// 设置id
			train.setIdTrain(date.getTime() + "");
			// 设置操作时间
			train.setTime(date);
			train.setType(i % 4 + 1);
			train.setTitle("标题" + (i % 3 + 1));
			train.setContent("容贼长的内容" + (i % 3 + 1));

			trainService.add(train);
		}
	}

	/**
	 * 添加
	 * 
	 * @return
	 */
	@RequestMapping(value = "/addTrain", method = RequestMethod.POST)
	@ResponseBody
	public Object addTrain(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		Date date = new Date();
		Train train = new Train();
		// 设置id
		train.setIdTrain(date.getTime() + "");
		// 设置操作时间
		train.setTime(date);
		// 设置浏览数量
		train.setBrowsingNumber(1);
		// 设置标题
		train.setTitle(request.getParameter("title"));
		// 设置类型
		String type = request.getParameter("type");
		train.setType((type != null && !type.isEmpty()) ? Integer.parseInt(type) : null);
		Html html = null;
		try {
			html = PoiUtil.getHtml(file, request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return retContent(201, "文件解析出问题了");
		}
		if (html != null) {
			train.setContent(html.getHtml());
			train.setHtmlUrl(html.getImagesParentFileUrl());
		} else {
			return retContent(201, "文件解析出问题了");
		}
		int result = trainService.add(train);
		// addData(train);

		return retContent(200, result);
	}

	/**
	 * 修改
	 * 
	 * @param train
	 * @return
	 */
	@RequestMapping(value = "/updateTrain", method = RequestMethod.POST)
	@ResponseBody
	public Object update(@RequestBody Train train) {

		int result = trainService.update(train);

		return retContent(200, result);
	}

	/**
	 * 删除
	 * 
	 * @param train
	 * @return
	 */
	@RequestMapping(value = "/deleteTrain", method = RequestMethod.POST)
	@ResponseBody
	public Object delete(@RequestBody Train train) {

		int result = trainService.delete(train.getIdTrain() + "");

		return retContent(200, result);
	}

	/**
	 * 查询详情
	 * 
	 * @param train
	 * @return
	 */
	@RequestMapping(value = "/getTrain", method = RequestMethod.POST)
	@ResponseBody
	public Object train(@RequestBody Train train) {

		Detail<Train> result = trainService.train(train.getIdTrain() + "");
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
	@RequestMapping(value = "/getTrains", method = RequestMethod.POST)
	@ResponseBody
	public Object trains(@RequestBody Currency<Train> currency) {
		// 修改分页索引
		Pagination pagination = currency.getPagination();
		if (pagination != null) {
			pagination.setPageIndex(pagination.getPageIndex() - 1);
			currency.setPagination(pagination);
		}
		List<Train> result = trainService.trains(currency);
		if (null != result) {
			return retContent(200, result);
		}
		return retContent(201, result);
	}
}
