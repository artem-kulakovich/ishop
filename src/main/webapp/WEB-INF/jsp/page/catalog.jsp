<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Каталог товаров</title>
    <link rel="stylesheet" type="text/css" href="/static/css/app.css">
    <link rel="stylesheet" type="text/css"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<c:import url="/WEB-INF/jsp/fragment/header.jsp"></c:import>

<div class="container-fluid">
    <c:import url="/WEB-INF/jsp/fragment/top-side.jsp"></c:import>
    <div class="row">
        <c:import url="/WEB-INF/jsp/fragment/left-side.jsp"></c:import>
        <c:import url="/WEB-INF/jsp/fragment/product-list.jsp"></c:import>
    </div>
    <c:import url="/WEB-INF/jsp/fragment/footer.jsp"></c:import>
    <script src="../../../static/js/jquery.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
    <script src="../../../static/js/app.js"></script>
</body>
</html>
