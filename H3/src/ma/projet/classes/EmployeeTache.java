/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.classes;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedQuery;


@Entity
//@NamedQuery(name = "findByCommande", query = "FROM Produit p join LigneCommandeProduit l l.produit join Commande c  l.commande where c.id = :id")
//amedQuery(name = "findByCommande", query = "FROM LigneCommandeProduit  join Produit p LigneCommandeProduit.produit join LigneCommandeProduit.commande Commande c where c.id = :id")

/**
 *
 * @author hp
 */
public class EmployeeTache {
    
    @EmbeddedId
   private Date dateDebutRelle;
     private Date dateFinRelle;

    @ManyToOne()
    @JoinColumn(name="tache",referencedColumnName="id",insertable = false,updatable = false)
    private Tache tache;
    

    @ManyToOne()
    @JoinColumn(name="employee",referencedColumnName="id",insertable = false,updatable = false)
    private Employee employee;

    public EmployeeTache(Date dateDebutRelle, Date dateFinRelle, Tache tache, Employee employee) {
        this.dateDebutRelle = dateDebutRelle;
        this.dateFinRelle = dateFinRelle;
        this.tache = tache;
        this.employee = employee;
    }

  
    public EmployeeTache() {
    }

    public Date getDateDebutRelle() {
        return dateDebutRelle;
    }

    public void setDateDebutRelle(Date dateDebutRelle) {
        this.dateDebutRelle = dateDebutRelle;
    }

    public Date getDateFinRelle() {
        return dateFinRelle;
    }

    public void setDateFinRelle(Date dateFinRelle) {
        this.dateFinRelle = dateFinRelle;
    }

    public Tache getTache() {
        return tache;
    }

    public void setTache(Tache tache) {
        this.tache = tache;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}