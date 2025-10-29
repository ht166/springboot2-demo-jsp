<%@ page language="java" contentType="text/html; charset=MS932"	pageEncoding="MS932"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="MS932">
	<title>welcome/admin</title>
</head>
<body>
   <% out.println("welcome"); %>
   <p>ようこそ、${sessionUser.userName} さん！</p>
   <p>メニューレベル：${sessionUser.menuLevel}です</p>
   
   <p>あなたには管理者権限があります</p>
    <c:if test="${sessionUser}== null" >
  		 <p>sessionUserが空です</p>
   </c:if>
<a href="${pageContext.request.contextPath}/admin/users">
    <button type="button">ユーザー管理画面_一覧</button>
</a>
<a href="${pageContext.request.contextPath}/admin/user/search/index">
    <button type="button">ユーザー検索条件入力画面</button>
</a>
</body>
</html>
