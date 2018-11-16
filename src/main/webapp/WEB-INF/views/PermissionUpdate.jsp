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
<title>修改用户信息</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<LINK rel="stylesheet" type="text/css" href="js/easyui/styles/default.css">
	<%@ include file="/WEB-INF/views/common_css.jsp"%>
	<%@ include file="/WEB-INF/views/common_js.jsp"%>
	<script type="text/javascript">
		function  deletePermission(roleId,permissionId) {
            var r=confirm("确认要删除此权限吗？");
            if (r==true)
            {
                window.location.href = "permission/deletePermission.action?roleId="+roleId +"&permissionId="+permissionId;
            	return true;
            }
            return false;

        }

        function  addPermission(roleId,permissionId) {
            var r=confirm("确认要添加此权限吗？");
            if (r==true)
            {
                window.location.href = "permission/addPermission.action?roleId="+roleId +"&permissionId="+permissionId;
                return true;
            }
            return false;

        }
	</script>
</head>
<body>
<table style="margin-left: 20%">
	<caption style="height: 60px ;width: 150px"><h3>修改权限信息</h3></caption>
<tr>
	<td>角 色 名</td>
	<td>&nbsp;&nbsp;${p.name }&nbsp;&nbsp;</td>
</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>已有权限</td>
		<td>
			<c:forEach items="${p.permissionList}" var="per">
				&nbsp;&nbsp;${per.name} &nbsp;&nbsp; <a href="javascript:;" onclick="deletePermission('${p.id}','${per.id}')">[删除]</a><br>
			</c:forEach>

		</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>添加权限</td>
		<td>
			<c:forEach items="${userNotPermission}" var="user">
				&nbsp;&nbsp;${user.name} &nbsp;&nbsp; <a href="javascript:;" onclick="addPermission('${p.id}','${user.id}')">[添加]</a><br>
			</c:forEach>

		</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
<tr>
<td colspan="2" align="center"><a href="permission/query.action">  <input class="btn btn-success" style="height: 35px;width: 120px" type="button" value="返回上一页"/></a>
</td>
</tr>
</table>
</body>

</html>