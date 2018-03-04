package cn.smbms.controller;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.smbms.pojo.Html;
import cn.smbms.utils.PoiUtil;

@MultipartConfig
@Controller
@RequestMapping("/upload")
@CrossOrigin
public class UploadController {

	@RequestMapping("/upload")
	@ResponseBody
	public Html uploadImg(@RequestParam("file") MultipartFile file, HttpServletRequest request) {

		if (file != null && !file.isEmpty()) {
			try {
				Html html = PoiUtil.getHtml(file, request);
				return html;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return new Html();
	}
}
