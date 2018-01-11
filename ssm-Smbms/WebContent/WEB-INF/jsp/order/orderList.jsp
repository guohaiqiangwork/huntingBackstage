<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/jsp/common/head.jsp"%>
	<div class="right">
		<div class="location">
			<strong>你现在所在的位置是:</strong> <span>供应商管理页面</span>
		</div>
		<div class="search">
			<form method="post"
				action="${pageContext.request.contextPath}/order/list">
				<span>订单名称：</span> 
				<input name="productname" value="${param.productname}" class="input-text" type="text">
			    <span>供货商名称：</span> 
				<input name="proName" value="${param.proName }" class="input-text" type="text">
				<input value="查 询" type="submit" id="searchbutton"> 
				<a href="${pageContext.request.contextPath}/pro/addProvder">添加供应商</a>
			</form>
		</div>
		<!--用户-->
		<table class="providerTable" cellpadding="0" cellspacing="0">
			<tr class="firstTr">
				<th width="10%">订单编码</th>
				<th width="10%">订单名称</th>
				<th width="10%">订单详情</th>
				<th width="7%">商品单位</th>
				<th width="8%">商品数量</th>
				<th width="10%">订单总价格</th>
				<th width="10%">是否支付</th>
				<th width="18%">供货商</th>
				<th width="15%">操作</th>
	
			</tr>
			<c:forEach var="o" items="${requestScope.order }">
				<tr>
					<td><span>${o.billcode}</span></td>
					<td><span>${o.productname}</span></td>
					<td><span>${o.productdesc}</span></td>
					<td><span>${o.productunit}</span></td>
					<td><span>${o.productcount}</span></td>
					<td><span>${o.totalprice}</span></td>
					<td><span>${o.ispayment==1?'未支付':'已支付'}</span></td>
					<td><span>${o.proName}</span></td>
					<td>
						<span>
							<a class="viewUser" href="${rootPath}/order/orderInfo/${o.billcode}" >
								<img src="${pageContext.request.contextPath }/statics/images/read.png"  />
							</a>
						</span>
						 <span>
						 	<a class="modifyUser" href="javascript:;"  >
						 		<img src="${pageContext.request.contextPath }/statics/images/xiugai.png" />
						 	</a>
						 </span> 
						 <span>
						 	<a href="${rootPath}" class="providerClick">
						 		<img src="${pageContext.request.contextPath }/statics/images/schu.png" />
						 	</a>
						 </span>
					</td>
				</tr>
			</c:forEach>
		</table>
		<c:import url="/WEB-INF/jsp/common/pager.jsp" charEncoding="utf-8">
			<c:param name="params" value="productname,proName"></c:param>
			<c:param name="url"
				value="${pageContext.request.contextPath}/order/list"></c:param>
		</c:import>
	</div>
</section>
<%@include file="/WEB-INF/jsp/common/foot.jsp"%>