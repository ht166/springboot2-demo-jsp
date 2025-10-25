<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2>���[�U�[�ꗗ</h2>
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
			<td><a
				href="${pageContext.request.contextPath}/admin/editUser/${user.userId}">�ҏW</a>
				<form
					action="${pageContext.request.contextPath}/admin/deleteUser/${user.userId}"
					method="post" style="display: inline;">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
					<button type="submit">�폜</button>
				</form></td>
		</tr>
	</c:forEach>
</table>
