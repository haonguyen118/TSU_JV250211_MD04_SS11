<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025/08/28
  Time: 2:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Product</title>
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
    </style>
</head>
<body>
<form:form modelAttribute="product" method="post" action="/products/add" enctype="multipart/form-data">
    <h1>Thêm mới sản phẩm</h1>
    <form:label path="productName">Tên sản phẩm</form:label>
    <form:input path="productName" placeholder="Nhập tên sản phẩm"/><br>
    <form:errors path="productName" cssClass="error"/><br>
    <form:label path="price">Giá</form:label>
    <form:input path="price" placeholder="Nhập giá sản phẩm"/><br>
    <form:errors path="price" cssClass="error"/><br>
    <form:label path="stock">Tồn kho</form:label>
    <form:input path="stock" placeholder="Nhập số lượng tồn kho"/><br>
    <form:errors path="stock" cssClass="error"/><br>
    <form:label path="imageUrl">Hình ảnh</form:label>
    <form:input path="imageUrl" type="file" placeholder="Nhập Url..."/><br>
    <form:select path="status">
        <option value="true" <c:if test="${product.status}">selected</c:if>>Đang bán</option>
        <option value="false" <c:if test="${ not product.status}">selected</c:if>>Ngừng bán</option>
    </form:select>
    <div><form:button type="submit">Thêm</form:button>
        <a href="/products">Quay lại</a></div>
</form:form>
</body>
</html>

