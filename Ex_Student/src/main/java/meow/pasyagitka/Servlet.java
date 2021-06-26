package meow.pasyagitka;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;

@WebServlet(name = "Servlet", value = "/Servlet")
public class Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean cookieExists = false;

        RequestDispatcher rd = request.getRequestDispatcher("main.jsp");

        if (request.getParameter("delete") != null) {
            Cookie[] cookies = request.getCookies();
            Cookie courseCookie = new Cookie("course", "");
            Cookie specCookie = new Cookie("spec", "");
            Cookie groupCookie = new Cookie("group", "");
            courseCookie.setMaxAge(0);
            specCookie.setMaxAge(0);
            groupCookie.setMaxAge(0);
            if (cookies != null) {
                response.addCookie(courseCookie);
                response.addCookie(specCookie);
                response.addCookie(groupCookie);
            }
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        else {
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie: cookies) {
                switch (cookie.getName()) {
                    case "course":
                        if (!cookie.getValue().isEmpty()) cookieExists = true;
                        if (!request.getParameter("course").equals(cookie.getValue())) {
                            rd = request.getRequestDispatcher("index.jsp");
                        }
                        break;
                    case "spec":
                        if (!cookie.getValue().isEmpty()) cookieExists = true;
                        if (!request.getParameter("spec").equals(cookie.getValue())) {
                            rd = request.getRequestDispatcher("index.jsp");
                        }
                        break;
                    case "group":
                        if (!cookie.getValue().isEmpty()) cookieExists = true;
                        if (!request.getParameter("group").equals(cookie.getValue())) {
                            rd = request.getRequestDispatcher("index.jsp");
                        }
                        break;
                }
            }
            if (!cookieExists){
                response.addCookie(new Cookie("course", request.getParameter("course")));
                response.addCookie(new Cookie("spec", request.getParameter("spec")));
                response.addCookie(new Cookie("group", request.getParameter("group")));
            }
            rd.forward(request, response);
        }
    }
}
