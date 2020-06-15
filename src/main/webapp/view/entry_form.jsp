<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Заказ отелей</title>
    <link rel="stylesheet" href="../src_css/entry_menu.css" />
</head>
<body>
<div class="header"></div>
<div class="main_window">
    <div class="content_window">
        <div class="title__sign_in">Вход в<br />личный кабинет</div>
        <p class="notification_window">
            Чтобы получить доступ к нашим<br />
            сервисам, войдите, используя данные<br />
            своего аккаунта
        </p>
        <form action = "/entryMenu" method="post">
        <div class="login_div">
            <b style ="font-weight:400">Введите логин</b>
            <input class = "login_enter" type="text" name = "login" size = "19" maxlength="20" />
        </div>
        <div class="password_div"> <b style ="font-weight:400">Введите пароль<br></b>
            <input class = "password_enter" type="password" name = "password" size = "19" maxlength="20" />
        </div>
        <input type = "submit" value = "Войти в личный кабинет" name ="button_enter" class = "button_submit">
        </form>
        <div class="text_additional">
            <p>Нет аккаунта?<a href="/view/reg_form.jsp" style ="text-decoration: none;"> Зарегистрируйтесь</a></p>
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
