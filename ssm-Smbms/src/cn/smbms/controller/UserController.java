package cn.smbms.controller;

import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.smbms.pojo.Role;
import cn.smbms.pojo.User;
import cn.smbms.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource(name="userService")
	private UserService userService;
	
	
	@RequestMapping("/userInfo/{id}")
	public String userInfoPage(@PathVariable("id") String userCode,Model model){
		
		try {
			User user = userService.checkIsExists(userCode);
			
			List<Role > list = userService.findAllRole();
			model.addAttribute("user", user);
			
			model.addAttribute("roles",list);
			
			return "UserInfo";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "redirect:/user/userList";
		}
	}
	
	
	
	
	@RequestMapping("/userList")
	public String userPage(Model model,User user,
			@RequestParam(value="pager.offset",defaultValue="0")Integer total){
		user.setUserName(user.getUserCode());
		
		List<User> list = userService.findAllUser(user,total>=0?total:0,5);
		
		int count = userService.findUserCount(user);
		
		model.addAttribute("userList",list);
		model.addAttribute("total",count);
		
		return "userlist";
	}
	
	
	
	
	@RequestMapping("/addUserPage")
	public String addUserPage(){
		return "useradd";
	}
	
	
	@RequestMapping("/codeIsExists")
	@ResponseBody
	public String codeIsExists(String userCode){
		
		User user = userService.checkIsExists(userCode);
		
		if(user != null){
			return "1";
		}
		return "2";
	}
	
	
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	public String addUser(User user,HttpServletRequest request){
		user.setCreatedBy(1);
		user.setCreationDate(new Date());
		if(userService.savaUser(user))
			return "redirect:/user/userList";
		else{
			request.setAttribute("error", "添加失败");
			return "forward:addUserPage";
		}
	}
	
	
	
	@RequestMapping("/updateUserPwd")
	public String updateUserPwd(){
		
		return "updateUserPassword";
	}
	@RequestMapping("/udpatePwd")
	public void udpatePwd(String newPwd,String userCode,PrintWriter out){
		
		int res = userService.modifyUserPwd(newPwd,userCode);
		
		out.print(res);		
	}
	
	
	
	@RequestMapping(value="/updateUserInfo",method=RequestMethod.POST)
	public String updateUserInfo(User user,Model model,HttpSession session){
		
		user.setModifyBy( ((User)session.getAttribute("userSession")).getId());
		user.setModifyDate(new Date());
		if(userService.modifyUserInfo(user)){
			
			return "redirect:/user/userInfo/"+user.getUserCode();
		}
		model.addAttribute("updateErr","添加失败");
		return "forward:/user/userInfo/"+user.getUserCode();
	}
	
	
	
	
	
	
	
//	@RequestMapping(value="/addUser",method=RequestMethod.POST)
//	public String addUser(User user,HttpServletRequest request,
//				@RequestParam(required=false,value="imgs") MultipartFile[] imgs){
//		
//		
//		String haedImg = null;
//		
//		String workPath = null;
//		
//		String path = "static"+File.separator+"uploadimg";//request.getSession().getServletContext().getRealPath("statics"+File.separator+"uploadfiles");
//		String errorInfo = null;
//		boolean flag = true;
//		
//		for (int i = 0; i < imgs.length; i++) {
//			
//			MultipartFile attach = imgs[i];
//			
//			if(i==0){
//				errorInfo = "headImgErr";
//			}else if(i==1){
//				errorInfo = "workImgErr";
//			}
//			
//			if(! attach.isEmpty()){
//				String oldFileName = attach.getOriginalFilename();
//				String prefix = FilenameUtils.getExtension(oldFileName);
//				int fileSize = 5000000;
//				if(attach.getSize()>fileSize){
//					request.setAttribute(errorInfo, "图片大小不能大于 500KB");
//					flag = false;
//				}else if(checkFilePrefix(prefix)){
//					String fileName = SmbmsUtil.generateFileName(prefix);
//					File targetFile = new File(path,fileName);
//					
//					if(!targetFile.exists()){
//						targetFile.mkdirs();
//					}
//					
//					try {
//						attach.transferTo(targetFile); 
//						if(i==0){
//							haedImg=path+File.separator+fileName;
//						}
//						else if(i==1){
//							workPath = path+File.separator+fileName;
//						}
// 
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//						request.setAttribute(errorInfo, "上传失败");
//						flag = false;
//					}
//				}
//			}
//		}
//		
//		if(flag){
//			user.setCreatedBy(1);
//			user.setCreationDate(new Date());
//			user.setIdPicPath(haedImg);
//			user.setWorkPiPath(workPath);
//			
//			if(userService.savaUser(user))
//				return "redirect:/user/userList";
//			else{
//				request.setAttribute("error", "添加失败");
//				return "forward:addUserPage";
//			}
//			
//		}
//		return "forward:addUserPage";
//	}




	private boolean checkFilePrefix(String prefix) {
		
		if (prefix.equalsIgnoreCase("jpg") || prefix.equalsIgnoreCase("png") || prefix.equalsIgnoreCase("jpeg")
				|| prefix.equalsIgnoreCase("pneg") || prefix.equals("txt")) {
			return true;
		} else {
			return false;
		}
		
		
	}
	
	
	
	

}
