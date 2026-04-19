package com.java;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String roll = request.getParameter("roll");
        String name = request.getParameter("name");

        String s1 = request.getParameter("s1");
        String s2 = request.getParameter("s2");
        String s3 = request.getParameter("s3");
        String s4 = request.getParameter("s4");
        String s5 = request.getParameter("s5");

        // Validation
        if (roll==null || name==null || s1==null || s2==null || s3==null || s4==null || s5==null ||
            roll.isEmpty() || name.isEmpty() || s1.isEmpty() || s2.isEmpty() || s3.isEmpty() || s4.isEmpty() || s5.isEmpty()) {

            response.getWriter().println("All fields are required!");
            return;
        }

        int m1 = Integer.parseInt(s1);
        int m2 = Integer.parseInt(s2);
        int m3 = Integer.parseInt(s3);
        int m4 = Integer.parseInt(s4);
        int m5 = Integer.parseInt(s5);

        if (m1<0||m1>100||m2<0||m2>100||m3<0||m3>100||m4<0||m4>100||m5<0||m5>100) {
            response.getWriter().println("Marks must be between 0 and 100");
            return;
        }

        // Average
        double avg = (m1+m2+m3+m4+m5)/5.0;

        // Result
        String result;
        if (m1>=40 && m2>=40 && m3>=40 && m4>=40 && m5>=40) {
            result = "PASS";
        } else {
            result = "FAIL";
        }

        // Set attributes
        request.setAttribute("roll", roll);
        request.setAttribute("name", name);
        request.setAttribute("m1", m1);
        request.setAttribute("m2", m2);
        request.setAttribute("m3", m3);
        request.setAttribute("m4", m4);
        request.setAttribute("m5", m5);
        request.setAttribute("avg", avg);
        request.setAttribute("result", result);

        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}