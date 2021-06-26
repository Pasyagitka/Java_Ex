package pasyagitka.controller;

import pasyagitka.database.DAOFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "likeServlet", value = "/like-servlet")
public class LikeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            DAOFactory daoFactory = new DAOFactory("jdbc:sqlserver://localhost;database=Ex_Like;integratedSecurity=true");
            Connection connection = daoFactory.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from LikeOrDislike");
            resultSet.next();
            int count = resultSet.getInt("like");
            statement.executeUpdate("update LikeOrDislike set [like] = " + (count + 1) + " where [like] = " + count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect(request.getContextPath() + "/look.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
}
