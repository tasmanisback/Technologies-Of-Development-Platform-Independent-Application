<%@ page import="app.model.entities.hotel.Hotel" %>
<%@ page import="app.controller.service.HotelService" %>
<%@ page import="app.model.entities.apartment.Apartment" %>
<%@ page import="java.util.List" %>

<%--  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 24.05.2020
  Time: 3:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/src_css/main_menu_user.css" />

</head>
<<body>
<h1>Displaying Client List</h1>
<table border ="1" width="500" align="center">
    <tr bgcolor="00FF7F">
        <th><b>apartment number</b></th>
        <th><b>count rooms</b></th>
        <th><b>Room class</b></th>
        <th><b>client's login</b></th>

    </tr>
    <%
        Hotel hotel = Hotel.getInstance();
        HotelService hs = new HotelService();
        List<Apartment> apartments = hotel.getApartments();
        for(Apartment s:apartments){%>
    <tr>
        <td><%=s.getNumber()%></td>
        <td><%=s.getCountRooms()%></td>
        <td><%=s.getRoomClass()%></td>
        <td><%=s.getClientLogin()%></td>
    </tr>
    <%}%>
</table>
<hr/>
<form method="post" action="/profileAdmin?action=back">
    <input type="submit" value="Назад" class="profile_button"/>
</form>
</body>
</html>
