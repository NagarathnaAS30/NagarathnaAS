<%@ page import="javax.servlet.http.Cookie" %>
<html>
<head>
    <title>Active Cookies</title>
</head>
<body>

<h2>Active Cookie List</h2>

<%
    Cookie cookies[] = request.getCookies();

    if (cookies != null) {
%>
        <table border="1">
            <tr>
                <th>Name</th>
                <th>Value</th>
            </tr>

<%
        for (int i = 0; i < cookies.length; i++) {
%>
            <tr>
                <td><%= cookies[i].getName() %></td>
                <td><%= cookies[i].getValue() %></td>
            </tr>
<%
        }
    } else {
%>
        <p>No cookies found</p>
<%
    }
%>

</table>

<br>
<a href="index.jsp">Back to Add Cookie</a>

</body>
</html>