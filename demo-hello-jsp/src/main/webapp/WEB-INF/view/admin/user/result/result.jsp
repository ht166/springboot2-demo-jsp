<%@ page language="java" contentType="text/html; charset=MS932" pageEncoding="MS932"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>��������</h2>

<div>
    <strong>���������F</strong><br>
    ID�F${searchForm.userId}<br>
    ���[�U�[���F${searchForm.userName}<br>
    ���j���[�����F${searchForm.menuLevel}
</div>

<table border="1">
    <tr>
        <th>ID</th>
        <th>���[�U�[��</th>
        <th>���j���[����</th>
        <th>����</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.userId}</td>
            <td>${user.userName}</td>
            <td>${user.menuLevel}</td>
            <td>�i�ҏW�E�폜�{�^���Ȃǁj</td>
        </tr>
    </c:forEach>
</table>

<a href="${pageContext.request.contextPath}/admin/user/result/returnSearch">������ʂɖ߂�</a>
