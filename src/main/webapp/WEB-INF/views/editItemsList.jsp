<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>批量修改商品查询</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<script type="text/javascript">
//修改商品提交
function updateItems(){
	
	//将form的action指向修改商品的地址
	document.itemsForm.action="${pageContext.request.contextPath }/items/editItemsListSubmit.action";
	
	//进行form提交
	document.itemsForm.submit();
	
}
</script>
	<link rel="stylesheet" href="/bootstrap/css/bootstrap.css" />
</head>
<body> 
<form name="itemsForm" action="${pageContext.request.contextPath }/items/queryItem.action" method="post">
<table class="table table-striped table-bordered">
<caption>用户角色列表</caption>
<thead>
	<tr>
		<td>用户名</td>
		<td>用户角色</td>
		<td>操作</td>
	</tr>
</thead>
<tbody>
<c:forEach items="${userRole}" var="info">
	<tr>
		<td>${info.username}</td>
		<td><c:if test="${not empty info.name}"><c:forEach items="${info.name}" var="item">|${item.name}|</c:forEach></c:if></td>
		<td><a href="${pageContext.request.contextPath }/role/update.action?id=${info.id}" class="btn btn-primary" >修改</a>&nbsp;&nbsp;</td>
	</tr>
</c:forEach>
</tbody>

</table>
</form>
</body>

</html>