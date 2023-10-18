/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.services;

import java.util.Date;
import java.util.List;
import ma.projet.classes.Projet;
import ma.projet.classes.Tache;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author hp
 */
public class ProjetService implements IDao<Projet> {
    private Object tacheDao;

    @Override
    public boolean create(Projet o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            return true;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

   

    public List<Projet> findBetweenDate(Date d1, Date d2) {
        List<Projet> projets = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            projets = session.getNamedQuery("betweenDate").setParameter("d1", d1).setParameter("d2", d2).list();
            tx.commit();
            return projets;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
            return projets;
        } finally {
            if(session != null)
                session.close();
        }
    }

    @Override
    public List<Projet> findAll() {
        List<Projet> projets = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            projets = session.createQuery("from Projet").list();
            tx.commit();
            return projets;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
            return projets;
        } finally {
            if(session != null)
                session.close();
        }
    }



    @Override
    public Projet getById(int id) {
        Projet projet = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            projet = (Projet) session.get(Projet.class, id);
            tx.commit();
            return projet;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return projet;
        } finally {
            if (session != null) {
                session.close();
            }
        }}
//q5
    public void afficherTachesPlanifieesPourProjet(Projet projet) {
    List<Tache> tachesPlanifiees = tache.getTachesPlanifieesPourProjet(projetId);

    System.out.println("Projet : " + projet.getId() + " Nom : " + projet.getNom() + " Date début : " + projet.getDateDebut());
    System.out.println("Liste des tâches planifiées :");
    System.out.println("Num\tNom\tDate Début Planifiée\tDate Fin Planifiée");
    for (Tache tache : tachesPlanifiees) {
        System.out.println(tache.getNom() + "\t" + tache.getNom() + "\t" + tache.getDateDebut() + "\t" + tache.getDateFin());
    }
}

   //q6
    public void afficherTachesRealiseesDansProjet(Projet projet) {
    // Récupérer les tâches réalisées pour le projet
    List<Tache> tachesRealisees = tacheDao.getTachesRealiseesDansProjet(projet);

    // Afficher les informations du projet
    System.out.println("Projet : " + projet.getId() + " Nom : " + projet.getNom() + " Date début : " + projet.getDateDebut());
    System.out.println("Liste des tâches réalisées :");
    System.out.println("Num\tNom\tDate Début Réelle\tDate Fin Réelle");

    // Afficher chaque tâche réalisée
    for (Tache tache : tachesRealisees) {
        System.out.println(tache.getNom() + "\t" + tache.getNom() + "\t" + tache.getDateDebut() + "\t" + tache.getDateFin());
    }
}


}
    
