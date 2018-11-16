<%--
  Created by IntelliJ IDEA.
  User: yzw
  Date: 2018/11/12
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
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
    <title>查询权限列表</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <LINK rel="stylesheet" type="text/css" href="js/easyui/styles/default.css">
    <%@ include file="/WEB-INF/views/common_css.jsp"%>
    <%@ include file="/WEB-INF/views/common_js.jsp"%>
</head>
<body>


<table class="table table-bordered" style="width: 80%;text-align: center;margin-left: 10%;" >
    <caption><h3>权限列表</h3></caption>
    <thead>
    <tr>
        <%--	<th>选择</th>--%>
        <td style="width: 20%;"><strong>角色名</strong></td>
        <td style="width: 20%;"><strong>权限</strong></td>
        <td style="width: 16%;"><strong>操作</strong></td>
    </tr></thead>
    <tbody>
    <c:forEach items="${permissionList}" var="p">
        <tr>
            <td>${p.name }</td>

            <td>
                    <c:forEach items="${p.permissionList}" var="per">
                        [${per.name},${per.percode}]、
                    </c:forEach>
            </td>

            <td>
               <a href="permission/goPermissionUpdate.action?id=${p.id}">修改</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
