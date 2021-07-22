<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Artyom
  Date: 23.04.2021
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Личный кабинет</title>
    <link rel="stylesheet" type="text/css" href="/static/css/app.css">
    <link rel="stylesheet" type="text/css"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<c:import url="/WEB-INF/jsp/fragment/header.jsp"></c:import>
<div class="container-fluid">
    <div class="row">
        <div class="col-2 mt-3 text-center">
            <form action="/account">
                <button class="btn btn-secondary w-100">Личные данные</button>
            </form>
        </div>
        <div class="col-2 mt-3 text-center">
            <form action="/account/orders" method="post">
                <button class="btn btn-secondary w-100">Заказы</button>
            </form>
        </div>
        <c:if test="${requestScope.url==null || requestScope.test.equals(\"\")}">
            <c:import url="/WEB-INF/jsp/fragment/personal-information.jsp"></c:import>
        </c:if>
    </div>
    <c:if test="${requestScope.url!=null}">
        <c:import url="${requestScope.url}"></c:import>
    </c:if>

</div>


<c:import url="/WEB-INF/jsp/fragment/footer.jsp"></c:import>
<script src="../../../static/js/jquery.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
<script src="../../../static/js/app.js"></script>
</body>
</html>
