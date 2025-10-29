<%@ page language="java" contentType="text/html; charset=MS932" pageEncoding="MS932"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>���[�U�[����</h2>

<form:form modelAttribute="userSearchForm"
           action="${pageContext.request.contextPath}/admin/user/search/search"
           method="post">

    <div>
        <form:label path="userId">ID�F</form:label>
        <form:input path="userId" />
    </div>

    <div>
        <form:label path="userName">���[�U�[���F</form:label>
        <form:input path="userName" />
    </div>

    <div>
        <form:label path="menuLevel">���j���[�����F</form:label>
        <form:select path="menuLevel">
            <form:option value="" label="�I�����Ă�������" />
            <form:option value="0" label="�Ǘ���" />
            <form:option value="1" label="���" />
        </form:select>
    </div>

    <div>
        <button type="submit">����</button>
    </div>

</form:form>
