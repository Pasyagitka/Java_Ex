package pasyagitka.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "loggingServlet", value = "/logging-servlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = null;
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost;database=Ex_Sum;integratedSecurity=true;");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Users");
            String login = request.getParameter("login");

            while (resultSet.next()) {
                if (resultSet.getString("login").equals(login)) {
                    request.getSession().setAttribute("userlogin", login);
                    response.sendRedirect(request.getContextPath() + "/work.jsp");
                    return;
                }
            }
            response.sendRedirect(request.getContextPath() + "/error.jsp");
            //throw new IOException("Нет пользователя с таким логином");
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}
