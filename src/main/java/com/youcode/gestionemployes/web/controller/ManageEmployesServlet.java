package com.youcode.gestionemployes.web.controller;

import com.youcode.gestionemployes.entity.Employe;
import com.youcode.gestionemployes.entity.Utilisateur;
import com.youcode.gestionemployes.metier.EmployeService;
import com.youcode.gestionemployes.shared.TemplateEngineProvider;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "ManageEmployes", value = "/manage-employes")
public class ManageEmployesServlet extends HttpServlet {
    private EmployeService employeService;
    private TemplateEngine te;

    @Override
    public void init() {
        te = TemplateEngineProvider.getTemplateEngine();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        employeService = new EmployeService();
        Utilisateur utilisateur = (Utilisateur) req.getSession().getAttribute("utilisateur");
        Collection<Employe> employes = employeService.findAll();

        Context context = new Context();
        context.setVariable("employes", employes);
        context.setVariable("firstName", utilisateur.getFirstName());
        context.setVariable("lastName", utilisateur.getLastName());
        context.setVariable("error", req.getParameter("error"));
        te.process("manageEmployes", context, resp.getWriter());

    }
}
