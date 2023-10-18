/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.util.Date;
import java.util.List;
import ma.projet.classes.Tache;
import ma.projet.services.TacheService;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author hp
 */
public class Test {
    
    public static void main(String[] args) {
        // Initialisez votre session Hibernate et vos services
        Session session = HibernateUtil.getSessionFactory().openSession();
        TacheService tacheService = new TacheService(session);

        // Test d'affichage des tâches réalisées entre deux dates
        Date dateDebut = ; // Remplacez par la date de début
        Date dateFin = ; // Remplacez par la date de fin
        List<Tache> tachesRealiseesEntreDeuxDates = tacheService.getTachesRealiseesEntreDeuxDates(dateDebut, dateFin);
        System.out.println("Tâches réalisées entre " + dateDebut + " et " + dateFin + ":");
        for (Tache tache : tachesRealiseesEntreDeuxDates) {
            System.out.println("Tâche : " + tache.getNom() + ", Date début réelle : " + tache.getDateDebut() + ", Date fin réelle : " + tache.getDateFin());
        }

        // Test d'affichage des tâches dont le prix est supérieur à 1000 DH
        List<Tache> tachesPrixSuperieurA1000 = tacheService.getTachesPrixSuperieurA1000DH();
        System.out.println("Tâches avec prix supérieur à 1000 DH:");
        for (Tache tache : tachesPrixSuperieurA1000) {
            System.out.println("Tâche : " + tache.getNom() + ", Prix : " + tache.getPrix());
        }

        // Fermez la session Hibernate
        session.close();
    }
}

    

