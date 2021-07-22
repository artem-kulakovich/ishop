<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Artyom
  Date: 16.04.2021
  Time: 2:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Заказ</title>
    <link rel="stylesheet" type="text/css" href="/static/css/app.css">
    <link rel="stylesheet" type="text/css"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css">
</head>
<body>
<c:import url="/WEB-INF/jsp/fragment/header.jsp"></c:import>
<div class="container-fluid">
    <div class="row">
        <div class="col-12 text-center">
            <button class="btn btn-outline-secondary mt-4" id="infoAboutOrder">Информация о заказе</button>
        </div>
    </div>
    <div id="orderList">
        <c:forEach var="product" items="${sessionScope.shoppingCart.shoppingCart}">
            <div class="row mt-5">
                <div class="col-3 text-center">
                    <img src="${product.value.product.image}" style="height: 10vw">
                </div>
                <div class="col-3 text-center">
                    <label class="default-font">Название товар: ${product.value.product.name}</label>
                </div>
                <div class="col-3 text-center">
                    <p>${product.value.product.description}</p>
                </div>
                <div class="col-3 text-center">
                    <label class="default-font">Количество: ${product.value.count}</label>
                </div>
            </div>
        </c:forEach>
    </div>
    <div class="row">
        <div class="col-12 mt-4 text-center">
            <label class="h2">К оплате: ${sessionScope.shoppingCart.totalCost}</label>
        </div>
    </div>
    <div class="row">
        <div class="col-12 text-center mt-5">
            <label class="h4">Заполните следующую форму для заказа</label>
        </div>
    </div>
    <div class="row">
        <div class="col-3"></div>
        <div class="col-md-6 mb-3 text-center mt-5">
            <label for="address">Адрес доставки:</label>
            <input type="text" class="form-control" id="address" name="lastname" placeholder="" value="">
        </div>
        <div class="col-3"></div>
    </div>
    <div class="row">
        <div class="col-3"></div>
        <div class="col-md-6 mb-3 text-center mt-3">
            <label for="telephone">Контактный номер:</label>
            <input type="text" class="form-control" id="telephone" name="lastname" placeholder="" value="">
        </div>
        <div class="col-3"></div>
    </div>
    <div class="row">
        <div class="col-3"></div>
        <div class="col-6">
            <input type="radio" name="requestTime"><label class="mr-2">Доставить как можно быстрее </label>
            <input type="radio" name="requestTime"><label class="mr-2">Договорное время </label>
        </div>
        <div class="col-3"></div>
    </div>
    <div class="row">
        <div class="col-3"></div>
        <div class="col-6">
            <input type="radio" name="payment"><label class="mr-2">Наличными</label>
            <input type="radio" name="payment"><label class="mr-2">Картой</label>
            <a href="#" style="text-decoration: none;color: black">Онлайн</a>
        </div>
        <div class="col-3"></div>
    </div>
    <div class="row" id="orderDiv">
        <div class="col-12 text-center mt-3">
            <form>
                <button id="orderBtn" class="btn btn-secondary w-50">Заказать</button>
            </form>
        </div>
    </div>
</div>


<c:import url="/WEB-INF/jsp/fragment/footer.jsp"></c:import>
<script src="../../../static/js/jquery.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
<script src="../../../static/js/app.js"></script>
<script src="../../../static/js/ajax.js"></script>
</body>
</html>
