package pasyagitka.controller;

import pasyagitka.model.Book;
import pasyagitka.database.DatabaseConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "indexServlet", value = "/index-servlet")
public class LoginServlet extends HttpServlet {
    private int iterator = 0;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> dBlist = DatabaseConnection.getInstance().getRecordsFromDB().getList();
        List<Book> resultBooks = new ArrayList<>();

        for (int i = 0; i < 2; i++)
        {
            if (iterator >= dBlist.size()) {
                iterator = 0;
                resultBooks.add(dBlist.get(iterator));
                iterator++;
            }
            else {
                resultBooks.add(dBlist.get(iterator));
                iterator++;
            }
        }
        request.setAttribute("DBlist", resultBooks);
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
    }
}
