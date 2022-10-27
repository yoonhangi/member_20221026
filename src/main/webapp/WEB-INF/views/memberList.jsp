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
    <link rel="stylesheet" href="/resources/CSS/bootstrap.min.css">
</head>
<body>

<div class="container">
    <h2>회원정보</h2>
<table class="table table-hover">
    <tr>
        <th>id</th>
        <th>email</th>
        <th>password</th>
        <th>name</th>
        <th>age</th>
        <th>mobile</th>
        <th>삭제</th>
    </tr>
    <c:forEach items="${memberList}" var="member">
    <tr>
    <td><a href="/member?memberId=${member.memberId}">${member.memberId}</a></td>
    <td>${member.memberEmail}</td>
        <td>${member.memberPassword}</td>
        <td>${member.memberName}</td>
        <td>${member.memberAge}</td>
        <td>${member.memberMobile}</td>
        <td>
            <button class="btn btn-danger" onclick="deleteMember(${member.memberId})">삭제</button>
        </td>
    </tr>
    </c:forEach>
</table>
</div>
</body>
<script>
    const deleteMember =(memberId) =>{
        <%--console.log('${memberList}')--%>
        console.log("클릭한 id값: ", memberId)
        // controller로 보내기
        location.href = "/delete?memberId="+memberId;

    }
</script>
</html>
