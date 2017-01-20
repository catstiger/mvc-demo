<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>500</title>
</head>
<body>
  505
<%
Exception e = (Exception) request.getAttribute("javax.servlet.error.exception");
out.println(e.getMessage());
%>
</body>
</html>