<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/jsp/common/head.jsp"%>


<div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>修改密码页面 >> 修改密码</span>
        </div>
        <div class="providerAdd">
                <div>
                    <label for="userPassword">请输入原密码：</label>
                    <input type="password" id="oldPwd"   onblur="checkOldPwd($(this))"> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="ruserPassword">请输入新密码：</label>
                    <input type="password"  id="newPwd" onblur="checkNewPwd($(this))"> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="ruserPassword">确认密码：</label>
                    <input type="password" id="yesNewPwd" onblur="checkYesNewPwd($(this))"> 
					<font color="red"></font>
                </div>
                <div class="providerAddBtn">
                    <input type="button" name="add" id="update" onclick="udpatePwd()" value="保存" >
                </div>
        </div>
</div>
</section>
<%@include file="/WEB-INF/jsp/common/foot.jsp"%>


<script type="text/javascript" >
	var old,pwd,yes = false;
	
	function checkOldPwd(dom){
		var currentPwd = '${sessionScope.userSession.userPassword}';
		var oldPwd = $(dom).val();
		if(oldPwd.length < 3){
			return ;
		}
		if(oldPwd != currentPwd){
			$(dom).next().html("原密码输入错误");
			old = false;
			return ;
		}else{
			$(dom).next().html("");
			old = true;
		}
	}
	function checkNewPwd(dom){
		var newPwd = $(dom).val();
		if( newPwd.length < 6 && newPwd != ''){
			$(dom).next().html("密码长度必须大于六位");
			pwd = false;
			return ;
		}else{
			$(dom).next().html("");
			pwd = true;
		}
	}
	function checkYesNewPwd(dom){
		var yesNewPwd = $(dom).val();
		var newPwd = $("#newPwd").val();
		if(yesNewPwd!=newPwd){
			$(dom).next().html("两次密码不一致");
			yes = false;
			return ;
		}else{
			$(dom).next().html("");
			yes = true;
		}
	}	
	function udpatePwd(){
		var currentCode = '${sessionScope.userSession.userCode}';
		if(old && pwd && yes){
			var yesNewPwd = $("#yesNewPwd").val();
			$.ajax({
				type:"get",
				url:"user/udpatePwd",
				data:{newPwd:yesNewPwd,userCode:currentCode},
				success:function(data){
					if(data == 1){
						if(confirm("修改成功请往登陆页面跳转")){
						}
						location.href="${rootPath}/login";
					}else{
						alert("修改失败");
					}
				},
				error:function(){
					alert("系统异常")
				}
				
			});
		}
		return ;
		
	}
	
	
	


</script>



