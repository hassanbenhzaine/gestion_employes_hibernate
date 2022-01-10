package com.youcode.gestionemployes.web.controller;

import com.youcode.gestionemployes.entity.Utilisateur;
import com.youcode.gestionemployes.metier.UtilisateurService;
import com.youcode.gestionemployes.shared.TemplateResolverProvider;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.IOException;

@WebServlet("/changepassword")
public class ChangePasswordServlet extends HttpServlet {
    private UtilisateurService utilisateurService;
    private TemplateEngine te;

    @Override
    public void init() {
        utilisateurService = new UtilisateurService();
        te = new TemplateEngine();
        te.setTemplateResolver(TemplateResolverProvider.getInstance().get());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getSession(false) != null) {
            Utilisateur utilisateur = (Utilisateur) req.getSession().getAttribute("utilisateur");
            Context context = new Context();
            context.setVariable("firstName", utilisateur.getFirstName());
            context.setVariable("lastName", utilisateur.getLastName());
            te.process("changePassword", context, resp.getWriter());
        } else {
            resp.sendRedirect("/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        if (req.getSession(false) != null) {
            Context context = new Context();
            Utilisateur utilisateur = (Utilisateur) req.getSession().getAttribute("utilisateur");
            String newPassword = req.getParameter("newPassword");
            String repeatPassword = req.getParameter("repeatPassword");
            String oldPassword = req.getParameter("oldPassword");

            if (oldPassword.equals(utilisateur.getPassword())) {
                if (newPassword.equals(repeatPassword)) {
                    utilisateur.setPassword(newPassword);
                    utilisateurService.modify(utilisateur);
                    resp.sendRedirect("/dashboard");
                } else {
                    context.setVariable("error", "Les mots de passe ne correspondent pas");
                    te.process("changePassword", context, resp.getWriter());
                }
            } else {
                resp.sendRedirect("/changepassword");
            }
        } else {
            resp.sendRedirect("/login");
        }
    }
}
