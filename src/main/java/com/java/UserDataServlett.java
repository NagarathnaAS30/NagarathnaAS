package com.java;



import java.io.IOException;

import java.util.regex.Pattern;



import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.*;



@WebServlet("/UserDataServlet")

public class UserDataServlett extends HttpServlet {

    private static final long serialVersionUID = 1L;



    protected void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {



        String username = request.getParameter("username");

        String email = request.getParameter("email");

        String designation = request.getParameter("designation");



        // Server-side validation

        if (username == null || username.isEmpty() ||

            email == null || email.isEmpty() ||

            designation == null || designation.isEmpty()) {



            response.getWriter().println("All fields are required!");

            return;

        }



        String emailRegex = "^[^ ]+@[^ ]+\\.[a-z]{2,3}$";

        if (!Pattern.matches(emailRegex, email)) {

            response.getWriter().println("Invalid Email format!");

            return;

        }



        // Pass data to JSP

        request.setAttribute("username", username);

        request.setAttribute("email", email);

        request.setAttribute("designation", designation);



        // Forward to result.jsp

        request.getRequestDispatcher("result.jsp").forward(request, response);

    }

}