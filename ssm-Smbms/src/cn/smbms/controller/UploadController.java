package cn.smbms.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import cn.smbms.utils.SmbmsUtil;

@Controller
@RequestMapping("/upload")
public class UploadController {
	
	
	@RequestMapping("/uploadImg")
	public void uploadImg(HttpServletRequest request,PrintWriter out,String fileName){
		
		MultipartHttpServletRequest mh = (MultipartHttpServletRequest) request;
		
		CommonsMultipartFile cm = (CommonsMultipartFile) mh.getFile(fileName);
		
		byte[] imgByte = cm.getBytes();
		
		String newFileName = UUID.randomUUID().toString().replace("-", "")+"."+(FilenameUtils.getExtension(cm.getOriginalFilename()));
		
		System.out.println(newFileName);
		
		Client client = Client.create();
		
		WebResource resource = client.resource(SmbmsUtil.TCP_HOST+"/upload/"+newFileName);
		
		
		resource.put(String.class, imgByte);
		
		
		String relativePath = "/upload/"+newFileName;
		String fullPath = SmbmsUtil.TCP_HOST+"/upload/"+newFileName;
		HashMap<String, String> map = new HashMap<String,String>();
		map.put("relativePath", relativePath);
		map.put("fullPath", fullPath);
		System.out.println(JSONArray.toJSONString(map));
		
		out.print(JSONArray.toJSONString(map));
		
		
		
		
		
		
		
	}
	
	
	
	
	

}
