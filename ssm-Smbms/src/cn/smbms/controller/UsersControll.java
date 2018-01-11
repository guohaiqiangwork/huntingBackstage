package cn.smbms.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import cn.smbms.pojo.Users;
import cn.smbms.service.UsersService;

@Controller
@RequestMapping("/users")
public class UsersControll {
	
	
	@Resource
	private UsersService usersService;
	
	
	@RequestMapping("/getUser")
	@ResponseBody
	public Object getUser() {
		
		return JSONArray.toJSONString(usersService.getAllUsers());
		
	}

}
