<%@ page language="java" contentType="text/html; charset=MS932" pageEncoding="MS932"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>ユーザー検索</h2>

<form:form modelAttribute="userSearchForm"
           action="${pageContext.request.contextPath}/admin/user/search/search"
           method="post">

    <div>
        <form:label path="userId">ID：</form:label>
        <form:input path="userId" />
    </div>

    <div>
        <form:label path="userName">ユーザー名：</form:label>
        <form:input path="userName" />
    </div>

    <div>
        <form:label path="menuLevel">メニュー権限：</form:label>
        <form:select path="menuLevel">
            <form:option value="" label="選択してください" />
            <form:option value="0" label="管理者" />
            <form:option value="1" label="一般" />
        </form:select>
    </div>

    <div>
        <button type="submit">検索</button>
    </div>

</form:form>
