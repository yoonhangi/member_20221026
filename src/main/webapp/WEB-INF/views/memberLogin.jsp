<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-10-26
  Time: 오전 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인</title>
    <link rel="stylesheet" href="/resources/CSS/bootstrap.min.css">
</head>
<body>
<div class="container">
    <form action="/login" method="post">
        <input type="text" name="memberEmail" class="form-control" placeholder="이메일"><br>
        <input type="text" name="memberPassword" class="form-control" placeholder="비밀번호"><br>
        <input type="submit" value="로그인">
    </form>
</div>
</body>
</html>
