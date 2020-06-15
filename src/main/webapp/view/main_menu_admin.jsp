<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 23.05.2020
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADMIN'S MENU</title>
    <link rel="stylesheet" href="/src_css/main_menu_user.css" />

</head>
<body>
<form method="post" action="/profileAdmin?action=exit">
    <input type="submit" class="profile_button" value="Выход"  />
</form>
</br>
<form method="post" action="/profileAdmin?action=client">
    <input type="submit" class="profile_button" value="Просмотреть пользователей"/>
</form>
<form method="post" action="/profileAdmin?action=requisition">
    </br>
<input type="submit" class="profile_button" value="Просмотреть заявки"/>
</form>
</br>
<form method="post" action="/profileAdmin?action=order">
<input type="submit" class="profile_button" value="Обработать заказ"/>
</form>
</br>
<form method="post" action="/profileAdmin?action=apartment">
    <input type="submit" class="profile_button" value="Просмотреть апартаменты"/>
</form>
</br>
<form method="post" action="/profileAdmin?action=createUser">
    <input type="submit"  class="profile_button" value="Добавить пользователя"/>
</form>
</br>
<form method="post" action="/profileAdmin?action=removeUser">
    <input type="submit" class="profile_button" value="Удалить пользователя"/>
</form>
</br>

<form method="post" action="/profileAdmin?action=createApartment">
    <input type="submit" class="profile_button" value="Добавить апартаменты"/>
</form>

</br>
<form method="post" action="/profileAdmin?action=removeApartment">
    <input type="submit" class="profile_button" value="Удалить апартаменты"/>
</form>

</body>
</html>
