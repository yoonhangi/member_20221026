<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-10-26
  Time: 오전 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입 페이지</title>
  <link rel="stylesheet" href="/resources/CSS/bootstrap.min.css">
  <style>
    #save-form{
      width: 1000px;
    }
  </style>
</head>
<body>
<div class="container" id="save-form">
  <h2>회원가입정보</h2>
<form action="/save" method="post" name="saveForm">
  <input type="text" name="memberEmail" placeholder="이메일"><br>
  <span id="email-input-check"></span>
  <input type="text" name="memberPassword" placeholder="비밀번호"><br>
  <input type="text" name="memberName" placeholder="이름"><br>
  <input type="text" name="memberAge" placeholder="나이"><br>
  <input type="text" name="memberMobile" placeholder="전화번호"><br>
  <input type="button" value="회원가입" onclick="save()" class="btn btn-primary">
<%--  <button onclick="btn1Fn()">버튼가입</button>--%>
</form>
</div>
</body>
<script>
  const save = () => {
    console.log("save 함수호출")
    if (document.saveForm.memberEmail.value == "") {
      // alert("이메일을 입력해주세요");
      // 이메일 입력 하지 않았을 때 span에 빨간색으로 출력
      const emailCheck = document.getElementById("email-input-check");
      emailCheck.innerHTML = "이메일을 입력해주세요";
      emailCheck.style.color ="red";
      return false;
    } else if (document.saveForm.memberPassword.value =="") {
      alert("비밀번호를 입력해주세요");
      return false;
    } else if (document.saveForm.memberName.value =="") {
      alert("이름을 입력해주세요");
      return false;
    } else if (document.saveForm.memberAge.value =="") {
      alert("나이를 입력헤주세요");
      return false;
    } else if (document.saveForm.memberMobile.value =="") {
      alert("전화번호를 입력해주세요");
      return false;
    }
    document.saveForm.submit();
  }
  // const btn1Fn = () => {
  //   console.log("btn1Fn 함수호출")
  // }
</script>
</html>
