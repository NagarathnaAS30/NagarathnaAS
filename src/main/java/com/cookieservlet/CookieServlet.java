package com.cookieservlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // 🔹 Handle GET (Display page)
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String userName = null;
        int count = 0;

        // 🔹 Read cookies
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("user")) {
                    userName = c.getValue();
                }
                if (c.getName().equals("count")) {
                    count = Integer.parseInt(c.getValue());
                }
            }
        }

        out.println("<html><head><title>Cookie Program</title></head><body>");

        // 🔹 If user already visited
        if (userName != null && !userName.isEmpty()) {

            count++; // increment visit count

            // 🔹 Update count cookie
            Cookie countCookie = new Cookie("count", String.valueOf(count));
            countCookie.setMaxAge(30); // expires in 30 seconds
            response.addCookie(countCookie);

            out.println("<h2 style='color:blue;'>Welcome back, " + userName + "!</h2>");
            out.println("<h2 style='color:magenta;'>You have visited this page " + count + " times!</h2>");
            out.println("<p style='color:green;'>Note: Cookie will expire in 30 seconds</p>");

        } else {

            // 🔹 First time user
            out.println("<h2 style='color:red;'>Welcome Guest! Please enter your name</h2>");

            out.println("<form action='CookieServlet' method='post'>");
            out.println("Enter your name: <input type='text' name='userName'>");
            out.println("<input type='submit' value='Submit'>");
            out.println("</form>");
        }

        out.println("</body></html>");
    }

    // 🔹 Handle POST (Create cookies)
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getParameter("userName");

        if (userName != null && !userName.isEmpty()) {

            // 🔹 Create user cookie
            Cookie userCookie = new Cookie("user", userName);
            userCookie.setMaxAge(30); // expires in 30 seconds

            // 🔹 Create visit count cookie
            Cookie countCookie = new Cookie("count", "0");
            countCookie.setMaxAge(30);

            response.addCookie(userCookie);
            response.addCookie(countCookie);
        }

        // Redirect to GET
        response.sendRedirect("CookieServlet");
    }
}