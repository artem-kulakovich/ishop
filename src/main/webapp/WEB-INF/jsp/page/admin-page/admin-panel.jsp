<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Artyom
  Date: 27.04.2021
  Time: 2:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Админская панель управления</title>
    <link rel="stylesheet" type="text/css" href="/static/css/app.css">
    <link rel="stylesheet" type="text/css"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>


<div class="container-fluid">
    <div class="row bg-light">
        <div class="col-2 text-center mt-2">
            <form method="post" action="/admin-panel/message/get-all-message">
                <button class="btn btn-outline-secondary" type="submit">Сообщения от пользователей</button>
            </form>
        </div>
    </div>
</div>
<script src="../../../../static/js/app.js"></script>
</body>
</html>
