<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 25.05.2020
  Time: 1:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/src_css/main_menu_user.css" />

</head>
<body>
<form method="post" action="/changeApartment?action=createApartment">
    <input type="number" name="number_apartment" value="Введите номер апартаментов">
    <select size="1" name="count_rooms" class="selection_form">
        <option class="list" disabled>Выберите количество комнат</option>
        <option selected value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
    </select>
    <select size="1" name="room_class" class="selection_form">
        <option class="list" disabled>Выберите класс апартаментов</option>
        <option selected value="LUX">Люкс</option>
        <option value="TYPE_A">A</option>
        <option value="TYPE_B">B</option>
        <option value="TYPE_C">C</option>
    </select>
    <input type = "submit" value = "Создать" />
</form>
<form method ="post" action="/profileAdmin?action=back">
    <input type="submit" class="profile_button" value="Назад">
</form>
</body>
</html>
