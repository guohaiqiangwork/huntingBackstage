<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ taglib  uri="http://jsptags.com/tags/navigation/pager" prefix="pg" %> --%>

<%@include file="/WEB-INF/jsp/common/head.jsp"%>
        <div class="right">
            <div class="location">
                <strong>你现在所在的位置是:</strong>
                <span>用户管理页面</span>
            </div>
            <div class="search">
           		<form method="post" action="${pageContext.request.contextPath }/user/userList">
					<input name="method" value="query" class="input-text" type="hidden">
					 <span>用户名：</span>
					 <input name="userCode" value="${param.userCode}" class="input-text"	type="text" >
					 
					 <span>用户角色：</span>
					 <select name="userRole" id="userRoelInfo" >
						
						   <option value="0">--请选择--</option>
						   <option value="1" ${param.userRole==1?'selected':'' }>--系统管理员--</option>
						   <option value="2" ${param.userRole==2?'selected':'' }>--经理--</option>
						   <option value="3" ${param.userRole==3?'selected':'' }>--员工--</option>
						   
	        		</select>
					 
					 <input type="hidden" name="pageIndex" value="1"/>
					 <input	value="查 询" type="submit" id="searchbutton">
					 <a href="${pageContext.request.contextPath}/user/addUserPage" >添加用户</a>
				</form>
            </div>
            <!--用户-->
            <table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th width="10%">用户编码</th>
                    <th width="20%">用户名称</th>
                    <th width="10%">性别</th>
                    <th width="10%">年龄</th>
                    <th width="10%">电话</th>
                    <th width="10%">用户角色</th>
                    <th width="30%">操作</th>
                    
                </tr>
                   <c:forEach var="user" items="${requestScope.userList }" varStatus="status">
					<tr>

						<td>
						<span>${user.userCode }</span>
						</td>
						<td>
						<span>${user.userName }</span>
						</td>
						<td>
							<span>
								<c:if test="${user.gender==1}">男</c:if>
								<c:if test="${user.gender==2}">女</c:if>
							</span>
						</td>
						<td>
						<span>${user.age}</span>
						</td>
						<td>
						<span>${user.phone}</span>
						</td>
						<td>
							<span>${user.userRoleName}</span>
						</td>
						<td>
						<span><a class="viewUser" href="user/userInfo/${user.userCode}" userid=${user.id } username=${user.userName }><img src="${pageContext.request.contextPath }/statics/images/read.png" alt="查看" title="查看"/></a></span>
						<span><a class="modifyUser" href="javascript:;" userid=${user.id } username=${user.userName }><img src="${pageContext.request.contextPath }/statics/images/xiugai.png" alt="修改" title="修改"/></a></span>
						<span><a class="deleteUser" href="javascript:;" userid=${user.id } username=${user.userName }><img src="${pageContext.request.contextPath }/statics/images/schu.png" alt="删除" title="删除"/></a></span>
						</td>
					</tr>
				</c:forEach>
			</table>
			<c:import url="/WEB-INF/jsp/common/pager.jsp" charEncoding="utf-8" >
				<c:param name="params" value="userCode,userRole"></c:param>
				<c:param name="url" value="${pageContext.request.contextPath}/user/userList"></c:param>
			 </c:import>
        </div>
    </section>



<%@include file="/WEB-INF/jsp/common/foot.jsp" %>

