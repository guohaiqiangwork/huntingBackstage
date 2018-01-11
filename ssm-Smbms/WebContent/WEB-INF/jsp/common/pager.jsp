<%@ page language="Java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib  uri="http://jsptags.com/tags/navigation/pager" prefix="pg" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


 	<!-- 写入分页根本标签 -->
 	<div id="pager">
 	
 	<pg:pager url="${param.url }" items="${requestScope.total }" maxPageItems="5" maxIndexPages="5" export="curr=pageNumber">
 			
 			<c:forEach items="${fn:split(param.params,',')}" var="p">
 				<pg:param name="${p}"/>
 			</c:forEach>
 			
 			<pg:first>
  				<a href="${pageUrl }">首页</a>
  			</pg:first>
  			<pg:prev>
  				<a href="${pageUrl }"> 上一页</a>
  			</pg:prev>
  			<pg:pages>
  				<a href="${pageUrl }" class="${pageNumber==curr?'curr':''}">${pageNumber }</a>
  			</pg:pages>
  			<pg:next>
  				<a href="${pageUrl }">下一页</a>
  			</pg:next>
  			<pg:last>
  				<a href="${pageUrl }">尾页</a>
  			</pg:last>
 	</pg:pager>
 	</div>
 	
 	