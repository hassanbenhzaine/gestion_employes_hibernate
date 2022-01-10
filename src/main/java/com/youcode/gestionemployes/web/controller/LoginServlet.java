package com.youcode.gestionemployes.web.controller;

import com.youcode.gestionemployes.entity.Utilisateur;
import com.youcode.gestionemployes.metier.UtilisateurService;
import com.youcode.gestionemployes.shared.TemplateResolverProvider;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.IOException;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    private UtilisateurService utilisateurService;
    private TemplateEngine te;

    @Override
    public void init(ServletConfig servletConfig) {
        utilisateurService = new UtilisateurService();
        te = new TemplateEngine();
        te.setTemplateResolver(TemplateResolverProvider.getInstance().get());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Utilisateur utilisateur = Utilisateur.builder()
                .email(req.getParameter("email"))
                .password(req.getParameter("password"))
                .build();
        utilisateur = utilisateurService.login(utilisateur);

        if (utilisateur != null) {
            req.getSession().setAttribute("utilisateur", utilisateur);
            resp.sendRedirect("/dashboard");
        } else {
            Context context = new Context();
            context.setVariable("error", "Email ou mot de passe incorrect");
            te.process("login", context, resp.getWriter());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getSession(false) != null) {
            resp.sendRedirect("/dashboard");
        } else {
            te.process("login", new Context(), resp.getWriter());
        }
    }
}