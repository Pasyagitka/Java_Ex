import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebFilter(filterName = "CheckTextFilter", urlPatterns = { "/Servlet"})
public class CheckTextFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        if (phone != null && !phone.isEmpty() && email != null && !email.isEmpty()) {
            request.getRequestDispatcher("/welcome.jsp").forward(request, response);
            return;
        }
        if ((phone == null || phone.isEmpty()) && (email == null || email.isEmpty()) ){
            request.getRequestDispatcher("/error.jsp").forward(request, response);
            return;
        }
        request.setAttribute("message", "Введите все данные");
        chain.doFilter(request, response);
    }
}
