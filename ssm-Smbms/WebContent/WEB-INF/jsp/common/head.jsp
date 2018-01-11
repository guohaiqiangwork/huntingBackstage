<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set value="http://127.0.0.1:8003/ImageServer" var="imgPage"></c:set>
<c:set var="rootPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <base href="<%=basePath%>"> 
    <title></title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/style.css" />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/public.css" />
    <link rel="stylesheet"  href="statics/uploadifive.css" type="text/css" />
 </head>
<body>
<!--头部-->
    <header class="publicHeader">
        <h1><a href="user/main.html" style="color:#fff;">超市订单管理系统</a></h1>
        <div class="publicHeaderR">
            <p><span>下午好！</span><span style="color: #fff21b"> ${sessionScope.userSession.userName }</span> , 欢迎你！</p>
            <a href="${pageContext.request.contextPath }/logout.html">退出</a>
        </div>
    </header>
<!--时间-->
    <section class="publicTime">
        <span id="time">2015年1月1日 11:11  星期一</span>
        <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
    </section>
 <!--主体内容-->
 <section class="publicMian ">
     <div class="left">
         <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
         <nav>
             <ul class="list">
                 <li ><a href="${pageContext.request.contextPath }/order/list">订单管理</a></li>
              <li><a href="${pageContext.request.contextPath }/pro/list">供应商管理</a></li>
              <li><a href="${pageContext.request.contextPath }/user/userList">用户管理</a></li>
              <li><a href="${pageContext.request.contextPath }/user/updateUserPwd">密码修改</a></li>
              <li><a href="${pageContext.request.contextPath }/logout.html">退出系统</a></li>
             </ul>
         </nav>
     </div>
     <input type="hidden" id="path" name="path" value="${pageContext.request.contextPath }"/>
     <input type="hidden" id="referer" name="referer" value="<%=request.getHeader("Referer")%>"/>