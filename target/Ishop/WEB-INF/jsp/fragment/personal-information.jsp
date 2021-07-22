<%--
  Created by IntelliJ IDEA.
  User: Artyom
  Date: 26.04.2021
  Time: 2:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Персональная информация</title>
</head>
<body>
</div>
<div class="row">
    <div class="col-3 mt-4 text-center">
        <div class="border" style="height: 100%">
            <img src="../../../static/img/account.png" style="width: 70%;height: 12vw"><br>
            <form method="post" action="/account/change-information">
                <button class="btn btn-outline-secondary mt-2">Изменить данные</button>
                <br>
            </form>
            <form method="post" action="/account/change-password">
                <button class="btn btn-outline-secondary mt-2">Изменить пароль</button>
                <br>
            </form>
            <form method="get" action="/sign-out">
                <button class="btn btn-outline-secondary mt-2">Выйти с аккаунта</button>
                <br><br>
            </form>
        </div>
    </div>

    <div class="col-4 mt-4 text-center">
        <div class="border" style="height: 100%">
            <label class="h4">Текущая скидка:</label>
        </div>
    </div>

    <div class="col-5 mt-4">
        <div class="border pl-2" style="height: 100%">
            <label class="account-info">E-mail: _ _ _ _ _ _ _ _ _ _ _ _ <label
                    class="h5 mr-5">${sessionScope.user.email}</label></label><br>
            <label class="account-info">Имя аккаунта: _ _ _ _ _ _ _ _ _ _ _ _ <label
                    class="h5 mr-5">${sessionScope.user.userName}</label></label><br>
            <label class="account-info">Имя: _ _ _ _ _ _ _ _ _ _ _ _ <label
                    class="h5 mr-5">${sessionScope.user.firsName}</label></label><br>
            <label class="account-info">Фамилия: _ _ _ _ _ _ _ _ _ _ _ _ <label
                    class="h5 mr-5">${sessionScope.user.lastName}</label></label><br>
            <label class="account-info">Дата создания: _ _ _ _ _ _ _ _ _ _ _ _ <label
                    class="h5 mr-5">${sessionScope.user.date}</label></label><br>
        </div>
    </div>
</div>

</body>
</html>
