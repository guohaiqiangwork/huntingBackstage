package cn.smbms.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.mysql.jdbc.StringUtils;

import cn.smbms.pojo.User;
import cn.smbms.service.UserService;

@Controller
public class LoginController {
	
	
	@Resource(name="userService")
	private UserService userService;
	
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(){
		return "login";
	}
	
	
	@RequestMapping("/userCodeIsExists")
	@ResponseBody
	public Object UserCodeIsExists(String userCode){
		
		Map<String, String> map = new HashMap<>();
		
		if(null == userService.checkIsExists(userCode)){
			map.put("acc","no");
			return JSONArray.toJSONString(map);
		}
		map.put("acc", "yes");
		return JSONArray.toJSONString(map);
	}
	
	
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(String userCode,String userPassword,Model model,HttpSession session){
		
		try {
			User user = userService.login(userCode,userPassword);
			if(null != user){
				
				session.setAttribute("userSession", user);
				return "redirect:/user/userList";
			}
			model.addAttribute("err","密码错误");
			return "login";
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			model.addAttribute("error",e.getMessage());
			return "login";
		}
		
	}
	
	@RequestMapping("/logout.html")
	public String logout(HttpSession session){
		
		//session.removeAttribute("userSession");
		session.invalidate();
		return "redirect:/login";
	}
	
	
	

}
