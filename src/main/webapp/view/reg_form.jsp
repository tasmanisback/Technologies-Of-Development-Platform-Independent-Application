<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 05.05.2020
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Заказ отелей</title>
    <link rel="stylesheet" href="../src_css/reg_form.css" />
</head>
<body>
<div class="header"></div>
<div class="main_window">
    <div class="content_window">
        <div class="arrow"></div>
        <div class="title_main_menu"><a href="/view/entry_form.jsp" style ="text-decoration: none; color:#000;">Главное меню</a></div>
        <p class="title__sign_in">Создание аккаунта</p>
        <p class="notification_window">
            Создайте аккаунт, чтобы пользоваться<br />
            сервисами Заказа отеля.
        </p>
        <form action="/registration" method="get">
        <div class="login_div">
            <b style ="font-weight:400">Введите логин<br></b>
            <input class = "login_enter" name="login" type="text" size = "19" maxlength="20" />
        </div>

            <input type = "submit" name = "button" class = "button_submit"/>
        </form>
        <div class="text_additional">
            <p>Есть аккаунт?<a href="entry_form.jsp" style ="text-decoration: none;"> Войдите</a></p>
        </div>

    </div>
</div>

<div class="footer">
    <p class="notification">
        Входя в аккаунт или создавая новый, вы соглашаетесь с нашими Правилами и
        условиями и Положением о конфиденциальности
    </p>
    <p class="rights_reserved">
        Все права защищены.<br />
        Copyright (2019–2020) — Заказ отелей™
    </p>
</div>
</body>
</html>

