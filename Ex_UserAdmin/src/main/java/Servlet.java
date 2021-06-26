import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(name = "Servlet", value = "/Servlet")
public class Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd;
        if (!request.getParameter("Password").matches("[0-9a-zA-Z]{6,12}")) {
            rd = request.getRequestDispatcher("index.jsp");
        }
        else {
            if (request.getParameter("role").equals("User")) {
                rd = request.getRequestDispatcher("User.jsp");
            } else {
                Cookie cookie = new Cookie("admin", LocalDateTime.now().toString());
                response.addCookie(cookie);
                rd = request.getRequestDispatcher("Admin.jsp");
            }
        }
        rd.forward(request, response);
    }
}
