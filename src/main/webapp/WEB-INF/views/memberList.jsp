<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-10-26
  Time: 오후 1:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--jstl 추가 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>회원 목록</title>
</head>
<body>
<h2>회원목록</h2><br>
<table>
    <tr>
    <c:forEach items="${memberList}" var="member">
    <th><a href="/member?memberId=${member.memberId}">${member.memberId}</a></th>
        <td>${member.memberEmail}</td>
    </c:forEach>
    </tr>
</table>
</body>
</html>
