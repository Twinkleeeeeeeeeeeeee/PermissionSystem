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
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询用户列表</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<LINK rel="stylesheet" type="text/css" href="js/easyui/styles/default.css">
	<%@ include file="/WEB-INF/views/common_css.jsp"%>
	<%@ include file="/WEB-INF/views/common_js.jsp"%>
<script type="text/javascript">

//退出系统方法
function deleteUser(id) {
    _confirm('您确定要删除该用户吗?',null,
        function(){
            location.href = 'user/delete.action?id='+id;
        }
    )
}
</script>
</head>
<body>


<table class="table table-bordered" style="width: 80%;text-align: center;margin-left: 10%;" >
	<caption><h3>用户列表</h3></caption>
	<thead>
<tr>
<%--	<th>选择</th>--%>
	<td style="width: 20%;"><strong>用户账号</strong></td>
	<td style="width: 20%;"><strong>用户姓名</strong></td>
	<td width="24%"><strong>用户密码</strong></td>
	<td style="width: 16%;"><strong>操作</strong></td>
</tr></thead>
	<tbody>
<c:forEach items="${userList }" var="user">
<tr>
	<td>${user.usercode }</td>
	<td>${user.username }</td>
	<td>${user.password}</td>
	
	<td>
	<!-- 有item:update权限才显示修改链接，没有该 权限不显示，相当 于if(hasPermission(item:update)) -->
	<shiro:hasPermission name="user:update">
	<a href="user/goUpdate.action?id=${user.id}">修改</a>
	</shiro:hasPermission>
		<shiro:hasPermission name="user:delete">
		<a href="javascript:;" onclick="deleteUser(${user.id})">删除</a>
		</shiro:hasPermission>
		<shiro:lacksPermission name="user:delete">
			无权限
		</shiro:lacksPermission>
		<shiro:lacksPermission name="user:update">
			无权限
		</shiro:lacksPermission>
	</td>

</tr>
</c:forEach>
	</tbody>
</table>
<shiro:hasPermission name="user:create">
<a href="user/goAdd.action" style="margin-left: 10%">新增用户</a>
</shiro:hasPermission>
</form>
</body>

</html>