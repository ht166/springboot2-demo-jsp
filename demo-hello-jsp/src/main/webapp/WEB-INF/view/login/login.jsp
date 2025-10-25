<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>���O�C��</title>
    <script>
        function submitLoginForm(event) {
            event.preventDefault(); // �ʏ�̃t�H�[�����M���~�߂�

            const form = event.target;
            const formData = new FormData(form);

            fetch(form.action, {
                method: "POST",
                body: formData
            })
            .then(response => {
                if (response.redirected) {
                    // Spring���Ń��O�C������ �� redirect:/index �Ȃǂ��Ԃ��Ă���ꍇ
                    window.open(response.url, "childWindow",
                        "width=900,height=700,resizable=yes,scrollbars=yes");
                } else {
                    // ���s���͉�ʂ����̂܂܍X�V
                    response.text().then(html => {
                        document.open();
                        document.write(html);
                        document.close();
                    });
                }
            })
            .catch(err => {
                alert("�ʐM�G���[: " + err);
            });
        }
    </script>
</head>
<body>
    <h2>���O�C��</h2>

    <c:if test="${not empty message}">
        <p style="color:red">${message}</p>
    </c:if>

    <form:form modelAttribute="loginForm" action="/login/auth" method="post" onsubmit="submitLoginForm(event)">
        <div>
            <form:label path="userId">���[�U�[ID�F</form:label>
            <form:input path="userId"/>
        </div>
        <div>
            <form:label path="password">�p�X���[�h�F</form:label>
            <form:password path="password"/>
        </div>
        <div>
            <input type="submit" value="���O�C��"/>
        </div>
        <div>
            <form:errors path="*" style="color: red;"/>
        </div>
    </form:form>
</body>
</html>
