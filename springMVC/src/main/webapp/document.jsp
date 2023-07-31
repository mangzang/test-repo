<%--
  Created by IntelliJ IDEA.
  User: lrs
  Date: 2023/7/18
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--单文件上传--%>
<form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">
    <input type="text" name="username"><br>
    <input type="file" name="file"><br>
    <input type="submit" value="文件上传">

</form>
<%--多文件上传--%>
<form action="${pageContext.request.contextPath}/multiUpload" method="post" enctype="multipart/form-data">
    <input type="text" name="username"><br>
    <input type="file" name="file"><br>
    <input type="file" name="file"><br>
    <input type="submit" value="文件上传">
<%System.out.println("asdada");%>
</form>
</body>
</html>
