<%--
  Created by IntelliJ IDEA.
  User: Artyom
  Date: 26.04.2021
  Time: 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Изменение пароля</title>
    <link rel="stylesheet" type="text/css" href="/static/css/app.css">
    <link rel="stylesheet" type="text/css"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container-fluid">
    <div class="row mt-5">
        <div class="col-3"></div>
        <div class="col-md-6 order-md-1 text-center mt-5">
            <form class="needs-validation" novalidate="" id="registrationForm">
                <div class="mb-3">
                    <label for="userName">Имя аккаунта</label>
                    <input type="text" id="userName" name="userName" disabled="true" value="${sessionScope.user.userName}" class="form-control"
                           placeholder="userName" required="">
                </div>
                <div class="mb-3">
                    <label for="email">Email</label>
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text">@</span>
                        </div>
                        <input type="text" class="form-control" disabled="true" id="email" name="email" value="${sessionScope.user.email}" placeholder="you@example.com">
                    </div>
                </div>
                <div class="mb-3">
                    <label for="password">Старый пароль</label>
                    <input type="password" id="password" name="password" class="form-control"
                           placeholder="Password" required="">
                </div>
                <div class="mb-3">
                    <label for="newPassword">Новый пароль</label>
                    <input type="password" id="newPassword" name="newPassword" class="form-control"
                           placeholder="Password" required="">
                </div>
                <button type="submit" class="btn btn-primary w-50" id="changePasswordBtn">Изменить пароль</button>
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
f