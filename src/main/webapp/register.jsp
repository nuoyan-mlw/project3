<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<div>${info}</div>
<form action="${pageContext.request.contextPath}/user/register" method="post">
    用户名:<input type="text" name="username"><br>
    密码:<input type="password" name="password"><br>
    邮箱:<input type="text" name="email">
    电话:<input type="text" name="phoneNum">
    <input type="hidden" name="status" value="1">
    <button type="submit">注册</button>

</form>
</body>
</html>
