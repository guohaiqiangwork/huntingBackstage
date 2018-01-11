<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>



<div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户添加页面</span>
        </div>
        <div class="providerAdd">
            <form id="addForm" name="userForm" method="post" action="${pageContext.request.contextPath }/user/addUser">
				<input type="hidden" name="method" value="add">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div>
                    <label for="userCode">用户编码：</label>
                    <input type="text" name="userCode" onblur="checkUserCode($(this))" id="userCode" value=""> 
					
					<!-- 放置提示信息 -->
					<font color="red"></font>
                </div>
                <div>
                    <label for="userName">用户名称：</label>
                    <input type="text" name="userName" id="userName" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="userPassword">用户密码：</label>
                    <input type="password" name="userPassword" id="userPassword" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="ruserPassword">确认密码：</label>
                    <input type="password" name="ruserPassword" id="ruserPassword" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label >用户性别：</label>
					<select name="gender" id="gender">
					    <option value="1" selected="selected">男</option>
					    <option value="2">女</option>
					 </select>
                </div>
                <div>
                    <label for="birthday">出生日期：</label>
                    <input type="text" Class="Wdate" id="birthday" name="birthday" 
					readonly="readonly" onclick="WdatePicker();">
					<font color="red"></font>
                </div>
                <div>
                    <label for="phone">用户电话：</label>
                    <input type="text" name="phone" id="phone" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="address">用户地址：</label>
                   <input name="address" id="address"  value="">
                </div>
                <div>
                    <label >用户角色：</label>
				    <select name="userRole" id="userRole">
					<option value="1">系统管理员</option>
					<option value="2">经理</option>
					<option value="3" selected="selected">普通用户</option>
				    </select>
	            	<font color="red"></font>
                </div>
                <!-- 上传 头像个 工作照 -->
                <div>
                    <label for="headImg">证件照：</label>
                   <input name="headimg" id="headImg" onchange="submitImgSize1Upload('#headImg2','headimg')"   type="file">
                   <input type="hidden" value="" onchange="" id="headImg2" name="idPicPath"/>
                </div>                
                <div>
                    <label for="workImg">工作照片：</label>
                   <input name="workimg" id="workImg" onchange="submitImgSize1Upload('#workImg2','workimg')"  type="file">
                   <input type="hidden" name="workPiPath"  value="" id="workImg2"/>
                </div>  
                
                
                
                               
                <div class="providerAddBtn">
                    <input type="submit" name="add" id="add" value="保存" >
					<input type="button" id="back" name="back" value="返回" >
                </div>
            </form>
        </div>
</div>
</section>
<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script type="text/javascript">
	
	$(function(){
		
	});
	
	
	function checkUserCode(dom){
		var code = $(dom).val();
		if(code == ''){
			return ;
		}
		 $.ajax({
			type:'get',
			url:'user/codeIsExists',
			data:{userCode:code},
			success:function(data){
				if(data == "1"){
					$(dom).next().html("该账户已存在");
				}else{
					$(dom).next().html("");
				}
			}
			
		}); 
		
	}
	

	
</script>
