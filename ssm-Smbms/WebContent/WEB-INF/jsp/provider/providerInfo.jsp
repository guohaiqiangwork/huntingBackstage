<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/jsp/common/head.jsp"%>


<div class="right " style="width:1500%;">
	<form action="${rootPath}/pro/updateProviderInfo" method="post" id="updateForm">
	<input type="hidden" value="${pro.procode}" name="procode"/>
	<table class="providerTable" cellpadding="0" cellspacing="0">
					<tr ><td><span>${pro.procode}</span></td></tr>
					<tr >
						<td>
							<span><input type="text" value="${pro.proname}" name="proname"/></span>
						</td>
					</tr>
					
					<tr><td><span><input type="text" value="${pro.procontact}" name="procontact"/></span></td></tr>
					<tr><td><span><input type="number" value="${pro.prophone}" name="prophone"/></span></td></tr>
					<tr><td><span><input type="text" value="${pro.profax}" name="profax"/></span></td></tr>
					<tr><td><span><input type="text" value="${pro.proaddress}" name="proaddress"/> </span></td></tr>
					<tr >
						<td style="padding-top:32px;">
							<span style="display:inline-block;overflow:hidden;">
								<textarea rows="3" cols="50" name="prodesc"
								style="background:none;border:0px;text-align:center;">${pro.prodesc}</textarea>
							</span> 
						</td>
					</tr>
					<tr>
						<td>
							<div style="position:relative;bottom:20px; float:left; margin:70px 0px 0px 100px;">
								<label>点击更换工商执照：</label>
								<input type="file" value="浏览" style="width:190px;" onchange="updateProviderPic('#companylicpicpath','pic01')" name="pic01">
								<input type="hidden" value="" id="companylicpicpath" name="companylicpicpath">
								<br/>
								<label>点击更换营业执照：</label>
								<input type="file" value="浏览" style="width:190px;" onchange="updateProviderPic('#orgcodepicpath','pic02')"  name="pic02">
								<input type="hidden" value="" id="orgcodepicpath" name="orgcodepicpath">
							</div>
							<div style="float:right; margin-right:350px;">
								<img alt="" src="${imgPage }${pro.companylicpicpath}" id="fullPath01" width="200px" height="150px">
								<img alt="" src="${imgPage }${pro.orgcodepicpath}" id="fullPath02" width="200px" height="150px">
							</div>
						</td>					
					</tr>					
					<tr>
						<td class="publicHeaderR" style="float:none;">
							<a href="javascript:;" onclick="updateInfo()">修改</a>
							<a href="${pageContext.request.contextPath}/pro/providerInfo/${pro.procode}">重置</a>
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