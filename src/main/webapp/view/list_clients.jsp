<%@ page import="app.model.entities.hotel.Hotel" %>
<%@ page import="app.controller.service.HotelService" %>
<%@ page import="app.model.entities.person.client.Client" %>
<%@ page import="java.util.List" %>
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 24.05.2020
  Time: 3:25
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
        <th><b>Client name</b></th>
        <th><b>login</b></th>
        <th><b>password</b></th>
        <th><b>age</b></th>
        <th><b>balance</b></th>
        <th><b>apartment number</b></th>
    </tr>
    <%
        Hotel hotel = Hotel.getInstance();
        HotelService hs = new HotelService();
        List<Client> clients = hotel.getClients();
        for(Client s:clients){%>
    <tr>
        <td><%=s.getName()%></td>
        <td><%=s.getLogin()%></td>
        <td><%=s.getPassword()%></td>
        <td><%=s.getAge()%></td>
        <td><%=s.getMoney()%></td>
        <td><%=s.getApartmentNumber()%></td>
    </tr>
    <%}%>
</table>
<hr/>
<form action="/profileAdmin?action=back" method="post">
    <input type="submit" value="Назад" class="profile_button"  />
</form>
</body>
</html>
