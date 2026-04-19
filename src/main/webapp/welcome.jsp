
<html>
<head>
    <title>Welcome</title>
</head>
<body>

<%
    // Set session timeout to 1 minute (60 seconds)
    session.setMaxInactiveInterval(60);

    String name = request.getParameter("username");

    if (name != null) {
        session.setAttribute("user", name);
    }

    String user = (String) session.getAttribute("user");

    if (user != null) {
%>
        <h2>Hello <%= user %>!</h2>
        <p>Your session is active.</p>
        <p>Wait for 1 minute and refresh to check session expiry.</p>
<%
    } else {
%>
        <h2>Session expired!</h2>
        <p>Please enter your name again.</p>
        <a href="index.jsp">Go Back</a>
<%
    }
%>

</body>
</html>