package com.youcode.gestionemployes.web.controller;

import com.youcode.gestionemployes.entity.Employe;
import com.youcode.gestionemployes.metier.UtilisateurService;
import com.youcode.gestionemployes.shared.TemplateEngineProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.TemplateEngine;

import java.io.IOException;

@WebServlet(name = "DeleteEmployeServlet", value = "/delete-employe")
public class DeleteEmployeServlet extends HttpServlet {
    private UtilisateurService utilisateurService;
    private TemplateEngine te;

    @Override
    public void init() throws ServletException {
        te = TemplateEngineProvider.getTemplateEngine();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer employeId = Integer.valueOf(req.getParameter("id"));
        utilisateurService = new UtilisateurService();
        Employe employe = (Employe) utilisateurService.findById(employeId);
        if (employe != null) {
            utilisateurService.delete(employe);

        }
        resp.sendRedirect("/manage-employes");
    }
}
