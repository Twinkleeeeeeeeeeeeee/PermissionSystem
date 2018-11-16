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
<title>新增用户信息</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<LINK rel="stylesheet" type="text/css" href="js/easyui/styles/default.css">
	<%@ include file="/WEB-INF/views/common_css.jsp"%>
	<%@ include file="/WEB-INF/views/common_js.jsp"%>
</head>
<body>
<form id="userForm" action="user/insert.action" method="post">
<table style="margin-left: 20%">
	<caption><h3>新增商品信息</h3></caption>
<tr>
	<td>用户账号</td>
	<td><input type="text" style="height: 20px;width: 130%" name="usercode" required class="form-control" /></td>
</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>用户姓名</td>
		<td><input type="text" style="height: 20px;width: 130%" name="username" required class="form-control" /></td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>用户密码</td>
		<td><input type="text" style="height: 20px;width: 130%" name="password" class="form-control" required/></td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
<tr>
<td colspan="2" align="center"><input class="btn btn-success" style="height: 35px;width: 60px" type="submit" value="提交"/>
</td>
</tr>
</table>

</form>
</body>

</html>