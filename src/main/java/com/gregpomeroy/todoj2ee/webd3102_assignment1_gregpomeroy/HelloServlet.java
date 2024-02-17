package com.gregpomeroy.todoj2ee.webd3102_assignment1_gregpomeroy;

import com.gregpomeroy.todoj2ee.webd3102_assignment1_gregpomeroy.database.DBConnect;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "hello-servlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() throws ServletException {

        try {
            Connection connection = DBConnect.getConnection();
            System.out.println("Connected to the database");

            getServletContext().setAttribute("dbConnection", connection);
        } catch (SQLException e) {
            throw new ServletException("Error connecting to the database", e);
        }
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
        Connection connection = (Connection) getServletContext().getAttribute("dbConnection");
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database connection closed");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}