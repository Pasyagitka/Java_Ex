package pasyagitka.controller;

import pasyagitka.database.DAOFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "dislikeServlet", value = "/dislike-servlet")
public class DislikeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            DAOFactory daoFactory = new DAOFactory("jdbc:sqlserver://localhost;database=Ex_Like;integratedSecurity=true");
            Connection connection = daoFactory.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from LikeOrDislike");
            resultSet.next();
            int count = resultSet.getInt("dislike");
            statement.executeUpdate("update LikeOrDislike set dislike = " + (count + 1) + " where dislike = " + count);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect(request.getContextPath() + "/look.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
