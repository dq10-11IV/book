<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>test</title>
</head>
<body>
   <!-- 使用第一种方式获取jsonResult 这样不用使用任何java代码  现在不支持第二种方式了-->
  ${requestScope.jsonResult} 
<%--  <% request.getAttribute("jsonResult"); %> --%>
</body>
</html>