package com.youcode.gestionemployes;

import com.youcode.gestionemployes.entity.Administrateur;
import com.youcode.gestionemployes.metier.UtilisateurService;

public class Main {
    public static void main(String[] args) {
//        Persistence.generateSchema("GestionEmployesPU", null);

        UtilisateurService utilisateurService = new UtilisateurService();
        Administrateur admin = new Administrateur();
        admin.setEmail("cbenhzaine@gmail.com");
        admin.setPassword("");

        utilisateurService.save(admin);


//        employe.setMatricule("abcdedf");
//        utilisateurService.update(employe);


    }
}
