<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 25.05.2020
  Time: 0:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/src_css/main_menu_user.css" />
</head>
<body>
    <form method="post" action="/changeUser?action=removeUser">
        <label for="login">Введите логин пользователя, которого вы хотите удалить</label>
        <input name = "login" id="login" type = "text"/>
        <input type = "submit" value="Удалить">
    </form>
    <form method="post" action="/profileAdmin?action=back">
        <input type="submit" value="Назад" class="profile_button"/>
    </form>
</body>
</html>
