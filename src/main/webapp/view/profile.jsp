<%@ page import="app.model.entities.person.client.Client" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 23.05.2020
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
    <link rel="stylesheet" href="/src_css/main_menu_user.css" />
</head>
<<body>
<h1>Displaying Client List</h1>
<table border ="1" width="500" align="center">
    <tr bgcolor="00FF7F">
        <th><b>Your name</b></th>
        <th><b>your age</b></th>
        <th><b>your login</b></th>
        <th><b>your password</b></th>

    </tr>
    <%
        Client s = (Client) request.getSession().getAttribute("client");
        HttpSession s1 = request.getSession();
        s1.setAttribute("client",s);
    %>
    <tr>
        <td><%=s.getName()%></td>
        <td><%=s.getAge()%></td>
        <td><%=s.getLogin()%></td>
        <td><%=s.getPassword()%></td>
    </tr>
</table>
<form method="get" action="/profile">
    <input type="submit" value="Выйти"/>
</form>
<hr/>
</body>
</html>
