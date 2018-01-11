<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <base href="<%=basePath%>"> 
    <meta charset="UTF-8">
    <title>系统登录 - 超市订单管理系统</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/style.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/jquery-1.8.3.min.js"></script>
    
    <script type="text/javascript">
		/* 	 if(top.location!=self.location){
			      top.location=self.location;
			 } */
	 	
		$(function(){
			  $("#userCode").blur(function(){
				   if($(this).val() != ""){
					   var acc = $(this).val();
					   $.ajax({
						   type:"GET",
						   url:"userCodeIsExists",
						   data:{userCode:acc},
						   dataType:"json",
						   success:function(data){
								console.info(data.acc);
							   if(data.acc=="no"){
								   $("#accInfo").html("账户不存在");
							   }else{
								   $("#accInfo").html("");
							   }
							   
						   },
						   error:function(data){
							   alert("系统繁忙");
						   }
					   });
				   } 
			  });
		});
	 
	 
	 
	 
    </script>
</head>
<body class="login_bg">
    <section class="loginBox">
        <header class="loginHeader">
            <h1>超市订单管理系统</h1>
        </header>
        <section class="loginCont">
	        <form class="loginForm" action="${pageContext.request.contextPath }/login"  name="actionForm" id="actionForm"  method="post" >
				<div class="info">${requestScope.error }</div>
				<div class="inputbox">
                    <label for="user">用户名：</label>
					<input type="text" class="input-text" id="userCode" name="userCode" placeholder="请输入用户名" required/>
					<br/>
					<label id="accInfo" style="color:red;font-size:10px;margin-left:80px;"></label>
				</div>	
				<div class="inputbox">
                    <label for="mima">密码：</label>
                    <input type="password" id="userPassword" name="userPassword" placeholder="请输入密码" required/>
                    <br/>
                    <label style="color:red;font-size:10px;margin-left:80px;">${requestScope.err}</label>
                </div>	
				<div class="subBtn">
                    <input type="submit" value="登录"/>
                    <input type="reset" value="重置"/>
                </div>	
			</form>
        </section>
    </section>
</body>
</html>
