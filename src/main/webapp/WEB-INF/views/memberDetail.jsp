<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-10-26
  Time: 오후 2:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>상세정보</title>
    <link rel="stylesheet" href="/resources/CSS/bootstrap.min.css">
</head>
<body>
  <div class="container">
    <table class="table table-hover">
    <h2>${member.memberEmail}님의 정보</h2>
      <tr>
        <th>번호</th>
        <th>이메일</th>
        <th>비밀번호</th>
        <th>이름</th>
        <th>나이</th>
        <th>전화번호</th>
      </tr>
      <tr>
        <td>${member.memberId}</td>
        <td>${member.memberEmail}</td>
        <td>${member.memberPassword}</td>
        <td>${member.memberName}</td>
        <td>${member.memberAge}</td>
        <td>${member.memberMobile}</td>
      </tr>
    </table>

</div>
</body>
</html>
