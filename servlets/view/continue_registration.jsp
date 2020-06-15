<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 23.05.2020
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Continue Registration</title>
    <link rel="stylesheet" href="/src_css/main_menu_user.css" />
</head>
<body>
<form method = "post" action="/registration">
    <label for ="name">Enter name</label>
    <input type="text" id ="name" name="name" class="selection_form" />
    <br />
    <br />
    <label for ="age">Enter age</label>
    <input type="number" id="age" name="age" class="selection_form" />
    <br />
    <br />
    <label for ="password">Password</label>
    <input type="password" id="password"  name="password" class="selection_form" />
    <br />
    <br />
    <label for ="money">Enter amount of money</label>
    <input type="number" id="money" name="money" class="selection_form" />
    <input type ="submit" value="Зарегистрироваться" class="selection_form">
</form>
</body>
</html>
