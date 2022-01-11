package com.youcode.gestionemployes.web.controller.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(filterName = "AuthenticationFilter", servletNames = {"LogoutServlet", "DashboardServlet", "ChangePasswordServlet"})
public class AuthenticationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        if (req.getSession(false) != null) {
            chain.doFilter(request, response);
        } else {
            resp.sendRedirect("/login");
        }
    }

    @Override
    public void destroy() {
    }
}
