<%@ page language="java" contentType="text/html; charset=MS932" pageEncoding="MS932"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="MS932">
    <title>ログイン</title>
    <script>
    function submitLoginForm(event) {
        event.preventDefault();

        const form = event.target;
        const formData = new FormData(form);

        fetch(form.action, {
            method: "POST",
            body: formData
        })
        .then(async response => {
            if (response.redirected) {
                window.open(response.url, "childWindow",
                    "width=900,height=700,resizable=yes,scrollbars=yes");
            } else {
                // MS932でテキストを取得
                const blob = await response.blob();
                const arrayBuffer = await blob.arrayBuffer();
                const decoder = new TextDecoder("shift_jis"); // MS932と互換
                const html = decoder.decode(arrayBuffer);

                document.open();
                document.write(html);
                document.close();
            }
        })
        .catch(err => {
            alert("通信エラー: " + err);
        });
    }
    </script>
</head>
<body>
    <h2>ログイン</h2>

    <c:if test="${not empty message}">
        <p style="color:red">${message}</p>
    </c:if>

    <form:form modelAttribute="loginForm" action="/login/auth" method="post" onsubmit="submitLoginForm(event)">
        <div>
            <form:label path="userId">ユーザーID：</form:label>
            <form:input path="userId"/>
        </div>
        <div>
            <form:label path="password">パスワード：</form:label>
            <form:password path="password"/>
        </div>
        <div>
            <input type="submit" value="ログイン"/>
        </div>
        <div>
            <form:errors path="*" style="color: red;"/>
        </div>
    </form:form>
</body>
</html>
