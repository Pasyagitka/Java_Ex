package pasyagitka.controller;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "SumServlet", value = "/SumServlet")
public class SumServlet extends HttpServlet {
    private final static Logger logger = Logger.getLogger(SumServlet.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost;database=Ex_Sum;integratedSecurity=true;");

            String userLogin = request.getSession().getAttribute("userlogin").toString();

            PreparedStatement preparedStatement = connection.prepareStatement("select * from Users where login = ?");
            preparedStatement.setString(1, userLogin);
            ResultSet resultSet =  preparedStatement.executeQuery();
            resultSet.next();

            int price = Integer.parseInt(request.getParameter("price"));
            if (request.getParameter("pay") != null) {
                preparedStatement = connection.prepareStatement("update Users set sum = sum - ? where login = ?");
                PreparedStatement stmt1 = connection.prepareStatement("select sum from Users where login = ?");
                stmt1.setString(1, userLogin);
                ResultSet resultSetSum = stmt1.executeQuery();
                resultSetSum.next();
                if (Integer.parseInt(request.getParameter("price")) > resultSetSum.getInt("sum")){
                    logger.info("CANNOT PAY " + price + ", because sum is " + resultSetSum.getInt("sum"));
                    throw new IOException("Нельзя отнять");
                }
                logger.info("PAY " + price);
            } else if (request.getParameter("add") != null) {
                preparedStatement = connection.prepareStatement("update Users set sum = sum + ? where login = ?");
                logger.info("ADD " + price);
            }
            preparedStatement.setInt(1, price);
            preparedStatement.setString(2, userLogin);
            preparedStatement.executeUpdate();

            RequestDispatcher rd = request.getRequestDispatcher("work.jsp");
            rd.forward(request, response);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}
