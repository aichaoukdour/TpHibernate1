/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.services;

import java.util.Date;
import java.util.List;
import ma.projet.classes.Tache;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author hp
 */
public class TacheService  implements IDao<Tache> {
    private Object session;

    public TacheService(Session session) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public boolean create(Tache o) {
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

    
    public boolean delete(Tache o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(o);
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

    
    public boolean update(Tache o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(o);
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

    
    public List<Tache> findAll(Tache o) {
        List<Tache> taches = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            taches = session.createQuery("from Tache").list();
            tx.commit();
            return taches;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
            return taches;
        } finally {
            if(session != null)
                session.close();
        }
    }

    public Tache findById(int id) {
        Tache tache = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            tache = (Tache) session.get(Tache.class, id);
            tx.commit();
            return tache;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return tache;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Tache> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tache getById(int n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
public List<Tache> getTachesPrixSuperieurA1000DH() {
    return session.getNamedQuery("Tache.prixSuperieurA1000").list();
}
//q8
public List<Tache> getTachesRealiseesEntreDeuxDates(Date dateDebut, Date dateFin) {
    return session.createQuery("SELECT t FROM Tache t WHERE t.dateDebutReelle BETWEEN :dateDebut AND :dateFin")
            .setParameter("dateDebut", dateDebut)
            .setParameter("dateFin", dateFin)
            .list();
}


}

    
