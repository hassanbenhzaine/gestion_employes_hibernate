package com.youcode.gestionemployes.web.controller;

import com.youcode.gestionemployes.shared.TemplateResolverProvider;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.TemplateEngine;

import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    private TemplateEngine te;

    @Override
    public void init(ServletConfig servletConfig) {
        te = new TemplateEngine();
        te.setTemplateResolver(TemplateResolverProvider.getInstance().get());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.getSession().invalidate();
        resp.sendRedirect("/login");
    }
}
