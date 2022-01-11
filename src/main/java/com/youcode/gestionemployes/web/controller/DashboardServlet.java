package com.youcode.gestionemployes.web.controller;

import com.youcode.gestionemployes.entity.Utilisateur;
import com.youcode.gestionemployes.shared.TemplateEngineProvider;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.IOException;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
    private TemplateEngine te;

    @Override
    public void init() {
        te = TemplateEngineProvider.getTemplateEngine();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getSession(false) != null) {
            Utilisateur utilisateur = (Utilisateur) req.getSession().getAttribute("utilisateur");
            Context context = new Context();
            context.setVariable("firstName", utilisateur.getFirstName());
            context.setVariable("lastName", utilisateur.getLastName());
            te.process("dashboard", context, resp.getWriter());
        } else {
            resp.sendRedirect("/login");
        }

    }
}
