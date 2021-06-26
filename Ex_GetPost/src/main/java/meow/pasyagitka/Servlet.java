package meow.pasyagitka;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Enumeration;

@WebServlet(name = "Servlet", value = "/Servlet")
public class Servlet extends HttpServlet {
    private boolean needToSaveCookie = true;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (needToSaveCookie) {
            //String requestType = req.getMethod();
            Cookie cookie = new Cookie("METHOD_GET",  LocalDateTime.now() + "protocol:" + request.getProtocol());
            response.addCookie(cookie);
            needToSaveCookie = false;

            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
        else {
            Cookie[] cookies = request.getCookies();
            String ResultString = "";
            ResultString +="<div>";
            for (Cookie cookie: cookies) {
                if (cookie.getName().equals("METHOD_GET")) {
                    ResultString = ResultString + "<h3>Last request: " + cookie.getValue() + "</br>";
                    break;
                }
            }
            ResultString +="</div>";
            request.setAttribute("result", ResultString);
            needToSaveCookie = true;
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("METHOD_POST",  LocalDateTime.now().toString());
        response.addCookie(cookie);

        StringBuilder headers = new StringBuilder();
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            headers.append(headerNames.nextElement()).append(", ");
        }
        request.setAttribute("result", headers.toString() + response.getStatus());

        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
    }
}
