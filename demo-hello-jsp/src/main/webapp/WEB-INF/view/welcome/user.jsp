<%@ page language="java" contentType="text/html; charset=MS932"	pageEncoding="MS932"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="MS932">
	<title>welcome</title>
</head>
<body>
   <% out.println("welcome"); %>
   <p>�悤�����A${sessionUser.userName} ����I</p>
   <p>���j���[���x���F${sessionUser.menuLevel}�ł�</p>
    <c:if test="${sessionUser}== null" >
  		 <p>sessionUser����ł�</p>
   </c:if>
</body>
</html>
