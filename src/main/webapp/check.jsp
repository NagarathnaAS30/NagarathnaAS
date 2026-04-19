<html>
<body>

<%
    String user = (String) session.getAttribute("user");

    if (user != null) {
%>

<h2>Hello <%= user %>! Session is still active.</h2>

<p>
Try again after 1 minute to see session expiry.
</p>

<%
    } else {
%>

<h2>Session expired!</h2>
<a href="index.jsp">Go Back</a>

<%
    }
%>

</body>
</html>