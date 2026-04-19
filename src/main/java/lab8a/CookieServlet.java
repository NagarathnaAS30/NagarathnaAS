package lab8a;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/CookieServlet")   // No need of web.xml
public class CookieServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("username");

        int visitCount = 0;
        boolean found = false;

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie c : cookies) {

                if (c.getName().equals("user")) {
                    name = c.getValue();
                }

                if (c.getName().equals("visit")) {
                    visitCount = Integer.parseInt(c.getValue());
                    visitCount++;
                    found = true;
                }
            }
        }

        if (!found) {
            visitCount = 1;
        }

        // Create cookies
        Cookie nameCookie = new Cookie("user", name);
        Cookie visitCookie = new Cookie("visit", String.valueOf(visitCount));

        // Expiry time (60 seconds)
        nameCookie.setMaxAge(60);
        visitCookie.setMaxAge(60);

        response.addCookie(nameCookie);
        response.addCookie(visitCookie);

        // Output
        out.println("<html><body>");
        out.println("<h2>Welcome back " + name + "!</h2>");
        out.println("<p>You have visited this page " + visitCount + " times.</p>");

        // Display cookies
        out.println("<h3>List of Cookies:</h3>");

        if (cookies != null) {
            out.println("<ul>");
            for (Cookie c : cookies) {
                out.println("<li>" + c.getName() + " : " + c.getValue() + "</li>");
            }
            out.println("</ul>");
        }

        out.println("<p><b>Note:</b> Cookie expires in 60 seconds.</p>");

        out.println("</body></html>");
    }
}