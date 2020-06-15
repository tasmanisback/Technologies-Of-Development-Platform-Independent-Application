<%@ page import="app.model.entities.hotel.Hotel" %>
<%@ page import="app.controller.service.HotelService" %>
<%@ page import="app.model.entities.requisiiton.Requisition" %>
<%@ page import="java.util.List" %>
<%@ page import="java.net.http.HttpRequest" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 23.05.2020
  Time: 23:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/src_css/main_menu_user.css" />

</head>
<body>
<h1>Displaying Requisition List</h1>
<table border ="1" width="500" align="center">
    <tr bgcolor="00FF7F">
        <th><b>Id requisition</b></th>
        <th><b>count rooms</b></th>
        <th><b>room class</b></th>
        <th><b>client login</b></th>
        <th><b>arrival date</b></th>
        <th><b>depature date</b></th>
        <th><b>description</b></th>
    </tr>
    <%Hotel hotel = Hotel.getInstance();
            HotelService hs = new HotelService();
            List<Requisition> reqs = hotel.getRequisitions();
            for(Requisition s:reqs){%>
    <tr>
        <td><%=s.getId()%></td>
        <td><%=s.getCount_rooms()%></td>
        <td><%=s.getRoomClass()%></td>
        <td><%=s.getClient_login()%></td>
        <td><%=s.getArrivalDate()%></td>
        <td><%=s.getDepartureDate()%></td>
        <td><%=s.getDescription()%></td>
    </tr>
    <%}%>
</table>
<hr/>
<form action="/profileAdmin?action=back" method="post">
    <input type="submit" value="Назад" class="profile_button"/>
</form>
</body>
</html>
