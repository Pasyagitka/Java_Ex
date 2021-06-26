package pasyagitka.controller;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "WorkServlet", value = "/WorkServlet")
public class WorkServlet extends HttpServlet {
    private final static Logger logger = Logger.getLogger(WorkServlet.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost;database=Ex_Sum;integratedSecurity=true;");

            PreparedStatement stmt = connection.prepareStatement("select * from Users where login = ?");
            stmt.setString(1, request.getSession().getAttribute("userlogin").toString());
            ResultSet resultSet =  stmt.executeQuery();
            resultSet.next();
            request.setAttribute("sum", resultSet.getString("sum"));
            logger.info("GETINFO");
            RequestDispatcher rd = request.getRequestDispatcher("work.jsp");
            rd.forward(request, response);

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}
