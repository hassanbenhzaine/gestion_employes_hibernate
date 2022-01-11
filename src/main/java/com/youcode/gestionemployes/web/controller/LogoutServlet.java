package com.youcode.gestionemployes.web.controller;

import com.youcode.gestionemployes.shared.TemplateEngineProvider;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.TemplateEngine;

import java.io.IOException;

@WebServlet(name = "LogoutServlet", value = "/logout")
public class LogoutServlet extends HttpServlet {
    private TemplateEngine te;

    @Override
    public void init(ServletConfig servletConfig) {
        te = TemplateEngineProvider.getTemplateEngine();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.getSession().invalidate();
        try {
            resp.sendRedirect("/login");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
