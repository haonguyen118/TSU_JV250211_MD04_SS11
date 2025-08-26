<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025/08/24
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UpLoad File</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/upload" method="post" enctype="multipart/form-data">
  <input type="file" name="file" id="">
  <button type="submit">Upload</button>
</form>
<c:if test = "${url != null}"><img src="${url}" alt=""></c:if>

</body>
</html>
