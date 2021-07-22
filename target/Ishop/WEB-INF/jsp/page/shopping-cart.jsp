<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Корзина</title>
    <link rel="stylesheet" type="text/css" href="/static/css/app.css">
    <link rel="stylesheet" type="text/css"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<c:import url="/WEB-INF/jsp/fragment/header.jsp"></c:import>
<div class="container">
    <div class="row mt-5 text-center">
        <div class="col border">
            <label class="h5">Изображение</label>
        </div>
        <div class="col border">
            <label class="h5">Название товара</label>
        </div>
        <div class="col border">
            <label class="h5">Количество</label>
        </div>
        <div class="col border">
            <label class="h5">Цена единицы</label>
        </div>
        <div class="col border">
            <label class="h5">Всего</label>
        </div>
    </div>
    <c:forEach var="product" items="${sessionScope.shoppingCart.shoppingCart}">
        <div class="row" id="row${product.value.product.id}">
            <div class="col border pt-3 pb-3">
                <img src="${product.value.product.image}" style="width: 100%;height: 20vw">
            </div>
            <div class="col border pt-3 pb-3">
                <label class="h5">${product.value.product.name}</label>
            </div>
            <div class="col border pt-3 pb-3 text-center">
                <form>
                    <button type="submit" class="add-product-btn" id="removeProductBtn"
                            data-id="${product.value.product.id}" data-count="${product.value.count}">-
                    </button>
                    <input type="text" disabled value="${product.value.count}" name="productCount"
                           class="shopping-cart-count-input" id="productInput${product.value.product.id}">
                    <button type="submit" class="add-product-btn" id="addProductBtn"
                            data-id="${product.value.product.id}" data-count="${product.value.count}">+
                    </button>
                </form>
            </div>

            <div class="col border pt-3 pb-3">
                <label class="h5" id="cost${product.value.product.id}"
                       data-cost="${product.value.product.cost}">${product.value.product.cost}</label>
            </div>
            <div class="col border pt-3 pb-3">
                <label class="h5" id="totalCost${product.value.product.id}">${product.value.product.cost}</label>
            </div>
        </div>
    </c:forEach>
</div>
<br>
<c:if test="${sessionScope.shoppingCart.shoppingCart.size()!=0}">
    <div class="text-center">
        <a type="button" class="btn btn-primary w-25" href="/order" title="">Оформить заказ</a>
    </div>
</c:if>
<c:import url="/WEB-INF/jsp/fragment/footer.jsp"></c:import>
<script src="../../../static/js/jquery.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
<script src="../../../static/js/app.js"></script>
<script src="/static/js/ajax.js"></script>
</body>
</html>
