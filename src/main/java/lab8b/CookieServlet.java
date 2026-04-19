package lab8b;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("username");
        int visitCount = 0;

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie c : cookies) {

                if (c.getName().equals("user")) {
                    name = c.getValue();
                }

                if (c.getName().equals("visit")) {
                    visitCount = Integer.parseInt(c.getValue());
                }
            }
        }

        // Increment visit count
        visitCount++;

        // Create cookies
        Cookie nameCookie = new Cookie("user", name);
        Cookie visitCookie = new Cookie("visit", String.valueOf(visitCount));

        // Set expiry (60 seconds)
        nameCookie.setMaxAge(60);
        visitCookie.setMaxAge(60);

        response.addCookie(nameCookie);
        response.addCookie(visitCookie);

        // OUTPUT DESIGN
        out.println("<html><body style='text-align:center; background-color:lightgray;'>");

        if (visitCount == 1) {
            out.println("<h2 style='color:red;'>Welcome Guest! you have been logged out or kindly login first time</h2>");
        }

        // Form again
        out.println("<form action='CookieServlet' method='post'>");
        out.println("Enter your name: ");
        out.println("<input type='text' name='username' value='" + name + "' required>");
        out.println("<input type='submit' value='Submit'>");
        out.println("</form><br><br>");

        // Greeting
        out.println("<h1 style='color:blue; font-size:40px;'>Welcome back, " + name + "!</h1>");

        // Visit count
        out.println("<h2 style='color:magenta; font-size:30px;'>You have visited this page " + visitCount + " times!</h2>");

        // Cookie list with values
        out.println("<h3>List of Cookies and Values:</h3>");

        Cookie[] newCookies = request.getCookies();

        if (newCookies != null) {
            out.println("<table border='1' align='center'>");
            out.println("<tr><th>Cookie Name</th><th>Value</th></tr>");

            for (Cookie c : newCookies) {
                out.println("<tr><td>" + c.getName() + "</td><td>" + c.getValue() + "</td></tr>");
            }

            out.println("</table>");
        }

        // Expiry message
        out.println("<p><b>Note:</b> Cookies will expire in 60 seconds.</p>");

        out.println("</body></html>");
    }
}
