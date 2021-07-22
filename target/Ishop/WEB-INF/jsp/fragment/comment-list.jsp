<%--
  Created by IntelliJ IDEA.
  User: Artyom
  Date: 30.04.2021
  Time: 2:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>

<c:forEach var="comment" items="${requestScope.commentList}">
    <div class="row">
        <div class="col-3 text-right mt-5">
            <img src="../../../static/img/kolyan.png" style="height: 6vw">
        </div>
        <div class="col-6 text-left border mt-5">
            <div class="row">
                <div class="col-6">
                    <label class="h5">${comment.userName}</label>
                    <label>(${comment.email})</label><br>
                    <p>${comment.text}</p>
                </div>
                <div class="col-6 text-right">
                    <c:if test="${sessionScope.user.id==comment.accountId}">
                        <form method="post" action="/product/reviews/delete-review">
                            <button type="submit"><img src="../../../static/img/close.png" style="height: 1vw"></button>
                            <input type="hidden" name="commentId" value="${comment.id}">
                            <input type="hidden" name="productId" value="${comment.productId}">
                        </form>
                    </c:if>
                </div>
            </div>
        </div>
        <div class="col-3">
        </div>
    </div>
</c:forEach>
</body>
</html>
