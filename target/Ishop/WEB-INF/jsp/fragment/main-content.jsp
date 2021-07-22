<%--
  Created by IntelliJ IDEA.
  User: Artyom
  Date: 09.04.2021
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<div class="container-fluid mt-5">
    <div class="row">
        <div class="col-12 text-center">
            <label class="h2 align-middle">Заказы</label><br>
        </div>
    </div>
    <hr>
    <div class="row">
        <div class="col-12">
            <p>"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam
                rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt
                explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia
                consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui
                dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora
                incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum
                exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem
                vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum
                qui dolorem eum fugiat quo voluptas nulla pariatur?"</p>
        </div>
    </div>
    <div class="row pl-5">
        <div class="col-7 frame-height">
            <img src="../../../static/img/smartphone.png" class="img-full-size">
        </div>
        <div class="col-5 frame-height">
            <img src="../../../static/img/tablet.png" class="img-full-size">
        </div>
    </div>
    <hr>
    <div class="row mt-4">
        <div class="col-4 frame-height">
            <img src="../../../static/img/laptop.png" class="img-full-size">
        </div>
        <div class="col-4 frame-height">
            <img src="../../../static/img/smartwatch.png" class="img-full-size">
        </div>
        <div class="col-4 frame-height">
            <img src="../../../static/img/personalcomputer.png" class="img-full-size">
        </div>
    </div>
</div>
<div class="container-fluid mt-5">
    <div class="row">
        <div class="col-12">
            <label class="h2"><span>Наши плюсы</span></label>
        </div>
    </div>
    <div class="row">
        <div class="col-4 text-center mt-4">
            <p>"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et
                dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip
                ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu
                fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia
                deserunt mollit anim id est laborum."</p>
        </div>
        <div class="col-4 text-center mt-4">
            <p>"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et
                dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip
                ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu
                fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia
                deserunt mollit anim id est laborum."</p>
        </div>
        <div class="col-4 text-center mt-4">
            <p>"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et
                dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip
                ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu
                fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia
                deserunt mollit anim id est laborum."</p>
        </div>
    </div>
    <div class="row mt-5">
        <div class="col-12">
            <label class="h2"><span>Бренды</span></label>
        </div>
    </div>
    <div class="row mt-2">
        <div class="col-2 brand-height">
            <img src="../../../static/img/xioami.png" class="img-full-size">
        </div>
        <div class="col-2 brand-height">
            <img src="../../../static/img/iphone.png" class="img-full-size">
        </div>
        <div class="col-2 brand-height">
            <img src="../../../static/img/hp1.png" class="img-full-size">
        </div>
        <div class="col-2 brand-height">
            <img src="../../../static/img/asus.png" class="img-full-size">
        </div>
        <div class="col-2 brand-height">
            <img src="../../../static/img/samsung.png" class="img-full-size">
        </div>
        <div class="col-2 brand-height">
            <img src="../../../static/img/huawei.png" class="img-full-size">
        </div>
    </div>
    <div class="row mt-5"></div>
    <div class="row mt-5"></div>
    <div class="row mt-5">
        <div class="col-12 text-center">
            <label class="h2"><span>Обратная связь</span></label>
        </div>
    </div>
    <div class="row align-content-between mt-4">
        <div class="col-3"></div>
        <div class="col-6 text-center">
            <form action="/main/send-feedback" method="get">
                <input id="type" class="feedback-input" type="text" name="type" placeholder="Категория"><br><br>
                <textarea id="msg" name="msg" placeholder="Комментарий" class="feedback-area"></textarea><br><br>
                <button  id="feedBackBtn" class="btn btn-danger" style="width: 20vw">Отправит</button>
            </form>
        </div>
        <div class="col-3"></div>
    </div>
</div>

<script src="../../../static/js/app.js"></script>
</body>
</html>
