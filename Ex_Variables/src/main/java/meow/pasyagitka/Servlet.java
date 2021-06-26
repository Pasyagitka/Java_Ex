package meow.pasyagitka;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Servlet", value = "/Servlet")
public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Double y;
        String a = request.getParameter("a");
        String b = request.getParameter("b");
        String c = request.getParameter("c");
        String x = request.getParameter("x");
        if(a.equals("")||b.equals("")||c.equals("")||x.equals("")) {
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
        else {
            y=Double.parseDouble(a)+Double.parseDouble(b)*Double.parseDouble(x)+Double.parseDouble(c)*Double.parseDouble(x)*Double.parseDouble(x);
            request.setAttribute("y", y);
            request.getRequestDispatcher("/result.jsp").forward(request, response);
        }

    }
}
