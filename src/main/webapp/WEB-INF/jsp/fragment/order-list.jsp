<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Artyom
  Date: 26.04.2021
  Time: 2:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Заказы</title>
</head>
<body>
<c:forEach var="order" items="${requestScope.orderList}">
    <div class="row" id="deleteOrderDiv${order.id}">
        <div class="col-11">
            <a href="" name="orderRef" data-value="${order.id}"><label>Заказ#${order.id}</label></a>
            <div id="orderDiv${order.id}" style="display:none">
                <p>${order.info}<p>
                <label class="h5">Дата заказа: ${order.date}</label>
            </div>
        </div>

        <div class="col-1 text-right">
            <form>
                <input type="hidden" name="orderId" value="${order.id}">
                <button type="submit" name="orderBtn" id="${order.id}">
                    <img src="../../../static/img/close.png" style="height: 1.5vw">
                </button>
            </form>
        </div>
    </div>
</c:forEach>

<script src="../../../static/js/ajax.js"></script>
</body>
</html>
