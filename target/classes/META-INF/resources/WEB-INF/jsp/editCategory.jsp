<%--
  Created by IntelliJ IDEA.
  User: 苏晨宇
  Date: 2020/12/3
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="margin:0px auto; width:500px">

    <form action="updateCategory" method="post">

        name: <input name="name" value="${c.name}"> <br>

        <input name="id" type="hidden" value="${c.id}">
        <button type="submit">提交</button>

    </form>
</div>
</body>
</html>
