<%--
  Created by IntelliJ IDEA.
  User: Artyom
  Date: 23.04.2021
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
    <link rel="stylesheet" type="text/css" href="/static/css/app.css">
    <link rel="stylesheet" type="text/css"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body bgcolor="#f5f5f5">
<div class="container-fluid">
    <div class="row mt-5">
        <div class="col-3"></div>
        <div class="col-md-6 order-md-1 text-center mt-5">
            <h4 class="mb-3">Добро пожаловать</h4>
            <form class="needs-validation" novalidate="" id="registrationForm">
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="firstName">Имя</label>
                        <input type="text" class="form-control" id="firstName" name="firstName" placeholder="" value="">
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="lastName">Фамилия</label>
                        <input type="text" class="form-control" id="lastName" name="lastname" placeholder="" value="">
                    </div>
                </div>
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
                </div>

                <div class="mb-3">
                    <label for="email">Email <span class="text-muted">(Optional)</span></label>
                    <input type="email" class="form-control" id="email" name="email" placeholder="you@example.com">
                </div>

                <div style="display: block" id="sendEmailDiv">
                    <button class="btn btn-primary btn-lg btn-block" id="sendEmail" type="submit">Отправить письмо
                    </button>
                </div>
                <div id="registrationDiv" style="display: none">
                    <input type="text" class="form-control" name="code" id="code" value="" placeholder="Введите код"><br>
                    <input type="hidden" name="uniqueCode" id="uniqueCode" value="">
                    <button class="btn btn-primary btn-lg btn-block" id="registrationBtn" type="submit">
                        Зарегистрироваться
                    </button>
                </div>
            </form>
        </div>
    </div>

</div>

<script src="../../../static/js/jquery.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
<script src="../../../static/js/app.js"></script>
<script src="../../../static/js/ajax.js"></script>
</body>
</html>
