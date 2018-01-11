<%@ page language="Java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
    <title>标题</title>        
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">    
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="This is my page">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 </head>
 <body>
 	<h1>呵呵  ${param.name }</h1>
 	
 	<pg:pager items="100" url="user/page" maxIndexPages="10">
 		
 		<pg:param name="name" value="呵呵"/>
 		
		<pg:prev>
			<a href="${pageUrl }">上一页</a>
		</pg:prev> 		
 		
 		
 		<pg:pages>
 			<a href="${pageUrl}">${pageNumber}</a>
 		</pg:pages>
 		
 		<pg:next><a href="${pageUrl }">下一页</a></pg:next>
 		
 	</pg:pager>
 	
 	
 	
 </body>
</html>