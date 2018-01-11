<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/jsp/common/head.jsp"%>


<div class="right " style="width:1500%;">
	<form action="${rootPath}/user/updateUserInfo" method="post" id="updateForm">
	<input type="hidden" value="${user.userCode}" name="userCode"/>
	<table class="providerTable" cellpadding="0" cellspacing="0">
					<tr ><td><span>${user.userCode}</span></td></tr>
					<tr >
						<td>
							<span><input type="text" value="${user.userName }" name="userName"/></span>
						</td>
					</tr>
					
					<tr>
						<td>
							<span>
								<select name="gender">
									<option value="1">男</option>
									<option value="2">女</option>
								</select>
							</span>
						</td>
					</tr>
					<tr><td><span><input type="number" value="${user.age}" name="age"/></span></td></tr>
					<tr><td><span><input type="text" value="${user.phone}" name="phone"/></span></td></tr>
					<tr>
						<td>
							<span>
								<select name="userRole">
									<c:forEach items="${roles}" var = "r">
										<option value="${r.id }" ${r.id==user.userRole?'selected':'' }>${ r.roleName}</option>
									</c:forEach>
								</select>
							</span>
						</td>
					</tr>					
					<tr>
						<td>
							<span>
								<fmt:formatDate value="${user.birthday }" type="both"  pattern="yyyy-MM-dd" var="hh"/>
								
								<input type="text" Class="Wdate" id="birthday" 
								name="birthday" readonly="readonly" value="${hh}" onclick="WdatePicker();">
							</span>
						</td>
					</tr>
					<tr><td><span><input type="text" value="${user.address}" name="address"/> </span></td></tr>
					<tr>
						<td>
							<div style="position:relative;bottom:20px; float:left; margin:70px 0px 0px 100px;">
								<label>点击更好个人照：</label>
								<input type="file" value="浏览" style="width:190px;" onchange="updateProviderPic('#companylicpicpath','pic01')" name="pic01">
								<input type="hidden" value="${user.idPicPath}" id="companylicpicpath" name="idPicPath">
								<br/>
								<label>点击更换工作照：</label>
								<input type="file" value="浏览" style="width:190px;" onchange="updateProviderPic('#orgcodepicpath','pic02')"  name="pic02">
								<input type="hidden" value="${user.workPiPath}" id="orgcodepicpath" name="workPiPath">
							</div>
							<div style="float:right; margin-right:350px;">
								<img alt="" src="${imgPage }${user.idPicPath}" id="fullPath01" width="200px" height="150px">
								<img alt="" src="${imgPage }${user.workPiPath}" id="fullPath02" width="200px" height="150px">
							</div>
						</td>					
					</tr>					
					<tr>
						<td class="publicHeaderR" style="float:none;">
							<a href="javascript:;" onclick="updateInfo()">修改</a>
							<a href="${pageContext.request.contextPath}/user/userInfo/${user.userCode}">重置</a>
						</td>
					</tr>

	</table>
	<input id="updateErr" value="${requestScope.updateErr}"  type="hidden"/>
	</form>
</div>
</section>
<%@include file="/WEB-INF/jsp/common/foot.jsp"%>
<script type="text/javascript">
	$(function(){
		
		$("table").children().children("tr").height(60);
		$("table input").addClass("infoPageInput");
		var res = $("#updateErr").val();
		if(res != "" && res==0){
			alert("添加失败");
		}
	});
	
	function updateProviderPic(domid,imgName){
		
		var option ={
			type:"POST",
			url:"upload/uploadImg",
			dataType:"text",
			data:{fileName:imgName},
			success:function(data){
				var jsonobj = $.parseJSON(data);
				console.info(jsonobj.relativePath);
				$(domid).val(jsonobj.relativePath);
				if(imgName=="pic01"){
					$("#fullPath01").attr("src",jsonobj.fullPath);
				}else{
					$("#fullPath02").attr("src",jsonobj.fullPath);
				}
			}
		};
		
		$("#updateForm").ajaxSubmit(option);
		
		
	}
	
	
	
	
	function updateInfo(){
		if(confirm("你确定修改吗？")){
			
			$("#updateForm").submit();
		}		
	}
	
	
</script>