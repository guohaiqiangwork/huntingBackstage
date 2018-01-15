package cn.smbms.utils;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class SysInteceptor extends HandlerInterceptorAdapter {
	
	
	public boolean preHandle(HttpServletRequest request,
									HttpServletResponse response,
									Object handler) throws Exception{
		
		HttpSession session = request.getSession();
		
//		User user = (User) session.getAttribute("userSession");
//		
//		if(null == user){
//			response.sendRedirect(request.getContextPath()+"/login");
//			return false;
//		}
		System.out.println(request);
		
		return true;
		
	}
	
}
