<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/jsp/common/head.jsp"%>


<div class="right " style="width:1500%;">
	<form action="${rootPath}/order/updateOrder" method="post" id="updateForm">
	<input type="hidden" value="${o.billcode}" name="billcode"/>
	<table class="providerTable" cellpadding="0" cellspacing="0">
					<tr ><td><span>${o.billcode}</span></td></tr>
					<tr >
						<td>
							<span><input type="text" value="${o.productname}" name="productname"/></span>
						</td>
					</tr>
					
					<tr><td><span><input type="text" value="${o.productdesc}" name="productdesc"/></span></td></tr>
					<tr><td><span><input type="text" value="${o.productunit}" name="productunit"/></span></td></tr>
					<tr><td><span><input type="number" value="${o.productcount}" name="productcount"/></span></td></tr>
					<tr><td><span><input type="number" value="${o.totalprice}" name="totalprice"/> </span></td></tr>
					<tr><td><span>
						<select name="ispayment">
							<option value="2" ${o.ispayment==1?'':'selected'}>已支付</option>
							<option value="1" ${o.ispayment==1?'selected':''}>未支付</option>
						</select>
					</span></td></tr>
					<tr>
						<td>
							<span>
								<select name="providerid">
									<c:forEach var="pro" items="${requestScope.pros }">
										<option value="${pro.id }" ${o.providerid==pro.id?'selected':'' }>${pro.proname}</option>
									</c:forEach>
								</select>
							</span>
						</td>
					</tr>
					
					<tr>
						<td class="publicHeaderR" style="float:none;">
							<a href="javascript:;" onclick="updateInfo()">修改</a>
							<a href="${pageContext.request.contextPath}/order/orderInfo/${o.billcode}">重置</a>
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
	
	
	
	
	 function updateInfo(){
		if(confirm("你确定修改吗？")){
			
			$("#updateForm").submit();
		}		
	} 
	
	
</script>