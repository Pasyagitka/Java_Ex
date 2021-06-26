import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDateTime;

@WebFilter(filterName = "WriteLogFilter")
public class WriteLogFilter implements Filter {
    private final static Logger logger = Logger.getLogger(WriteLogFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        logger.info(LocalDateTime.now() + " - " + request.getRemoteAddr());
        chain.doFilter(request, response);
    }
}
