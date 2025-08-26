<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025/08/25
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng ký</title>
  <style>
    h1{
      text-align: center;
    }
    form{
      width: 40%;
      height: auto;
      box-shadow: rgba(0, 0, 0, 0.16) 0px 1px 4px, rgb(51, 51, 51) 0px 0px 0px 3px;
      margin-left: 20%;
    }
    input{
      width: 80%;
      height: 50px;
      margin-left: 10%;
    }
    button{
      width: 10%;
      height: 50px;
      margin-left: 45%;
      background-color: blue;
      margin-bottom: 20px;
      margin-top: 20px;
      color: white;
    }
    label{
      margin-left: 10%;
    }
    h1{
      text-align: center;
    }
    select{
      margin-left: 10%;
    }
    .error{
      color: red;
      font-size: 14px;
      margin-left: 10%;
    }
    a{
      text-decoration: none;
    }
  </style>
</head>
<body>
<form:form modelAttribute="user" method="post" action="/register" enctype="multipart/form-data">
  <h1>Đăng ký</h1>
  <form:label path="userName">Tên đăng nhập</form:label>
  <form:input path="userName" placeholder="Nhập tên..."/><br>
  <form:errors path="userName" cssClass="error"/><br>
  <form:label path="password">Mật khẩu</form:label>
  <form:input path="password" placeholder="Nhập mật khẩu..."/><br>
  <form:errors path="password" cssClass="error"/><br>
  <form:label path="email">Email</form:label>
  <form:input path="email" placeholder="Nhập email..."/><br>
  <form:errors path="email" cssClass="error"/><br>
  <form:label path="avatarUrl">Ảnh đại diện</form:label>
  <form:input path="avatarUrl" type="file" placeholder="Nhập avatarUrl..."/><br>
  <form:errors path="avatarUrl" cssClass="error"/><br>
  <form:button type="submit">Đăng ký</form:button><br>
  <div style="display: flex; margin-left: 10%; justify-content: center; align-items: center">
    <p>Đã có tài khoản</p>
    <a href="<%=request.getContextPath()%>/login">  Đăng nhập</a>
  </div>
</form:form>
</body>
</html>
