<%--
  Created by IntelliJ IDEA.
  User: Artyom
  Date: 23.04.2021
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Авторизация</title>
    <link rel="stylesheet" type="text/css" href="/static/css/app.css">
    <link rel="stylesheet" type="text/css"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container-fluid">
    <div class="row mt-5">
        <div class="col-3"></div>
        <div class="col-md-6 order-md-1 text-center mt-5">
            <h4 class="mb-3">Добро пожаловать</h4>
            <form class="needs-validation" novalidate="" id="registrationForm" action="/sign-in" method="get">
                <div class="mb-3">
                    <label for="username">Имя аккаунта</label>
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text">@</span>
                        </div>
                        <input type="text" class="form-control" id="username" name="userName" placeholder="Username">
                    </div>
                </div>
                <div class="mb-3">
                    <label for="password">Пароль</label>
                    <input type="password" id="password" name="password" class="form-control"
                           placeholder="Password" required="">
                    <input type="hidden" name="url" value="${sessionScope.url}">
                </div>
                <p>У вас нет аккаунта? <a href="/registration">Зарегистрироваться</a></p>
                <button class="btn btn-primary w-50">Войти</button>
            </form>
        </div>
    </div>
</div>

<script src="../../../static/js/app.js"></script>
<script src="../../../static/js/jquery.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
</body>
</html>
