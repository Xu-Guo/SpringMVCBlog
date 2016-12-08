<%--
  Created by IntelliJ IDEA.
  User: xuxu
  Date: 12/6/16
  Time: 10:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>User Login</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

</head>

<body>

<form action="/clientLoginP" method="post">
    First name：<input type="text" name="firstName"> <br><br>
    Last name：<input type="text" name="lastName"> <br><br>
    Password ：<input type="text" name="password"> <br><br>
    <input type="submit" value="Submit">
</form>
<form action="/register" method="get">
    <input type="submit" value="Register">
</form>

<%--<a href="/register" type="button" class="btn btn-sm btn-success">Register</a>--%>


<%--<div class="container">--%>
    <%--<h1>Welcome back admin</h1>--%>

    <%--<table class="table table-bordered table-striped">--%>
        <%--<tr>--%>
            <%--<td>--%>
                <%--<a href="/admin/users" type="button" class="btn btn-sm btn-success">Show Users</a>--%>
                <%--<a href="/admin/blogs" type="button" class="btn btn-sm btn-success">SHow Blogs</a>--%>
            <%--</td>--%>
        <%--</tr>--%>
    <%--</table>--%>
<%--</div>--%>

</body>
</html>