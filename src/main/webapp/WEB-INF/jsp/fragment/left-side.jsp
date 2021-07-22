<%@ page import="java.util.Map" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<div class="col-3 mt-5">
    <button class="btn btn-warning mr-5" id="catalogBtn" style="width: 12vw">Каталог</button>
    <br>
    <div id="catalogDiv" class="mt-3" style="display:
    <c:if test="${requestScope.searchForm!=null}">block</c:if>
    <c:if test="${requestScope.searchForm==null}">none</c:if>">
        <form action="/product/search">
            <c:forEach var="category" items="${applicationScope.categoryList}">
                <input class="mr-2" type="checkbox" value="${category.id}" name="category"
                       <c:if test="${requestScope.searchForm.categoriesMap.get(category.id)== true}">checked</c:if>>
                <label class="h5">${category.name}</label>
                <label class="h5">(${requestScope.countProductsInCategories.get(category.id)})</label><br>
            </c:forEach><br>
            <input type="text" class="form-control" name="search" placeholder="Поиск" style="width: 12vw"
                   value="${requestScope.searchForm.searchingProduct}"><br>
            <input type="hidden" name="page" value="1">
            <button class="btn btn-primary" style="width: 12vw">Поиск</button>
        </form>
    </div>
</div>
</body>
</html>
