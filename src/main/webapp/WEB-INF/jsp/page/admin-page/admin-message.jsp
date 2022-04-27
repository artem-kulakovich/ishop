<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Artyom
  Date: 27.04.2021
  Time: 2:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Обратная связь</title>
    <link rel="stylesheet" type="text/css" href="/static/css/app.css">
    <link rel="stylesheet" type="text/css"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<c:import url="/WEB-INF/jsp/fragment/header.jsp"></c:import>
<div class="container-fluid">
    <c:forEach var="message" items="${requestScope.messageList}">
        <div class="row border">
            <div class="col-11 mt-2">
                <a href="#" name="messageLink" id="messageLink${message.id}" data-id="${message.id}" class="h5">${message.userName}</a>
                <div id="messageDiv${message.id}" style="display:none">
                    <label class="h5">${message.email}</label><br>
                    <label>${message.body}</label>
                    <form>
                        <button name="responseBtn" data-mail="${message.email}" data-id="${message.id}" class="btn btn-outline-secondary">Ответить</button>
                    </form>
                </div>
            </div>
        </div>
    </c:forEach>
</div>

<script src="../../../../static/js/ajax.js"></script>
<script src="../../../../static/js/app.js"></script>
</body>
</html>
