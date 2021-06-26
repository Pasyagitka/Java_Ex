import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

@WebServlet(name = "Servlet", value = "/Servlet")
public class Servlet extends HttpServlet {

    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        int answer = 0;
        Calendar calendar = Calendar.getInstance();
        if(request.getParameter("year")!=null)
        {
            if(request.getParameter("year").equals("yes") && calendar.get(Calendar.YEAR) == 2021)
            {
                answer +=5;
            }
        }
        if(request.getParameter("month")!=null)
        {
            if(request.getParameter("month").equals("yes") && calendar.get(Calendar.DAY_OF_MONTH) == 5)
            {
                answer +=5;
            }
        }

        PrintWriter out = response.getWriter();
        out.println(answer);
    }
}
