<%--
  Created by IntelliJ IDEA.
  User: lrs
  Date: 2023/7/15
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="${pageContext.request.contextPath}/user/simpleParam?id=1&username=张三">基本参数类型</a>


    <form action="${pageContext.request.contextPath}/user/pojoParam" method="post">
        账号：<input type="text" name="id"><br>
        用户名：<input type="text" name="username"><br>
        <input type="submit" value="对象参数">
    </form>

<form action="${pageContext.request.contextPath}/user/arrays" method="post" >
    <%--value是框选后的最终取值 ，method=post表示将这个请求类型设置为post请求--%>
    编号：<br>
    <input type="checkbox" name="ids" value="1">1<br>
    <input type="checkbox" name="ids" value="2">2<br>
    <input type="checkbox" name="ids" value="3">3<br>
    <input type="checkbox" name="ids" value="4">4<br>
    <input type="checkbox" name="ids" value="5">6<br>
    <input type="submit" value="数组类型">
</form>

<form action="${pageContext.request.contextPath}/user/commix">
    keyword:<input name="keyword" type="text" ><br>

    user:<input name="user.id" type="text" placeholder="账号">
    <input name="user.username" type="text" placeholder="名字"><br>

    list:<input name="users[0].id" type="text" placeholder="account"><br>
    <input name="users[0].username" type="text" placeholder="username"><br>

    map:<input name="userMap['u1'].id" type="text" placeholder="account"><br>
    <input name="userMap['u1'].username" type="text" placeholder="account"><br>

    <input name="userMap['u2'].id" type="text" placeholder="account"><br>
    <input name="userMap['u2'].username" type="text" placeholder="account"><br>

    <input type="submit" value="commix">

</form>

<form action="${pageContext.request.contextPath}/user/test">
    <%--name要与参数名保持一致--%>
    生日<input name="birthday" type="text"><br>
    <input type="submit" value="生日提交">

</form>

<a href="${pageContext.request.contextPath}/user/notSame?page=2" > 不同参数名

</a>
<%--引入静态资源文件。.jquery.js文件--%>
<script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script>




</body>
</html>
