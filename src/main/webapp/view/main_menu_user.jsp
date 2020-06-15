<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 23.05.2020
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <link rel="stylesheet" href="/src_css/main_menu_user.css" />
    <title>Static Template</title>
</head>
<body>
<div class="container">
    <div class="profile">
        <form method="post" action="/mainMenuUser?action=exit">
            <input type="submit" value="Выйти" class="profile_button"/>
        </form>
        <form method="post" action="/mainMenuUser?action=profile">
            <input type="submit" class="profile_button" style ="float:left;" value="Ваш профиль" />
        </form>
        <form method="post" action="/mainMenuUser?action=order">
            <input type="submit" class="profile_button"  value="Просмотреть заказы" />
        </form>
    </div>
    <div class="hotel_form">
        <form action="/mainMenuUser" method="get">
            <div class="formo4ka">
                <select size="1" name="room_class" class="selection_form">
                    <option class="list" disabled>Выберите класс апартаментов</option>
                    <option selected value="LUX">Люкс</option>
                    <option value="TYPE_A">A</option>
                    <option value="TYPE_B">B</option>
                    <option value="TYPE_C">C</option>
                </select>
                <select size="1" name="count_rooms" class="selection_form">
                    <option class="list" disabled>Выберите количество комнат</option>
                    <option selected value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                </select>
                <input
                        type="date"
                        name="arrivalDate"
                        value="2020-05-26"
                        min="2020-05-26"
                        max="2021-01-01"
                        class="selection_form"
                        style="height:43px; "
                />
                <input
                        type="date"
                        name="depatureDate"
                        value="2020-05-26"
                        min="2020-05-26"
                        max="2021-01-01"
                        class="selection_form"
                        style="height:43px; "
                />
                <input
                        type="submit"
                        value="Оставить заявку"
                        name="button_submit"
                        class="selection_form"
                        style="height:50px; background-color: #AFC5F8;"
                />
                <input type ="text" name="description" class ="selection_form" style
                        = "width:76%; height:100px;">
            </div>
        </form>
    </div>
    <div class="footer">
        <p class="notification">
            Входя в аккаунт или создавая новый, вы соглашаетесь с нашими Правилами
            и условиями и Положением о конфиденциальности
        </p>
        <p class="rights_reserved">
            Все права защищены.<br />
            Copyright (2019–2020) — Заказ отелей™
        </p>
    </div>
</div>
</body>
</html>
