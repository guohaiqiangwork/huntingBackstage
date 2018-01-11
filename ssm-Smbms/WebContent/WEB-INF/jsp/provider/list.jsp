<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/jsp/common/head.jsp"%>
	<div class="right">
		<div class="location">
			<strong>你现在所在的位置是:</strong> <span>供应商管理页面</span>
		</div>
		<div class="search">
			<form method="post"
				action="${pageContext.request.contextPath}/pro/list ">
				<span>供应商名称：</span> 
				<input name="proname" value="${param.proname }" class="input-text" type="text">
			    <span>联系人名称：</span> 
				<input name="procontact" value="${param.procontact }" class="input-text" type="text">
				<input value="查 询" type="submit" id="searchbutton"> 
				<a href="${pageContext.request.contextPath}/pro/addProvder">添加供应商</a>
			</form>
		</div>
		<!--用户-->
		<table class="providerTable" cellpadding="0" cellspacing="0">
			<tr class="firstTr">
				<th width="10%">供应商编码</th>
				<th width="20%">供应商名称</th>
				<th width="10%">联系人名称</th>
				<th width="10%">联系人电话</th>
				<th width="10%">供应商座机</th>
				<th width="30%">操作</th>
	
			</tr>
			<c:forEach var="pro" items="${requestScope.list }">
				<tr>
					<td><span>${pro.procode}</span></td>
					<td><span>${pro.proname}</span></td>
					<td><span>${pro.procontact}</span></td>
					<td><span>${pro.prophone}</span></td>
					<td><span>${pro.profax}</span></td>
					<td>
						<span>
							<a class="viewUser" href="${rootPath}/pro/providerInfo/${pro.procode}" >
								<img src="${pageContext.request.contextPath }/statics/images/read.png"  />
							</a>
						</span>
						 <span>
						 	<a class="modifyUser" href="javascript:;"  >
						 		<img src="${pageContext.request.contextPath }/statics/images/xiugai.png" />
						 	</a>
						 </span> 
						 <span>
						 	<a href="${rootPath}/pro/deleteProvider/${pro.procode}" class="providerClick">
						 		<img src="${pageContext.request.contextPath }/statics/images/schu.png" />
						 	</a>
						 </span>
					</td>
				</tr>
			</c:forEach>
		</table>
		<c:import url="/WEB-INF/jsp/common/pager.jsp" charEncoding="utf-8">
			<c:param name="params" value="proname,procontact"></c:param>
			<c:param name="url"
				value="${pageContext.request.contextPath}/pro/list"></c:param>
		</c:import>
	</div>
</section>
<%@include file="/WEB-INF/jsp/common/foot.jsp"%>