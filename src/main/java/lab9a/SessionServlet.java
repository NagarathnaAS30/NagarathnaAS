package lab9a;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.util.Date;

@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get session
        HttpSession session = request.getSession();

        // Set session timeout to 1 minute (60 seconds)
        session.setMaxInactiveInterval(60);

        // Visit count logic
        Integer visitCount = (Integer) session.getAttribute("visitCount");

        if (visitCount == null) {
            visitCount = 1;
        } else {
            visitCount++;
        }

        session.setAttribute("visitCount", visitCount);

        // Get session details
        String sessionId = session.getId();
        Date creationTime = new Date(session.getCreationTime());
        Date lastAccessTime = new Date(session.getLastAccessedTime());

        // OUTPUT
        out.println("<html><body style='text-align:center; background-color:lightyellow;'>");

        out.println("<h1 style='color:blue;'>Session Tracking Information</h1>");

        out.println("<table border='1' align='center'>");

        out.println("<tr><th>Session ID</th><td>" + sessionId + "</td></tr>");
        out.println("<tr><th>Creation Time</th><td>" + creationTime + "</td></tr>");
        out.println("<tr><th>Last Access Time</th><td>" + lastAccessTime + "</td></tr>");
        out.println("<tr><th>Visit Count</th><td>" + visitCount + "</td></tr>");

        out.println("</table>");

        out.println("<p><b>Note:</b> Session expires after 1 minute of inactivity.</p>");

        out.println("<br><a href='SessionServlet'>Refresh / Visit Again</a>");

        out.println("</body></html>");
    }
}
