<%@ page import="java.util.*" %>
<html>
<body>

<%
    // Set session timeout = 1 minute (60 sec)
    session.setMaxInactiveInterval(60);

    String name = request.getParameter("username");

    if (name != null) {
        session.setAttribute("user", name);
    }

    String user = (String) session.getAttribute("user");

    if (user != null) {

        Date creationTime = new Date(session.getCreationTime());
        Date lastAccessTime = new Date(session.getLastAccessedTime());
        int maxTime = session.getMaxInactiveInterval();

%>

<h2>Hello <%= user %>!</h2>

<p><b>Session Creation Time:</b> <%= creationTime %></p>
<p><b>Last Access Time:</b> <%= lastAccessTime %></p>
<p><b>Session Expiry Time:</b> <%= maxTime %> seconds</p>

<p>
Click here to check session:
<a href="check.jsp">Check Session</a>
</p>

<p>Wait for 1 minute and click the link again to see session expiry.</p>

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