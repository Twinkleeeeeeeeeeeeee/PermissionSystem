<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <base href="<%=basePath%>" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>修改角色</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
</head>

<script>
    $(document).ready(function () {
        $(".checkbox").find('input:checkbox').change(function () {
            var examineChecked = $(this).prop("checked");
            if (examineChecked) {
                $(this).attr('checked', 'true');
            } else {
                $(this).attr('checked', 'false');
            }
        })
    })

    function subId(userId) {
        var roleList = [];
        $(".checkbox").find('input:checkbox').each(function () {
            var examineChecked = $(this).prop("checked");
            if (examineChecked) {
                var roleId = $(this).attr('id');
                roleList.push(roleId)
            }
        });
        $.ajax({
            type: "GET",
            url: "role/roleuser.action",
            data: {userId:userId, roleList:roleList},
            traditional:true,
            dataType: "json",
            success: function(res){
               console.log(res)
            },
            error:function () {
                window.location.href = "role/query.action"
            }
        });
    }
</script>

<body>
<!-- 错误信息 -->
<c:forEach items="${errors }" var="error">
    ${error.defaultMessage }<br/>

</c:forEach>
<h3>${user.username}:</h3>
<div id="menu">
    <c:forEach items="${roleList}" var="info">
        <div class="checkbox" ><input type="checkbox" id="${info.id}" checked/>${info.name}</div>
    </c:forEach>
    <c:forEach items="${notUserRoleList}" var="notUser">
        <div class="checkbox" ><input type="checkbox" id="${notUser.id}">${notUser.name}</div>
    </c:forEach>
</div>

<button class="btn btn-primary" onclick="subId('${user.id}')">提交</button>
</body>

</html>