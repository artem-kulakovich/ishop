<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Artyom
  Date: 28.04.2021
  Time: 3:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Отзывы</title>
    <link rel="stylesheet" type="text/css" href="/static/css/app.css">
    <link rel="stylesheet" type="text/css"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<c:import url="/WEB-INF/jsp/fragment/header.jsp"></c:import>
<div class="container-fluid">
    <div class="row">
        <div class="col text-center border pt-5">
            <label class="h5">${requestScope.product.name}</label><br>
            <img src="${requestScope.product.image}" style="height: 20vw">
            <p>${requestScope.product.description}</p>
        </div>
    </div>

    <div id="test">
        <c:import url="/WEB-INF/jsp/fragment/comment-list.jsp"></c:import>
    </div>
    <div class="row" id="ref">
        <div class="col-3"></div>
        <div class="col-6 text-center mt-5">
            <form>
                <input type="hidden" name="index" id="index" value="1">
                <input type="hidden" name="productId" id="productId" value="${requestScope.product.id}">
                <input type="hidden" id="accountId" value="${sessionScope.user.id}">
                <button type="submit" class="btn btn-outline-secondary w-25" id="reviewBtn">Показать еще</button>
            </form>
        </div>
        <div class="col-3"></div>
    </div>
    <div class="row">
        <div class="col text-center">
            <label class="h4">Оставить Отзыв</label><br>
            <form action="/product/reviews" method="post">
                <textarea name="text" id="reviewText" style="width: 30vw;height: 10vw"></textarea><br>
                <input type="hidden" name="productId" value="${requestScope.product.id}">
                <button id="sendReviewBtn" type="submit" class="btn btn-outline-secondary w-25 mt-5">Оставить отзыв
                </button>
            </form>
        </div>
    </div>
</div>
<c:import url="/WEB-INF/jsp/fragment/footer.jsp"></c:import>
<script src="../../../static/js/ajax.js"></script>
<script src="../../../static/js/app.js"></script>
</body>
</html>
