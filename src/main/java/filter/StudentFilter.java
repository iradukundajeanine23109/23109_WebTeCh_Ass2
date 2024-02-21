package filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/AdminFilter")
public class StudentFilter implements Filter {
    public StudentFilter() {
        super();
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpSession session = req.getSession();

        if(session.getAttribute("email") == null)
            req.getRequestDispatcher("index.jsp").forward(request, response);
        else
            chain.doFilter(request, response);
    }

    public void init(FilterConfig fConfig) throws ServletException {
        //
    }
}