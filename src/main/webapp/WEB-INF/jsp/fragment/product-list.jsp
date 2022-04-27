<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Artyom
  Date: 11.04.2021
  Time: 23:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div class="col-8">
    <div class="row mt-5">
        <c:forEach var="product" items="${requestScope.productList}">
            <div class="col-md-4 col-sm-12 border">
                <div class="text-center">
                    <label class="h3">${product.name}</label>
                </div>
                <img src="${product.image}" class="mt-1" width="100%" height="250vw">
                <p class="mt-2">${product.description}</p>
                <label class="h6 mr-5">Цена: ${product.cost}</label>
                <label class="h6">Количество: ${product.count}</label>
                <div class="row mt-5">
                    <div class="col-6">
                        <form class="text-center" action="/add-to-shopping-cart" method="post">
                            <button type="submit" class="btn btn-primary w-100">В корзину</button>
                            <br><br>
                            <input type="hidden" value="${product.id}" name="product_id">
                        </form>
                    </div>
                    <div class="col-6">
                        <form class="text-center" action="/product/reviews" method="get">
                            <button type="submit" class="btn btn-primary w-100">Отзывы</button>
                            <input type="hidden" name="productId" value="${product.id}">
                        </form>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <div class="row">
        <div class="col">
            <nav aria-label="Page navigation example">
                <ul class="pagination justify-content-center mt-5">
                    <c:forEach var="page" items="${requestScope.pages}">
                        <li class="page-item"><a name="link" class="page-link" href="${page.value}">${page.key}</a></li>
                    </c:forEach>
                </ul>
            </nav>
        </div>
    </div>
</div>
</body>
</html>
