<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 25.05.2020
  Time: 0:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/src_css/main_menu_user.css" />
</head>
<body>
    <form method="post" action="/changeUser?action=createUser">
        <label for="login">Введите логин пользователя</label>
        <input type="text" id="login" class="selection_form" name="login"/>
        <label for="password">Введите пароль пользователя</label>
        <input type="text" name="password" class="selection_form" id="password"/>
        <label for="name">Введите имя пользователя</label>
        <input type="text" name="name" class="selection_form" id="name"/>
        <label for="age">Введите возраст пользователя</label>
        <input type="text" name="age" class="selection_form" id="age" />
        <label for="balance">Введите баланс пользователя</label>
        <input type="text" name="balance" class="selection_form" id="balance"/>
        <input type="submit" class="selection_form" value ="Подтвердить"/>
    </form>
    <form method="post" action="/profileAdmin?action=back">
        <input type="submit" value="Назад" class="profile_button"/>
    </form>
</body>
</html>
