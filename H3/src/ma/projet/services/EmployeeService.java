/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.services;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import ma.projet.classes.Employee;
import ma.projet.classes.EmployeeTache;
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
public class EmployeeService implements IDao<Employee> {

    @Override
    public boolean create(Employee o) {
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

   

    public List<Employee> findBetweenDate(Date d1, Date d2) {
        List<Employee> employees = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            employees = session.getNamedQuery("betweenDate").setParameter("d1", d1).setParameter("d2", d2).list();
            tx.commit();
            return employees;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
            return employees;
        } finally {
            if(session != null)
                session.close();
        }
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            employees = session.createQuery("from Employee").list();
            tx.commit();
            return employees;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
            return employees;
        } finally {
            if(session != null)
                session.close();
        }
    }



    @Override
    public Employee getById(int id) {
        Employee employee = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            employee = (Employee) session.get(Employee.class, id);
            tx.commit();
            return employee;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return employee;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    //q3
  

    public List<Tache> afficherTachesRealiseesParEmploye(Employee e) {
        List<Tache> tachesRealisees = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            // Récupérer les tâches réalisées par l'employé
            tachesRealisees = session.createQuery("select t from Tache t join t.employees e where e.id = :employeeId")
                    .setParameter("employeeId", e.getId())
                    .list();

            // Afficher les tâches réalisées
            System.out.println("Tâches réalisées par l'employé (ID " + e.getId() + "):");
            System.out.println("Num\tNom\tDate Début Réelle\tDate Fin Réelle");
            for (Tache tache : tachesRealisees) {
                System.out.println(tache.getNom() + "\t" + tache.getNom() + "\t" + tache.getDateDebut() + "\t" + tache.getDateFin());
            }

            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null)
                tx.rollback();
        } finally {
            if (session != null)
                session.close();
        }
        return tachesRealisees;
    }
    public List<Tache> afficherTachesRealiseesParEmploye2(Employee e) {
        SimpleDateFormat format = new SimpleDateFormat();
        System.out.println("Tache: " + e.getId() );
        System.out.println("Liste des taches :");
        return null;
    }    
       // ... (autres imports et code)


//q4
    public List<Projet> getProjetsGeresParEmploye(Employee e) {
        List<Projet> projetsGeres = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            // Récupérer les projets gérés par l'employé
            projetsGeres = session.createQuery("select p from Projet p join p.employee e where e.id = :employeeId")
                    .setParameter("employeeId", e.getId())
                    .list();

            // Afficher les projets gérés
            System.out.println("Projets gérés par l'employé (ID " + e.getId() + "):");
            System.out.println("ID\tNom\tDescription\tPrix");
            for (Projet projet : projetsGeres) {
                System.out.println(projet.getId() + "\t" + projet.getNom() + "\t" + projet.getId() + "\t" + projet.getDateDebut() + "\t" +projet.getDateFin());
            }

            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null)
                tx.rollback();
        } finally {
            if (session != null)
                session.close();
        }
        return projetsGeres;
    }}



       
    
