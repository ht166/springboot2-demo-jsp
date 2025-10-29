<%@ page language="java" contentType="text/html; charset=MS932" pageEncoding="MS932"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>検索結果</h2>

<div>
    <strong>検索条件：</strong><br>
    ID：${searchForm.userId}<br>
    ユーザー名：${searchForm.userName}<br>
    メニュー権限：${searchForm.menuLevel}
</div>

<table border="1">
    <tr>
        <th>ID</th>
        <th>ユーザー名</th>
        <th>メニュー権限</th>
        <th>操作</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.userId}</td>
            <td>${user.userName}</td>
            <td>${user.menuLevel}</td>
            <td>（編集・削除ボタンなど）</td>
        </tr>
    </c:forEach>
</table>

<a href="${pageContext.request.contextPath}/admin/user/result/returnSearch">検索画面に戻る</a>
