<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xuxu
  Date: 12/7/16
  Time: 2:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Login Success</title>

    <!-- new Bootstrap core CSS file -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>

</head>
<body>

<div class="container">
    <h1>Welcome back admin</h1>

    <table class="table table-bordered table-striped">
        <tr>
            <td>
                <a href="/admin/users" type="button" class="btn btn-sm btn-success">Show Users</a>
                <a href="/admin/blogs" type="button" class="btn btn-sm btn-success">Show Blogs</a>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
