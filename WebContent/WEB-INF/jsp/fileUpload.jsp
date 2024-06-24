<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>画像アップロード</title>
</head>
<body>
<%@ include file="header.jsp"%>
<%
	String filePath = (String)request.getAttribute("filePath");
%>
    <h2>画像をアップロードしてください</h2>
    <img src = "<%= filePath%>" alt ="img" width=200>
    <form action="/simpleBC/samServlet" method="post" enctype="multipart/form-data">
        <input type="file" name="imageFile">
        <input type="submit" value="アップロード">
    </form>
    <%@ include file="footer.jsp"%>
</body>
</html>