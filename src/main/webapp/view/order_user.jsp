<%@ page import="app.model.entities.order.Order" %>
<%@ page import="app.model.entities.person.client.Client" %>
<%@ page import="app.controller.dao.entitiesDAO.OrderDAO" %>
<%@ page import="app.model.entities.apartment.Apartment" %>
<%@ page import="app.controller.dao.entitiesDAO.ApartmentDAO" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 24.05.2020
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order</title>
    <link rel="stylesheet" href="/src_css/main_menu_user.css" />

</head>
<body>
<table border ="1" width="500" align="center">
    <tr bgcolor="00FF7F">
        <th><b>Ваш логин</b></th>
        <th><b>описание</b></th>
        <th><b>номер апартаментов</b></th>
        <th><b>Сумма для оплаты</b></th>

    </tr>
    <%
        Order s = (Order) request.getSession().getAttribute("order");
        String login = (String) request.getSession().getAttribute("login");
        HttpSession s1 = request.getSession();
        s1.setAttribute("login",login);
        ApartmentDAO od = new ApartmentDAO();
        Apartment ap = od.getEntityById(s.getApartment_number());
    %>
    <tr>
        <td><%=s.getClient_login()%></td>
        <td><%=s.getDescription()%></td>
        <td><%=s.getApartment_number()%></td>
        <td><%=s.getPayment()%></td>
    </tr>
    <tr bgcolor="00FF7F">
        <th><b>количество комнат</b></th>
        <th><b>класс апартаментов</b></th>
    </tr>
    <tr>
        <td><%=ap.getCountRooms()%></td>
        <td><%=ap.getRoomClass()%></td>
    </tr>
    <form method="post" action="/orderUser?action=exit">
        <input type="submit" value="Выйти">
    </form>
    <form method="post" action="/orderUser?action=accept">
        <input type="submit" value="Оплатить">
    </form>
    <form method="post" action="/orderUser?action=decline">
        <input type="submit" value="Отменить">
    </form>
</table>
</body>
</html>
