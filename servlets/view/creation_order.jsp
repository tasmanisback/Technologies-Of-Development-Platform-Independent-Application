<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 24.05.2020
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/src_css/main_menu_user.css" />

</head>
<body>
<form method="post" action="/order?action=order">
    <br/>
    <br/>
        <label for="apartment_number">Enter apartment number</label>
        <input type="number" id="apartment_number" name="apartment_number">
    <br/>
    <br/>
        <label for="client_login">Enter client login</label>
        <input type="text" id ="client_login" name ="client_login">
    <br/>
    <br/>
        <label for="description">Enter description</label>
        <input type="text" id="description" name ="description">
    <br/>
    <br/>
        <label for="payment">Enter cost for apartment</label>
        <input type="number" id="payment" name="payment">
    <input type="submit" value="Подтвердить" class="profile_button"/>
    <br/>
    <br/>
</form>
<form method = "post" action="/order?action=exit">
    <input type="submit" value="Выйти" class="profile_button"/>
</form>
</body>
</html>
